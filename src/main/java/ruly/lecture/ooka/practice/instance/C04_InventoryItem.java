package ruly.lecture.ooka.practice.instance;

/**
 * 商品在庫を管理するクラス。
 * <p>
 * 【商品識別情報の定義】
 * </p>
 * <ul>
 * <li>「商品ID(String)」と「商品名(String)」をフィールドとして定義すること。</li>
 * <li>これら2つの情報は、インスタンス生成時にコンストラクタで初期化し、その後は変更できないようにすること。</li>
 * <li>外部から値を取得するための getter メソッドを提供すること。</li>
 * </ul>
 * *
 * <p>
 * 【在庫状態の管理】
 * </p>
 * <ul>
 * <li>「在庫数(int)」を保持するフィールドを定義すること。外部から直接数値を書き換えることは禁止とする。</li>
 * <li>現在の在庫数を取得するための getter メソッドを提供すること。</li>
 * </ul>
 * *
 * <p>
 * 【在庫操作ロジック】
 * </p>
 * <ul>
 * <li>在庫を増やす `restock(int amount)` メソッドを実装すること。 引数が 0
 * 以下の場合は、在庫を更新せず処理を終了すること。</li>
 * <li>在庫を減らす `ship(int amount)` メソッドを実装すること。 引数が 0
 * 以下、または現在の在庫数を超える出荷指示があった場合は、false を返し在庫を更新しないこと。 正常に出荷できた場合は在庫数を減らし、true
 * を返すこと。</li>
 * </ul>
 * *
 * <p>
 * 【システム共通の統計情報】
 * </p>
 * <ul>
 * <li>これまでにこのシステム（クラス）を通じて出荷された「商品の総個数」を保持するフィールドを定義すること。</li>
 * <li>このフィールドは全インスタンスで共有し、出荷に成功した数（shipメソッドの引数）を累計していくこと。</li>
 * <li>現在の総出荷数を返すメソッドを定義すること。このメソッドはクラス名から直接呼び出し可能であること。</li>
 * </ul>
 */
public class C04_InventoryItem {

	private String itemId;
	private String itemName;
	private int quantity = 0;
	private static int totalShippedCount;

	public C04_InventoryItem(String id, String name) {
		this.itemId = id;
		this.itemName = name;
	}

	public String getItemId() {
		return this.itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public static int getTotalShippedCount() {
		return totalShippedCount;
	}

	public void restock(int amount) {
		if (amount > 0) {
			this.quantity += amount;
		}
	}

	public boolean ship(int amount) {
		if (amount < 0 || this.quantity < amount) {
			return false;
		} else {
			quantity -= amount;
			totalShippedCount += amount;
			return true;
		}
	}

	// 全てのフィールド、コンストラクタ、メソッドを仕様に基づいてゼロから実装してください
}
