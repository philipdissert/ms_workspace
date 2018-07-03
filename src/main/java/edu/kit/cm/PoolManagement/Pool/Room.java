package edu.kit.cm.PoolManagement.Pool;

import java.util.List;

import lombok.Getter;

public class Room {
	public static final String ROOMS = "rooms";
	
	@Getter
	private Location location1;
	@Getter
	private Location location2;
	@Getter
	private int id;
	@Getter
	private List<Door> doors;

	public Room(int id, Location location1, Location location2, List<Door> doors) {
		this.location1 = location1;
		this.location2 = location2;
		this.id = id;
		this.doors = doors;
	}
	
}
