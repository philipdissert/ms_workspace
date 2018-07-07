package edu.kit.cm.WorkspaceManagement.Workspace.Domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Computer {
	
	private String operatingSystem;
	private String name;

	public Computer() {
	}
}
