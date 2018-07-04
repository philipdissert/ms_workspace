package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Workspace extends Room {
	private static int newId = 0;
	
	private List<PoolElement> poolElements;
	private List<Room> rooms;
	private int id;
	
	public Workspace() {
		poolElements = new ArrayList<>();
		rooms = new ArrayList<>();
		id = newId++;
	}
}
