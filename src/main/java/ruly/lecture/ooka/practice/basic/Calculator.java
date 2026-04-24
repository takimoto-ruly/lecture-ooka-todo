package ruly.lecture.ooka.practice.basic;

public class Calculator {
	/**
	 * 1からmaxまでの合計を算出する
	 */
	public int sumUp(int max) {
		int total = 0;
		for (int i = 1; i <= max; i++) {
			total += i;
		}
		return total;
	}
}
