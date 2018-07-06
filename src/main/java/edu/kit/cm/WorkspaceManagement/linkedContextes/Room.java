package edu.kit.cm.WorkspaceManagement.linkedContextes;

import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Room {
	
	private List<PortalGate> portalGate;
	private List<Location> location;
	private int id;
	
	public Room() {
		portalGate = new ArrayList<PortalGate>();
		location = new ArrayList<Location>();
	}
	
	public Room(List<PortalGate> doors, List<Location> location, int id) {
		this.portalGate = doors;
		this.location = location;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Room [doors=" + portalGate + ", pos=" + location + ", id=" + id + "]";
	}
}
