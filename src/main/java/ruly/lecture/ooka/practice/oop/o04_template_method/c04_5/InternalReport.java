package ruly.lecture.ooka.practice.oop.o04_template_method.c04_5;

public class InternalReport extends Report {
	@Override
	protected String headerText() {
		return "【社内親睦会】";
	}

	@Override
	protected String footerText() {
		return "以上（回覧してください）";
	}
}
