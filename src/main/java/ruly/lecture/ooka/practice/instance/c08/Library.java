package ruly.lecture.ooka.practice.instance.c08;

/**
 * 蔵書管理と、利用者への貸出・返却の仲介を行うクラス。
 * <p>
 * 【仕様】
 * </p>
 * <ul>
 * <li>フィールド：図書館が保有する全蔵書リスト(allBooks: List&lt;Book&gt;)を持つ。</li>
 * <li>addBook(Book book): 図書館に新しい本を1冊登録する。</li>
 * <li>processLending(Member member, Book book): 貸出のメインロジック。
 * <ol>
 * <li>指定された本が蔵書リストに存在し、かつ貸出中でないことを確認する。</li>
 * <li>利用者が既に5冊借りていないかを確認する。</li>
 * <li>上記をすべて満たす場合のみ、本の借入手続き(borrowBook)を行い、 利用者に本を渡す(acceptBook)処理を実行し、true
 * を返す。</li>
 * <li>条件を満たさない場合は一連の処理を行わず false を返す。</li>
 * </ol>
 * </li>
 * <li>processReturn(Member member, Book book): 返却のメインロジック。
 * 利用者がその本を保持していることを確認し、本の返却手続き(returnBook)と 利用者の保持解除(releaseBook)を行う。</li>
 * </ul>
 */
public class Library {

}
