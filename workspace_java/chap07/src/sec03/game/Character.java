package sec03.game;

public class Character {
	// 공통 스탯
	int hp = 80;
	int ap = 10;
	int dp = 3;
	
	// 개별 값
	String name;
	int weapon;
	int armour;
	
	Character(String name, int weapon, int armour){
		this.name = name;
		this.weapon = weapon;
		this.armour = armour;
	}
	
	int attack() {
		System.out.println("공격!");
		return this.weapon + ap;
	}
	
	int guard() {
		return this.armour + dp;
	}
	
	
}
