package edu.kit.cm.PoolManagement.Pool;

import lombok.Getter;
import lombok.Setter;

public class LearningDeskLaptop extends PoolElement{
	public static final String ELEMENT_NAME = "Laptop";
	
	@Getter @Setter
	private LearningDeskState state;
	
	public LearningDeskLaptop(Location location, int id) {
		this.location = location;
		this.id = id;
		this.elementNamen = ELEMENT_NAME;
	}	
}
