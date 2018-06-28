package edu.kit.cm.PoolManagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Test {
	@RequestMapping("/")
	public String index() {
		return "Hello World!";
	}

	
	@RequestMapping("/test")
	public String test() {
		return "ok tschüss!!!";
	}
}
