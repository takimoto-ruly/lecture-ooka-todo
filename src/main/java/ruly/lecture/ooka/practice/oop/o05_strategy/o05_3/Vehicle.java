package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

import lombok.Setter;

@Setter
public class Vehicle {
	private String number;
	protected DrivingRouteStrategy drivingRouteStrategy;
}