package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_13;

public class WeatherModifierStrategy implements EnvironmentModifierStrategy {

	@Override
	public double getMultiplier(String attribute, String weather) {
		if (attribute.equals("FIRE") || weather.equals("SUNNY")) {
			return 2.0;
		}

		if (attribute.equals("ICE") || weather.equals("RAIN")) {
			return 1.5;
		}

		return 1.0;
	}
}