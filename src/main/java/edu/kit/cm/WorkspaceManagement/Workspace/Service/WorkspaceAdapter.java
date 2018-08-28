package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.*;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.WorkspaceManagement.linkedContextes.Passage;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Door;
import edu.kit.cm.WorkspaceManagement.linkedContextes.PortalGate;
import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service@Scope("singleton")
public class WorkspaceAdapter {
	@Autowired
	private WorkspaceDataService workspaceDataService;

	@Getter
	private Workspace workspace;
	
	public WorkspaceAdapter() {
		this.workspace = new Workspace();
	}

	public JSONObject getLayout() {
		return getLayout(this.workspace);
	}

	public JSONObject getLayout(Workspace workspace) {
		return workspaceToJson(workspace);
	}

	public JSONObject getLayout(int id) {return getLayout(workspaceDataService.getWorkspace(id)); }

	public JSONArray getLayoutList() {
		JSONArray jsonArray = new JSONArray();
		List<Integer> list = workspaceDataService.getWorkspaceList();
		list.forEach(x-> {
			jsonArray.put(x);
		});
		return jsonArray;
	}

	public Workspace addLayout(JSONObject jsonObject, int id) {
		Workspace workspace = jsonToWorkspace(jsonObject);
		workspace.setId(id);
		if(workspaceDataService.getWorkspaceList().contains(id)) {
			workspaceDataService.deleteWorkspace(id);
		}
		workspaceDataService.safeWorkspace(workspace);
		return workspace;
	}

	public void changeToLayout(int id) {
		workspace = workspaceDataService.getWorkspace(id);
	}


	
	public JSONObject getLearningDesk(int id) throws IllegalArgumentException{
		JSONObject learningDesk = new JSONObject();
		this.workspace.getWorkspaceElements().forEach(poolElement -> {
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
		this.workspace.getWorkspaceElements().forEach(poolElement -> {
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
		this.workspace.getOpeningHours().forEach(openingHour -> {
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

	public void addOpeningHours(JSONObject jsonObject, int workspaceId) {
		JSONArray jsonArray = jsonObject.getJSONArray("openingHours");
		List<OpeningHour> openingHours = new ArrayList<>();
		jsonArray.forEach(x-> {
			JSONObject oh = (JSONObject) x;
			LocalTime start = LocalTime.parse(oh.getString("startTime"));
			LocalTime end = LocalTime.parse(oh.getString("endTime"));
			DayOfWeek dayOfWeek = DayOfWeek.valueOf(oh.getString("dayOfWeek"));
			openingHours.add(new OpeningHour(dayOfWeek, start, end));
		});
		Workspace workspace = workspaceDataService.getWorkspace(workspaceId);
		workspace.setOpeningHours(openingHours);
		workspaceDataService.safeWorkspace(workspace);

		if (this.workspace.getId() == workspaceId) {
			changeToLayout(workspaceId);
		}
	}
	
	private WorkspaceElement createPoolElement(int id, String type, Location location) {
		switch(type) {
			case "PC": 			return new LearningDeskPc(id, location);
			case "Laptop": 		return new LearningDeskLaptop(id, location);
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

	public void init() {
		if (workspaceDataService.getWorkspaceList() == null || workspaceDataService.getWorkspaceList().size() == 0) {
			PoolController.init(this);
		}
		changeToLayout(workspaceDataService.getWorkspaceList().get(0));
	}

	public Workspace jsonToWorkspace(JSONObject json) throws IllegalArgumentException, JSONException{
		Workspace newWorkspace = new Workspace();
		List<WorkspaceElement> workspaceElements = newWorkspace.getWorkspaceElements();
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

			WorkspaceElement workspaceElement = createPoolElement(id, type, location);
			workspaceElement.setLength(length);
			workspaceElement.setWidth(width);
			workspaceElements.add(workspaceElement);
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
		return newWorkspace;
	}

	public JSONObject workspaceToJson(Workspace localWorkspace) {
		JSONObject json = new JSONObject();
		JSONArray poolElementJSArray = new JSONArray();
		JSONArray roomsJS = new JSONArray();
		try {
			for(WorkspaceElement workspaceElement : localWorkspace.getWorkspaceElements()) {
				JSONObject element = new JSONObject();
				JSONObject pos = new JSONObject();
				pos.put("x", workspaceElement.getLocation().getXPos());
				pos.put("y", workspaceElement.getLocation().getYPos());
				element.put("id", workspaceElement.getId());
				element.put("pos", pos);
				element.put("type", workspaceElement.getType());
				element.put("width", workspaceElement.getWidth());
				element.put("length", workspaceElement.getLength());
				poolElementJSArray.put(element);
			}

			for(Room room: localWorkspace.getRooms()) {
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

}
