package edu.kit.cm.WorkspaceManagement.Workspace.Domain;



public class LearningDeskPc extends PoolElement {
	

	public LearningDeskPc(int id, Location location) {		
		super(id, "PC", location);
	}
	
	public String getName() {
		return this.getType()+":"+this.getId();
	}
	
}
