package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Computer;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.LearningDesk;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.LearningDeskState;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Workspace;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.PoolElement;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Printer;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.WirlessAccessPoint;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Breakthrough;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Door;
import edu.kit.cm.WorkspaceManagement.linkedContextes.PortalGate;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class WorkspaceAdapter {

	private List<Workspace> workspace;
	private int activeWorkspace;
	
	public WorkspaceAdapter() {
		this.workspace = new ArrayList<Workspace>();
		this.activeWorkspace = 0;
	}
	
	public void addLayout(JSONObject json) throws IllegalArgumentException{
		Workspace newWorkspace = new Workspace();
		List<PoolElement> poolElements = newWorkspace.getPoolElements();
		List<Room>rooms = newWorkspace.getRooms();
		
		try {
			JSONArray pElements = json.getJSONArray("poolElements");
			for(int i = 0; i<pElements.length();i++) {
				Location location = parseLocation(pElements.getJSONObject(i).getString("pos"));
				int id = pElements.getJSONObject(i).getInt("id");
				String type = pElements.getJSONObject(i).getString("type");
				
				PoolElement poolElement = createPoolElement(id, type);
				poolElement.setLocation(location);
				poolElements.add(poolElement);
			}			
			JSONArray pRooms = json.getJSONArray("rooms");
			for(int i = 0; i<pRooms.length(); i++) {
				List<Location> location = new ArrayList<Location>();
				List<PortalGate> portalGate = new ArrayList<PortalGate>();
				for (int k = 0; k < pRooms.getJSONObject(i).getJSONArray("pos").length(); k++) {
					location.add(parseLocation(pRooms.getJSONObject(i).getJSONArray("pos").getString(k)));
				}
				for (int k = 0; k < pRooms.getJSONObject(i).getJSONArray("portalGates").length(); k++) {										
					portalGate.add(parsePortalGate(pRooms.getJSONObject(i).getJSONArray("portalGates").getJSONObject(k)));
				}
				int id = pRooms.getJSONObject(i).getInt("id");
					
				Room room = new Room(portalGate, location, id);
				rooms.add(room);
			}
		} catch (JSONException e) {
			throw new IllegalArgumentException();
		}
		workspace.add(newWorkspace);
	}
	

	public void setActiveLayout(int id) {
		if (getWorkspaceIdList().contains(id)) {
			this.activeWorkspace = getWorkspaceIdList().indexOf(id);
		}
	}
	
	public JSONArray getLayoutList() {
		JSONArray jsonArray = new JSONArray();
		getWorkspaceIdList().forEach(id -> {
			jsonArray.put(id);
		});
		return jsonArray;
	}
	
	public JSONObject getLayout() {
		return getLayout(activeWorkspace);
	}
	
	public JSONObject getLayout(int index) {
		JSONObject json = new JSONObject();
		JSONArray poolElementJSArray = new JSONArray();
		JSONArray roomsJS = new JSONArray();
		try {
			for(PoolElement poolElement : workspace.get(index).getPoolElements()) {
				JSONObject element = new JSONObject();
				element.put("id",poolElement.getId());
				element.put("pos", poolElement.getLocation().toString());
				element.put("type", poolElement.getType());
				poolElementJSArray.put(element);
			}
			
			for(Room room: workspace.get(index).getRooms()) {
				JSONObject roomJS = new JSONObject();
				JSONArray locationJS = new JSONArray();
				room.getLocation().forEach(location -> {
					locationJS.put(location.toString());
				});
				roomJS.put("pos", locationJS);
				roomJS.put("id", room.getId());
				
				JSONArray portalGateJSArray = new JSONArray();
				for(PortalGate portalGate : room.getPortalGate()) {
					JSONObject portalGateJS = new JSONObject();
					JSONArray locationPortalGateJS = new JSONArray();
					portalGate.getLocation().forEach(location -> {
						locationPortalGateJS.put(location.toString());
					});
					portalGateJS.put("pos", locationPortalGateJS);
					portalGateJS.put("type", portalGate.getType());					
					portalGateJSArray.put(portalGateJS);
				}
				roomJS.put("portalGates", portalGateJSArray);
				roomsJS.put(roomJS);
			}
			json.put("poolElements", poolElementJSArray);
			json.put("rooms", roomsJS);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public JSONObject getLearningDesk(int id) throws IllegalArgumentException{
		JSONObject learningDesk = new JSONObject();
		workspace.get(activeWorkspace).getPoolElements().forEach(poolElement -> {
			if (poolElement.getType().equals("PC") && poolElement.getId() == id) {
				
				try {
					learningDesk.put("id", poolElement.getId());
				} catch (JSONException e) {
					throw new IllegalArgumentException();
				}
			}
		});
		if (learningDesk.equals(null)) {
			throw new IllegalArgumentException();
		}
		return learningDesk;
	}
	
	public JSONArray getAllPcs() {
		JSONArray jsonArray = new JSONArray();
		workspace.get(activeWorkspace).getPoolElements().forEach((x) -> {
			if(x.getType().equals("PC")) {
				jsonArray.put(x.getId());
			}
		});
		return jsonArray;
	}
	
	public void setPCStatus(int id, String state) {
		workspace.get(activeWorkspace).getPoolElements().forEach((x) -> {
			if(x.getType().equals("PC") && x.getId()==id) {
				LearningDesk ld = (LearningDesk)x;
				ld.setState(getLearningDeskState(state));
			}
		});
	}
	
	public LearningDeskState getPCStatus(int id) {
		for(PoolElement x : workspace.get(activeWorkspace).getPoolElements()) {
			if(x.getType().equals("PC") && x.getId()==id) {
				LearningDesk ld = (LearningDesk)x;
				return ld.getState();
			}
		}
		return LearningDeskState.UNKNOWN;
	}
	
	private LearningDeskState getLearningDeskState(String state) {
		switch (state) {
			case "occupied": return LearningDeskState.OCCUPIED;
			case "free": return LearningDeskState.FREE;
			default: return LearningDeskState.UNKNOWN;
		}
	}
	
	
	private List<Integer> getWorkspaceIdList() {
		List<Integer> output = new ArrayList<Integer>();
		workspace.forEach(ws -> {
			output.add(ws.getId());
		});
		return output;
	}
	
	private PoolElement createPoolElement(int id, String type) {
		switch(type) {
			case "PC": 			return new LearningDesk(id, new Computer());
			case "Laptop": 		return new LearningDesk(id);
			case "wap": 		return new WirlessAccessPoint(id);
			case "printer":		return new Printer(id);	
			default : 			return null;
		}
	}
	
	private Location parseLocation(String pos) {		
		try {
			String[] temp = pos.split(",");		
			return new Location(Long.parseLong(temp[0]),Long.parseLong(temp[1]));
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
	
	private PortalGate parsePortalGate(JSONObject jsonObject)  {
		try {
			String type = jsonObject.getString("type");
			List<Location> location = new ArrayList<Location>();			
			for (int k = 0; k < jsonObject.getJSONArray("pos").length(); k++) {
				location.add(parseLocation(jsonObject.getJSONArray("pos").getString(k)));
			}
			return getPortalGate(type, location);
			
		} catch (JSONException e) {
			throw new IllegalArgumentException();
		}
	}

	private PortalGate getPortalGate(String type, List<Location> location) {
		switch(type) {
			case "door":			return new Door(location, type);
			case "breakthrough":	return new Breakthrough(location, type);
			default :				return null;
		}
	}
}
