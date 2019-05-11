package main.model;

import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;

public class Location {
	private double x;
	private double y;
	Address locationAddress;

	public Location(xCoord, yCoord) {
		NominatimReverseGeocodingJAPI nominatim1 = new NominatimReverseGeocodingJAPI(); // create instance with default
																						// zoom level (18)
		
		locationAddress = nominatim1.getAdress(x, y); //returns Address object for the given position
	}
	
	

}
