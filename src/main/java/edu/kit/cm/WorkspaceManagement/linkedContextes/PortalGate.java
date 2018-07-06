package edu.kit.cm.WorkspaceManagement.linkedContextes;

import java.util.List;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public abstract class PortalGate {
	
	private List<Location> location;
	private String type;
	
	public PortalGate(List<Location> location, String type) {
		this.location = location;
		this.type = type;
	}

}
