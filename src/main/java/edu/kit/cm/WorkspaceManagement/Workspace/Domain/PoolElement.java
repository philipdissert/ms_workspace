package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public abstract class PoolElement {
	private Location location;
	private int id;
	private String type;
	
	public PoolElement(int id, String type) {
		this.id = id;
		this.type = type;
	}
}
