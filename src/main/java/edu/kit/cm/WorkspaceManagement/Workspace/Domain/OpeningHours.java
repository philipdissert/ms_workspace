package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class OpeningHours {
	
	private List<OpeningHour> openingHourList;
	private boolean openedOnNationalHoliday;

	public OpeningHours() {
		openingHourList = new ArrayList<OpeningHour>();
		openedOnNationalHoliday = false;
	}

	public void addOpeningHour(OpeningHour openingHour) {
		this.openingHourList.add(openingHour);
	}

	public List<OpeningHour> getOpeningHours() {
		return this.openingHourList;
	}
}
