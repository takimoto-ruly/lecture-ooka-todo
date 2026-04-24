package ruly.lecture.ooka.practice.basic.high_level.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1問のクイズ情報を保持するデータ転送オブジェクト。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {

	/** 第1引数 */
	private int num1;

	/** 第2引数 */
	private int num2;

	/** ユーザーが入力した回答 */
	private String userAnswer;

	/** 正解かどうかのフラグ（採点時に使用） */
	private boolean correct;

	/**
	 * 最小限の構成でインスタンス化するコンストラクタ（問題生成時用） * @param num1 第1引数
	 * 
	 * @param num2 第2引数
	 */
	public QuizDTO(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
}
