package ruly.lecture.ooka.practice.instance.hige_level.c15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FireAlarmSystemTest {
	private final FireAlarmSystem system = new FireAlarmSystem();

	@ParameterizedTest
	@DisplayName("境界値：バッテリ残量による強制発報判定")
	@CsvSource({
			"10, 20, true", // バッテリ10（境界値：強制発報）
			"11, 20, false", // バッテリ11（境界値：通常モードへ）
			"5, 20, true" // バッテリ5（同値クラス：異常）
	})
	void testShouldRing_BatteryBoundary(int batteryLevel, int temp, boolean expected) {
		AlarmHub hub = new AlarmHub(new HeatSensor(temp), new BatteryUnit(batteryLevel));
		assertEquals(expected, system.shouldRing(hub));
	}

	@ParameterizedTest
	@DisplayName("境界値：温度による発報判定（バッテリ十分な場合）")
	@CsvSource({
			"100, 59, false", // 59度（境界値-1）
			"100, 60, true", // 60度（境界値）
			"100, 61, true" // 61度（同値クラス）
	})
	void testShouldRing_TempBoundary(int batteryLevel, int temp, boolean expected) {
		AlarmHub hub = new AlarmHub(new HeatSensor(temp), new BatteryUnit(batteryLevel));
		assertEquals(expected, system.shouldRing(hub));
	}

	@Test
	@DisplayName("異常系：各階層のnullチェック")
	void testShouldRing_NullCheck() {
		assertFalse(system.shouldRing(null), "hubがnull");
		assertFalse(system.shouldRing(new AlarmHub(null, new BatteryUnit(100))), "sensorがnull");
		assertFalse(system.shouldRing(new AlarmHub(new HeatSensor(20), null)), "batteryがnull");
	}
}
