package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {

		// Oppretter en ny liste GPSpunkter med gitt antall.
		this.gpspoints = new GPSPoint[antall];
		
		// Setter antall som 0 for at første punkt settes inn på første plassen
		this.antall = 0;
		
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// sjekker om det er plass til å sette inn et punkt til.
		// dersom det er plass, settes punktet inn og true returneres.
		// dersom det ikke er plass returneres false uten at noe settes inn.
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}
		return inserted;
		
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;
		
		// Bruker GPSDataConverter fra forrige oppgave til å konvertere dataen til ett nytt gpspoint
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		// bruker insertGPS til å sette det nye punktet inn i listen
		boolean inserted = insertGPS(gpspoint);
		
		// returnerer true om punktet ble satt inn og false om det ikke ble satt inn
		return inserted;
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");
		
		// Går gjennom listen med punkt og printer dem ved hjelp av toString fra foorige oppgave.
		for (GPSPoint g : gpspoints) {
			System.out.print(g.toString());
		}
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
