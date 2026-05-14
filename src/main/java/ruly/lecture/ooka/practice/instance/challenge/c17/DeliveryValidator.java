package ruly.lecture.ooka.practice.instance.challenge.c17;

public class DeliveryValidator {

	public boolean canAddParcel(TruckDTO truck, ParcelDTO newParcel, RouteRestrictionDTO route) {

		if (truck == null || newParcel == null || route == null || truck.getLoadedParcels() == null) {
			return false;
		}

		double totalWeight = truck.getLoadedParcels().stream()
				.mapToDouble(ParcelDTO::getWeight)
				.sum();

		if (totalWeight + newParcel.getWeight() > truck.getMaxPayload()) {
			return false;
		}

		if (!newParcel.getDestinationCode().startsWith(route.getAreaCode())) {
			return false;
		}

		if (newParcel.getWeight() > 500.0) {
			if (!route.isHeavyVehicleAllowed()) {
				return false;
			}
		}

		return true;
	}
}
