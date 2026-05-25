package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_06;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Luggage {
	private final String trackingId;
	private final double weight;

	public int getDeliveryFee(DeliveryStrategy deliveryStrategy) {
		return deliveryStrategy.calculateDeliveryFee(this.weight);
	}
}