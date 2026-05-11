package ruly.lecture.ooka.practice.instance.c13;

/**
 * 商品情報を保持するクラスです。<br>
 * フィールド: String name, int stockQuantity<br>
 * コンストラクタ: 全フィールドを初期化
 */
public class Product {

	private String name;
	private int stockQuantity;

	public Product(String name, int stockQuantity) {
		this.name = name;
		this.stockQuantity = stockQuantity;
	}

	public int getStoskQuantity() {
		return this.stockQuantity;
	}
}
