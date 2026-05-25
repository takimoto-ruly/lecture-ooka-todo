package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_06;

public class CoolLuggage extends Luggage {
	public CoolLuggage(String trackingId, double weight) {
		super(trackingId, weight);
	}

	@Override
	public int getDeliveryFee(DeliveryStrategy deliveryStrategy) {
		return super.getDeliveryFee(deliveryStrategy) + 1200;
	}
}