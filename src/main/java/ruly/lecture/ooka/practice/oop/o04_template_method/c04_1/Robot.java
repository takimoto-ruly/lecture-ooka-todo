package ruly.lecture.ooka.practice.oop.o04_template_method.c04_1;

abstract class Robot {
	// 全体の流れを制御するメソッド（勝手に書き換えられないよう final をつける）
	public final void startBehavior() {
		System.out.println("ロボットの電源を入れます。");

		// ここで子クラスが実装した挨拶を呼び出す
		/* ①ここに適切なメソッド呼び出しを記述 */ ;

		System.out.println("ロボットの電源を切ります。");
	}

	// 子クラスに実装を強制する抽象メソッド
	protected abstract void greet();
}
