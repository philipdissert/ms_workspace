package edu.kit.cm.WorkspaceManagement.Utilization.Infrastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.kit.cm.WorkspaceManagement.RESTMANAGER.RestManager;
import edu.kit.cm.WorkspaceManagement.Utilization.Service.UtilizationAdapter;

public class ComputerStateATISAdapter {
	
	public void getComputersWithStatesFromATIS() throws Exception {		
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();		
		
		BufferedReader in = getBufferedReaderByAdress("https://webadmin.informatik.kit.edu/pool/html/snmp_out.txt");	
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			if(!inputLine.startsWith("Stand:")
					&& !inputLine.startsWith(".")) {
				String[] s = inputLine.split(" ");
				JSONObject jsonObjectEntry = new JSONObject();
				jsonObjectEntry.put("id", s[0]);
				jsonObjectEntry.put("state", s[1]);
				
				jsonArray.put(jsonObjectEntry);
			}			
		}
		in.close();
		jsonObject.put("data", jsonArray);
		UtilizationAdapter.getInstance().insertData(jsonObject);
	}
	
	public void getPoolElementsFromWorkspace() {
		JSONObject jsonObject = RestManager.sendGetRequest("/learningDesks");
		UtilizationAdapter.getInstance().createPoolElementHashMap(jsonObject);
		
	}
	
//	public HashMap<Date, Integer> getFreeSeatMapFromATIS() throws Exception {
//		HashMap<Date, Integer> freeSeatMap = new HashMap<>(); 
//		BufferedReader in = getBufferedReaderByAdress("https://webadmin.informatik.kit.edu/pool/html/freeseats.txt");
//		String inputLine;
//		while ((inputLine = in.readLine()) != null) {
//			String[] s = inputLine.split(" ");			
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
//			String sdate = s[0].replaceAll("[.]", "-");
//			Date date = formatter.parse(sdate);
//			freeSeatMap.put(date, Integer.valueOf(s[1]));
//		}
//		in.close();
//		return freeSeatMap;
//	}
//	
//	public int getLastFreeSeatsFromATIS() throws Exception {
//		BufferedReader in = getBufferedReaderByAdress("https://webadmin.informatik.kit.edu/pool/html/freeseats.txt");
//		String inputLine;
//		String erg="";
//		while ((inputLine = in.readLine()) != null) erg=inputLine;
//		return Integer.valueOf(erg.split(" ")[1]);
//	}
//	
	private BufferedReader getBufferedReaderByAdress(String addr) throws Exception {
		String url = addr;		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		return in;
	}
}
