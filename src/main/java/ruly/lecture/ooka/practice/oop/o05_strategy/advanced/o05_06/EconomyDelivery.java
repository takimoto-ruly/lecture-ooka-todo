package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_06;

public class EconomyDelivery implements DeliveryStrategy {

	@Override
	public int calculateDeliveryFee(double weight) {
		if (weight <= 0) {
			throw new IllegalArgumentException("重量は0を超える数を指定すべきです");
		}
		return (int) (weight * 150);
	}
}