package ruly.lecture.ooka.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Todo {
	public enum Status {
		/** 未完了 */
		INCOMPLETE,

		/** 完了 */
		COMPLETED,;
	}

	/** ID */
	private int id;

	/** TODOの状態 */
	private Status status;

	/** TODOの内容 */
	private String content;
}
