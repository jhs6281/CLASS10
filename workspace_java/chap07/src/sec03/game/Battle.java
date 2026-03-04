package sec03.game;

public class Battle {

	String battle(Character c1, Character c2) {
		while (true) {
			c1.hp -= ((c2.attack() + (int)(Math.random() * 6)) - c1.guard() );
			if (c1.hp <= 0) {
				return c2.name;
			}
			c2.hp -= ((c1.attack() + (int)(Math.random() * 6)) - c2.guard());
			if (c2.hp <= 0) {
				return c1.name;
			}

		}
	}
}
