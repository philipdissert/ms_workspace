package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Computer;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.LearningDesk;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Workspace;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.PoolElement;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Printer;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.WirlessAccessPoint;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Door;
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
	
	public void addLayout(JSONObject json) {
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
				Location pos1 = parseLocation(pRooms.getJSONObject(i).getString("pos1"));
				Location pos2 = parseLocation(pRooms.getJSONObject(i).getString("pos2"));
				int id = pRooms.getJSONObject(i).getInt("id");
				JSONArray doors = pRooms.getJSONObject(i).getJSONArray("doors");
				List<Door> doorList = new ArrayList<>();
				for(int j = 0; j<doors.length(); j++) {
					Location location = parseLocation(doors.getJSONObject(j).getString("pos"));
					int length = doors.getJSONObject(j).getInt("length");
					doorList.add(new Door(location, length));
				}
				Room room = new Room();
				room.setDoors(doorList);
				room.setPos1(pos1);
				room.setPos2(pos2);
				room.setId(id);
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
				roomJS.put("pos1", room.getPos1().toString());
				roomJS.put("pos2", room.getPos2().toString());
				roomJS.put("id", room.getId());
				JSONArray doorsJS = new JSONArray();
				for(Door door : room.getDoors()) {
					JSONObject doorJS = new JSONObject();
					doorJS.put("length",door.getLength());
					doorJS.put("pos",door.getLocation().toString());
					doorsJS.put(doorJS);
				}
				roomsJS.put(roomJS);
			}
			json.put("poolElements", poolElementJSArray);
			json.put("rooms", roomsJS);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
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
}
