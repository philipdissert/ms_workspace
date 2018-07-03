package edu.kit.cm.PoolManagement.controller;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cucumber.deps.com.thoughtworks.xstream.core.util.Pool;
import edu.kit.cm.PoolManagement.Pool.ApplicationServices.PoolController;

@RestController
public class LayoutAPIController {

//    private static final String JSON = MediaType.APPLICATION_JSON_VALUE;
//    private static final String JSON_UTF8 = MediaType.APPLICATION_JSON_UTF8_VALUE;
//	
//	@RequestMapping(value = "/layout", produces = {JSON, JSON_UTF8}, method = RequestMethod.GET)
	
	@GetMapping("/layout")
	public String getLayout() {
		PoolController poolController = new PoolController();
		poolController.init();
		//return poolController.getLayout().toJSON();
		return poolController.getLayout().toJSON().toString();
		//return poolController.getLayout().toJSON();
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
