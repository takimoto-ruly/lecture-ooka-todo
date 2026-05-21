package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

public class Car extends Vehicle {
	public int calsulatePrice(int distance) {
		return drivingRouteStrategy.getToll(distance);
	}
}