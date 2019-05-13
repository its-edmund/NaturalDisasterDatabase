package main.model;

public abstract class Disaster {
	private String type;
	private Location loc;
	
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
	public Disaster(String type, Location loc)
	{
		this.type = type;
		this.loc = loc;
	}
}
