package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceDataService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceAdapter;

import javax.transaction.Transactional;
import javax.xml.ws.Response;


@CrossOrigin
@RestController
public class LayoutAPIController {

	@Autowired
	private WorkspaceAdapter workspaceAdapter;

	@Autowired
	private WorkspaceDataService workspaceDataService;

	ComputerStateATISAdapter computerStateATISAdapter = new ComputerStateATISAdapter();

	
	@GetMapping("/layout")
	public String getLayout() {	return workspaceAdapter.getLayout().toString(); }

	@GetMapping("/layout/id/{id}")
	public String getWorkspaceById(@PathVariable("id") int id) {
		return workspaceAdapter.getLayout(id).toString();
	}

	@GetMapping("/layout-list")
	public String getLayoutList() {
		return workspaceAdapter.getLayoutList().toString();
	}

	@GetMapping("/get-layout-id")
	public int getLayoutId() {
		return workspaceAdapter.getWorkspaceId();
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

	@GetMapping("/change-layout/id/{id}")
	public String changeLayout(@PathVariable int id){
		workspaceAdapter.changeToLayout(id);
		return workspaceAdapter.getLayout().toString();
	}

	@Transactional
	@PostMapping("/add-layout/id/{id}")
	public void addLayout(@RequestBody String input,@PathVariable int id) {
		workspaceAdapter.addLayout(new JSONObject(input), id);
	}

	@GetMapping("/deleteFkAll")
	public void deleteFkAll() {
		workspaceAdapter.deleteOpeningHoursAllOpeningHours();
	}

	@GetMapping("/opening-hours")
	public String getOpeningHours() throws JSONException {
		return workspaceAdapter.getOpeningHours().toString();
	}

	@PostMapping("/addOpeningHours/id/{id}")
	public void addOpeningHours(@PathVariable int id, @RequestBody String input) {
		workspaceAdapter.addOpeningHours(new JSONObject(input), id);
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

	@GetMapping("/init")
	public String init() {
		workspaceAdapter.init();
		return "init";
	}




	@GetMapping("/ResponseEntityTest")
	public ResponseEntity<Location> responseEntityTest() {
		Location loc = new Location(1,2);
		return new ResponseEntity<>(loc, HttpStatus.OK);
	}

	@GetMapping("/SecureTest")
	public String secureTest() {
		return "Correct";
	}
}
