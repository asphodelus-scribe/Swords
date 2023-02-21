package main.environment;

import java.util.ArrayList;
import java.util.Random;

import main.character.Enemy;
import main.weapons.Weapon;
import main.weapons.Weaponlist;

public class Environment {

	private ArrayList<String> environment;
	private int randInt;
	private int randInt2;
	private Enemy tileEnemy;
	private int tileEnemyLocation;
	private int playerLocation;
	private String localEnvironment = "";
	Random r = new Random();
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	Weaponlist wpl = new Weaponlist();
	Weapon wepAdd;
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	
	public Environment(){
		environment = new ArrayList<String>(5);
		randInt = r.nextInt(100)+1;
		for(int i = 0; i < 500; i++){	
			//extend functionality to obstacles
			randInt = r.nextInt(100)+1;
			if(randInt < 15){
				environment.add("O");
				if(i >= 0 && i <= 100){
					randInt = r.nextInt(9);
					randInt2 = r.nextInt(5);
					tileEnemy = new Enemy("Duelist", 2, 2, 1, wpl.getWepList().get(randInt), 10+randInt2, i);
					enemyList.add(tileEnemy);
					tileEnemyLocation = i;
					//System.out.println("Generated "+tileEnemy.getName()+" at location "+i+" weilding "+tileEnemy.getWeapon().getName()+" with health "+tileEnemy.getHealth());
				}else if(i > 100 && i <= 200){
					randInt = r.nextInt(9);
					randInt2 = r.nextInt(5)+5;
					tileEnemy = new Enemy("Fighter", 4, 4, 2, wpl.getWepList().get(randInt), 10+randInt2, i);
					enemyList.add(tileEnemy);
					tileEnemyLocation = i;
					//System.out.println("Generated "+tileEnemy.getName()+" at location "+i+" weilding "+tileEnemy.getWeapon().getName()+" with health "+tileEnemy.getHealth());
				}else if(i > 200 && i <= 300){
					randInt = r.nextInt(9);
					randInt2 = r.nextInt(10)+5;
					tileEnemy = new Enemy("Warrior", 6, 6, 3, wpl.getWepList().get(randInt), 10+randInt2, i);
					enemyList.add(tileEnemy);
					tileEnemyLocation = i;
					//System.out.println("Generated "+tileEnemy.getName()+" at location "+i+" weilding "+tileEnemy.getWeapon().getName()+" with health "+tileEnemy.getHealth());
				}else if(i > 300 && i <= 400){
					randInt = r.nextInt(9);
					randInt2 = r.nextInt(15)+5;
					tileEnemy = new Enemy("Champion", 8, 8, 4, wpl.getWepList().get(randInt), 10+randInt2, i);
					enemyList.add(tileEnemy);
					tileEnemyLocation = i;
					//System.out.println("Generated "+tileEnemy.getName()+" at location "+i+" weilding "+tileEnemy.getWeapon().getName()+" with health "+tileEnemy.getHealth());
				}else{
					randInt = r.nextInt(9);
					randInt2 = r.nextInt(5)+5;
					tileEnemy = new Enemy("Warlord", 10, 10, 5, wpl.getWepList().get(randInt), 10+randInt2, i);
					enemyList.add(tileEnemy);
					tileEnemyLocation = i;
					//System.out.println("Generated "+tileEnemy.getName()+" at location "+i+" weilding "+tileEnemy.getWeapon().getName()+" with health "+tileEnemy.getHealth());
				}
			}else{
				environment.add(".");
			}
		}
		environment.set(2, "X");
		playerLocation = 2;
	}
	
	public void clearTile(int index){
		environment.set(index, ".");
	}
	
	public String getLocalEnvironment(){
		t1 = environment.get(playerLocation-2);
		t2 = environment.get(playerLocation-1);
		t3 = environment.get(playerLocation);
		t4 = environment.get(playerLocation+1);
		t5 = environment.get(playerLocation+2);
		/**
		System.out.println("player location: "+playerLocation);
		if(playerLocation > 1){
			localEnvironment.concat(environment.get(playerLocation-2));
			System.out.println("a Concatted "+environment.get(playerLocation-2));
		}
		if(playerLocation > 0){
			System.out.println("player location is > 0 ("+environment.size()+" < "+playerLocation);
			localEnvironment.concat(environment.get(playerLocation-1));
			System.out.println("b Concatted "+environment.get(playerLocation-1));
		}
		localEnvironment.concat("X");
		if(playerLocation == environment.size()-2){
			randInt = r.nextInt(100)+1;
			if(randInt <= 10){
				environment.set(environment.size()-2, "O");
			}else{
				environment.set(environment.size()-2, ".");
			}
			localEnvironment.concat(environment.get(playerLocation+1));
			System.out.println("c Concatted "+environment.get(playerLocation+1));
		}
		localEnvironment.concat(environment.get(playerLocation+2));
		System.out.println("Returning "+localEnvironment);
		return localEnvironment;
		*/
		
		return t1 + t2 + t3 + t4 + t5;
		
	}
	
	public void addEnemy(int index, Enemy enemy){
		environment.set(index, "O");
		tileEnemy = enemy;
		tileEnemyLocation = index;
	}
	
	public void advanceEnemy(int distance){
		
	}
	
	public void retreatEnemy(int distance){
		
	}
	
	public Enemy getTileEnemy(){
		return tileEnemy;
	}
	
	public int getTileEnemyLocation(){
		return tileEnemyLocation;
	}
	
	public ArrayList<Enemy> getEnemyList(){
		return enemyList;	
	}
	
	public boolean advancePlayer(){
		if(!environment.get(playerLocation+1).equals("O")){
		environment.set(playerLocation, ".");
		playerLocation += 1;
		environment.set(playerLocation, "X");
		return true;
		}else{
			System.out.println("Cannot move forwards, an enemy blocks the path...");
			return false;
		}
		
	}
	
	public void retreatPlayer(){
		
	}
	
	
	
	public int getPlayerLocation(){
		return playerLocation;
	}
	
	public String checkTile(int index){
		return environment.get(index);
	}
	
	
}
