package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_06;

public class PremiumDelivery implements DeliveryStrategy {

	@Override
	public int calculateDeliveryFee(double weight) {
		return (int) (weight * 500 + 2000);
	}
}