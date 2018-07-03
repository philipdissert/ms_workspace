package edu.kit.cm.PoolManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import edu.kit.cm.PoolManagement.Pool.ApplicationServices.PoolController;

@ComponentScan("edu.kit.cm.PoolManagement.controller")
@SpringBootApplication
public class PoolManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(PoolManagementApplication.class, args);
//		PoolController p = new PoolController();
//		p.init();
	}
}
