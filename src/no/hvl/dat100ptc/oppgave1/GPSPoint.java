package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	// Lagt inn private objektvariabler.
	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
	
	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		// Laget konstruktør som gir objektvariablene verdier.
		this.time  = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;

	}

	// lagt inn getTime()
	public int getTime() {
		
		return time;
		
	}

	// lagt inn setTime()
	public void setTime(int time) {
		
		this.time = time;

	}

	//Lagt in getLatitude()
	public double getLatitude() {
		
		return latitude;
			
	}

	//lagt inn setLatitude()
	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
				
	}

	//lagt inn getLongitude()
	public double getLongitude() {
		
		return longitude;
				
	}
	
	//lagt inn setLongitude()
	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
				
	}
	
	// lagt inn getElevation()
	public double getElevation() {
		
		return elevation;
		
	}

	// lagt inn setElevation()
	public void setElevation(double elevation) {
		
		this.elevation = elevation;
				
	}
	
	public String toString() {
		
		String str;
				
		str = time + " (" + latitude + "," + longitude + ") " + elevation + "\n";
		
		return str;

		
	}
}