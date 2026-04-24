package ruly.lecture.ooka.practice.basic;

public class ArrayAnalyzer {
	/**
	 * 与えられた整数の配列の中から、最も大きな数値を返します。
	 * <p>
	 * 【仕様】
	 * </p>
	 * <ul>
	 * <li>配列の要素を順番に確認し、最大値を保持して返します。</li>
	 * <li>配列が空（要素数0）の場合は 0 を返します。</li>
	 * </ul>
	 * * @param numbers 数値の配列
	 * 
	 * @return 配列内の最大値
	 */
	public int findMax(int[] numbers) {
		if (numbers.length == 0) {
			return 0;
		}

		int max = numbers[0];
		for (int number : numbers) {
			if (max < number) {
				max = number;
			}
		}
		return max;
	}

}
