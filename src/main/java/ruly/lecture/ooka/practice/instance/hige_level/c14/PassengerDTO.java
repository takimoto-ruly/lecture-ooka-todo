package ruly.lecture.ooka.practice.instance.hige_level.c14;

import lombok.Getter;

@Getter
public class PassengerDTO {

	private String name;
	PassportDTO passport;

	public PassengerDTO(String name, PassportDTO passport) {
		this.name = name;
		this.passport = passport;
	}
}
