package ruly.lecture.ooka.practice.instance.c10;

/**
 * スマートホームの自動制御を行うクラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>メソッド名: needsCooling</li>
 * <li>戻り値: boolean</li>
 * <li>引数: TemperatureSensor sensor, AirConditioner ac</li>
 * <li>判定ロジック:
 * <ul>
 * <li>引数が null の場合は false を返す。</li>
 * <li>エアコンの電源(isPowerOn)が入っていること。</li>
 * <li>現在の温度(currentTemp)が設定温度(settingTemp)より 2.0度以上高いこと。</li>
 * </ul>
 * </li>
 * </ul>
 */
public class HomeAutomation {

	public boolean needsCooling(TemperatureSensor sensor, AirConditioner ac) {
		if (sensor == null || ac == null) {
			return false;
		}

		if (ac.isPowerOn()) {
			double difference = sensor.getCurrentTemp() - ac.getSettingTemp();
			if (difference >= 2.0) {
				return true;
			}
		}

		return false;
	}
}
