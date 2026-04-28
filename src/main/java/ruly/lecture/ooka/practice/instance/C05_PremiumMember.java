package ruly.lecture.ooka.practice.instance;

import lombok.Getter;

/**
 * サービスの会員情報を管理するクラス。 *
 * <p>
 * 【会員基本情報の定義】
 * </p>
 * <ul>
 * <li>「会員ID(String)」と「氏名(String)」をフィールドとして定義すること。</li>
 * <li>これら2つの情報は、インスタンス生成時にコンストラクタで初期化し、その後は変更できないようにすること。</li>
 * <li>外部から値を取得するための getter メソッドを提供すること。</li>
 * </ul>
 * *
 * <p>
 * 【ポイントとランクの管理】
 * </p>
 * <ul>
 * <li>「保有ポイント(int)」と「ダイヤモンド会員フラグ(boolean)」を private フィールドとして持つこと。</li>
 * <li>初期状態はポイント 0、フラグは false とすること。</li>
 * <li>ポイントが 10,000 以上になった瞬間に、自動的にダイヤモンド会員フラグを true に更新するロジックを実装すること。</li>
 * <li>一度ダイヤモンド会員になったら、その後ポイントが減ってもフラグは true のまま維持すること。</li>
 * </ul>
 * *
 * <p>
 * 【ポイント操作ロジック】
 * </p>
 * <ul>
 * <li>ポイントを加算する `addPoints(int amount)` メソッドを実装すること。 引数が 0 以下の場合は何もしないこと。</li>
 * <li>ポイントを消費する `usePoints(int amount)` メソッドを実装すること。 引数が 0 以下、または保有ポイントを超える消費は
 * false を返し、ポイントを減らさないこと。 正常に消費できた場合はポイントを減らし、true を返すこと。</li>
 * </ul>
 * *
 * <p>
 * 【システム全体の統計】
 * </p>
 * <ul>
 * <li>全インスタンスの「合計保有ポイント」を保持する static フィールドを定義すること。</li>
 * <li>ポイントの増減（加算・消費成功）が発生するたびに、このフィールドを適切に更新すること。</li>
 * <li>現在の全会員の合計ポイントを返す static メソッドを定義すること。</li>
 * </ul>
 */
@Getter
public class C05_PremiumMember {

	private String memberId;
	private String memberName;
	private int points = 0;
	private boolean isDiamond = false;
	private static int totalSystemPoints;

	public C05_PremiumMember(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public static int getTotalSystemPoints() {
		return totalSystemPoints;
	}

	public void addPoints(int amount) {
		if (amount <= 0) {
			return;
		}

		this.points += amount;
		totalSystemPoints += amount;
		if (this.points >= 10000) {
			this.isDiamond = true;
		}
	}

	public boolean usePoints(int amount) {
		if (amount < 0 || this.points < amount) {
			return false;
		}

		this.points -= amount;
		totalSystemPoints -= amount;
		return true;
	}

}
