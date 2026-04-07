package ruly.lecture.ooka.todo.logic;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoDelete {
	/**
	 * ユーザーから入力を受け
	 * TODOリストの削除
	 */

	private Scanner scanner;

	public TodoDelete(InputStream systemIn) {
		this.scanner = new Scanner(systemIn);
	}

	public List<Todo> todoDelete(List<Todo> todos) {
		if (todos.isEmpty()) {
			System.out.println("削除する項目がありません。");
			return todos;
		}
		System.out.println("削除するIDを入力してください。");
		int targetId = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < todos.size(); i++) {
			if (todos.get(i).getId() == targetId) {
				Todo removed = todos.remove(i);
				System.out.println("削除しました" + removed.getContent());
				break;
			}
		}
		return todos;
	}
}
