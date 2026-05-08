package ruly.lecture.ooka.practice.instance.c09;

/**
 * 入室認可を行うクラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>メソッド名: canEnter</li>
 * <li>戻り値: boolean</li>
 * <li>引数: UserCard card, Room room</li>
 * <li>判定ロジック:
 * <ul>
 * <li>引数が null の場合は false。</li>
 * <li>カードが有効期限切れ(isExpired)の場合は常に false。</li>
 * <li>カードの権限レベルが部屋の必要レベル以上であれば true。</li>
 * </ul>
 * </li>
 * </ul>
 */
public class SecurityGate {
}
