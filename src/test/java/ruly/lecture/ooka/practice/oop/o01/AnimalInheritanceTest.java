package ruly.lecture.ooka.practice.oop.o01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題1: 動物クラス継承の網羅テスト")
class AnimalInheritanceTest {

	@Test
	@DisplayName("コンストラクタで設定した名前が、getter経由で正しく取得できること")
	void testConstructorAndGetter() {
		String testName = "ポチ";
		Dog dog = new Dog(testName);

		assertEquals(testName, dog.getName(), "Dogクラスは親から引き継いだゲッターで正しい名前を返す必要があります");
	}

	@Test
	@DisplayName("親から継承したメソッドと子固有のメソッドが例外なく実行できること")
	void testMethodExecution() {
		Dog dog = new Dog("ラッキー");

		// 標準出力のメソッド（void）がエラーを起こさず稼働するか検証
		assertDoesNotThrow(() -> dog.sleep(), "親クラスのsleepメソッドが正常に実行できること");
		assertDoesNotThrow(() -> dog.bark(), "子クラスのbarkメソッドが正常に実行できること");
	}
}