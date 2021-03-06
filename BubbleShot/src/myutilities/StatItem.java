package myutilities;

/**
 * A class that stores a single information. 
 * This can be used to store player data like kill count, number of 
 * deaths, etc.
 *
 * @param <dataType> The type of data type this class will store.
 * Ex: Player name will be stored with Strings.
 */
public class StatItem<dataType>
{
	private String name;
	private dataType info;
	
	public StatItem(String name, dataType info)
	{
		this.name = name;
		this.info = info;
	}
	
	public dataType getInfo() {return info;}
	public void setInfo(dataType info) {this.info = info;}
	
	public String toString()
	{
		return "Name: " + name + "   Infomation: " + info;
	}
}
