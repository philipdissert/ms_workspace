package edu.kit.cm.PoolManagement.API;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	

		
	@PostMapping("/test")
	public String postTest() {
		return "DOCH!";
	}
	
	@PutMapping("/test/{id}")
	public String putTest(@PathVariable long id) {
		System.out.println(id);
		return "OUCH!";
	}
	
	@DeleteMapping("/test/{id}")
	public String deleteTest(@PathVariable long id) {
		System.out.println(id);
		return "Why?????????????";
	}
}
