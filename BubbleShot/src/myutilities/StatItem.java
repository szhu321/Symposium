package myutilities;

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
