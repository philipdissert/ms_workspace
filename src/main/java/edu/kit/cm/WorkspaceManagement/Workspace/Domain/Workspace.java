package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import edu.kit.cm.WorkspaceManagement.linkedContextes.Room;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Workspace extends Room {
	private static int newId = 0;
	
	private List<WorkspaceElement> workspaceElements;
	private List<Room> rooms;
	private OpeningHours openingHours;
	private int id;
	
	public Workspace() {
		this.workspaceElements = new ArrayList<>();
		this.rooms = new ArrayList<>();
		this.id = newId++;
		this.openingHours = new OpeningHours();
		this.openingHours.addOpeningHour(new OpeningHour(DayOfWeek.MONDAY, LocalTime.of(7,0,0), LocalTime.of(21,0,0)));
		this.openingHours.addOpeningHour(new OpeningHour(DayOfWeek.TUESDAY, LocalTime.of(7,0,0), LocalTime.of(21,0,0)));
		this.openingHours.addOpeningHour(new OpeningHour(DayOfWeek.WEDNESDAY, LocalTime.of(7,0,0), LocalTime.of(21,0,0)));
		this.openingHours.addOpeningHour(new OpeningHour(DayOfWeek.THURSDAY, LocalTime.of(7,0,0), LocalTime.of(21,0,0)));
		this.openingHours.addOpeningHour(new OpeningHour(DayOfWeek.FRIDAY, LocalTime.of(7,0,0), LocalTime.of(21,0,0)));
		this.openingHours.addOpeningHour(new OpeningHour(DayOfWeek.SATURDAY, LocalTime.of(7,0,0), LocalTime.of(14,0,0)));
	}
}
