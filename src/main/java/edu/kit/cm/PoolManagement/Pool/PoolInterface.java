package edu.kit.cm.PoolManagement.Pool;

import org.json.JSONObject;

public interface PoolInterface {

	public JSONObject getLayout();
	public void createNewLayout(JSONObject layout);
	
	public JSONObject getCurrentState();
}
