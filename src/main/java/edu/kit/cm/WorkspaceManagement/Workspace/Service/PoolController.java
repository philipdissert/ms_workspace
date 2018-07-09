package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PoolController{
	
	
	//Veraltet
	public static void init(WorkspaceAdapter layout) {
		String text = "{\r\n" + 
				"\"poolElements\":[\r\n" + 
				"{\"pos\":\"1,1\",\"id\":\"1\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":\"2,1\",\"id\":\"2\",\"type\":\"Laptop\",\"width\":\"5\",\"length\":\"5\"},\r\n" + 
				"{\"pos\":\"3,1\",\"id\":\"3\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"}\r\n" + 
				"],\r\n" + 
				"\"rooms\":[\r\n" + 
				"{\"pos\":[\"1,1\",\"1,2\",\"2,2\",\"2,1\"],\"id\":\"1\",\"portalGates\":[\r\n" + 
				"											{\"type\":\"door\",\"pos\": [\"1,1\",\"2,2\"]},\r\n" + 
				"											{\"type\":\"breakthrough\",\"pos\": [\"1,1\",\"5,2\"]}\r\n" + 
				"											]},\r\n" + 
				"\r\n" + 
				"{\"pos\":[\"1,1\",\"1,2\",\"2,2\",\"2,1\"],\"id\":\"1\",\"portalGates\":[\r\n" + 
				"											{\"type\":\"door\",\"pos\": [\"1,1\",\"3,2\"]},\r\n" + 
				"											{\"type\":\"breakthrough\",\"pos\": [\"1,1\",\"4,2\"]}\r\n" + 
				"											]}\r\n" + 
				"]\r\n" + 
				"}";
        try {
			JSONObject obj = new JSONObject(text);
			layout.addLayout(obj);
			layout.addLayout(obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
