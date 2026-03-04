package sec03.game;

public class BattleExam {

	public static void main(String[] args) {
		Bard bard = new Bard();
		Worrior wr = new Worrior();
		Battle bt = new Battle();
		
		System.out.println("승자 : " + bt.battle(bard, wr));
		
	}

}
