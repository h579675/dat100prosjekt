package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 
	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		
	
		hr = parseInt(timestr.substring(11, 13));
		min = parseInt(timestr.substring(14, 16));
		sec = parseInt(timestr.substring(17, 19));
		
		
		secs = hr*3600 + min*60 + sec;
		
	
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		
		int time = toSeconds(timeStr);
		double latitude = parseDouble(latitudeStr);
		double longitude = parseDouble(longitudeStr);
		double elevation = parseDouble(elevationStr);
		
		gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		
	
		return gpspoint;
	    
	}
	
}