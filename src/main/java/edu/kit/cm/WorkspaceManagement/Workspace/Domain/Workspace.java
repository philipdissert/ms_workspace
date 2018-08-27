package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Workspace {
	private static int newId = 0;
	
	private List<WorkspaceElement> workspaceElements;
	private List<Room> rooms;
	private List<OpeningHour> openingHours;
	private int id;
	
	public Workspace() {
		this.workspaceElements = new ArrayList<>();
		this.rooms = new ArrayList<>();
		this.openingHours = new ArrayList<>();
		this.id = newId++;
	}
	public Workspace(int id, List<WorkspaceElement> workspaceElementList, List<Room> roomList, List<OpeningHour> openingHours) {
		this();
		this.id = id;
		this.workspaceElements = workspaceElementList;
		this.rooms = roomList;
		this.openingHours = openingHours;
	}

}
