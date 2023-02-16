package ch04;

public class MainTest {

	// main 함수
	public static void main(String[] args) {

		GenericPrinter<Powder> gp1 = new GenericPrinter<>();
		GenericPrinter<Plastic> gp2 = new GenericPrinter<>();
//		GenericPrinter<Water> gp3 = new GenericPrinter<>();
		
		
		//재료 넣기
		gp1.setMaterial(new Powder());
		gp2.setMaterial(new Plastic());
		
		//문제
		//제네릭을 활용한 프로그램을 작성하고 테스트 해주세요
		GenericPrinter2<Bus> gp3 = new GenericPrinter2<>();
		GenericPrinter2<Subway> gp4 = new GenericPrinter2<>();
		
//		gp3.setVehicle(new Bus());
//		gp4.setVehicle(new Subway());
		
	} // end of main

} // end of class
