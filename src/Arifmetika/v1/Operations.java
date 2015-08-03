package Arifmetika.v1;

import Arifmetika.v1.calc.Calculator;

public class Operations {
	
	private Calculator calc;
	
	public int createSummaryReport(int factor) {
		int result = calc.summa(factor, 78);
		result = calc.summa(result, factor);
		return result;
	}
	
	public void setCalc(Calculator calc) {
		this.calc = calc;
	}
}
