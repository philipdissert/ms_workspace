package edu.kit.cm.PoolManagement.Pool;

import java.text.ParseException;

import lombok.Getter;
import lombok.Setter;

public abstract class PoolElement {
	
	public static final String ELEMENTS = "poolElements";
	
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
	public static PoolElement getPoolElement(String type, int id, Location location) {
		PoolElement output = null;
		switch(type) {
		case LearningDeskPc.ELEMENT_NAME: output = new LearningDeskPc(location, id); break;
		case LearningDeskLaptop.ELEMENT_NAME: output = new LearningDeskLaptop(location, id); break;
		}
		return output;
	}
}
