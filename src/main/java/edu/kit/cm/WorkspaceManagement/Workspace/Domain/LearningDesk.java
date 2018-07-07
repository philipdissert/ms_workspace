package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class LearningDesk extends PoolElement {
	
	private Computer computer;
	private LearningDeskState state;

	public LearningDesk(int id, Computer computer) {		
		super(id, "PC");
		this.computer = computer;
		state = LearningDeskState.UNKNOWN;
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
	
	public String getName() {
		return this.getType()+":"+this.getId();
	}
	
	public String getType() {
		return hasComupter() ? "PC" : "Laptop";
	}
}
