package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PoolController{
	
	
	//Veraltet
	public static void init(WorkspaceAdapter layout) {
		String text = "{\n" + 
				"\"poolElements\":[\n" + 
				"{\"pos\":\"1,1\",\"id\":\"1\",\"type\":\"PC\"},\n" + 
				"{\"pos\":\"2,1\",\"id\":\"2\",\"type\":\"Laptop\"},\n" + 
				"{\"pos\":\"3,1\",\"id\":\"3\",\"type\":\"PC\"}\n" + 
				"],\n" + 
				"\"rooms\":[\n" + 
				"{\"pos1\":\"1,1\",\"pos2\":\"1,1\",\"id\":\"1\",\"doors\":[\n" + 
				"											{\"pos\":\"1,2\",\"length\":\"10\"},\n" + 
				"											{\"pos\":\"3,5\",\"length\":\"5\"}\n" + 
				"											]},\n" + 
				"\n" + 
				"{\"pos1\":\"1,1\",\"pos2\":\"1,1\",\"id\":\"1\",\"doors\":[\n" + 
				"											{\"pos\":\"2,7\",\"length\":\"10\"},\n" + 
				"											{\"pos\":\"9,7\",\"length\":\"5\"}\n" + 
				"											]}\n" + 
				"]\n" + 
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
