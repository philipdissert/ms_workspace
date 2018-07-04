package edu.kit.cm.WorkspaceManagement.linkedContextes;

import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Room {
	
	private List<Door> doors;
	private Location pos1;
	private Location pos2;
	private int id;
	
	public Room() {
		doors = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Room [doors=" + doors + ", pos1=" + pos1 + ", pos2=" + pos2 + ", id=" + id + "]";
	}
}
