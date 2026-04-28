package ruly.lecture.ooka.practice.instance;

/**
 * クラスの設計とインスタンスの制御に関する実践演習。
 * <p>
 * 【仕様：カプセル化】
 * </p>
 * <ul>
 * <li>年齢を保持するフィールドは、外部クラスから直接参照・変更できないように定義すること。</li>
 * <li>年齢の変更には setter を、取得には getter を使用すること。</li>
 * <li>setter では、引数が 0 未満の場合は強制的に 0 を設定するバリデーションを実装すること。</li>
 * </ul>
 *
 * <p>
 * 【仕様：インスタンスの状態と初期化】
 * </p>
 * <ul>
 * <li>「名前(String)」「年齢(int)」「ペットの名前(String)」の3つを個別のインスタンスの状態として保持すること。</li>
 * <li>コンストラクタはこれら3つの引数を受け取り、すべてのフィールドを適切に初期化すること。</li>
 * <li>フィールド名と引数名が同一である場合、適切に self-reference（thisキーワード）を用いて区別すること。</li>
 * </ul>
 *
 * <p>
 * 【仕様：クラス共通の状態（static）】
 * </p>
 * <ul>
 * <li>全インスタンスで共有される「累計生成人数」を保持する整数型フィールドを定義すること。</li>
 * <li>このカウンタはインスタンスが生成されるたびに、コンストラクタ内で 1 加算すること。</li>
 * <li>現在の累計人数を返すメソッドを定義すること。このメソッドは、インスタンスを生成せずともクラス名から直接呼び出し可能であること。</li>
 * </ul>
 */
public class C03_SmartPerson {
	private int age;
	private String name;
	private String petName;
	private static int totalCount = 0;

	public C03_SmartPerson(String name, int age, String petName) {
		this.name = name;
		this.age = age;
		this.petName = petName;

		totalCount++;
	}

	public void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	public int getAge() {
		return this.age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetName() {
		return this.petName;
	}

	public static int getTotalCount() {
		return totalCount;
	}
}
