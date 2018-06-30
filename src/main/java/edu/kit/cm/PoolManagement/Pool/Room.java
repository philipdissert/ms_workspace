package edu.kit.cm.PoolManagement.Pool;

import java.util.List;

import edu.kit.cm.PoolManagement.Parser.PoolParser;
import lombok.Getter;

public class Room extends PoolElement{
	@Getter
	private Location location2;

	public Room(int id, Location location1, Location location2) {
		this.location = location1;
		this.location2 = location2;
		this.id = id;
		this.elementNamen = "Room";
	}
	
	public String locationToString() {
		return this.location.toString() + ";" + this.location2.toString();
	}
	
	public static Room roomFromString(int id, String text) {
		Location[] location2 = new Location[2];
		String location[] = text.split(";");
		for (int i = 0; i < location.length; i++) {
			String position[] = location[i].split(",");
			int pos[] = new int[2];
			for(int k = 0; k < position.length; k++) {
				pos[k] = Integer.parseInt(position[k]);
			}
			location2[i] = new Location(pos[0], pos[1]);
		}
		return new Room(id, location2[0], location2[1]);
	}
	
	public static Room getRoom(String name, String parameter) {
		List<Location> list = PoolParser.parseLocationList(parameter);
		return new Room(PoolParser.parseId(name),list.get(0), list.get(1));
	}
}
