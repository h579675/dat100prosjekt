package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		//playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		// TODO - START
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		ystep = MAPYSIZE / (Math.abs(maxlat - minlat));
		
		return ystep;
		
		// throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		
		setColor(0,255,0);
		
		int prevX = 0;
		int prevY = 0;
		
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		for (int i = 0; i < gpspoints.length; i++) {
			double longitude = gpspoints[i].getLongitude();
			double latitude  = gpspoints[i].getLatitude();
			double maplongitude = (xstep() * (longitude - minlon));
			double maplatitude = (ystep() * (latitude - minlat));
			int xposition = (int)(maplongitude + 0.5);
			int yposition = (int)(maplatitude + 0.5);
			System.out.println(xstep() + " " + longitude + " " + minlon + " " + maplongitude + " " + xposition);
			System.out.println(ystep() + " " + latitude + " "  + minlat + " " + maplatitude + " " + yposition + "\n");
			fillCircle(xposition + MARGIN, ybase - yposition, 3);
			if (i >= 1) {
				drawLine(MARGIN + prevX, ybase - prevY, MARGIN + xposition, ybase - yposition);
			}
			prevX = xposition;
			prevY = yposition;
			
		}
		
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		
		drawString("Total Time     :" + GPSUtils.formatTime(gpscomputer.totalTime()), 5,10);
		drawString("Total distance :" + GPSUtils.formatDouble(gpscomputer.totalDistance()) + " km",5,20);
		drawString("Total elevation:" + GPSUtils.formatDouble(gpscomputer.totalElevation()) + " m",5,30);
		drawString("Max speed      :" + GPSUtils.formatDouble(gpscomputer.maxSpeed()) + " km/t",5,40);
		drawString("Average speed  :" + GPSUtils.formatDouble(gpscomputer.averageSpeed()) + " km/t",5,50);
		drawString("Energy         :" + GPSUtils.formatDouble(gpscomputer.totalKcal(80)) + " kcal",5,60);
		
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT;
	}

	public void playRoute(int ybase) {

		// TODO - START
		
		
		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

}
