package ruly.lecture.ooka.practice.instance.c06;

/**
 * バッテリーを利用して動作するスマートフォンのクラス。
 * <p>
 * 【仕様】
 * </p>
 * <ul>
 * <li>「モデル名(modelName)」と「使用するバッテリー(Battery型)」を保持すること。</li>
 * <li>コンストラクタでモデル名とBatteryインスタンスを受け取り、初期化すること。</li>
 * <li>useApp(String appName): アプリを使用する。 実行時にバッテリーを「5」消費させること。 ただし、バッテリー残量が 0
 * の場合は「電池がありません」と表示し、消費させないこと。</li>
 * </ul>
 */
public class Smartphone {
	private String modelName;
	Battery battery;

	public Smartphone(String modelName, Battery battery) {
		this.modelName = modelName;
		this.battery = battery;
	}

	public void useApp(String appName) {
		if (battery.getLevel() == 0) {
			System.out.println("電池がありません");
		} else {
			Battery.consume(5);
		}
	}
	// TODO: フィールド、コンストラクタ、メソッドを実装してください
}