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
				"{\"pos\":{\"x\":\"1\",\"y\":\"1\"},\"id\":\"1\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"2\",\"y\":\"1\"},\"id\":\"2\",\"type\":\"Laptop\",\"width\":\"5\",\"length\":\"5\"},\r\n" + 
				"{\"pos\":{\"x\":\"3\",\"y\":\"1\"},\"id\":\"3\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"}\r\n" + 
				"],\r\n" + 
				"\"rooms\":[\r\n" + 
				"{\"pos\":[{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"}],\"id\":\"1\",\"portalGates\":[\r\n" + 
				"											{\"type\":\"door\",\"pos\": [{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"}]},\r\n" + 
				"											{\"type\":\"breakthrough\",\"pos\": [{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"}]}\r\n" + 
				"											]},\r\n" + 
				"\r\n" + 
				"{\"pos\":[{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"}],\"id\":\"1\",\"portalGates\":[\r\n" + 
				"											{\"type\":\"door\",\"pos\": [{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"}]},\r\n" + 
				"											{\"type\":\"breakthrough\",\"pos\": [{\"x\":\"1\",\"y\":\"1\"},{\"x\":\"1\",\"y\":\"1\"}]}\r\n" + 
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
