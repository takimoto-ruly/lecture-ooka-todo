package ruly.lecture.ooka.practice.instance.hige_level.c16;

import lombok.Getter;

@Getter
public class CourseDTO {

	private int targetGrade;
	private boolean isAdvanced;

	public CourseDTO(int targetGrade, boolean isAdvanced) {
		this.targetGrade = targetGrade;
		this.isAdvanced = isAdvanced;
	}
}
