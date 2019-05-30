package main.model;

public class Disaster {
	
	private String type;
	private Location loc;
	
	public Disaster(String type, String city, String country)
	{
		this.type = type;
		this.loc = new Location(city, country);
	}
	
	public String getType()
	{
		return type;
	}
	
	public Location getLoc()
	{
		return loc;
	}
	
	public void setType(String newType)
	{
		this.type = newType;
	}
	
	public void setLoc(Location newLoc)
	{
		this.loc = newLoc;
	}
	
	public String toString()
	{
		return loc.getCity() + ", " + loc.getCountry();
	}
	
	
	
}
