package ruly.lecture.ooka.practice.instance.advanced.c20.logic;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SalaryLogic {
	public int calculate(int hourlyRate, double hours, double multiplier) {
		double dailyPay = hourlyRate * hours * multiplier;

		return (int) Math.round(dailyPay);
	}
}
