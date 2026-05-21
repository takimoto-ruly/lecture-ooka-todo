package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

public class LargeCar extends Vehicle {
	public int calculetePrice(int distance) {
		return (int) (drivingRouteStrategy.getToll(distance) * 1.5);
	}
}