package myutilities;

public class GraphicsItem
{
	private int id;
	private String graphicsName;
	private boolean defaultValue;
	private boolean currentValue;
	
	/**
	 * A Graphics Item is a item that keeps track of a single graphics setting in the game.
	 * @param name The name of the graphics.
	 * @param controlStr The 
	 */
	public GraphicsItem(String name, boolean isOn)
	{
		graphicsName = name;
		defaultValue = isOn;
		currentValue = isOn;
	}

	public String toString()
	{
		return "Name: " + graphicsName + " ControlInput: " + currentValue;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getGraphicsName()
	{
		return graphicsName;
	}

	public boolean getDefaultValue()
	{
		return defaultValue;
	}

	public boolean getCurrentValue()
	{
		return currentValue;
	}

	public void setCurrentValue(boolean currentValue)
	{
		this.currentValue = currentValue;
	}
	
}
