package edu.kit.cm.PoolManagement.Pool.Parser;

import java.text.ParseException;

import edu.kit.cm.PoolManagement.Pool.Location;

public class PoolParser {
	
	/**
	 * gives an Location Object back out of an String
	 * @param text in format xPosition,yPosition
	 * @return Location Object
	 * @throws ParseException if Input wasn't in the correct format
	 */
	public static Location parseLocation(String text) throws ParseException{
		try {
			String[] temp = text.split(",");		
			return new Location(Long.parseLong(temp[0]),Long.parseLong(temp[1]));
		} catch(NumberFormatException e) {
			throw new ParseException("Input in wrong format", 53);
		}

	}
	
}
