package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

public class GeneralRoad implements DrivingRouteStrategy {
	@Override
	public int getToll(int distance) {
		return 0;
	}
}