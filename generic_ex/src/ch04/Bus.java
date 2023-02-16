package ch04;

public abstract class Bus extends Vehicle {

	public String toString() {
		return "버스입니다.";
	}
	
	@Override
	public void doPrinting() {
		System.out.println("버스로 출력합니다.");
	}

}
