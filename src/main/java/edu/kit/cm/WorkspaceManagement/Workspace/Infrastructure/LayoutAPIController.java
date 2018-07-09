package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.kit.cm.WorkspaceManagement.Workspace.Service.PoolController;
import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceAdapter;



@RestController
public class LayoutAPIController {
	//@Inject
	WorkspaceAdapter workspaceAdapter = new WorkspaceAdapter();
	

//	@RequestMapping(value = "/layout", produces = {JSON, JSON_UTF8}, method = RequestMethod.GET)
	
	@GetMapping("/layout")
	public String getLayout() {		
		PoolController.init(workspaceAdapter);
		return workspaceAdapter.getLayout().toString();
	}
	@GetMapping("/")
	public String asd() {
		return workspaceAdapter.getLayoutList().toString();
	}
	
	@GetMapping("/computer")
	public String getComputers() {
		return workspaceAdapter.getAllPcs().toString();
	}
	
	@GetMapping("/computer/{id}")
	public String getCompterStatus(@PathVariable int id) {
		return workspaceAdapter.getPCStatus(id).toString();
	}
	
	@PutMapping("/Computers/{id}")
	public void setComputerStatus() {
		
	}
	
	@PutMapping("/layout")
	public String getTest() {		
		return "asdfas";
	}
}
