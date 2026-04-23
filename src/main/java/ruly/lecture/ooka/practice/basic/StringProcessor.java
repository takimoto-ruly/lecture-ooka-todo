package ruly.lecture.ooka.practice.basic;

public class StringProcessor {
	/**
	 * 指定された文字列を、指定された回数分だけ繰り返した文字列を生成します。 *
	 * <p>
	 * 【仕様】
	 * </p>
	 * <ul>
	 * <li>count が 3 の場合、str を 3回繰り返した文字列を返します。</li>
	 * <li>count が 0 以下の場合は、空文字 "" を返します。</li>
	 * </ul>
	 * * @param str 繰り返したい文字列
	 * 
	 * @param count 繰り返す回数
	 * @return 繰り返した結果の文字列。countが0以下の場合は空文字。
	 */
	public String repeatString(String str, int count) {
		// TODO: for文を使って実装してください
		return "";
	}

	/**
	 * 文字列の中に、指定された文字が何個含まれているかをカウントします。 *
	 * <p>
	 * 【仕様】
	 * </p>
	 * <ul>
	 * <li>文字列を先頭から1文字ずつ確認し、target と一致する文字の総数を返します。</li>
	 * <li>text が空文字の場合は 0 を返します。</li>
	 * </ul>
	 * * @param text 検索対象の文字列
	 * 
	 * @param target カウントしたい文字
	 * @return 一致した文字の個数
	 */
	public int countChar(String text, char target) {
		// TODO: 文字列の長さ分ループさせ、if文で一致判定をしてカウントしてください
		// ヒント: text.length() と text.charAt(i) を使います
		return 0;
	}
}
