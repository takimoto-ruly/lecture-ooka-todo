package ruly.lecture.ooka.practice.instance.hige_level.c15;

import lombok.Getter;

@Getter
public class AlarmHub {
	HeatSensor sensor;
	BatteryUnit battery;

	public AlarmHub(HeatSensor sensor, BatteryUnit battery) {
		this.sensor = sensor;
		this.battery = battery;
	}

}
