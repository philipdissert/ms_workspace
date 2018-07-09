package edu.kit.cm.WorkspaceManagement.Utilization.Service;

import java.util.Date;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import edu.kit.cm.WorkspaceManagement.Utilization.Domain.PoolElementState;

public class UtilizationAdapter {
	
	private static UtilizationAdapter utilizationAdapter = new UtilizationAdapter();
	
	private HashMap<Integer, PoolElementState> poolElementHashMap;
	
	private UtilizationAdapter() {
		
	}
	
	public static UtilizationAdapter getInstance() {
		return utilizationAdapter;
	}
	
	public void createPoolElementHashMap(JSONObject poolElementList) {
		poolElementHashMap = new HashMap<Integer, PoolElementState>();
		try {
		JSONArray jsonArray = poolElementList.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {	
				int id = jsonArray.getJSONObject(i).getInt("id");
				String type = jsonArray.getJSONObject(i).getString("type");
				poolElementHashMap.put(id, new PoolElementState(id, type));		
			}
		} catch (JSONException e) {
			throw new IllegalArgumentException();
		}	
	}
	
	public void insertData (JSONObject poolData) {
		try {
			JSONArray jsonArray = poolData.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				String idString = jsonArray.getJSONObject(i).getString("id");
				int id = -1;
				try {
					id = Integer.parseInt(idString);
				} catch (NumberFormatException e) {
				}
				
				int state = jsonArray.getJSONObject(i).getInt("state");
				if (poolElementHashMap.get(id) != null) {
					poolElementHashMap.get(id).setState(state);
				}
			}
			
		} catch (JSONException e) {
			throw new IllegalArgumentException();
		}
	}
	
	public JSONObject getCurrentState() {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		poolElementHashMap.forEach( (id, element) -> {
			JSONObject jsonObjectEntry = new JSONObject();
			try {
				jsonObjectEntry.put("id", id);
				jsonObjectEntry.put("type", element.getType());
				jsonObjectEntry.put("state", element.getState());
			} catch (JSONException e) {
			}
			jsonArray.put(jsonObjectEntry);
		});
		try {
			jsonObject.put("data", jsonArray);
		} catch (JSONException e) {

		}
		return jsonObject;
	}
	
}
