package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_13;

public class AttributeSynergy implements EnvironmentStrategy {
	@Override
	public double getSynegyCorrector(String attribute, String weather) {
		if (attribute.equals("FIRE") || weather.equals("SUNNY")) {
			return 2.0;
		}

		if (attribute.equals("ICE") || weather.equals("RAIN")) {
			return 1.5;
		}

		return 1.0;
	}
}