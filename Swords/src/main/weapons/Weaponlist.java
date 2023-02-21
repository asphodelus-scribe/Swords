package main.weapons;

import java.util.ArrayList;

public class Weaponlist {

	public Weapon shortSword;
	public Weapon longSword;
	public Weapon claymore;
	public Weapon sabre;
	public Weapon broadSword;
	public Weapon rapier;
	public Weapon cutlass;
	public Weapon katana;
	public Weapon dagger;
	public ArrayList<Weapon> wepList;
	
	public Weaponlist(){
		wepList = new ArrayList<Weapon>();
		initializeWeapons();
		wepList.add(shortSword);
		wepList.add(longSword);
		wepList.add(claymore);
		wepList.add(sabre);
		wepList.add(broadSword);
		wepList.add(rapier);
		wepList.add(cutlass);
		wepList.add(katana);
		wepList.add(dagger);
		
	}
	
	public void initializeWeapons(){
		shortSword = new Weapon("Shortsword", 3, 8, 2);
		longSword = new Weapon("Longsword", 7, 2, 6);
		claymore = new Weapon("Claymore", 9, 1, 7);
		sabre = new Weapon("Sabre", 4, 6, 5);
		broadSword = new Weapon("Broadsword", 6, 5, 8);
		rapier = new Weapon("Rapier", 2, 7, 9);
		cutlass = new Weapon("Cutlass", 5, 4, 4);
		katana = new Weapon("Katana", 8, 3, 3);
		dagger = new Weapon("Dagger", 1, 9, 1);
	}
	
	public ArrayList<Weapon> getWepList(){
		return wepList;
	}
	
}
