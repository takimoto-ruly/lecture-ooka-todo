package ruly.lecture.ooka.practice.instance.hige_level.c16;

import lombok.Getter;

@Getter
public class EnrollmentHistory {

	private int completedCourses;

	public EnrollmentHistory(int completedCourses) {
		this.completedCourses = completedCourses;
	}
}
