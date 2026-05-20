package ruly.lecture.ooka.practice.oop.o04_template_method.c04_5;

abstract class Report {
	public final String generateReport() {
		return headerText() + "\n" + mainText() + "\n" + footerText();
	}

	protected abstract String headerText();

	protected abstract String footerText();

	protected String mainText() {
		return "--- 2026年度 中間報告 ---";
	}
}
