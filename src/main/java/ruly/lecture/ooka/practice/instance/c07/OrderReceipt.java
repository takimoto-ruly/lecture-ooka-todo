package ruly.lecture.ooka.practice.instance.c07;

import java.util.ArrayList;
import java.util.List;

/**
 * 複数の明細をまとめ、伝票全体の計算を行うクラス。
 * <p>
 * 【仕様】
 * </p>
 * <ul>
 * <li>OrderDetail インスタンスを複数保持するために List コレクションを使用すること。</li>
 * <li>addDetail(Product p, int q): 新しい OrderDetail インスタンスを生成し、リストに追加すること。</li>
 * <li>calculateTotal(): リスト内の全明細の小計を合算し、税抜きの合計金額を返すこと。</li>
 * <li>getTaxAmount(): 合計金額に対する消費税(10%)を算出して返すこと（小数点以下切り捨て）。</li>
 * </ul>
 */
public class OrderReceipt {
	List<OrderDetail> order = new ArrayList<>();
	private int totalAmount;
	private int taxAmount;

	public void addDetail(Product p, int q) {
		order.add(new OrderDetail(p, q));
	}

	public int calculateTotal() {
		for (OrderDetail o : order) {
			this.totalAmount += o.getSubtotal();
		}
		return this.totalAmount;
	}

	public int getTaxAmount() {
		this.taxAmount = totalAmount *= 0.1;
		return this.taxAmount;
	}
}
