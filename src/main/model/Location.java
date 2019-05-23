package main.model;

import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;

public class Location {
	private double x;
	private double y;

	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}

	private Address locationAddress;

	public Location(double xCoord, double yCoord) {
		NominatimReverseGeocodingJAPI nominatim1 = new NominatimReverseGeocodingJAPI(); // create instance with default
																						// zoom level (18)
		
		locationAddress = nominatim1.getAdress(x, y); //returns Address object for the given position
	}
	
	
}
