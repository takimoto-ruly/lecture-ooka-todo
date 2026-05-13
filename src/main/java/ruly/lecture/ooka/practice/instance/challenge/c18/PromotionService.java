package ruly.lecture.ooka.practice.instance.challenge.c18;

public class PromotionService {

	public boolean isEligibleForPromotion(StudentReportDTO report, SchoolYearSettingsDTO settings) {
		int failCount = 0;

		if (report == null || settings == null || report.getScores() == null) {
			return false;
		}

		if (report.getScores().isEmpty()) {
			return false;
		}

		for (ExamScoreDTO scores : report.getScores()) {
			if (scores.getScore() < settings.getPassingscore()) {
				failCount++;
			}

			if (failCount > settings.getMaxFailedAllowed()) {
				return false;
			}
		}

		return true;
	}
}
