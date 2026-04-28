package ruly.lecture.ooka.practice.instance.c08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LibrarySystemTest {

	private Library library;
	private Member alice;
	private Member bob;
	private Book javaBook;
	private Book sqlBook;

	@BeforeEach
	void setUp() {
		library = new Library();
		alice = new Member("アリス");
		bob = new Member("ボブ");
		javaBook = new Book("Java入門");
		sqlBook = new Book("SQL入門");

		// 図書館に本を登録しておく
		library.addBook(javaBook);
		library.addBook(sqlBook);
	}

	@Nested
	@DisplayName("貸出処理(processLending)の検証")
	class LendingProcessTest {

		@Test
		@DisplayName("正常系：在庫があり上限以下の場合は貸出に成功すること")
		void testLendingSuccess() {
			boolean result = library.processLending(alice, javaBook);

			assertTrue(result);
			assertTrue(javaBook.isBorrowed(), "本の状態が貸出中になること");
			assertEquals(1, alice.getBorrowedCount(), "利用者の保持数が増えること");
			assertTrue(alice.getBorrowedBooks().contains(javaBook), "利用者のリストに本が含まれること");
		}

		@Test
		@DisplayName("異常系：貸出中の本は他の人に貸し出せないこと")
		void testLendingConflict() {
			library.processLending(alice, javaBook);

			// アリスが借りている本をボブが借りようとする
			boolean result = library.processLending(bob, javaBook);

			assertFalse(result, "貸出中の本は貸出失敗となること");
			assertEquals(0, bob.getBorrowedCount());
		}

		@Test
		@DisplayName("異常系：図書館に登録されていない本は貸し出せないこと")
		void testUnregisteredBookLending() {
			Book unregistered = new Book("未登録本");
			boolean result = library.processLending(alice, unregistered);

			assertFalse(result, "蔵書リストにない本は処理できないこと");
		}

		@Test
		@DisplayName("境界値：1人5冊まで。6冊目は拒否されること")
		void testMemberLendingLimit() {
			// 5冊登録して貸し出す
			for (int i = 0; i < 5; i++) {
				Book b = new Book("Collection " + i);
				library.addBook(b);
				library.processLending(alice, b);
			}
			assertEquals(5, alice.getBorrowedCount());

			// 6冊目を借りようとする
			Book book6 = new Book("Overflow Book");
			library.addBook(book6);
			boolean result = library.processLending(alice, book6);

			assertFalse(result, "上限を超えた貸出は拒否されること");
			assertFalse(book6.isBorrowed(), "拒否された本の状態は変化しないこと");
		}
	}

	@Nested
	@DisplayName("返却処理(processReturn)の検証")
	class ReturnProcessTest {

		@Test
		@DisplayName("正常系：借りている本を正しく返却でき、蔵書が再利用可能になること")
		void testReturnSuccess() {
			library.processLending(alice, javaBook);

			library.processReturn(alice, javaBook);

			assertFalse(javaBook.isBorrowed(), "本の状態が未貸出に戻ること");
			assertEquals(0, alice.getBorrowedCount(), "利用者の保持数が減ること");

			// 再度貸出可能か確認
			assertTrue(library.processLending(bob, javaBook), "返却後は他の人が借りられること");
		}

		@Test
		@DisplayName("異常系：他人が借りている本を返却しようとしても無視されること")
		void testReturnInvalidOwnership() {
			library.processLending(alice, javaBook);

			// アリスが借りている本をボブが返そうとする
			library.processReturn(bob, javaBook);

			assertTrue(javaBook.isBorrowed(), "所有者でない返却操作で本の状態が変わってはいけない");
			assertEquals(1, alice.getBorrowedCount(), "本来の所有者のリストから消えてはいけない");
		}
	}
}