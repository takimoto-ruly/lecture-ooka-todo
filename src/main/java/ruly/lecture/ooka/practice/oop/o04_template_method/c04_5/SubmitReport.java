package ruly.lecture.ooka.practice.oop.o04_template_method.c04_5;

public class SubmitReport extends Report {
	@Override
	protected String headerText() {
		return "【株式会社〇〇 御中】";
	}

	@Override
	protected String footerText() {
		return "ご査収のほどよろしくお願い申し上げます。";
	}
}
