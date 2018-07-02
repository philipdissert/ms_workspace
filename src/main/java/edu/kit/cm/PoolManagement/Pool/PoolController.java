package edu.kit.cm.PoolManagement.Pool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class PoolController implements PoolInterface{
	private static List<Room> rooms = new ArrayList<Room>();
	private static List<PoolElement> roomElement = new ArrayList<PoolElement>();
	private static Pool pool = new Pool(1, rooms, roomElement);

	
	@Override
	public JSONObject getLayout()  {
		JSONObject layout = new JSONObject();
		String existingElements = "";
		for(int i = 0; i < pool.getRooms().size(); i++) {
			Room room = pool.getRooms().get(i);
			
			if(existingElements.length() == 0) {
				existingElements += room.getName() + room.getId();
			}
			else {
				existingElements += ","+ room.getName() + room.getId();
			}
			
			try {
				layout.put(room.getName() + room.getId(), room.locationToString());
			} catch (JSONException ex) {
				try {
					layout.put("Error", "in PoolAdapter");
				} catch (JSONException e) {
				}
			}
		}
		
		for(int i = 0; i < pool.getRoomElement().size(); i++) {
			PoolElement element = pool.getRoomElement().get(i);
			if(existingElements.length() == 0) {
				existingElements += element.getName() + element.getId();
			}
			else {
				existingElements += "," + element.getName() + element.getId();
			}
			try {
				layout.put(element.getName() + element.getId(), element.getLocation().toString());
				if (i == pool.getRoomElement().size() - 1) {
					layout.put(PoolElement.AVAILABLE_ELEMENTS, existingElements);
				}
			} catch (JSONException e) {
				System.out.println("Error in PoolAdapter.getLayout");
			}
		}
		return layout;
	}

	@Override
	public void createNewLayout(JSONObject layout)  throws IllegalArgumentException{
		
		try {
			pool = Pool.createPool(layout);
		} catch (ParseException e) {
			throw new IllegalArgumentException();
		}
		
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
