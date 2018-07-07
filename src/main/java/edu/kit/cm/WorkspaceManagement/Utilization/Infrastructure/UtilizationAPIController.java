package edu.kit.cm.WorkspaceManagement.Utilization.Infrastructure;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Computer;



@RestController
public class UtilizationAPIController {
	
	ComputerStateATISAdapter csaa = new ComputerStateATISAdapter();

	@GetMapping("/FreeSeats")
	public int getFreeSeats() {		
		try {
			return csaa.getLastFreeSeatsFromATIS();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	private void updateComputerStates(List<Computer> computers) {
		computers.forEach((x)-> {
			//put-> computer id=state
		});
	}
	
}
