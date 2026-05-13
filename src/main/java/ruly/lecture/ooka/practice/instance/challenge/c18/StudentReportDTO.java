package ruly.lecture.ooka.practice.instance.challenge.c18;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class StudentReportDTO {

	private String studentId;
	private List<ExamScoreDTO> scores = new ArrayList<>();

	public StudentReportDTO(String studentId, List<ExamScoreDTO> scores) {
		this.studentId = studentId;
		this.scores = scores;
	}
}
