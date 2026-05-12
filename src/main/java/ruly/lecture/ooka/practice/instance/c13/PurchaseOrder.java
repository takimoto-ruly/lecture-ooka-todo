package ruly.lecture.ooka.practice.instance.c13;

import lombok.Getter;

/**
 * 注文内容を保持するクラスです。<br>
 * フィールド: int orderQuantity<br>
 * コンストラクタ: 全フィールドを初期化
 */
@Getter
public class PurchaseOrder {

	private int orderQuantity;

	public PurchaseOrder(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

}
