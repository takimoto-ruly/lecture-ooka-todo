package ruly.lecture.ooka.practice.instance.c08;

/**
 * 図書館の利用者をあらわすクラス。
 * <p>
 * 【仕様】
 * </p>
 * <ul>
 * <li>フィールド：会員名(name: String)と、現在借りている本のリスト(borrowedBooks:
 * List&lt;Book&gt;)を持つ。</li>
 * <li>コンストラクタ：名前を引数に取り、リストを空の状態で初期化する。</li>
 * <li>acceptBook(Book book): 図書館から貸し出された本をリストに追加する。
 * ※このメソッド自体で貸出可否の判断（上限チェック等）は行わない。</li>
 * <li>releaseBook(Book book): 指定された本をリストから削除する。</li>
 * <li>getName(), getBorrowedBooks(), getBorrowedCount():
 * 名前、保持しているリスト（またはコピー）、現在の冊数を取得する。</li>
 * </ul>
 */
public class Member {
	// TODO: List<Book> フィールドの初期化を忘れずに。
}
