package sprite.character.enemy.ai;

import java.util.ArrayList;
import java.util.List;

import map.Level;
import map.Room;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.character.Character;

public class Astar extends AI
{
	
	public Astar(Enemy enemy, Player player)
	{
		super(enemy,player);
	}
	
	public static int aStar(Level level, Player player, Enemy enemy) 
	{
		//Takes all tiles
		Tile[][] allTiles=level.getCurrentRoom().getTiles();
		//All Obstacles
		List<Obstacle> allOb=level.getCurrentRoom().getObstacles();
		
		//Enemy and player position
		int playerX=(int)player.getXLocation()/100;
		int playerY=(int)player.getYLocation()/100;
		int enemyX=(int)enemy.getXLocation()/100;
		int enemyY=(int)enemy.getYLocation()/100;
		
		Tile previous=null;
		
		//Set H Values to each Tiles
		for(int i=0;i<allTiles.length;i++)
		{
			for(int s=0;s<allTiles[0].length;s++)
			{
				allTiles[i][s].sethScore((Math.abs(playerX-s)+Math.abs(playerY-i))*10);
			}
		}
		
		//Checks for obstacles
		for(int i=0;i<allTiles.length;i++)
		{
			for(int s=0;s<allTiles[0].length;s++)
			{
				for(int q=0;q<allOb.size();q++)
				{
					if(allTiles[i][s].getBoundsOfObject().intersect(allOb.get(q).getBoundsOfObject()))
					{	
						allTiles[i][s].sethScore(-1);					
					}
				}
			}
		}
		
		for(int i=0;i<allTiles.length;i++)
		{
			String name="";
			for(int s=0;s<allTiles[0].length;s++)
			{
				name+=" "+allTiles[i][s].gethScore();
			}
			System.out.println(name);
		}
		
		
		List<Tile> closedSet=new ArrayList<Tile>();
		List<Tile> openSet=new ArrayList<Tile>();
		
		Tile start=allTiles[enemyY][enemyX];	
		Tile end=allTiles[playerY][playerX];
		
		
		openSet.add(start);
		start.setgScore(0);
		start.setfScore(allTiles[(int)start.getYLocation()/100][(int)start.getYLocation()/100].gethScore());
		
		while(openSet.size()>0)
		{
			System.out.println();
			Tile current=openSet.get(0); 
		//	System.out.println(openSet.size());
			for(int i=0;i<openSet.size();i++)
			{
				if(openSet.get(i).getfScore()<current.getfScore())
				{
					current=openSet.get(i);
				}
			}
			if(current.getCame()==null)
				System.out.println("NULL");
			else
				System.out.println("CAME FROM: ("+current.getCame().getXLocation()/100+","+current.getCame().getYLocation()/100+")");
			System.out.println("CURRENT F: "+current.getfScore());
			System.out.println("CURRENT H: "+current.gethScore());
			System.out.print("ELOCATION: "+current.getXLocation()+" "+current.getYLocation());
			System.out.println();
			System.out.print("PLOCATION: "+end.getXLocation()+" "+end.getYLocation());
			System.out.println();
			
			if(current.equals(end))
			{
				System.out.println("CAME FROM: ("+current.getCame().getXLocation()/100+","+current.getCame().getYLocation()/100+")");
				List<Tile> path=Astar.makePath(current);
				String itWorked="PATH LOCATION INDEX: ";
				for(Tile t:path)
				{
					itWorked+="("+t.getXLocation()/100+","+t.getYLocation()/100+")"+" ";
				}
				System.out.println(itWorked);
				System.out.println("worked");
				return 1;
			}
			
			openSet.remove(current);
			closedSet.add(current);
			
			System.out.println("OPEN SET SIZE: "+openSet.size());
			System.out.println("CLOSED SET SIZE: "+closedSet.size());
			
			List<Tile> allNeighbors=Astar.getNeighbors(allTiles,current);
			for(Tile t:allNeighbors)
			{
				int gScore=t.getgScore();
				int hScore=t.gethScore();
				t.setfScore(gScore+hScore);
			}
			
			System.out.println("NEIGHBOOOORS SIZE: "+allNeighbors.size());
			
			for(int i=0;i<allNeighbors.size();i++)
			{
				Boolean isInClosed=false;
				for(int s=0;s<closedSet.size();s++)
				{
					if(allNeighbors.get(i).equals(closedSet.get(s)))
					{
						isInClosed=true;
						System.out.println("CLOSED LIST SIZE IN NEIGHBOR: "+ closedSet.size());
						break;
					}				
				}
				
				if(isInClosed)
					continue;
				
				int tentGScore=current.getgScore()+allNeighbors.get(i).getgScore();
				System.out.println("TENTG SCORE: "+tentGScore);
				System.out.println("CURRENT NEIGHBOR G SCORE: "+allNeighbors.get(i).getgScore());
				
				if(openSet.size()!=0)
				{
					for(int q=0;q<openSet.size();q++)
					{
						if(!(openSet.get(q).equals(allNeighbors.get(i))))
						{
							openSet.add(allNeighbors.get(i));
							System.out.println("NEIGHBOR ADD TO OPEN: "+openSet.size());
							break;
						}	
						else
							if(tentGScore>=allNeighbors.get(i).getgScore())
							{
								continue;
							}
					}	
				}
				else
				{
					openSet.add(allNeighbors.get(i));
					System.out.println("NEIGHBOR ADD TO OPEN: "+openSet.size());
				}
				allNeighbors.get(i).setCame(current);
				System.out.println("CAME FROM: ("+allNeighbors.get(i).getCame().getXLocation()/100+","+allNeighbors.get(i).getCame().getYLocation()/100+")");
				allNeighbors.get(i).setgScore(tentGScore);
				allNeighbors.get(i).setfScore(allNeighbors.get(i).getgScore()+allNeighbors.get(i).gethScore());
			}
			
			String lul="ALL F SCORE: ";
			String OwO="ALL G SCORE: ";
			String UwU="ALL H SCORE: ";
			String Position="Index: ";
			for(Tile t:allNeighbors)
			{
				lul+=t.getfScore()+" ";
				OwO+=t.getgScore()+" ";
				UwU+=t.gethScore()+" ";
				Position+="("+t.getXLocation()/100+","+t.getYLocation()/100+")"+" ";
			}
			
			System.out.println(lul);
			System.out.println(OwO);
			System.out.println(UwU);
			System.out.println(Position);
		}
		return 0;
	}
	
