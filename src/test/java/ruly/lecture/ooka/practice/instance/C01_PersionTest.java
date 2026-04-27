package ruly.lecture.ooka.practice.instance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class C01_PersionTest {
	@Test
	@DisplayName("インスタンスごとに異なる名前を保持できること")
	void testNamePersistence() {
		C01_Person p1 = new C01_Person();
		p1.name = "田中";
		C01_Person p2 = new C01_Person();
		p2.name = "佐藤";

		assertEquals("田中", p1.name);
		assertEquals("佐藤", p2.name);
	}

	@Test
	@DisplayName("introduceメソッドが正しい自己紹介文字列を返すこと")
	void testIntroduce() {
		C01_Person p = new C01_Person();
		p.name = "鈴木";
		assertEquals("私の名前は鈴木です", p.introduce());
	}
}
