package ruly.lecture.ooka.practice.oop.o02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題2: 図形クラス多態性の網羅テスト")
class ShapePolymorphismTest {

	@Test
	@DisplayName("各クラスを単体で動かした際、それぞれ固有の文字列が返ること")
	void testIndividualBehavior() {
		Shape genericShape = new Shape();
		Circle circle = new Circle();
		Square square = new Square();

		assertEquals("図形を描画します", genericShape.draw());
		assertEquals("円を描画します", circle.draw(), "Circleクラスで正しくオーバーライドされている必要があります");
		assertEquals("四角を描画します", square.draw(), "Squareクラスで正しくオーバーライドされている必要があります");
	}

	@Test
	@DisplayName("【多態性の検証】親クラス型の変数に子クラスを代入しても、子クラスの振る舞いが呼び出されること")
	void testPolymorphicBehavior() {
		// 親の型（Shape）の変数に、子のインスタンス（Circle）を代入
		Shape polymorphicShape = new Circle();

		assertEquals("円を描画します", polymorphicShape.draw(),
				"変数の型がShapeであっても、インスタンスの実体がCircleであればCircleのメソッドが呼ばれなければなりません");
	}
}
