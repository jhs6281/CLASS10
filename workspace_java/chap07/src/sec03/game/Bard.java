package sec03.game;

public class Bard extends Character {

	Bard(){
		super("바드", 2, 4);
	}
	
	@Override
	int attack() {
		System.out.println("바드의 악기로 머리 부수기!");
		return this.weapon + ap;
	}
}
