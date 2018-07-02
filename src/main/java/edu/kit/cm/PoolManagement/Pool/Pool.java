package edu.kit.cm.PoolManagement.Pool;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.PoolManagement.Pool.Parser.PoolParser;
import lombok.Getter;
import lombok.Setter;

public class Pool {
	@Getter
	private int id;
	@Getter @Setter
	private List<Room> rooms;
	@Getter @Setter
	private List<PoolElement> roomElement;
	 
	public Pool(int id, List<Room> rooms, List<PoolElement> roomElement) {
		this.id = id;
		this.rooms = rooms;
		this.roomElement = roomElement;
	}
	
	/**
	 * 
	 * @param json json datei in format {"existingElements":"PC1,...,Room3", "PC1": "2,1", ... ,"Room3":"2,3;3,4"}
	 * @return pool 
	 * @throws ParseException if input is in wrong format
	 */
	public static Pool createPool (JSONObject json) throws ParseException {
		List<Room> room = new ArrayList<Room>();
		List<PoolElement> element = new ArrayList<PoolElement>();
		JSONArray jsonArray;
		
		try {
			jsonArray = json.getJSONArray(PoolElement.ELEMENTS);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Location location = PoolParser.parseLocation(jsonObject.getString("pos"));
				int id = jsonObject.getInt("id");
				String type = jsonObject.getString("type");					
				element.add(PoolElement.getPoolElement(type, id, location));
			}
			
			jsonArray = json.getJSONArray(Room.ROOMS);	
			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Location location1 = PoolParser.parseLocation(jsonObject.getString("pos1"));
				Location location2 = PoolParser.parseLocation(jsonObject.getString("pos2"));
				int id = jsonObject.getInt("id");			
				room.add(new Room(id, location1, location2));
			}
			
		} catch (JSONException e) {
			throw new ParseException("Input in wrong format", 42);
		}
		
		return new Pool(1, room, element);
	}
}
