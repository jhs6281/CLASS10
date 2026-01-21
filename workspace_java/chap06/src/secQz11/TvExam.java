package secQz11;

public class TvExam {

	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.on();
		tv.channel(10);
		tv.volume("-");
		tv.volume("-");
		tv.volume("-");
		tv.volume("-");
		tv.volume("-");
		tv.volume("+");
		tv.volume("+");
		tv.volume("+");
		tv.volume("+");
		tv.volume("+");
		tv.volume("-");
		tv.volume("-");
		tv.off();
	}

}
