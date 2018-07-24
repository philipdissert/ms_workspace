package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceAdapter;



@RestController
public class LayoutAPIController {

	WorkspaceAdapter workspaceAdapter = WorkspaceAdapter.getInstance();
	

//	@RequestMapping(value = "/layout", produces = {JSON, JSON_UTF8}, method = RequestMethod.GET)
	
	@GetMapping("/layout")
	public String getLayout() {		
		return workspaceAdapter.getLayout().toString();
	}
	
	@GetMapping("/layout/poolElements")
	public String getPoolElements() {
		try {
			return workspaceAdapter.getLayout().getJSONArray("poolElements").toString();
		} catch (JSONException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@GetMapping("/layout/rooms")
	public String getRooms() {
		try {
			return workspaceAdapter.getLayout().getJSONArray("rooms").toString();
		} catch (JSONException e) {
			e.printStackTrace();
			return "";
		}
	}

	@GetMapping("/opening-hours")
	public String getOpeningHours() {
		return workspaceAdapter.getOpeningHours().toString();
	}
}
