package edu.kit.cm.PoolManagement.Pool;

import java.text.ParseException;
import java.util.List;

import edu.kit.cm.PoolManagement.Pool.Parser.PoolParser;
import lombok.Getter;

public class Room extends PoolElement{
	public static final String ELEMENT_NAME = "Room";
	
	@Getter
	private Location location2;

	public Room(int id, Location location1, Location location2) {
		this.location = location1;
		this.location2 = location2;
		this.id = id;
		this.elementNamen = ELEMENT_NAME;
	}
	
	/**
	 * gives Location as String back
	 * @return xPos1,yPos1;xPos2,yPos2
	 */
	public String locationToString() {
		return this.location.toString() + ";" + this.location2.toString();
	}
	
	/**
	 * 
	 * @param name name of the Element in format <name><id>
	 * @param parameter  input String in format <xPos1>,<yPos1>;<xPos2>,<yPos2>
	 * @return room
	 * @throws ParseException if Input wasn't in the correct format
	 */
	public static Room getRoom(String name, String parameter) throws ParseException{
		List<Location> list = PoolParser.parseLocationList(parameter);
		return new Room(PoolParser.parseId(name),list.get(0), list.get(1));
	}
}
