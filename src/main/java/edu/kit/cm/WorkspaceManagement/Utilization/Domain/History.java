package edu.kit.cm.WorkspaceManagement.Utilization.Domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class History {
	private final List<CurrentUtilization> utilizationList = new ArrayList<>();
}
