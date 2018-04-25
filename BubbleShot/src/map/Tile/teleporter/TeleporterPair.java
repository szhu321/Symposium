package map.Tile.teleporter;

public class TeleporterPair
{
	private static int idCounter = 0;
	private int id;
	private Teleporter teleporter1;
	private Teleporter teleporter2;
	
	public TeleporterPair()
	{
		id = idCounter;
		teleporter1 = new Teleporter(0, 0, id);
		teleporter2 = new Teleporter(0, 0, id);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Teleporter getTeleporter1()
	{
		return teleporter1;
	}

	public void setTeleporter1(Teleporter teleporter1) 
	{
		this.teleporter1 = teleporter1;
	}

	public Teleporter getTeleporter2() 
	{
		return teleporter2;
	}

	public void setTeleporter2(Teleporter teleporter2) 
	{
		this.teleporter2 = teleporter2;
	}
	
	
}
