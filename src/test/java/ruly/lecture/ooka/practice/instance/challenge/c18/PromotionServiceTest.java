package ruly.lecture.ooka.practice.instance.challenge.c18;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PromotionServiceTest {
	private final PromotionService service = new PromotionService();

	@Test
	@DisplayName("正常系：合格基準を満たしている")
	void testIsEligible_Success() {
		SchoolYearSettingsDTO settings = new SchoolYearSettingsDTO(60, 1); // 1科目まで不合格OK
		StudentReportDTO report = new StudentReportDTO("S001", Arrays.asList(
				new ExamScoreDTO("Math", 80),
				new ExamScoreDTO("English", 59) // 1科目だけ不合格
		));
		assertTrue(service.isEligibleForPromotion(report, settings));
	}

	@Test
	@DisplayName("境界値：許容不合格数ぴったり")
	void testIsEligible_FailedCountBoundary() {
		SchoolYearSettingsDTO settings = new SchoolYearSettingsDTO(60, 2);
		List<ExamScoreDTO> scores = Arrays.asList(
				new ExamScoreDTO("A", 10), new ExamScoreDTO("B", 10), new ExamScoreDTO("C", 80));
		StudentReportDTO report = new StudentReportDTO("S001", scores);

		assertTrue(service.isEligibleForPromotion(report, settings), "不合格2科目まではOK");

		SchoolYearSettingsDTO newSettings = new SchoolYearSettingsDTO(60, 1);
		assertFalse(service.isEligibleForPromotion(report, newSettings), "不合格2科目はNG（許容1）");
	}

	@Test
	@DisplayName("異常系：試験未受験（空リスト）")
	void testIsEligible_EmptyScores() {
		SchoolYearSettingsDTO settings = new SchoolYearSettingsDTO(60, 5);
		StudentReportDTO report = new StudentReportDTO("S001", new ArrayList<>());
		assertFalse(service.isEligibleForPromotion(report, settings));
	}
}
