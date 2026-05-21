package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

public class HighwayRoad implements DrivingRouteStrategy {
	@Override
	public int getToll(int distance) {
		return distance * 20;
	}
}