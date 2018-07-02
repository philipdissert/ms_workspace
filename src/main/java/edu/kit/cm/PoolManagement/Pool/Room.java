package edu.kit.cm.PoolManagement.Pool;

import lombok.Getter;

public class Room {
	public static final String ROOMS = "rooms";
	
	@Getter
	private Location location1;
	@Getter
	private Location location2;
	@Getter
	private int id;

	public Room(int id, Location location1, Location location2) {
		this.location1 = location1;
		this.location2 = location2;
		this.id = id;
	}
	
}
