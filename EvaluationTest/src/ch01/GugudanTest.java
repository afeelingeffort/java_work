package ch01;

import java.util.Scanner;

public class GugudanTest {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int start = 0;
		int end = 0;

		System.out.println("시작 값.>");
		start = scn.nextInt();
		System.out.println("종료 값.>");
		end = scn.nextInt();

		for (int i = start; i <= end; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}

	}
}
