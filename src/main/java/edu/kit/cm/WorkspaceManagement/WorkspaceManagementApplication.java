package edu.kit.cm.WorkspaceManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.kit.cm.WorkspaceManagement.RESTMANAGER.RestManager;
import edu.kit.cm.WorkspaceManagement.Utilization.Infrastructure.ComputerStateATISAdapter;
import edu.kit.cm.WorkspaceManagement.Workspace.Service.PoolController;
import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceAdapter;

@SpringBootApplication
public class WorkspaceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkspaceManagementApplication.class, args);
		PoolController.init(WorkspaceAdapter.getInstance());
		ComputerStateATISAdapter csaa = new ComputerStateATISAdapter();
		try {
			csaa.getPoolElementsFromWorkspace();
			csaa.getComputersWithStatesFromATIS();
		} catch (Exception e) {

		}
	}
}