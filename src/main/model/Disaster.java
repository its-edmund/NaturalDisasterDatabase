package main.model;

public abstract class Disaster {
	
	private String type;
	private Location loc;
	
	public Disaster(String type, double xCoord, double yCoord)
	{
		this.type = type;
		this.loc = new Location(xCoord, yCoord);
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
	
}
