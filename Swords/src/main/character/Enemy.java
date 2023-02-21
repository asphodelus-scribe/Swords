package main.character;

import java.util.Random;

import main.weapons.Weapon;

public class Enemy {

	String name;
	int strength;
	int dexterity;
	int defense;
	Weapon weapon;
	int health;
	int location;
	Random r = new Random();
	int randInt;
	
	public Enemy(String name, int strength, int dexterity, int defense, Weapon weapon, int health, int location){
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.defense = defense;
		this.weapon = weapon;
		this.health = health;
		this.location = location;
	}
	
	public String getName(){
		return name;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public int getDexterity(){
		return dexterity;
	}
	
	public int getDefense(){
		return defense;
	}
	
	public Weapon getWeapon(){
		return weapon;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getLocation(){
		return location;
	}
	public boolean attackPlayer(Player p){
		return p.damage(this);
	}
	
	public boolean parryCounter(Player p){
		randInt = 50+r.nextInt(2)+(p.getDefense()*2)+p.getWeapon().getDefense();
		if(randInt >100){
			randInt = 100;
		}
		if(r.nextInt(100) <= randInt){
			System.out.println("You successfully parry the enemy's attack and attempt to counter...");
			randInt = 50+r.nextInt(7)+(p.getDexterity()*2);
			if(randInt > 100){
				randInt = 100;
			}
			if(r.nextInt(100) <= randInt){
				health -= p.getStrength()+p.getWeapon().getDamage()-defense;
				System.out.println("You swing and deal "+(p.getStrength()+p.getWeapon().getDamage()-defense)+" damage...");
				if(health <= 0){
					return true;
				}else{
					return false;
				}
			}else{
				System.out.println("You swing at the "+name+", but miss...");
				return false;
			}
			
		}else{
			p.damage(this);
			System.out.println("You fail to parry the enemy attack...");
			return false;
		}
	}
	
	public boolean damage(Player p){
		randInt = 50+r.nextInt(7)+(p.getDexterity()*2);
		if(randInt > 100){
			randInt = 100;
		}
		if(r.nextInt(100) <= randInt){
			health -= p.getStrength()+p.getWeapon().getDamage()-defense+(p.getWeapon().getDamage()/2);
			System.out.println("You swing and deal "+(p.getStrength()+p.getWeapon().getDamage()-defense+(p.getWeapon().getDamage()/2))+" damage...");
			if(health <= 0){
				return true;
			}else{
				return false;
			}
		}else{
			System.out.println("You swing at the "+name+", but miss...");
			return false;
		}
	}
	
}
