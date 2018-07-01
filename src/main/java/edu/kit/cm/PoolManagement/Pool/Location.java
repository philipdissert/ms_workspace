package edu.kit.cm.PoolManagement.Pool;

import lombok.Getter;

public class Location{
	@Getter
	private long xPos;
	@Getter
	private long yPos;
	
	public Location(long xPos, long yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
/**
 * 
 * @return String in form <xPos>,<yPos>
 */
	public String toString() {
		String text = "" + this.xPos + "," + this.yPos;
		return text;
	}
	
}
