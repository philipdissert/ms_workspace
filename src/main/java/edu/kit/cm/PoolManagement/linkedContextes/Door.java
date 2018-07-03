package edu.kit.cm.PoolManagement.linkedContextes;

import edu.kit.cm.PoolManagement.Pool.DomainModel.Location;
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

	@Override
	public String toString() {
		return "Door [location=" + location + ", length=" + length + "]";
	}

}
