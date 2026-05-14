package ruly.lecture.ooka.practice.instance.challenge.c17;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class TruckDTO {

	private double maxPayload;
	private List<ParcelDTO> loadedParcels = new ArrayList<>();

	public TruckDTO(double maxPayload, List<ParcelDTO> loadeParcels) {
		this.maxPayload = maxPayload;
		this.loadedParcels = loadeParcels;
	}

}
