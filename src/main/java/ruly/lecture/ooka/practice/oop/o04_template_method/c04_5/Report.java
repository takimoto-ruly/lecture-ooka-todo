package ruly.lecture.ooka.practice.oop.o04_template_method.c04_5;

abstract class Report {
	public final String generate() {
		return null;
	}

	protected abstract String header();

	protected abstract String footer();
}
