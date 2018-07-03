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
	
	private List<LearningDesk> learningDesks;
	private List<Room> rooms;
	private List<Printer> printer;
	private List<WirlessAccessPoint> wirlessAccessPoints;
	
	public Pool() {
		learningDesks = new ArrayList<>();
		rooms = new ArrayList<>();
		printer = new ArrayList<>();
		wirlessAccessPoints = new ArrayList<>();
	}
}
