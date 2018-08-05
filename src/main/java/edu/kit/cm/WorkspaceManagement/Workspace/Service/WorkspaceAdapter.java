package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.LearningDeskLaptop;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.LearningDeskPc;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Workspace;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.PoolElement;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Printer;
import edu.kit.cm.WorkspaceManagement.Workspace.Domain.WirlessAccessPoint;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Passage;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Door;
import edu.kit.cm.WorkspaceManagement.linkedContextes.PortalGate;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;

public class WorkspaceAdapter {
	
	private static WorkspaceAdapter workspaceAdapter = new WorkspaceAdapter();
	private Workspace workspace;
	
	private WorkspaceAdapter() {
		this.workspace = new Workspace();
	}
	
	public static WorkspaceAdapter getInstance() {
		return workspaceAdapter;
	}
	
	public void addLayout(JSONObject json) throws IllegalArgumentException, JSONException{
		Workspace newWorkspace = new Workspace();
		List<PoolElement> poolElements = newWorkspace.getPoolElements();
		List<Room>rooms = newWorkspace.getRooms();

		JSONArray pElements = new JSONArray();
		try {
			pElements = json.getJSONArray("poolElements");
		} catch (Exception e) {
		}
			for(int i = 0; i<pElements.length();i++) {
				Location location = new Location(pElements.getJSONObject(i).getJSONObject("pos").getInt("x"),
							pElements.getJSONObject(i).getJSONObject("pos").getInt("y"));
				int id = pElements.getJSONObject(i).getInt("id");
				String type = pElements.getJSONObject(i).getString("type");
				int length = pElements.getJSONObject(i).getInt("length");
				int width = pElements.getJSONObject(i).getInt("width");

				PoolElement poolElement = createPoolElement(id, type, location);
				poolElement.setLength(length);
				poolElement.setWidth(width);
				poolElements.add(poolElement);
			}

		try {
			JSONArray pRooms = json.getJSONArray("rooms");
			for(int i = 0; i<pRooms.length(); i++) {
				List<Location> location = new ArrayList<Location>();
				List<PortalGate> portalGate = new ArrayList<PortalGate>();
				for (int k = 0; k < pRooms.getJSONObject(i).getJSONArray("pos").length(); k++) {
					JSONArray pos = pRooms.getJSONObject(i).getJSONArray("pos");
					location.add(new Location(pos.getJSONObject(k).getInt("x"), pos.getJSONObject(k).getInt("y")));					
				}
				
				for (int k = 0; k < pRooms.getJSONObject(i).getJSONArray("portalGates").length(); k++) {										
					portalGate.add(parsePortalGate(pRooms.getJSONObject(i).getJSONArray("portalGates").getJSONObject(k)));
				}
				int id = pRooms.getJSONObject(i).getInt("id");
					
				Room room = new Room(portalGate, location, id);
				rooms.add(room);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		this.workspace = newWorkspace;
	}
	
	public JSONObject getLayout() {
		JSONObject json = new JSONObject();
		JSONArray poolElementJSArray = new JSONArray();
		JSONArray roomsJS = new JSONArray();
		try {
			for(PoolElement poolElement : this.workspace.getPoolElements()) {
				JSONObject element = new JSONObject();
				JSONObject pos = new JSONObject();
				pos.put("x", poolElement.getLocation().getXPos());
				pos.put("y", poolElement.getLocation().getYPos());
				element.put("id",poolElement.getId());
				element.put("pos", pos);
				element.put("type", poolElement.getType());
				element.put("width", poolElement.getWidth());
				element.put("length", poolElement.getLength());
				poolElementJSArray.put(element);
			}
			
			for(Room room: this.workspace.getRooms()) {
				JSONObject roomJS = new JSONObject();
				JSONArray locationJS = new JSONArray();
				room.getLocation().forEach(location -> {
					JSONObject pos = new JSONObject();
					try {
						pos.put("x", location.getXPos());
						pos.put("y", location.getYPos());
					} catch (JSONException e) {

					}
					locationJS.put(pos);
				});
				roomJS.put("pos", locationJS);
				roomJS.put("id", room.getId());
				JSONArray portalGateJSArray = new JSONArray();
				for(PortalGate portalGate : room.getPortalGate()) {
					JSONObject portalGateJS = new JSONObject();
					JSONArray locationPortalGateJS = new JSONArray();
					portalGate.getLocation().forEach(location -> {
						JSONObject pos = new JSONObject();
						try {
							pos.put("x", location.getXPos());
							pos.put("y", location.getYPos());
						} catch (JSONException e) {
						}
						locationPortalGateJS.put(pos);
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
		this.workspace.getPoolElements().forEach(poolElement -> {
			if (poolElement.getType().equals("PC") && poolElement.getId() == id) {				
				try {
					learningDesk.put("id", poolElement.getId());
					learningDesk.put("type", poolElement.getType());
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
	
	public JSONObject getLearningDesks() {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		this.workspace.getPoolElements().forEach(poolElement -> {
			JSONObject learningDesk = new JSONObject();
			if (poolElement.getType().equals("PC")) {				
				try {
					learningDesk.put("id", poolElement.getId());
					learningDesk.put("type", poolElement.getType());
					jsonArray.put(learningDesk);
				} catch (JSONException e) {
					throw new IllegalArgumentException();
				}
			}			
		});
		try {
			jsonObject.put("data", jsonArray);
		} catch (JSONException e) {
		}
		return jsonObject;
	}

	public JSONObject getOpeningHours() throws JSONException{
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		this.workspace.getOpeningHours().getOpeningHourList().forEach(openingHour -> {
			JSONObject entry = new JSONObject();
			try {
				entry.put("dayOfWeek", openingHour.getWeekDay());
				entry.put("startTime", openingHour.getStart());
				entry.put("endTime", openingHour.getEnd());
				jsonArray.put(entry);	
			} catch (Exception e) {
				
			}			
		});
		jsonObject.put("openingHours",jsonArray);
		return jsonObject;
	}
	
	private PoolElement createPoolElement(int id, String type, Location location) {
		switch(type) {
			case "PC": 			return new LearningDeskPc(id, location);
			case "Laptop": 		return new LearningDeskLaptop(id, location);
			case "wap": 		return new WirlessAccessPoint(id, location);
			case "Printer":		return new Printer(id, location);	
			default : 			return null;
		}
	}
	
	
	private PortalGate parsePortalGate(JSONObject jsonObject)  {
		try {
			String type = jsonObject.getString("type");
			List<Location> location = new ArrayList<Location>();			
			for (int k = 0; k < jsonObject.getJSONArray("pos").length(); k++) {
				int xPos = jsonObject.getJSONArray("pos").getJSONObject(k).getInt("x");
				int yPos = jsonObject.getJSONArray("pos").getJSONObject(k).getInt("y");
				location.add(new Location(xPos, yPos));
			}
			return getPortalGate(type, location);
			
		} catch (JSONException e) {
			throw new IllegalArgumentException();
		}
	}

	private PortalGate getPortalGate(String type, List<Location> location) {
		switch(type) {
			case "door":			return new Door(location);
			case "passage":			return new Passage(location);
			default :				return null;
		}
	}

}
