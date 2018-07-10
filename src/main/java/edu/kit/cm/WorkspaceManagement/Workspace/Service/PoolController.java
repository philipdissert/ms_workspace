package edu.kit.cm.WorkspaceManagement.Workspace.Service;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PoolController{
	
	
	//Veraltet
	public static void init(WorkspaceAdapter layout) {
		String text = "{\"poolElements\":[{\"pos\":{\"x\":50,\"y\":0},\"width\":10,\"length\":10,\"id\":1,\"type\":\"Printer\"},{\"pos\":{\"x\":60,\"y\":0},\"width\":10,\"length\":10,\"id\":2,\"type\":\"Printer\"},{\"pos\":{\"x\":70,\"y\":0},\"width\":10,\"length\":10,\"id\":3,\"type\":\"Printer\"},{\"pos\":{\"x\":20,\"y\":20},\"width\":10,\"length\":10,\"id\":1,\"type\":\"PC\"},{\"pos\":{\"x\":10,\"y\":20},\"width\":10,\"length\":10,\"id\":2,\"type\":\"PC\"},{\"pos\":{\"x\":0,\"y\":20},\"width\":10,\"length\":10,\"id\":3,\"type\":\"PC\"},{\"pos\":{\"x\":0,\"y\":30},\"width\":10,\"length\":10,\"id\":4,\"type\":\"PC\"},{\"pos\":{\"x\":10,\"y\":30},\"width\":10,\"length\":10,\"id\":5,\"type\":\"PC\"},{\"pos\":{\"x\":20,\"y\":30},\"width\":10,\"length\":10,\"id\":6,\"type\":\"PC\"},{\"pos\":{\"x\":30,\"y\":30},\"width\":10,\"length\":10,\"id\":7,\"type\":\"PC\"},{\"pos\":{\"x\":30,\"y\":50},\"width\":10,\"length\":10,\"id\":8,\"type\":\"PC\"},{\"pos\":{\"x\":20,\"y\":50},\"width\":10,\"length\":10,\"id\":9,\"type\":\"PC\"},{\"pos\":{\"x\":10,\"y\":50},\"width\":10,\"length\":10,\"id\":10,\"type\":\"PC\"},{\"pos\":{\"x\":0,\"y\":50},\"width\":10,\"length\":10,\"id\":11,\"type\":\"PC\"},{\"pos\":{\"x\":0,\"y\":60},\"width\":10,\"length\":10,\"id\":12,\"type\":\"PC\"},{\"pos\":{\"x\":10,\"y\":60},\"width\":10,\"length\":10,\"id\":13,\"type\":\"PC\"},{\"pos\":{\"x\":20,\"y\":60},\"width\":10,\"length\":10,\"id\":14,\"type\":\"PC\"},{\"pos\":{\"x\":30,\"y\":60},\"width\":10,\"length\":10,\"id\":15,\"type\":\"PC\"},{\"pos\":{\"x\":0,\"y\":80},\"width\":10,\"length\":10,\"id\":16,\"type\":\"PC\"},{\"pos\":{\"x\":10,\"y\":80},\"width\":10,\"length\":10,\"id\":17,\"type\":\"PC\"},{\"pos\":{\"x\":20,\"y\":80},\"width\":10,\"length\":10,\"id\":18,\"type\":\"PC\"},{\"pos\":{\"x\":0,\"y\":90},\"width\":10,\"length\":10,\"id\":19,\"type\":\"PC\"},{\"pos\":{\"x\":10,\"y\":90},\"width\":10,\"length\":10,\"id\":20,\"type\":\"PC\"},{\"pos\":{\"x\":20,\"y\":90},\"width\":10,\"length\":10,\"id\":21,\"type\":\"PC\"},{\"pos\":{\"x\":50,\"y\":30},\"width\":10,\"length\":10,\"id\":22,\"type\":\"PC\"},{\"pos\":{\"x\":50,\"y\":40},\"width\":10,\"length\":10,\"id\":23,\"type\":\"PC\"},{\"pos\":{\"x\":50,\"y\":50},\"width\":10,\"length\":10,\"id\":24,\"type\":\"PC\"},{\"pos\":{\"x\":50,\"y\":60},\"width\":10,\"length\":10,\"id\":25,\"type\":\"PC\"},{\"pos\":{\"x\":50,\"y\":70},\"width\":10,\"length\":10,\"id\":26,\"type\":\"PC\"},{\"pos\":{\"x\":60,\"y\":70},\"width\":10,\"length\":10,\"id\":27,\"type\":\"PC\"},{\"pos\":{\"x\":60,\"y\":60},\"width\":10,\"length\":10,\"id\":28,\"type\":\"PC\"},{\"pos\":{\"x\":60,\"y\":50},\"width\":10,\"length\":10,\"id\":29,\"type\":\"PC\"},{\"pos\":{\"x\":60,\"y\":40},\"width\":10,\"length\":10,\"id\":30,\"type\":\"PC\"},{\"pos\":{\"x\":60,\"y\":30},\"width\":10,\"length\":10,\"id\":31,\"type\":\"PC\"},{\"pos\":{\"x\":90,\"y\":20},\"width\":10,\"length\":10,\"id\":32,\"type\":\"PC\"},{\"pos\":{\"x\":80,\"y\":20},\"width\":10,\"length\":10,\"id\":33,\"type\":\"PC\"},{\"pos\":{\"x\":80,\"y\":30},\"width\":10,\"length\":10,\"id\":34,\"type\":\"PC\"},{\"pos\":{\"x\":90,\"y\":30},\"width\":10,\"length\":10,\"id\":35,\"type\":\"PC\"},{\"pos\":{\"x\":90,\"y\":50},\"width\":10,\"length\":10,\"id\":36,\"type\":\"PC\"},{\"pos\":{\"x\":80,\"y\":50},\"width\":10,\"length\":10,\"id\":37,\"type\":\"PC\"},{\"pos\":{\"x\":80,\"y\":60},\"width\":10,\"length\":10,\"id\":38,\"type\":\"PC\"},{\"pos\":{\"x\":90,\"y\":60},\"width\":10,\"length\":10,\"id\":39,\"type\":\"PC\"},{\"pos\":{\"x\":90,\"y\":80},\"width\":10,\"length\":10,\"id\":40,\"type\":\"PC\"},{\"pos\":{\"x\":80,\"y\":80},\"width\":10,\"length\":10,\"id\":41,\"type\":\"PC\"},{\"pos\":{\"x\":80,\"y\":90},\"width\":10,\"length\":10,\"id\":42,\"type\":\"PC\"},{\"pos\":{\"x\":90,\"y\":90},\"width\":10,\"length\":10,\"id\":43,\"type\":\"PC\"},{\"pos\":{\"x\":100,\"y\":10},\"width\":2,\"length\":100,\"id\":0,\"type\":\"PC\"},{\"pos\":{\"x\":102,\"y\":10},\"width\":10,\"length\":10,\"id\":44,\"type\":\"PC\"},{\"pos\":{\"x\":112,\"y\":10},\"width\":10,\"length\":10,\"id\":45,\"type\":\"PC\"},{\"pos\":{\"x\":102,\"y\":20},\"width\":10,\"length\":10,\"id\":46,\"type\":\"PC\"},{\"pos\":{\"x\":112,\"y\":20},\"width\":10,\"length\":10,\"id\":47,\"type\":\"PC\"},{\"pos\":{\"x\":102,\"y\":40},\"width\":10,\"length\":10,\"id\":48,\"type\":\"PC\"},{\"pos\":{\"x\":112,\"y\":40},\"width\":10,\"length\":10,\"id\":49,\"type\":\"PC\"},{\"pos\":{\"x\":102,\"y\":50},\"width\":10,\"length\":10,\"id\":50,\"type\":\"PC\"},{\"pos\":{\"x\":112,\"y\":50},\"width\":10,\"length\":10,\"id\":51,\"type\":\"PC\"},{\"pos\":{\"x\":102,\"y\":70},\"width\":10,\"length\":10,\"id\":52,\"type\":\"PC\"},{\"pos\":{\"x\":112,\"y\":70},\"width\":10,\"length\":10,\"id\":53,\"type\":\"PC\"},{\"pos\":{\"x\":102,\"y\":80},\"width\":10,\"length\":10,\"id\":54,\"type\":\"PC\"},{\"pos\":{\"x\":112,\"y\":80},\"width\":10,\"length\":10,\"id\":55,\"type\":\"PC\"},{\"pos\":{\"x\":102,\"y\":100},\"width\":10,\"length\":10,\"id\":56,\"type\":\"PC\"},{\"pos\":{\"x\":112,\"y\":100},\"width\":10,\"length\":10,\"id\":57,\"type\":\"PC\"},{\"pos\":{\"x\":122,\"y\":100},\"width\":10,\"length\":10,\"id\":58,\"type\":\"PC\"},{\"pos\":{\"x\":132,\"y\":100},\"width\":10,\"length\":10,\"id\":59,\"type\":\"PC\"},{\"pos\":{\"x\":142,\"y\":100},\"width\":10,\"length\":10,\"id\":60,\"type\":\"PC\"},{\"pos\":{\"x\":132,\"y\":20},\"width\":10,\"length\":10,\"id\":61,\"type\":\"PC\"},{\"pos\":{\"x\":132,\"y\":30},\"width\":10,\"length\":10,\"id\":62,\"type\":\"PC\"},{\"pos\":{\"x\":132,\"y\":40},\"width\":10,\"length\":10,\"id\":63,\"type\":\"PC\"},{\"pos\":{\"x\":132,\"y\":50},\"width\":10,\"length\":10,\"id\":64,\"type\":\"PC\"},{\"pos\":{\"x\":132,\"y\":60},\"width\":10,\"length\":10,\"id\":65,\"type\":\"PC\"},{\"pos\":{\"x\":132,\"y\":70},\"width\":10,\"length\":10,\"id\":66,\"type\":\"PC\"},{\"pos\":{\"x\":142,\"y\":70},\"width\":10,\"length\":10,\"id\":67,\"type\":\"PC\"},{\"pos\":{\"x\":142,\"y\":60},\"width\":10,\"length\":10,\"id\":68,\"type\":\"PC\"},{\"pos\":{\"x\":142,\"y\":50},\"width\":10,\"length\":10,\"id\":69,\"type\":\"PC\"},{\"pos\":{\"x\":142,\"y\":40},\"width\":10,\"length\":10,\"id\":70,\"type\":\"PC\"},{\"pos\":{\"x\":142,\"y\":30},\"width\":10,\"length\":10,\"id\":71,\"type\":\"PC\"},{\"pos\":{\"x\":142,\"y\":20},\"width\":10,\"length\":10,\"id\":72,\"type\":\"PC\"},{\"pos\":{\"x\":40,\"y\":90},\"width\":10,\"length\":10,\"id\":1,\"type\":\"Laptop\"},{\"pos\":{\"x\":50,\"y\":90},\"width\":10,\"length\":10,\"id\":2,\"type\":\"Laptop\"},{\"pos\":{\"x\":60,\"y\":90},\"width\":10,\"length\":10,\"id\":3,\"type\":\"Laptop\"},{\"pos\":{\"x\":40,\"y\":100},\"width\":10,\"length\":10,\"id\":4,\"type\":\"Laptop\"},{\"pos\":{\"x\":50,\"y\":100},\"width\":10,\"length\":10,\"id\":5,\"type\":\"Laptop\"},{\"pos\":{\"x\":60,\"y\":100},\"width\":10,\"length\":10,\"id\":6,\"type\":\"Laptop\"}],\"rooms\":[{\"pos\":[{\"x\":0,\"y\":0},{\"x\":162,\"y\":0},{\"x\":162,\"y\":142},{\"x\":0,\"y\":142}],\"portalGates\":[],\"id\":0},{\"pos\":[{\"x\":0,\"y\":0},{\"x\":32,\"y\":0},{\"x\":32,\"y\":32},{\"x\":0,\"y\":32}],\"portalGates\":[],\"id\":1},{\"pos\":[{\"x\":32,\"y\":0},{\"x\":64,\"y\":0},{\"x\":64,\"y\":32},{\"x\":32,\"y\":32}],\"portalGates\":[],\"id\":2},{\"pos\":[{\"x\":64,\"y\":0},{\"x\":96,\"y\":0},{\"x\":96,\"y\":32},{\"x\":64,\"y\":32}],\"portalGates\":[],\"id\":3},{\"pos\":[{\"x\":96,\"y\":0},{\"x\":128,\"y\":0},{\"x\":128,\"y\":32},{\"x\":96,\"y\":32}],\"portalGates\":[],\"id\":4},{\"pos\":[{\"x\":128,\"y\":0},{\"x\":162,\"y\":0},{\"x\":162,\"y\":32},{\"x\":128,\"y\":32}],\"portalGates\":[],\"id\":5}]}";
		/*String text = "{\r\n" + 
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
				"}";*/
        try {
			JSONObject obj = new JSONObject(text);
			layout.addLayout(obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
