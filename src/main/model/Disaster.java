package main.model;

public abstract class Disaster {
	private String type;
	private Location loc;
	
	public Disaster(String type, Location loc)
	{
		this.type = type;
		this.loc = loc;
	}
}
