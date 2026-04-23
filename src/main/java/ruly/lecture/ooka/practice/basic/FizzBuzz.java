package ruly.lecture.ooka.practice.basic;

public class FizzBuzz {
	public String convert(int n) {

		if (n % 15 == 0) {
			return "FizzBuzz";
		} else if (n % 3 == 0) {
			return "Fizz";
		} else if (n % 5 == 0) {
			return "Buzz";
		}
		// ここを実装してください
		String s = String.valueOf(n);
		return s;
	}
}
