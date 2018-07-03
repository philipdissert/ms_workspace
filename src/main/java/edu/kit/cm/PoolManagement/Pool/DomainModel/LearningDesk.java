package edu.kit.cm.PoolManagement.Pool.DomainModel;

import java.text.ParseException;

import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class LearningDesk extends PoolElement {
	
	private Computer computer;
	private LearningDeskState state;

	public LearningDesk(int id, Computer computer) {		
		super(id, "PC");
		this.computer = computer;
	}
	
	public LearningDesk(int id) {		
		super(id, "Laptop");
	}
	
	public boolean hasComupter() {
		if(computer!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getType() {
		return hasComupter() ? "PC" : "Laptop";
	}
}
