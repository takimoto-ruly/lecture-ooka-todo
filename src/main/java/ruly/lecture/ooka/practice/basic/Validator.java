package ruly.lecture.ooka.practice.basic;

public class Validator {
	/**
	 * パスワードが以下の条件を満たしているか判定します。
	 * <p>
	 * 【仕様】
	 * </p>
	 * <ul>
	 * <li>長さが 8文字以上 であること。</li>
	 * <li>長さが 16文字以下 であること。</li>
	 * <li>最初の一文字目が 英大文字（'A'～'Z'） であること。</li>
	 * </ul>
	 * * @param password 検証する文字列
	 * 
	 * @return すべての条件を満たせば true、そうでなければ false
	 */
	public boolean isValidPassword(String password) {

		int length = password.length();
		if (length < 8 || length > 16) {
			return false;
		}
		char first = password.charAt(0);
		if (first < 'A' || first > 'Z') {
			return false;
		}

		// TODO: 文字列の長さチェックと、最初の文字の判定を実装してください
		// ヒント: password.length() と password.charAt(0) を使います
		return true;
	}
}
