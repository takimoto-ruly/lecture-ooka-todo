package ruly.lecture.ooka.practice.basic;

public class PriceCalculator {
	/**
	 * 商品の合計金額に割引を適用した最終的な金額を計算します。
	 * <p>
	 * 【仕様】
	 * </p>
	 * <ul>
	 * <li>合計金額が 5,000円以上の場合は、500円引き を適用します。</li>
	 * <li>合計金額が 10,000円以上の場合は、1,000円引き を適用します。</li>
	 * <li>割引適用後の金額が 0円未満になることはありません。</li>
	 * </ul>
	 * * @param totalAmount 割引前の合計金額
	 * 
	 * @return 割引適用後の支払い金額
	 */
	public int calculateDiscountedPrice(int totalAmount) {
		int result = 0;
		if (totalAmount >= 10000) {
			result = totalAmount - 1000;
		} else if (totalAmount >= 5000) {
			result = totalAmount - 500;
		} else if (totalAmount < 5000) {
			return totalAmount;
		}
		// TODO: if-else文を使って、金額に応じた割引額を計算してください
		return result;
	}
}
