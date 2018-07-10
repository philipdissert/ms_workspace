package edu.kit.cm.WorkspaceManagement.linkedContextes;

import java.util.List;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;

public class Passage extends PortalGate{

	public Passage(List<Location> location) {
		super(location, "passage");
	}
	
}
