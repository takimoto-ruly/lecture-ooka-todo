package ruly.lecture.ooka.practice.oop.o04_template_method.c04_3;

public class CheeseBurger extends Hamburger {
	@Override
	protected String topping() {
		return "具材を乗せます";
	}

	@Override
	protected String applySauce() {
		return "ソースをかけます";
	}

	@Override
	protected boolean isToppingRequired() {
		return true;
	}
}
