package edu.kit.cm.PoolManagement.Pool;

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
	
	public static Pool createPool (JSONObject json) {
		List<Room> room = new ArrayList<Room>();
		List<PoolElement> element = new ArrayList<PoolElement>();
		String temp = "";
		
		try {
			temp = json.getString("existingElements");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String[] elementeArray = temp.split(",");
		for (int i = 0; i < elementeArray.length; i++) {
			String parameter = "";
			try {
				parameter = json.getString(elementeArray[i]);
			} catch (JSONException e) {
				e.printStackTrace();
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
