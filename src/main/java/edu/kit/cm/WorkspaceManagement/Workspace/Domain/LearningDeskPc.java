package edu.kit.cm.WorkspaceManagement.Workspace.Domain;



public class LearningDeskPc extends WorkspaceElement {
	

	public LearningDeskPc(int id, Location location) {		
		super(id, "PC", location);
	}
	
	public String getName() {
		return this.getType()+":"+this.getId();
	}
	
}
