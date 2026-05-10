package ruly.lecture.ooka.practice.instance.c11;

/**
 * 決済処理を判定するクラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>メソッド名: canPayWithPoints</li>
 * <li>戻り値: boolean</li>
 * <li>引数: Order order, UserCard card</li>
 * <li>判定ロジック:
 * <ul>
 * <li>引数が null の場合は false を返す。</li>
 * <li>カードが期限切れ(isExpired)でないこと。</li>
 * <li>保有ポイント(pointBalance)が合計金額(totalAmount)以上であること。</li>
 * </ul>
 * </li>
 * </ul>
 */
public class PaymentProcessor {

	public boolean canPayWithPoints(Order order, UserCard card) {
		if (order == null || card == null || card.getIsExpired()) {
			return false;
		}
		if (card.getPointBalance() >= order.getTotalAmount()) {
			return true;
		}

		return false;
	}
}
