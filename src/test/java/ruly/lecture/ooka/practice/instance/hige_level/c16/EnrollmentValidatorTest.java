package ruly.lecture.ooka.practice.instance.hige_level.c16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EnrollmentValidatorTest {
	private final EnrollmentValidator validator = new EnrollmentValidator();

	@ParameterizedTest
	@DisplayName("正常系・境界値：学年と修了数の判定")
	@CsvSource({
			"2, 2, false, 0, true", // 学年一致, 初級
			"1, 2, false, 0, false", // 学年不足
			"3, 3, true,  4, false", // 上級コース・修了数不足(4)
			"3, 3, true,  5, true", // 上級コース・修了数一致(5)
	})
	void testIsEligible_Logic(int sGrade, int cGrade, boolean advanced, int completed, boolean expected) {
		StudentDTO s = new StudentDTO(sGrade, true);
		CourseDTO c = new CourseDTO(cGrade, advanced);
		EnrollmentHistory h = new EnrollmentHistory(completed);
		assertEquals(expected, validator.isEligible(s, c, h));
	}

	@Test
	@DisplayName("異常系：学費未納・null入力")
	void testIsEligible_Abnormal() {
		StudentDTO unpaid = new StudentDTO(3, false);
		CourseDTO course = new CourseDTO(1, false);
		EnrollmentHistory hist = new EnrollmentHistory(10);

		assertFalse(validator.isEligible(unpaid, course, hist), "学費未納");
		assertFalse(validator.isEligible(null, course, hist), "引数null");
	}
}
