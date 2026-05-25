package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_06;

public class IslandCoolLuggage extends CoolLuggage {
	public IslandCoolLuggage(String trackingId, double weight) {
		super(trackingId, weight);
	}

	@Override
	public int getDeliveryFee(DeliveryStrategy deliveryStrategy) {
		return (int) (super.getDeliveryFee(deliveryStrategy) * 1.5);
	}
}
