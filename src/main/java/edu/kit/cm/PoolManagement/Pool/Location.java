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
	
	/**
	 * gives an Location Object back out of an String
	 * @param text in format xPosition,yPosition
	 * @return Location Object
	 * @throws IllegalArgumentException if Input wasn't in the correct format
	 */
	public static Location parseLocation(String text) throws IllegalArgumentException{
		try {
			String[] temp = text.split(",");		
			return new Location(Long.parseLong(temp[0]),Long.parseLong(temp[1]));
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException();
		}

	}
	
}
