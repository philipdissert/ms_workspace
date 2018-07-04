package edu.kit.cm.WorkspaceManagement.linkedContextes;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Door {
	
	private Location location;
	private int length;
	
	public Door(Location location, int length) {
		this.location = location;
		this.length = length;
	}

}
