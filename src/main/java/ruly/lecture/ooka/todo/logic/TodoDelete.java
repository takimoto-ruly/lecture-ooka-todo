package ruly.lecture.ooka.todo.logic;

import java.util.List;
import java.util.Scanner;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoDelete {
	/**
	 * ユーザーから入力を受け
	 * TODOリストの削除
	 */
	
	Scanner scanner = new Scanner(System.in);

	public void todoDelete(List<Todo> todos) {
		if (todos.isEmpty()) {
			System.out.println("削除する項目がありません。");
			return;
		}
		System.out.println("削除するIDを入力してください。");
		try {
			int targetId = Integer.parseInt(scanner.nextLine());
			for (int i = 0; i < todos.size(); i++) {
				if (todos.get(i).getId() == targetId) {
					Todo removed = todos.remove(i);
					System.out.println("削除しました" + removed.getContent());
					break;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("数字で入力してください");
		}
	}
}