	public static List<Tile> getNeighbors(Tile[][] tilesArr, Tile start)
	{
		List<Tile> neighbor=new ArrayList<Tile>();
		
		int currentX=(int)start.getXLocation()/100;
		int currentY=(int)start.getYLocation()/100;
		
		if(currentX-1>=0&&currentY-1>=0)
		{
			System.out.println("HSCORE"+tilesArr[currentY-1][currentX-1].gethScore());
			if(tilesArr[currentY-1][currentX-1].gethScore()!=-1)
			{
				tilesArr[currentY-1][currentX-1].setgScore(14);
				neighbor.add(tilesArr[currentY-1][currentX-1]);	
			}
		}
		
		if(currentX-1>=0&&currentY>=0)
		{
			if(tilesArr[currentY][currentX-1].gethScore()!=-1)
			{
				tilesArr[currentY][currentX-1].setgScore(10);
				neighbor.add(tilesArr[currentY][currentX-1]);
			}
		}
		
		if(currentX-1>=0&&currentY+1>=0)
		{
			if(tilesArr[currentY+1][currentX-1].gethScore()!=-1)
			{
				tilesArr[currentY+1][currentX-1].setgScore(14);
				neighbor.add(tilesArr[currentY+1][currentX-1]);
			}
		}
		
		if(currentX>=0&&currentY-1>=0)
		{
			if(tilesArr[currentY-1][currentX].gethScore()!=-1)
			{
				tilesArr[currentY-1][currentX].setgScore(10);
				neighbor.add(tilesArr[currentY-1][currentX]);
			}
		}
		
		if(currentX>=0&&currentY+1>=0)
		{
			if(tilesArr[currentY+1][currentX].gethScore()!=-1)
			{
				tilesArr[currentY+1][currentX].setgScore(10);
				neighbor.add(tilesArr[currentY+1][currentX]);
			}
		}
		
		if(currentX+1>=0&&currentY-1>=0)
		{
			if(tilesArr[currentY-1][currentX+1].gethScore()!=-1)
			{
				tilesArr[currentY-1][currentX+1].setgScore(14);
				neighbor.add(tilesArr[currentY-1][currentX+1]);
			}
		}
		
		if(currentX+1>=0&&currentY>=0)
		{
			if(tilesArr[currentY][currentX+1].gethScore()!=-1)
			{
				tilesArr[currentY][currentX+1].setgScore(10);
				neighbor.add(tilesArr[currentY][currentX+1]);
			}
		}
		
		if(currentX+1>=0&&currentY+1>=0)
		{
			if(tilesArr[currentY+1][currentX+1].gethScore()!=-1)
			{
				tilesArr[currentY+1][currentX+1].setgScore(10);
				neighbor.add(tilesArr[currentY+1][currentX+1]);
			}
		}
		
		return neighbor;
	}
	
	public static List<Tile> makePath(Tile current)
	{
		List<Tile> path=new ArrayList<Tile>();
		path.add(current);
		while(current.getCame()!=null)
		{
			path.add(current.getCame());
			current=current.getCame();
		}
		
		return path;
	}
	
	public void move(double sec, Level level)
	{
		
	}
}
