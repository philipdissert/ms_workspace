package edu.kit.cm.PoolManagement.Pool;

import lombok.Getter;
import lombok.Setter;

public class LearningDeskPc extends PoolElement{
	public static final String ELEMENT_NAME = "PC";
	
	@Getter @Setter
	private LearningDeskState state;
	
	public LearningDeskPc(Location location, int id) {
		this.location = location;
		this.id = id;
		this.elementNamen = ELEMENT_NAME;
	}	
	
}
