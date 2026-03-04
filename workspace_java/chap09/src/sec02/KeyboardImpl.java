package sec02;

public class KeyboardImpl implements Keyboard {

	@Override
	public String press(int KeyCode) {
		
		if(KeyCode == 13) {
			return "Enter";
		}
		return "뭔가 눌림";
	}

}
