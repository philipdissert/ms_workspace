package edu.kit.cm.PoolManagement.Parser;

import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.PoolManagement.Pool.Location;

public class PoolParser {
	
	
	public static int parseId(String text) {
		String number = text.replaceAll("[^-?0-9]+", " ").trim();
		return Integer.parseInt(number);
	}
	
	public static String parseElementName(String text) {
		String temp = "" + parseId(text);
		return text.substring(0, text.length() - temp.length());		
	}
	
	public static Location parseLocation(String text) {
		String[] temp = text.split(",");		
		return new Location(Long.parseLong(temp[0]),Long.parseLong(temp[1]));
	}
	
	public static List<Location> parseLocationList(String text) {
		String[] temp = text.split(";");
		List<Location> list = new ArrayList<Location>();
		for(int i = 0; i < temp.length; i++) {
			list.add(parseLocation(temp[i]));
		}
		return list;
	}
}
