package ruly.lecture.ooka.practice.instance.c13;

/**
 * 在庫判定を行うクラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>メソッド名: canAllocate</li>
 * <li>戻り値: boolean</li>
 * <li>引数: Product product, PurchaseOrder order</li>
 * <li>判定ロジック:
 * <ul>
 * <li>引数が null の場合は false。</li>
 * <li>注文数が 0 以下の場合は常に false。</li>
 * <li>商品の在庫数が注文数以上であれば true。</li>
 * </ul>
 * </li>
 * </ul>
 */
public class InventoryManager {

	public boolean canAllocate(Product product, PurchaseOrder order) {
		if (product == null || order == null || order.getOrderQuantity() <= 0) {
			return false;
		}

		if (product.getStockQuantity() >= order.getOrderQuantity()) {
			return true;
		}

		return false;
	}

}
