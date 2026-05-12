package ruly.lecture.ooka.practice.instance.hige_level.c16;

import lombok.Getter;

@Getter
public class StudentDTO {

	private int grade;
	private boolean hasPaidTuition;

	public StudentDTO(int grade, boolean hasPaidTuition) {
		this.grade = grade;
		this.hasPaidTuition = hasPaidTuition;
	}

}
