package edu.kit.cm.PoolManagement.Pool;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.PoolManagement.Parser.PoolParser;
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
	 * @param json jsnon datei in format {"existingElements":"PC1,...,Room3", "PC1": "2,1", ... ,"Room3":"2,3;3,4"}
	 * @return pool 
	 * @throws ParseException if input is in wrong format
	 */
	public static Pool createPool (JSONObject json) throws ParseException {
		List<Room> room = new ArrayList<Room>();
		List<PoolElement> element = new ArrayList<PoolElement>();
		String temp = "";
		
		try {
			temp = json.getString("existingElements");
		} catch (JSONException e) {
			throw new ParseException("Input in wrong format", 42);
		}
		String[] elementeArray = temp.split(",");
		for (int i = 0; i < elementeArray.length; i++) {
			String parameter = "";
			try {
				parameter = json.getString(elementeArray[i]);
			} catch (JSONException e) {
				throw new ParseException("Input in wrong format", 50);
			}
			
			if (PoolParser.parseElementName(elementeArray[i]).equals("Room")) {
				room.add(Room.getRoom(elementeArray[i], parameter));
			} else {
				element.add(PoolElement.getPoolElement(elementeArray[i], parameter));
			}
		}			
		return new Pool(1, room, element);
	}
}
