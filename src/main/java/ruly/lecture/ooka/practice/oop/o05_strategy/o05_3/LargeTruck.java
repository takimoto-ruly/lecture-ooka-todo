package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

public class LargeTruck extends Vehicle {
	public LargeTruck(String name, DrivingRouteStrategy drivingRouteStrategy) {
		super(name, drivingRouteStrategy);
	}

	@Override
	public int calculatePrice(int distance) {
		return (int) (drivingRouteStrategy.getToll(distance) * 1.5);
	}
}