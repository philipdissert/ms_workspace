package edu.kit.cm.PoolManagement.Pool.DomainModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.kit.cm.PoolManagement.linkedContextes.Room;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Pool extends Room {
	
	private List<PoolElement> poolElements;
	private List<Room> rooms;
	
	public Pool() {
		poolElements = new ArrayList<>();
		rooms = new ArrayList<>();
	}
}
