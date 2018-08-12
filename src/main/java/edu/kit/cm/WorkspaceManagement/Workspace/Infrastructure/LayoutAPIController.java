package edu.kit.cm.WorkspaceManagement.Workspace.Infrastructure;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Location;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceAdapter;

import javax.xml.ws.Response;


@CrossOrigin
@RestController
public class LayoutAPIController {

	WorkspaceAdapter workspaceAdapter = WorkspaceAdapter.getInstance();
	ComputerStateATISAdapter computerStateATISAdapter = new ComputerStateATISAdapter();
	

//	@RequestMapping(value = "/layout", produces = {JSON, JSON_UTF8}, method = RequestMethod.GET)
	
	@GetMapping("/layout")
	public String getLayout() {		
		return workspaceAdapter.getLayout().toString();
	}

	@GetMapping("/test")
	public ResponseEntity<Location> getTest() {
		Location loc = new Location(1,2);
		return new ResponseEntity<>(loc, HttpStatus.OK);
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
}
