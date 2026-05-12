package ruly.lecture.ooka.practice.instance.challenge.c17;

public class DeliveryValidator {

	public boolean canAddParcel(TruckDTO truck, ParcelDTO newParcel, RouteRestrictionDTO route) {

		if (truck == null || newParcel == null || route == null || truck.loadeParcels == null) {
			return false;
		}

		for (ParcelDTO p : truck.getLoadeParcels()) {
			double totalWhigth = 0;
			totalWhigth += p.getWeigth();
			if (totalWhigth + newParcel.getWeigth() > truck.getMaxPayload()) {
				return false;
			}

			if (!newParcel.getDestinationCode().startsWith(route.getAreaCode())) {
				return false;
			}

			if (newParcel.getWeigth() > 500.0) {
				if (route.isHeavyVehicleAllowed()) {
					return false;
				}
			}
		}

		return true;
	}
}
