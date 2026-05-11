package ruly.lecture.ooka.practice.instance.c13;

/**
 * 注文内容を保持するクラスです。<br>
 * フィールド: int orderQuantity<br>
 * コンストラクタ: 全フィールドを初期化
 */
public class PurchaseOrder {
	private int orderQuantity;

	public PurchaseOrder(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getOrderQuantity() {
		return this.orderQuantity;
	}
}
