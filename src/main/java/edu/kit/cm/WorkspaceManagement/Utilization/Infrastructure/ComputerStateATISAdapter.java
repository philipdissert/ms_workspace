package edu.kit.cm.WorkspaceManagement.Utilization.Infrastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import edu.kit.cm.WorkspaceManagement.Workspace.Domain.Computer;

public class ComputerStateATISAdapter {
	public List<Computer> getComputersWithStatesFromATIS() throws Exception {		
		List<Computer> computers = new ArrayList<>();
		
		BufferedReader in = getBufferedReaderByAdress("https://webadmin.informatik.kit.edu/pool/html/snmp_out.txt");	
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			if(!inputLine.startsWith("Stand:")
					&& !inputLine.startsWith(".")) {
				String[] s = inputLine.split(" ");
				Computer computer = new Computer();
				computer.setName(s[0]);
				computer.setOperatingSystem(s[1]);
				computers.add(computer);	
			}			
		}
		in.close();
		return computers;
	}
	
	public HashMap<Date, Integer> getFreeSeatMapFromATIS() throws Exception {
		HashMap<Date, Integer> freeSeatMap = new HashMap<>(); 
		BufferedReader in = getBufferedReaderByAdress("https://webadmin.informatik.kit.edu/pool/html/freeseats.txt");
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			String[] s = inputLine.split(" ");			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
			String sdate = s[0].replaceAll("[.]", "-");
			Date date = formatter.parse(sdate);
			freeSeatMap.put(date, Integer.valueOf(s[1]));
		}
		in.close();
		return freeSeatMap;
	}
	
	public int getLastFreeSeatsFromATIS() throws Exception {
		BufferedReader in = getBufferedReaderByAdress("https://webadmin.informatik.kit.edu/pool/html/freeseats.txt");
		String inputLine;
		String erg="";
		while ((inputLine = in.readLine()) != null) erg=inputLine;
		return Integer.valueOf(erg.split(" ")[1]);
	}
	
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
