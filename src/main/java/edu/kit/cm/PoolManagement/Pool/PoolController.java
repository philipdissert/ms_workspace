package edu.kit.cm.PoolManagement.Pool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import lombok.Getter;

public class PoolController implements PoolInterface{
	private static List<Room> rooms = new ArrayList<Room>();
	private static List<PoolElement> roomElement = new ArrayList<PoolElement>();
	@Getter
	private static Pool pool = new Pool(1, rooms, roomElement);

	
	@Override
	public JSONObject getLayout()  {
		JSONObject layout = new JSONObject();
		JSONArray elements = new JSONArray();	
		JSONArray rooms = new JSONArray();
		
		for(int i = 0; i < pool.getRoomElement().size(); i++) {
			PoolElement poolElement = pool.getRoomElement().get(i);
			
			JSONObject element = new JSONObject();
			try {
				element.put("id", poolElement.getId());
				element.put("pos", poolElement.getLocation().toString());
				element.put("type", poolElement.getName());				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			elements.put(element);
		}

		for(int i = 0; i < pool.getRooms().size(); i++) {
			Room roomElement = pool.getRooms().get(i);
			
			JSONObject room = new JSONObject();
			try {
				room.put("id", roomElement.getId());
				room.put("pos1", roomElement.getLocation1().toString());
				room.put("pos2", roomElement.getLocation2().toString());	
				
				JSONArray doors= new JSONArray();
				for (int k = 0; k < roomElement.getDoors().size(); k++) {					
					JSONObject door = new JSONObject();
					door.put("pos", roomElement.getDoors().get(k).getLocation());
					door.put("length", roomElement.getDoors().get(k).getLength());
					doors.put(door);
				}
				room.put(Door.DOORS, doors);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			rooms.put(room);
		}
		try {
			layout.put(PoolElement.ELEMENTS, elements);
			layout.put(Room.ROOMS, rooms);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return layout;
	}

	@Override
	public void createNewLayout(JSONObject layout)  throws IllegalArgumentException{
			pool = Pool.createPool(layout);		
	}

	@Override
	public JSONObject getCurrentState() {
		return null;
	}
	
	public void init() {
		String text = "";
		try {
			java.nio.file.Path path = Paths.get("C:\\Users\\Steffen\\Documents\\_Studium\\PSE\\GIT\\PoolManagement\\iot_atis_iosb\\src\\main\\resources\\layout.json");
			text = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			JSONObject obj = new JSONObject(text);
			createNewLayout(obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
