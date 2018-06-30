package edu.kit.cm.PoolManagement.Pool;

import lombok.Getter;
import lombok.Setter;

public class LearningDesk extends PoolElement{
	@Getter @Setter
	private LearningDeskState state;
	@Getter
	private boolean hasPc;
	
	public LearningDesk(Location location, int id, boolean hasPC) {
		this.location = location;
		this.id = id;
		this.hasPc = hasPC;
		if (hasPC) {
			this.elementNamen = "PC";	
		} else  {
			this.elementNamen = "Laptop";
		}

	}	
	
}
