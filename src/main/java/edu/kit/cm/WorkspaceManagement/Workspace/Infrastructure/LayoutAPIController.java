package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kit.cm.WorkspaceManagement.Workspace.Service.PoolController;



@RestController
public class LayoutAPIController {

//	@RequestMapping(value = "/layout", produces = {JSON, JSON_UTF8}, method = RequestMethod.GET)
	
	@GetMapping("/layout")
	public String getLayout() {
		PoolController poolController = new PoolController();
		poolController.init();
		return poolController.getLayout().toJSON().toString();
	}
	@GetMapping("/")
	public String asd() {
		return "asdf";
	}
	
	@PutMapping("/layout")
	public String getTest() {		
		return "asdfas";
	}
}
