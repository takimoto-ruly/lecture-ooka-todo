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
		INCOMPLETE("未完了"),

		/** 完了 */
		COMPLETED("完了"),
		;
		
		private String mark;
		
		private Status(String mark) {
			this.mark = mark;
		}
		
		public String getMark() {
			return this.mark;
		}
	}

	/** ID */
	private int id;

	/** TODOの状態 */
	private Status status;

	/** TODOの内容 */
	private String content;
}
