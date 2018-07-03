package edu.kit.cm.PoolManagement.Pool.DomainModel;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Location{
	
	private long xPos;
	private long yPos;
	
	public Location(long xPos, long yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	@Override
	public String toString() {
		return xPos+","+yPos;
	}
}
