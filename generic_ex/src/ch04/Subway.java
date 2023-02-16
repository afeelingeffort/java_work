package ch04;

public abstract class Subway extends Vehicle {

	public String toString() {
		return "지하철입니다.";
	}
	
	@Override
	public void doPrinting() {
		System.out.println("지하철로 출력합니다.");
	}
	
}
