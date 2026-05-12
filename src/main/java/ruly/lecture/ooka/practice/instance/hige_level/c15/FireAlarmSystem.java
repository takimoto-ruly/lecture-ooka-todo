package ruly.lecture.ooka.practice.instance.hige_level.c15;

/**
 * 火災警報の発報判定を行うクラスです。
 * 
 * <p>
 * 【利用クラス（DTO）の設計仕様】
 * </p>
 * <ul>
 * <li>HeatSensor: int temperature</li>
 * <li>BatteryUnit: int level</li>
 * <li>AlarmHub: HeatSensor sensor, BatteryUnit battery</li>
 * </ul>
 * 
 * <p>
 * 【判定ロジック仕様】
 * </p>
 * <ul>
 * <li>引数の hub が null、または hub 内の sensor, battery が null の場合は false を返す。</li>
 * <li>バッテリ残量(level)が 10 以下の場合は、安全のため温度に関わらず警報を鳴らす(true)。</li>
 * <li>バッテリが十分(11以上)な場合、センサー温度(temperature)が 60度以上 であれば警報を鳴らす(true)。</li>
 * <li>それ以外は警報を鳴らさない(false)。</li>
 * </ul>
 */
public class FireAlarmSystem {

	public boolean shouldRing(AlarmHub hub) {
		if (hub == null || hub.getSensor() == null || hub.battery == null) {
			return false;
		}

		if (hub.getBattery().getLevel() <= 10) {
			return true;
		}

		if (hub.getSensor().getTemperatrue() >= 60) {
			return true;
		}

		return false;
	}

}
