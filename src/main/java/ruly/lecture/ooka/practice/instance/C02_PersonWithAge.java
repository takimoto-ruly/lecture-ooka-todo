package ruly.lecture.ooka.practice.instance;

/**
 * 年齢管理機能付きのPersonクラス。
 */
public class C02_PersonWithAge {
	String name;
	int age;

	/**
	 * 【仕様】<br>
	 * 名前と年齢を受け取って初期化するコンストラクタを実装すること。
	 */
	public C02_PersonWithAge(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 【仕様】<br>
	 * 呼び出すと年齢(age)が1つ増える celebrateBirthday メソッドを実装すること。
	 */
	public void celebrateBirthday() {
		this.age += 1;
	}

}
