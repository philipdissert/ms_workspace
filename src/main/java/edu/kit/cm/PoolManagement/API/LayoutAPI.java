package edu.kit.cm.PoolManagement.API;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kit.cm.PoolManagement.Pool.PoolAdapter;
import edu.kit.cm.PoolManagement.Pool.PoolInterface;

@RestController
public class LayoutAPI {
	
	@GetMapping("/layout")
	public JSONObject getLayout() {
		PoolInterface pool = new PoolAdapter();
		return pool.getLayout();
	}
	
	@PutMapping("/layout")
	public String getTest() {		
		return "NEIN!";
	}
}
