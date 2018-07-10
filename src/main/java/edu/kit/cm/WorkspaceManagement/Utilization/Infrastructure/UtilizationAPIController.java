package edu.kit.cm.WorkspaceManagement.Utilization.Infrastructure;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kit.cm.WorkspaceManagement.Utilization.Service.UtilizationAdapter;



@RestController
public class UtilizationAPIController {
	
	UtilizationAdapter utilizationAdapter = UtilizationAdapter.getInstance();

	@GetMapping("/currentState")
	public String getCurrentState() {		
		return utilizationAdapter.getCurrentState().toString();
	}
	
	@GetMapping("/currentUtilization")
	public String getCurrentUtilization() {
		return utilizationAdapter.getCurrentUtilization().toString();
	}
	
	@GetMapping("/currentUtilization/free")
	public int getCurrentUtilizationFreeWorksaces() {
		return utilizationAdapter.getFreeWorkspaces();
	}
	
	@GetMapping("/currentUtilization/occupied")
	public int getCurrentUtilizationOccupiedWorksaces() {
		return utilizationAdapter.getOccupiedWorkspaces();
	}
	
	@GetMapping("/currentUtilization/percentageFree")
	public double getCurrentUtilizationFreePercentage() {
		return utilizationAdapter.getPercentageFree();
	}
	
	@GetMapping("/currentUtilization/percentageOccupied")
	public double getCurrentUtilizationOccupiedPercentage() {
		return utilizationAdapter.getPercentageOccupied();
	}
}
