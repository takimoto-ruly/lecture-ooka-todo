package ruly.lecture.ooka.practice.instance.challenge.c18;

import lombok.Getter;

@Getter
public class SchoolYearSettingsDTO {

	private int passingscore;
	private int maxFailedAllowed;

	public SchoolYearSettingsDTO(int passingscore, int maxFailedAllowed) {
		this.passingscore = passingscore;
		this.maxFailedAllowed = maxFailedAllowed;
	}
}
