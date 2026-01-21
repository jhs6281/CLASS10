package sec05_this;

public class Car {
	String model;
	Car(){};
	
	void setModel(String model) {
//		String model;
		this.model = model;
	}
	
	Car(String model){
		this.model = model;
	}
}



