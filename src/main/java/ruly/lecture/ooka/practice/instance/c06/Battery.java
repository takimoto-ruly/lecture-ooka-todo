package ruly.lecture.ooka.practice.instance.c06;

/**
 * バッテリーの状態を管理するクラス。
 * <p>
 * 【仕様】
 * </p>
 * <ul>
 * <li>現在の残量(level: int)をフィールドとして持つこと。</li>
 * <li>コンストラクタで初期残量を設定すること。</li>
 * <li>consume(int amount): 指定された量だけ残量を減らす。ただし、0未満にはならないように制御すること。</li>
 * <li>getLevel(): 現在の残量を返すこと。</li>
 * </ul>
 */
public class Battery {

	private static int level;

	public Battery(int level) {
		this.level = level;
	}

	public static void consume(int amount) {
		if (level >= amount) {
			level -= amount;
		}
	}

	public int getLevel() {
		return level;
	}

	// TODO: フィールド、コンストラクタ、メソッドを実装してください
}
