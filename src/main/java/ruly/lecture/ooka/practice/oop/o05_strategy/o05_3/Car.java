package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

public class Car extends Vehicle {
	public Car(String name, DrivingRouteStrategy drivingRouteStrategy) {
		super(name, drivingRouteStrategy);
	}

	@Override
	public int calculatePrice(int distance) {
		return drivingRouteStrategy.getToll(distance);
	}
}