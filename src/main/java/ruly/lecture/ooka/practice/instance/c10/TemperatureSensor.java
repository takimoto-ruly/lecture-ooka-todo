package ruly.lecture.ooka.practice.instance.c10;

/**
 * 室温センサーのデータを保持するデータクラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>フィールド1: double currentTemp (現在の室温)</li>
 * <li>コンストラクタ: フィールドを初期化するコンストラクタを定義すること</li>
 * </ul>
 */
public class TemperatureSensor {
	private double currentTemp;

	public TemperatureSensor(double currentTemp) {
		this.currentTemp = currentTemp;
	}

	public double getCurrentTemp() {
		return this.currentTemp;
	}
}
