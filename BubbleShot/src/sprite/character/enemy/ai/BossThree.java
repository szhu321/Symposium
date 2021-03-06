package sprite.character.enemy.ai;

import mainGame.GameRunner;
import map.Room;
import map.Tile.Tile;
import map.Tile.TileDesign;
import sprite.character.enemy.Boss;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.WizardBoss;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.BossWepEight;
import sprite.item.weapon.BossWepFive;
import sprite.item.weapon.BossWepNine;
import sprite.item.weapon.BossWepTen;
import sprite.item.weapon.BossWepThree;

public class BossThree extends AI
{
	private int time;
	private int onetime;
	private int wepArrNum;
	public BossThree(Enemy enemy, Player player) {
		super(enemy, player, "BossOne");
		// TODO Auto-generated constructor stub
		time=200;
		onetime=0;
		wepArrNum=(int)(Math.random()*2);
		((WizardBoss)(this.getEnemy())).switchElement(wepArrNum);
	}

	@Override
	public void action(double sec)
	{
		//Pauses an enemy after an attack and resets time for new attack
		if(time==300)
			time=0;
		if(time<200)
		{
			if(wepArrNum==0)
			{
					Room currentRoom=GameRunner.getGameManager().getLevel().getCurrentRoom();
					Tile[][] allTiles=currentRoom.getTiles();
					for(int i=onetime;i<allTiles.length;i++)
					{
						for(int s=0;s<allTiles[0].length;s++)
						{
							if(i!=3&&s!=allTiles[0].length-4&&s!=3&&i!=allTiles.length-4)
								currentRoom.setTileAt(s, i, TileDesign.getLavaTileDesignOne(i*100, s*100, 100, 100, 0));
						}
					}
			}
			else
			{
						Room currentRoom=GameRunner.getGameManager().getLevel().getCurrentRoom();
						Tile[][] allTiles=currentRoom.getTiles();
						for(int i=onetime;i<allTiles.length;i++)
						{
							for(int s=0;s<allTiles[0].length;s++)
							{			
								currentRoom.setTileAt(s, i, TileDesign.getStoneTileDesignOne(i*100, s*100, 100, 100, 0));
							}
						}
					
			}
			if(time%10==0)
			{
				int wepIdx=(int)(Math.random()*((Boss)(this.getEnemy())).getAllWep().size());
				((Boss)(this.getEnemy())).switchWeapon(wepIdx);
			}
			if(time%300==0)
			{
				wepArrNum=(int)(Math.random()*3);
				((WizardBoss)(this.getEnemy())).switchElement(wepArrNum);
			}
			this.getEnemy().useCurrentItem(Item.WEAPON);		
			//this.getEnemy().useCurrentItem(Item.WEAPON);
		}
		time++;
	}
	
	public void move()
	{
		
	}
	
	public void wander(double sec)
	{
		//Doesn't Wander
	}
}
