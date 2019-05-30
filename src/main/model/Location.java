package main.model;

import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;

public class Location {
	
	private double x;
	private double y;
	private String city;
	private String country;
	private Address locationAddress;

	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getCountry()
	{
		return country;
	}

	public Location(String city, String country) {
		
		this.city = city;
		this.country = country;
		//NominatimReverseGeocodingJAPI nominatim1 = new NominatimReverseGeocodingJAPI(); // create instance with default
																						// zoom level (18)
		
		//locationAddress = nominatim1.getAdress(x, y); //returns Address object for the given position
	}
	
	
}
