package ruly.lecture.ooka.practice.instance.challenge.c18;

import lombok.Getter;

@Getter
public class ExamScoreDTO {

	private String subjectName;
	private int score;

	public ExamScoreDTO(String subjectName, int score) {
		this.subjectName = subjectName;
		this.score = score;
	}
}
