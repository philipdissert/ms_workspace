package edu.kit.cm.PoolManagement.API;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.kit.cm.PoolManagement.Pool.PoolAdapter;
import edu.kit.cm.PoolManagement.Pool.PoolInterface;

@RestController
public class LayoutAPI {

//    private static final String JSON = MediaType.APPLICATION_JSON_VALUE;
//    private static final String JSON_UTF8 = MediaType.APPLICATION_JSON_UTF8_VALUE;
//	
//	@RequestMapping(value = "/layout", produces = {JSON, JSON_UTF8}, method = RequestMethod.GET)
	
	@GetMapping("/layout")
	public String getLayout() {
		PoolInterface pool = new PoolAdapter();
		return pool.getLayout().toString();
	}
	
	@PutMapping("/layout")
	public String getTest() {		
		return "NEIN!";
	}
}
