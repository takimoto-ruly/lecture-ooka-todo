package ruly.lecture.ooka.practice.oop.o04_template_method.c04_1;

abstract class Robot {
	public final void startBehavior() {
		System.out.println("ロボットの電源を入れます。");
		greet();
		System.out.println("ロボットの電源を切ります。");
	}

	protected abstract void greet();
}
