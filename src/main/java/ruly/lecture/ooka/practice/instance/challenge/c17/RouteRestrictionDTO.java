package ruly.lecture.ooka.practice.instance.challenge.c17;

import lombok.Getter;

@Getter
public class RouteRestrictionDTO {

	private String areaCode;
	private boolean isHeavyVehicleAllowed;

	public RouteRestrictionDTO(String areaCode, boolean isHeavyVehicleAllowed) {
		this.areaCode = areaCode;
		this.isHeavyVehicleAllowed = isHeavyVehicleAllowed;
	}
}
