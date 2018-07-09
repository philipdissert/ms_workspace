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
	
}
