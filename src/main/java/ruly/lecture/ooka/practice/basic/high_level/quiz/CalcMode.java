package ruly.lecture.ooka.practice.basic.high_level.quiz;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 計算の種類を定義する列挙型。
 */
@Getter
@RequiredArgsConstructor
public enum CalcMode {
	/** 足し算 */
	ADD("たし算", "+"),

	/** 引き算 */
	SUBTRACT("ひき算", "-"),

	/** かけ算 */
	MULTIPLY("かけ算", "×"),

	/** わり算 */
	DIVISION("わり算", "÷");

	/** 表示用ラベル（例：たし算） */
	private final String label;

	/** 演算子記号（例：+） */
	private final String operator;

	/**
	 * 文字列から対応するCalcModeを取得する。 * @param name 列挙子名(ADD, SUBTRACT等)
	 * 
	 * @return CalcModeオブジェクト
	 * @throws IllegalArgumentException 一致する列挙子がない場合
	 */
	public static CalcMode fromName(String name) {
		for (CalcMode mode : values()) {
			if (mode.name().equalsIgnoreCase(name)) {
				return mode;
			}
		}
		throw new IllegalArgumentException("不正なモード指定です: " + name);
	}
}
