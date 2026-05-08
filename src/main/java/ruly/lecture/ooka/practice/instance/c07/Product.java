package ruly.lecture.ooka.practice.instance.c07;

/**
 * 商品の基本情報を管理するクラス。
 * <p>
 * 【仕様】
 * </p>
 * <ul>
 * <li>商品名(name)と単価(price)を保持すること。</li>
 * <li>各フィールドは、コンストラクタによる初期化以降、変更できない(final)ようにすること。</li>
 * <li>外部から各フィールドの値を取得するための getter を提供すること。</li>
 * </ul>
 */
public class Product {
	private final int price;
	private final String name;

	public Product(String name, int price) {
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}
}
