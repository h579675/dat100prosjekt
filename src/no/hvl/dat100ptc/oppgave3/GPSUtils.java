package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		// Setter første plass i listen som foreløpig
		min = da[0];
		
		// går gjennom listen punkt for punkt og ser om punktet er mindre en det minste vi har funnet så langt
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		// returner den minste verdien vi har funnet.
		return min;

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// lager en ny liste som er like lang som mengden gps punkt
		double[] latitudes = new double[gpspoints.length];
		
		// Lager en teller som brukes for indeksering av punktene.
		int teller = 0;
		
		// Går gjennom punktene og henter latitude for hvert enkelt punkt og setter inn i listen
		for (GPSPoint g : gpspoints) {
			latitudes[teller] = g.getLatitude();
			
			//inkrementerer telleren.
			teller++;
		}
		
		// Returnerer listen når for løkken er ferdig.
		return latitudes;

	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		
		//Gjør akkurat det samme som ovenfor bare med longitude i stedet.
		double[] longitudes = new double[gpspoints.length];
		int teller = 0;
		
		for (GPSPoint g : gpspoints) {
			longitudes[teller] = g.getLongitude();
			teller++;
		}
		
		return longitudes;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		
		// Gjør om laditudes og longitudes til radianer.
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		//regner ut delta phi og lambda
		double deltaPhi = latitude2 - latitude1;
		double deltaLambda = longitude2 - longitude1;
		
		// Regner ut distanse i henhold til formel.
		double a = Math.pow(Math.sin(deltaPhi/2), 2) + Math.cos(latitude1)*Math.cos(latitude2)*Math.pow(Math.sin(deltaLambda/2), 2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		d = R*c;
		
		// returnerer funnet verdi.
		return d;

		// throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		
		// finner prukt tid ved tidsdifferanse
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		// finnner distanse ved forrige formel
		double distance = distance(gpspoint1, gpspoint2);
		
		// regner ut hastighet i Km/t
		speed = (distance/secs)*3.6;
		
		// returnerer funnet verdi.
		return speed;

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		
		// regner ut tid i timer, minutter og sekunder.
		int hh = secs/3600;
		int rest = secs%3600;
		int mm = rest/60;
		int ss = rest%60;

		// gjør om til streng som pass med 0.
		String hhStr = String.format("%02d", hh);
		String mmStr = String.format("%02d", mm);
		String ssStr = String.format("%02d", ss);
		
		// legger sammen strenger.
		timestr = hhStr + TIMESEP + mmStr + TIMESEP + ssStr;
		
		// formaterer strengen slik at den har lengde på 10
		timestr = String.format("%10s", timestr);
		
		// returnerer strngen.
		return timestr;

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		// formatetr strengen med local.US for å få punktum desimal med to siffer
		str = String.format(Locale.US, "%.2f", d);
		// formaterer strngen slik at lengden alltid er 10.
		str = String.format("%"+TEXTWIDTH+"s", str);
		
		// returnerer ferdig formatert streng
		return str;
		
	}
}