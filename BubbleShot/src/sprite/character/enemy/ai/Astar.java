package sprite.character.enemy.ai;

import java.util.ArrayList;
import java.util.List;

import mainGame.GameRunner;
import mainGame.backend.Constants;
import map.Level;
import map.Room;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import sprite.character.enemy.Enemy;
import sprite.character.movement.Coord;
import sprite.character.movement.MovementPath;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.character.Character;

public class Astar extends AI
{
	private double timePass;
	private MovementPath path;
	
	public Astar(Enemy enemy, Player player)
	{
		super(enemy,player,"Astar");
		timePass=Math.random();
		//timePass = -.4;
	}
		
	public List<Coord> aStar() 
	{
		//Takes all tiles
		Tile[][] allTiles=GameRunner.getGameManager().getLevel().getCurrentRoom().getTiles();
		
		//All Obstacles
		List<Obstacle> allOb=GameRunner.getGameManager().getLevel().getCurrentRoom().getObstacles();
		
		//Enemy and player position
		int playerX=(int)this.getPlayer().getXCenter()/100;
		int playerY=(int)this.getPlayer().getYCenter()/100;
		int enemyX=(int)this.getEnemy().getXCenter()/100;
		int enemyY=(int)this.getEnemy().getYCenter()/100;
		
		//Resets previous tile
		Tile previous=null;
		
		//Set all tile's f,h,g and camefrom
		for(Tile[] tilearr: allTiles)
		{
			for(Tile tile: tilearr)
			{
				tile.setfScore(0);
				tile.sethScore(0);
				tile.setgScore(0);
				tile.setCame(null);
			}
		}
		
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
		
	/*for(int i=0;i<allTiles.length;i++)
		{
			String name="";
			for(int s=0;s<allTiles[0].length;s++)
			{
				name+=" "+allTiles[i][s].gethScore();
			}
			////System.out.println(name);
		}
		*/
		
		//Closed set for tiles already check, Open set for tiles needed to be checked
		List<Tile> closedSet=new ArrayList<Tile>();
		List<Tile> openSet=new ArrayList<Tile>();
		
		//Sets the starting tile and the destination
		Tile start=allTiles[enemyY][enemyX];	
		Tile end=allTiles[playerY][playerX];
		
		//Checks and initializes the first tile
		openSet.add(start);
		start.setgScore(0);
		start.setfScore(allTiles[(int)start.getYLocation()/100][(int)start.getYLocation()/100].gethScore());
		
		//Checks all tiles in open set
		while(openSet.size()>0)
		{
			////System.out.println();
			Tile current=openSet.get(0); 
		//	//System.out.println(openSet.size());
			
			//Finds the next tile to see if it is a better paath
			for(int i=0;i<openSet.size();i++)
			{
				if(openSet.get(i).getfScore()<current.getfScore())
				{
					current=openSet.get(i);
				}
			}
			
			//if(current.getCame()==null)
				//System.out.println("NULL");
		//	else
				//System.out.println("CAME FROM: ("+current.getCame().getXLocation()/100+","+current.getCame().getYLocation()/100+")");
			//System.out.println("CURRENT F: "+current.getfScore());
			//System.out.println("CURRENT H: "+current.gethScore());
			//System.out.print("ELOCATION: "+current.getXLocation()+" "+current.getYLocation());
			//System.out.println();
			//System.out.print("PLOCATION: "+end.getXLocation()+" "+end.getYLocation());
			//System.out.println();
			
			//If the current tile is the destination then make a path
			if(current.equals(end))
			{
				//System.out.println("CAME FROM: ("+current.getCame().getXLocation()/100+","+current.getCame().getYLocation()/100+")");
				
				//Makes the path
				List<Tile> path=Astar.makePath(current);
				
				//Makes a list of coords for the player to move
				List<Coord> pathCoords=new ArrayList<Coord>();
				
				//For every path, add the coords of the path to the list
				for(Tile t: path)
				{
					pathCoords.add(0, new Coord((int)t.getXCenter(),(int)t.getYCenter()));
				}
				
				
				//String itWorked="PATH LOCATION INDEX: ";
				//for(Tile t:path)
				//{
				//	itWorked+="("+t.getXLocation()/100+","+t.getYLocation()/100+")"+" ";
				//}
				//System.out.pinrtln(itWorked);
				//System.out.println("worked");
				
				//First position is the start
				pathCoords.remove(0);
				return pathCoords;
			}
			
			//The current Tile is not checked again
			openSet.remove(current);
			closedSet.add(current);
			
			//System.out.println("OPEN SET SIZE: "+openSet.size());
			//System.out.println("CLOSED SET SIZE: "+closedSet.size());
			
			
			//Find the neighbors of the current tile
			List<Tile> allNeighbors=Astar.getNeighbors(allTiles,current);
			//for(Tile t:allNeighbors)
			//{
			//	int gScore=t.getgScore();
			//	int hScore=t.gethScore();
			//	t.setfScore(gScore+hScore);
			//}d
			
			//System.out.println("NEIGHBOOOORS SIZE: "+allNeighbors.size());
			
			//Checks all neighbors to see which is the best path
			for(int i=0;i<allNeighbors.size();i++)
			{
				//Doesn't check for neighbors already checked
				if(closedSet.contains(allNeighbors.get(i)))
					continue;
				
				//Adds up the g score of the current tile with the neighbor
				int tentGScore=current.getgScore()+allNeighbors.get(i).getgScore();
				//System.out.println("TENTG SCORE: "+tentGScore);
				//System.out.println("CURRENT NEIGHBOR G SCORE: "+allNeighbors.get(i).getgScore());
				
				//Add the neighbors to openset if not done so already and checks if a neighbor has a better path
				if(!openSet.contains(allNeighbors.get(i)))
					openSet.add(allNeighbors.get(i));
				else if(tentGScore>=allNeighbors.get(i).getgScore())
					continue;
				
				//The current neighbor is the best path
				allNeighbors.get(i).setCame(current);
				//System.out.println("CAME FROM: ("+allNeighbors.get(i).getCame().getXLocation()/100+","+allNeighbors.get(i).getCame().getYLocation()/100+")");
				allNeighbors.get(i).setgScore(tentGScore);
				allNeighbors.get(i).setfScore(allNeighbors.get(i).getgScore()+allNeighbors.get(i).gethScore());
			}
			
		/*	String lul="ALL F SCORE: ";
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
			
			//System.out.println(lul);
			//System.out.println(OwO);
			//System.out.println(UwU);
			//System.out.println(Position); */
		}
		return null;
	}
	
