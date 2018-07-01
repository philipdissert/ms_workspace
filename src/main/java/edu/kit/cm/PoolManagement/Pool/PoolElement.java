package edu.kit.cm.PoolManagement.Pool;

import java.text.ParseException;

import edu.kit.cm.PoolManagement.Parser.PoolParser;
import lombok.Getter;
import lombok.Setter;

public abstract class PoolElement {
	@Getter
	protected int id;
	@Getter @Setter
	protected Location location;
	protected String elementNamen = "pls insert name in subclass";
	
	public String getName() {
		return elementNamen;
	}
	
	/**
	 * 
	 * @param name name of the Element in format <name><id>
	 * @param parameter  input String in format <xPos1>,<yPos1>;<xPos2>,<yPos2>
	 * @return RoomElement
	 * @throws ParseException if Input wasn't in the correct format
	 */
	public static PoolElement getPoolElement(String name, String parameter) throws ParseException {
		PoolElement output = null;
		switch(PoolParser.parseElementName(name)) {
		case "PC": output = new LearningDesk(PoolParser.parseLocation(parameter), PoolParser.parseId(name), true); break;
		case "Laptop": output = new LearningDesk(PoolParser.parseLocation(parameter), PoolParser.parseId(name), false); break;
		}
		return output;
	}
}
