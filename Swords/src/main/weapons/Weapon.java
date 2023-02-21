package main.weapons;

public class Weapon {
	
	String name;
	int damage;
	int speed;
	int defense;

	public Weapon(String name, int damage, int speed, int defense){
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.defense = defense;
	}
	
	public String getName(){
		return name;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getDefense(){
		return defense;
	}
	
}
