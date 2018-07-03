package edu.kit.cm.PoolManagement.Pool.DomainModel;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PoolElement {
	private Location location;
	private int id;
	private String type;
	
	public PoolElement(int id, String type) {
		this.id = id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "PoolElement [location=" + location + ", id=" + id + ", type=" + type + "]";
	}
}
