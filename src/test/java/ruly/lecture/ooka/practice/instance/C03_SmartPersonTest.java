package ruly.lecture.ooka.practice.instance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class C03_SmartPersonTest {
	@Test
	@DisplayName("カプセル化（負の年齢が入力された場合、強制的に0として保持されること）")
	void testAgeEncapsulation() {
		// テストごとにインスタンスを生成し、他への影響を遮断
		C03_SmartPerson p = new C03_SmartPerson("テスト太郎", 20, "ポチ");

		p.setAge(-1);
		assertEquals(0, p.getAge(), "負の値はバリデーションで0に変換される必要があります");

		p.setAge(18);
		assertEquals(18, p.getAge(), "正の値はそのまま保持される必要があります");
	}

	@Test
	@DisplayName("コンストラクタによる全フィールドの初期化（ペット名含む）")
	void testConstructorInitialization() {
		String expectedName = "佐藤";
		int expectedAge = 30;
		String expectedPet = "タマ";

		C03_SmartPerson p = new C03_SmartPerson(expectedName, expectedAge, expectedPet);

		assertAll("フィールドが正しく初期化されていること",
				() -> assertEquals(expectedName, p.getName()),
				() -> assertEquals(expectedAge, p.getAge()),
				() -> assertEquals(expectedPet, p.getPetName()));
	}

	@Test
	@DisplayName("staticによるインスタンス生成総数のカウントアップ（共有状態の検証）")
	void testTotalCountSharedState() {
		// 1. テスト開始時点のカウントを基準点とする（重要）
		int baseCount = C03_SmartPerson.getTotalCount();

		// 2. このテスト内で2つ生成
		new C03_SmartPerson("A", 1, "P1");
		new C03_SmartPerson("B", 2, "P2");

		// 3. 基準点から正確に2増えているかを検証
		int currentCount = C03_SmartPerson.getTotalCount();
		assertEquals(baseCount + 2, currentCount,
				"生成したインスタンスの数だけstaticなカウンタが増加していなければなりません");
	}
}
