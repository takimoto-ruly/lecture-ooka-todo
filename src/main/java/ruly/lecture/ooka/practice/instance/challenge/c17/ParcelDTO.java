package ruly.lecture.ooka.practice.instance.challenge.c17;

import lombok.Getter;

@Getter
public class ParcelDTO {

	private double weigth;
	private String destinationCode;

	public ParcelDTO(double weigth, String destinationCode) {
		this.weigth = weigth;
		this.destinationCode = destinationCode;
	}
}
