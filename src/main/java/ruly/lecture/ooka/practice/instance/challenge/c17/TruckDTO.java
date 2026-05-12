package ruly.lecture.ooka.practice.instance.challenge.c17;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class TruckDTO {

	private double maxPayload;
	List<ParcelDTO> loadeParcels = new ArrayList<>();

	public TruckDTO(double maxPayload, List<ParcelDTO> loadeParcels) {
		this.maxPayload = maxPayload;
		this.loadeParcels = loadeParcels;
	}
	
}
