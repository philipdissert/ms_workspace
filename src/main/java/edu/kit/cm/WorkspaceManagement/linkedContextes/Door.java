package edu.kit.cm.WorkspaceManagement.linkedContextes;

import java.util.List;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;

public class Door extends PortalGate{
	
	public Door(List<Location> location) {
		super(location, "door");
	}
}