	/**
	 * Gets all neighbors for a tile
	 * @param tilesArr
	 * @param start
	 * @return return all neighbors
	 */
	public static List<Tile> getNeighbors(Tile[][] tilesArr, Tile start)
	{
		List<Tile> neighbor=new ArrayList<Tile>();
		
		int currentX=(int)start.getXLocation()/100;
		int currentY=(int)start.getYLocation()/100;
		
		if(currentX-1>=0&&currentY-1>=0)
		{
			//System.out.println("HSCORE"+tilesArr[currentY-1][currentX-1].gethScore());
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
	
	/**
	 * Makes a path when destination is found
	 * @param current
	 * @return
	 */
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
	
	public void action(double sec)
	{
		this.getEnemy().calculateEnemyAngleToPlayer();
		move(sec);
		this.getEnemy().useCurrentItem(Item.WEAPON);
	}
	
	public void move(double sec)
	{
		if(timePass > 1.5)
		{
			timePass=1;
			
			//List<Coord> coords=new ArrayList<Coord>();
			//coords.add(new Coord(850,150));
			//coords.add(new Coord(750,150));
			//coords.add(new Coord(650,150));
			//coords.add(new Coord(550,150));
			
			//Gets path
			MovementPath hardPath=new MovementPath(aStar(),false);
			
			//Updates path if enemy moves
			this.getEnemy().getMovement().updateMovementPath(hardPath);
		}
		
			timePass+=sec;	
			double[] moveTo=this.getEnemy().getMovement().runDrive(sec);
			if(moveTo!=null)
			{
				double deltaX=moveTo[0];
				double deltaY=moveTo[1];
				if(deltaX<0)
				{
					if(!(GameRunner.getGameManager().getLevel().getCurrentRoom().canCharacterMove(this.getEnemy(), Constants.MOVE_DIR_LEFT, Math.abs(deltaX))))
					{
						deltaX=0;
					}
				}
				if(deltaX>0)
				{
					if(!(GameRunner.getGameManager().getLevel().getCurrentRoom().canCharacterMove(this.getEnemy(), Constants.MOVE_DIR_RIGHT, Math.abs(deltaX))))
					{
						deltaX=0;
					}
				}
				if(deltaY<0)
				{
					if(!(GameRunner.getGameManager().getLevel().getCurrentRoom().canCharacterMove(this.getEnemy(), Constants.MOVE_DIR_UP, Math.abs(deltaY))))
					{
						deltaY=0;
					}
				}
				if(deltaY>0)
				{
					if(!(GameRunner.getGameManager().getLevel().getCurrentRoom().canCharacterMove(this.getEnemy(), Constants.MOVE_DIR_DOWN, Math.abs(deltaY))))
					{
						deltaY=0;
					}
				}
				if(deltaX != 0 && deltaY != 0)
				{
					deltaX *= 1 / Math.sqrt(2);
					deltaY *= 1 / Math.sqrt(2);
				}		
    	
				this.getEnemy().addXLocation(deltaX);
				this.getEnemy().addYLocation(deltaY);
			}
	}
}
