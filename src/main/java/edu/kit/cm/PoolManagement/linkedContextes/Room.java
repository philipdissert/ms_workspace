package edu.kit.cm.PoolManagement.linkedContextes;

import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.PoolManagement.Pool.DomainModel.Location;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Room {
	
	private List<Door> doors;
	private Location pos1;
	private Location pos2;
	private int id;
	
	public Room() {
		doors = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Room [doors=" + doors + ", pos1=" + pos1 + ", pos2=" + pos2 + ", id=" + id + "]";
	}
	
	
//	public static final String ROOMS = "rooms";
//	
//	@Getter
//	private Location location1;
//	@Getter
//	private Location location2;
//	@Getter
//	private int id;
//	@Getter
//	private List<Door> doors;
//
//	public Room(int id, Location location1, Location location2, List<Door> doors) {
//		this.location1 = location1;
//		this.location2 = location2;
//		this.id = id;
//		this.doors = doors;
//	}
	
}
