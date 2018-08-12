package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public abstract class WorkspaceElement {
	private Location location;
	private int id;
	private String type;
	private int length;
	private int width;
	
	public WorkspaceElement(int id, String type, Location location) {
		this.id = id;
		this.type = type;
		this.location = location;
		this.length = 10;
		this.width = 10;
	}
	
	public String getName() {
		return this.getType()+":"+this.getId();
	}
}
