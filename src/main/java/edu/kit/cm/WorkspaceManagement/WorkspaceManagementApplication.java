package edu.kit.cm.WorkspaceManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.kit.cm.WorkspaceManagement.RESTMANAGER.RestManager;
import edu.kit.cm.WorkspaceManagement.Workspace.Service.PoolController;
import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceAdapter;

@SpringBootApplication
public class WorkspaceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkspaceManagementApplication.class, args);

		WorkspaceAdapter workspaceAdapter = new WorkspaceAdapter();
		
		PoolController.init(workspaceAdapter);
		System.out.println(workspaceAdapter.getLayout());
		System.out.println(workspaceAdapter.getAllPcs());
		System.out.println(workspaceAdapter.getPCStatus(1));
		workspaceAdapter.setPCStatus(1, "occupied");
		System.out.println(workspaceAdapter.getPCStatus(1));
		System.out.println(RestManager.sendGetRequest("/layout"));
	}
}