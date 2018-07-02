package edu.kit.cm.PoolManagement.Pool;

import lombok.Getter;
import lombok.Setter;

public class LearningDesk extends PoolElement{
	public static final String ELEMENT_NAME = "PC";
	
	@Getter @Setter
	private LearningDeskState state;
	@Getter
	private boolean hasPc;
	
	public LearningDesk(Location location, int id, boolean hasPC) {
		this.location = location;
		this.id = id;
		this.hasPc = hasPC;
		if (hasPC) {
			this.elementNamen = ELEMENT_NAME;	
		} else  {
			this.elementNamen = "Laptop";
		}

	}	
	
}
