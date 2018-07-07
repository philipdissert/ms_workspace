package edu.kit.cm.WorkspaceManagement.Utilization.Domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class CurrentUtilization {
	private int freeWorkspaces;
	private int occupiedWorkspaces;
	private int printerUtilization;
}
