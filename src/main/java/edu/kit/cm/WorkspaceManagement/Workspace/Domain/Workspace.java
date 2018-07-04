package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Workspace extends Room {
	
	private List<PoolElement> poolElements;
	private List<Room> rooms;
	
	public Workspace() {
		poolElements = new ArrayList<>();
		rooms = new ArrayList<>();
	}
}
