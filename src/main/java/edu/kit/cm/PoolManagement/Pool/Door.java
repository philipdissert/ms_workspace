package edu.kit.cm.PoolManagement.Pool;

import lombok.Getter;

public class Door {
	
	public static final String DOORS = "doors";
	@Getter
	private Location location;
	@Getter
	private int length;
	
	public Door(Location location, int length) {
		this.location = location;
		this.length = length;
	}
}
