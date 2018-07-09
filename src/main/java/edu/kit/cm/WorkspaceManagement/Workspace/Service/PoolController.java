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
				"{\"pos\":{\"x\":\"10\",\"y\":\"1\"},\"id\":\"1\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"20\",\"y\":\"1\"},\"id\":\"2\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"30\",\"y\":\"1\"},\"id\":\"3\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"40\",\"y\":\"1\"},\"id\":\"4\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"50\",\"y\":\"1\"},\"id\":\"5\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"60\",\"y\":\"1\"},\"id\":\"6\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"70\",\"y\":\"1\"},\"id\":\"7\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"80\",\"y\":\"1\"},\"id\":\"8\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"90\",\"y\":\"1\"},\"id\":\"9\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"100\",\"y\":\"1\"},\"id\":\"10\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"110\",\"y\":\"1\"},\"id\":\"11\",\"type\":\"PC\",\"width\":\"10\",\"length\":\"10\"},\r\n" + 
				"{\"pos\":{\"x\":\"120\",\"y\":\"1\"},\"id\":\"1\",\"type\":\"Laptop\",\"width\":\"5\",\"length\":\"5\"}\r\n" + 
				"\r\n" + 
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
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
