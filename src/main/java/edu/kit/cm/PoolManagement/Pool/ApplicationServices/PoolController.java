package edu.kit.cm.PoolManagement.Pool.ApplicationServices;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.PoolManagement.Pool.DomainServices.Layout;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PoolController{
	private Layout layout;
	
	//Veraltet
	public void init() {
		String text = "";
		try {
			//java.nio.file.Path path = Paths.get("C:\\Users\\Steffen\\Documents\\_Studium\\PSE\\GIT\\PoolManagement\\iot_atis_iosb\\src\\main\\resources\\layout.json");
			java.nio.file.Path path = Paths.get("G:\\UNI\\PSE\\iot_atis_iosb\\src\\main\\resources\\layout.json");
			text = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
		} catch (IOException e) {			
			e.printStackTrace();
			System.out.println("asdf");
		}
        try {
			JSONObject obj = new JSONObject(text);
			layout = new Layout(obj);
		} catch (JSONException e) {
			System.out.println("asdf");
			e.printStackTrace();
		}
	}
}
