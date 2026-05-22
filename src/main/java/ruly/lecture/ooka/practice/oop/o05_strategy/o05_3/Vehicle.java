package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public abstract class Vehicle {
	private String number;

	@Setter
	protected DrivingRouteStrategy drivingRouteStrategy;

	public abstract int calculatePrice(int distance);
}