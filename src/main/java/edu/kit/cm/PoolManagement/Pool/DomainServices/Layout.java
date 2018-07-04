package edu.kit.cm.PoolManagement.Pool.DomainServices;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.PoolManagement.Pool.DomainModel.Computer;
import edu.kit.cm.PoolManagement.Pool.DomainModel.LearningDesk;
import edu.kit.cm.PoolManagement.Pool.DomainModel.Location;
import edu.kit.cm.PoolManagement.Pool.DomainModel.Pool;
import edu.kit.cm.PoolManagement.Pool.DomainModel.PoolElement;
import edu.kit.cm.PoolManagement.Pool.DomainModel.Printer;
import edu.kit.cm.PoolManagement.Pool.DomainModel.WirlessAccessPoint;
import edu.kit.cm.PoolManagement.linkedContextes.Door;
import edu.kit.cm.PoolManagement.linkedContextes.Room;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Layout {
	
	private Pool pool;
	
	public Layout() {
		pool = new Pool();
	}
	
	
	@Override
	public String toString() {
		return "Layout [poolElements=" + pool.getPoolElements() + ", rooms=" + pool.getRooms() + "]";
	}

//	private List<PoolElement> poolElements;
//	private List<Room> rooms;
	
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
	
	public void change(JSONObject json) {
		pool = new Pool();
		List<PoolElement> poolElements = pool.getPoolElements();
		List<Room>rooms = pool.getRooms();
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
			e.printStackTrace();//Falsches Format
		}
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		JSONArray poolElementJSArray = new JSONArray();
		JSONArray roomsJS = new JSONArray();
		System.out.println("test"+poolElementJSArray);
		try {
			for(PoolElement poolElement : pool.getPoolElements()) {
				JSONObject element = new JSONObject();
				element.put("id",poolElement.getId());
				element.put("pos", poolElement.getLocation().toString());
				element.put("type", poolElement.getType());
				poolElementJSArray.put(element);
			}
			
			for(Room room: pool.getRooms()) {
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
}
