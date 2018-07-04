package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OpeningHours {
	
	private String hours;
	
	public OpeningHours(String txt) {
		hours = txt;
	}

}
