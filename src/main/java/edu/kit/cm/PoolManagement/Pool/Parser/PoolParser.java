package edu.kit.cm.PoolManagement.Pool.Parser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.PoolManagement.Pool.Location;

public class PoolParser {
	
	/**
	 * gives the id back
	 * @param text String in form "name of RoomELement" + "id"
	 * @return id
	 * @throws ParseException if Input wasn't in the correct format
	 */
	public static int parseId(String text) throws ParseException {
		String number = text.replaceAll("[^-?0-9]+", " ").trim();
		try {
			return Integer.parseInt(number);
		} catch(NumberFormatException e) {
			throw new ParseException("Input in wrong format", 23);
		}
	}
	
	/**
	 * gives the name of an RoomElement back
	 * @param text String in form "name of RoomELement" + "id"
	 * @return name of RoomELement
	 * @throws ParseException if Input wasn't in the correct format
	 */
	public static String parseElementName(String text) throws ParseException {
		String temp = "" + parseId(text);
		try {
			return text.substring(0, text.length() - temp.length());	
		} catch(IndexOutOfBoundsException e) {
			throw new ParseException("Input in wrong format", 38);
		}
			
	}
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
	
	/**
	 * gives an List of the Positions of an Room
	 * @param text input String in format xPos1,yPos1;xPos2,yPos2
	 * @return List<Location> with the Locations of an Room
	 * @throws ParseException if Input wasn't in the correct format
	 */
	public static List<Location> parseLocationList(String text) throws ParseException{
			String[] temp = text.split(";");
		
		List<Location> list = new ArrayList<Location>();
		for(int i = 0; i < temp.length; i++) {
			list.add(parseLocation(temp[i]));
		}
		return list;
	}
}
