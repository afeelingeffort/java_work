package ch01;

import java.util.Arrays;
import java.util.Random;

public class LottoTest {

	int[] lottoNumber = new int[6];

	public int[] createLottoNumber() {
		int[] lottoNumber = new int[6];
		Random r = new Random();
		
		for (int i = 0; i < lottoNumber.length; i++) {
			int num = r.nextInt(45) + 1;
			lottoNumber[i] = num;

			for (int j = 0; j < i; j++) {
				if (lottoNumber[i] == lottoNumber[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lottoNumber);
		return lottoNumber;
	}

	public static void main(String[] args) {
		LottoTest lt = new LottoTest();
		
		int[] lottoNum = new int[6];
		lottoNum = lt.createLottoNumber();

		System.out.print("로또 번호 : ");
		
		for (int i = 0; i < lottoNum.length; i++) {
			System.out.print(lottoNum[i] + " ");
		}
	}

}
