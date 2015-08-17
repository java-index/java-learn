package Arifmetika;

public class Arifmetika {

	public static int summa(int[] numbers) {
		System.out.println("Arifmetika summa");
		int summa = 0;
		for (int i : numbers) {
			summa += i;
		}
		return summa;
	}

	public static int multiply(int number, int multiplier) {
		System.out.println("Arifmetika multiplay");
		int result = 0;
		for (int i = 0; i < multiplier; i++) {
			result *= multiplier;
		}
		return result;
	}
}
