package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure;

import edu.kit.cm.WorkspaceManagement.Workspace.Service.PoolController;
import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceDataService;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceAdapter;


@CrossOrigin
@RestController
public class LayoutAPIController {

	@Autowired
	private WorkspaceAdapter workspaceAdapter;

	@Autowired
	private WorkspaceDataService workspaceDataService;

	ComputerStateATISAdapter computerStateATISAdapter = new ComputerStateATISAdapter();
	

//	@RequestMapping(value = "/layout", produces = {JSON, JSON_UTF8}, method = RequestMethod.GET)
	
	@GetMapping("/layout")
	public String getLayout() {		
		workspaceDataService.safeWorkspace(workspaceAdapter.getWorkspace());
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
	
	@GetMapping("/layout/poolElementsJSONArray")
	public String getPoolElementsJSONArray() {
		try {
			return workspaceAdapter.getLayout().getJSONArray("poolElements").toString();
		} catch (Exception e) {
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
	public String getOpeningHours() throws JSONException {
		return workspaceAdapter.getOpeningHours().toString();
	}
	
	@GetMapping("/getComputersWithState")
	public String getComputersWithState() {
		try {
			return computerStateATISAdapter.getComputersWithStatesFromATISJSON().toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@GetMapping("/layout/id/{id}")
	public String getWorkspaceById(@PathVariable("id") int id) {
		return workspaceAdapter.getLayout(workspaceDataService.getWorkspace(id)).toString();
	}

	@GetMapping("/init")
	public String init() {
		workspaceAdapter.init();
		return "init";
	}
}
