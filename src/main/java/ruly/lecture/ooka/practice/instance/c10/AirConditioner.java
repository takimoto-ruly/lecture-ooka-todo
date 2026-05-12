package ruly.lecture.ooka.practice.instance.c10;

/**
 * エアコンの状態を保持するデータクラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>フィールド1: boolean isPowerOn (電源が入っているか)</li>
 * <li>フィールド2: double settingTemp (設定温度)</li>
 * <li>コンストラクタ: 全てのフィールドを初期化するコンストラクタを定義すること</li>
 * </ul>
 */
public class AirConditioner {
	private boolean isPowerOn;
	private double settingTemp;

	public AirConditioner(boolean isPowerOn, double settingTemp) {
		this.isPowerOn = isPowerOn;
		this.settingTemp = settingTemp;
	}

	public boolean isPowerOn() {
		return this.isPowerOn;
	}

	public double getSettingTemp() {
		return this.settingTemp;
	}

}
