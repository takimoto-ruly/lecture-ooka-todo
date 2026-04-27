package ruly.lecture.ooka.practice.basic.high_level.quiz;

import java.util.Random;

/**
 * 計算クイズの問題生成を担うサービス。
 */
public class QuizGenerationService {

	private final Random random = new Random();

	/**
	 * 指定されたモードと難易度に基づいて、計算問題を1問生成する。 *
	 * <p>
	 * 【仕様】
	 * </p>
	 * <ul>
	 * <li>難易度バリデーション: difficultyは1, 2, 3のみ許容。範囲外はIllegalArgumentExceptionをスロー。</li>
	 * <li>数値生成範囲（同値分割）:
	 * <ul>
	 * <li>難易度1: 1 〜 9 (1桁)</li>
	 * <li>難易度2: 10 〜 99 (2桁)</li>
	 * <li>難易度3: 100 〜 999 (3桁)</li>
	 * </ul>
	 * </li>
	 * <li>引き算(SUBTRACT)の制約: 答えがマイナスにならないよう、生成後に num1 < num2 の場合は値を入れ替える。</li>
	 * <li>割り算(DIVISION)の制約:
	 * <ul>
	 * <li>余りが出ない（割り切れる）問題のみを生成する。</li>
	 * <li>割る数(num2)に 0 は使用しない。</li>
	 * <li>条件を満たすまで再生成を繰り返す。</li>
	 * </ul>
	 * </li>
	 * </ul>
	 *
	 * @param mode       生成する計算の種類 (ADD, SUBTRACT, MULTIPLY, DIVISION)
	 * @param difficulty 難易度 (1, 2, 3)
	 * @return 生成された問題データ(QuizDTO)
	 * @throws IllegalArgumentException 難易度が不正、またはmodeがnullの場合
	 */
	public QuizDTO generateQuestion(CalcMode mode, int difficulty) {
		QuizDTO beginner =new QuizDTO(random.nextInt(8),random.nextInt(8));
		
			// --- 実装してください ---
		// ヒント：
		// 1. switch式で min と max を決定する
		// 2. random.nextInt(max - min + 1) + min で範囲数値を生成
		// 3. while, if, 一時変数(temp)による入れ替えなどを駆使する
		return null;
	}
}
