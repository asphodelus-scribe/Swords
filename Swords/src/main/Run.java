package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import main.character.Player;
import main.environment.Environment;
import main.weapons.Weapon;
import main.weapons.Weaponlist;

public class Run {

	public static void main(String[] args) {
		int diff = 0;
		int points = 0;
		int enemyNumber = 0;
		Environment env = new Environment();
		String name = "Generic Character Name";
		Weapon wep = new Weapon("placeholder", 0, 0, 0);
		Weaponlist wpl = new Weaponlist();
		ArrayList<Weapon> wplist = wpl.getWepList();
		System.out.println("Please enter character name: ");
		Scanner scan = new Scanner(System.in);
		String str;
		boolean skip = false;
		Random r = new Random();
		boolean bool = false;
		name = scan.nextLine();
		System.out.println("Please choose a difficulty level [1, 2, 3]: ");
		while(bool == false){
			str = scan.nextLine();
			if(str.equals("1")){
				diff = 1;
				bool = true;
			}else if(str.equals("2")){
				diff = 2;
				bool  = true;
			}else if(str.equals("3")){
				diff = 3;
				bool = true;
			}else{
				System.out.println("Invalid input, please enter one of the following options [1, 2, 3]...");
			}
		}
		bool = false;
		System.out.println("Please select a starting weapon from the following options, weapon stats (damage, speed, and defense) are displayed ");
		for(int i = 0; i < wplist.size(); i++){
			System.out.println((i+1)+") "+wplist.get(i).getName()+": "+wplist.get(i).getDamage()+", "+wplist.get(i).getSpeed()+", "+wplist.get(i).getDefense());
		}
		System.out.println("Please enter the number of the weapon you would like to select: ");
		while(bool == false){
			str = scan.nextLine();
			if(str.equals("1")){
				wep = wplist.get(0);
				bool = true;
			}else if(str.equals("2")){
				wep = wplist.get(1);
				bool  = true;
			}else if(str.equals("3")){
				wep = wplist.get(2);
				bool = true;
			}else if(str.equals("4")){
				wep = wplist.get(3);
				bool  = true;
			}else if(str.equals("5")){
				wep = wplist.get(4);
				bool = true;
			}else if(str.equals("6")){
				wep = wplist.get(5);
				bool = true;
			}else if(str.equals("7")){
				wep = wplist.get(6);
				bool = true;
			}else if(str.equals("8")){
				wep = wplist.get(7);
				bool = true;
			}else if(str.equals("9")){
				wep = wplist.get(8);
				bool  = true;
			}else{
				System.out.println("Invalid input, please enter the number of the weapon you would like to select [1-9]...");
			}
		}
		Player character = new Player(name, diff, wep);
		System.out.println("Now initializing game for player \""+name+"\" at difficulty level "+diff+" weilding a "+wep.getName()+"...");
		str = "";
		bool = false;
		while(bool == false){
			System.out.println("Enter \"d\" to move forward and \"a\" to move back, \"e\" to inspect an enemy, \"s\" to see character stats, \"w\" to attack, or \"q\" to attempt a parry and counterattack...");
			System.out.println(env.getLocalEnvironment());
			str = scan.nextLine();
			if(str.equals("d")){
				env.advancePlayer();		
			}
			if(str.equals("q")){
				if(env.checkTile(env.getPlayerLocation()+1).equals("O")){
					if(env.getEnemyList().get(enemyNumber).parryCounter(character)){
						System.out.println("You have killed the "+env.getEnemyList().get(enemyNumber).getName()+"...");
						character.gainExperience(env.getEnemyList().get(enemyNumber).getStrength()+2);
						enemyNumber += 1;
						points += 5;
						env.clearTile(env.getPlayerLocation()+1);
						
					}else{
						if(character.getHealth() <= 0 ){
							System.out.println("You have died...");
							points += env.getPlayerLocation();
							points += character.getLevel()*5;
							System.out.println("Finished with "+points+" points...");
							System.out.println("Add character to highschores? [y,n]: ");
							//TODO
							bool = true;
						}
					}
				}
			}
			if(str.equals("e")){
				if(env.checkTile(env.getPlayerLocation()+1).equals("O")){
					System.out.println("Enemy: "+env.getEnemyList().get(enemyNumber).getName()+", with "+env.getEnemyList().get(enemyNumber).getHealth()+" health weilding a "+env.getEnemyList().get(enemyNumber).getWeapon().getName()+"...");
				}
			}
			if(str.equals("s")){
				System.out.println("Player \""+character.getName()+"\" level "+character.getLevel()+" (difficulty["+character.getDifficulty()+"]): ");
				System.out.println("Weapon: "+character.getWeapon().getName()+" (dmg["+character.getWeapon().getDamage()+"+"+character.getStrength()+"], spd["+character.getWeapon().getSpeed()+"+"+character.getDexterity()+"], def["+character.getWeapon().getDefense()+"+"+character.getDefense()+"])");
				System.out.println("Health: "+character.getHealth());
				System.out.println("Strength: "+character.getStrength());
				System.out.println("Dexterity: "+character.getDexterity());
				System.out.println("Defense: "+character.getDefense());
				System.out.println("Experience: "+character.getExperience());
			}
			if(str.equals("w")){
				if(env.checkTile(env.getPlayerLocation()+1).equals("O")){
					if(character.getWeapon().getName().equals("Dagger") && r.nextInt(50)+9+character.getDexterity() > r.nextInt(100)){
						System.out.println("Double attack!");
						if(env.getEnemyList().get(enemyNumber).damage(character)){
							System.out.println("You have killed the "+env.getEnemyList().get(enemyNumber).getName()+"...");
							character.gainExperience(env.getEnemyList().get(enemyNumber).getStrength()+2);
							enemyNumber += 1;
							points += 5;
							env.clearTile(env.getPlayerLocation()+1);
							skip = true;
						}else{
							
						}
					}
					if(!skip){
						if(env.getEnemyList().get(enemyNumber).damage(character)){
							System.out.println("You have killed the "+env.getEnemyList().get(enemyNumber).getName()+"...");
							character.gainExperience(env.getEnemyList().get(enemyNumber).getStrength()+2);
							enemyNumber += 1;
							points += 5;
							env.clearTile(env.getPlayerLocation()+1);
						
						}else{
							if(env.getEnemyList().get(enemyNumber).attackPlayer(character)){
								System.out.println("You have died...");
								points += env.getPlayerLocation();
								points += character.getLevel()*5;
								System.out.println("Finished with "+points+" points...");
								System.out.println("Add character to highschores? [y,n]: ");
								//TODO
								bool = true;
							}else{
							
							}
						}
					}else{
						skip = false;
					}
				}else{
					System.out.println("There is no enemy in front of you...");
				}
			}
		}
	}

}
