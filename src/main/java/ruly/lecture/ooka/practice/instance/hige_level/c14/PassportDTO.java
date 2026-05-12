package ruly.lecture.ooka.practice.instance.hige_level.c14;

import lombok.Getter;

@Getter
public class PassportDTO {

	private String passportNumber;
	private boolean isExpired;

	public PassportDTO(String passportNumber, boolean isExpired) {
		this.passportNumber = passportNumber;
		this.isExpired = isExpired;
	}
}
