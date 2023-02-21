package main.character;

import java.util.Random;
import java.util.Scanner;

import main.weapons.Weapon;

public class Player {
	
	String name;
	int difficulty;
	Weapon weapon;
	int strength;
	int dexterity;
	int defense;
	int health;
	int randInt;
	int experience;
	int level = 1;
	Random r = new Random();
	
	public Player(String name, int difficulty, Weapon weapon){
		this.name = name;
		this.difficulty = difficulty;
		this.weapon = weapon;
		strength = 2;
		dexterity = 2;
		defense = 1;
		health = 25;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getExperience(){
		return experience;
	}
	
	public void gainExperience(int xp){
		experience += xp;
		System.out.println("You gained "+xp+" experience...");
		if(experience >= 10+(3*(level^2))){
			levelUp();
		}
	}
	
	public void levelUp(){
		experience = 0;
		level += 1;
		health = 20+(3*(level^2));
		System.out.println("You have leveled up!");
		System.out.println("Please select a stat to upgrade: [str, dex, def]");
		boolean bool = false;
		Scanner scan = new Scanner(System.in);
		String str = "";
		while(bool == false){
			str = scan.nextLine();
			if(str.equals("str")){
				strength += 1;
				System.out.println("Strength increased! ("+(strength-1)+" -> "+strength+")...");
				bool = true;
			}else if(str.equals("dex")){
				dexterity += 1;
				System.out.println("Dexterity increased! ("+(dexterity-1)+" -> "+dexterity+")...");
				bool = true;
			}else if(str.equals("def")){
				defense += 1;
				System.out.println("Defense increased! ("+(defense-1)+" -> "+defense+")...");
				bool = true;
			}else{
				System.out.println("Please enter a valid input...");
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getDefense() {
		return defense;
	}

	public int getHealth() {
		return health;
	}
	
	public boolean damage(Enemy e){
		randInt = 50+r.nextInt(7)+(e.getDexterity()*2)-(((dexterity+weapon.getSpeed())*2));
		if(randInt > 100){
			randInt = 100;
		}
		if(r.nextInt(100) <= randInt){
			if(e.getStrength()+e.getWeapon().getDamage()-defense <= 0){
				System.out.println("The "+e.getName()+" hits you, but cannot penetrate your defenses...");
			}else{
				health -= e.getStrength()+e.getWeapon().getDamage()-defense;
				System.out.println("The "+e.getName()+" swings and deals "+(e.getStrength()+e.getWeapon().getDamage()-defense)+" damage...");
			}
			
			if(health <= 0){
				return true;
			}else{
				return false;
			}
		}else{
			System.out.println("The "+e.getName()+" swings at you, but misses...");
			return false;
		}
	}
	
	

}
