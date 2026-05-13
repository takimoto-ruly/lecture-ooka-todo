package ruly.lecture.ooka.practice.instance.challenge.c17;

import lombok.Getter;

@Getter
public class ParcelDTO {

	private double weight;
	private String destinationCode;

	public ParcelDTO(double weight, String destinationCode) {
		this.weight = weight;
		this.destinationCode = destinationCode;
	}
}
