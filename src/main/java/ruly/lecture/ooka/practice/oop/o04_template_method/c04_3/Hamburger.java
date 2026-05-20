package ruly.lecture.ooka.practice.oop.o04_template_method.c04_3;

abstract class Hamburger {
	public void cook() {
		System.out.println("下のバンズを用意します");
		System.out.println(topping());
		System.out.println(applySauce());
		if (isToppingRequired()) {
			System.out.println("チーズを追加します");
		}
		System.out.println("上のバンズを乗せて完成！");
	}

	protected abstract String topping();

	protected abstract String applySauce();

	protected boolean isToppingRequired() {
		return false;
	}
}
