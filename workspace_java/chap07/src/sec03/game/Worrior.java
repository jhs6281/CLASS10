package sec03.game;

public class Worrior extends Character {

	Worrior(){
		super("전사", 3, 3);
	}
	
	@Override
	int attack() {
		System.out.println("전사의 팔 휘두르기!");
		return this.weapon + ap;
	}
}
