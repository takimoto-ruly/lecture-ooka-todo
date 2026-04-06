package ruly.lecture.ooka.todo.logic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoAdd {

	private Scanner scanner;
	private List<Todo> todos = new ArrayList<>();
	private int id = 1;
	
	public TodoAdd(InputStream systemIn) {
		this.scanner = new Scanner(systemIn);
	}

	/**
	 * ユーザーから入力を受け TODOリストに追加する
	 */
	public List<Todo> todoAdd() {
		System.out.println("追加するTODOを入力");
		String content = scanner.nextLine();
		System.out.println("１：未完了　２：完了");
		String choice = scanner.nextLine();
		Todo.Status status = Todo.Status.INCOMPLETE;
		if ("2".equals(choice)) {
			status = Todo.Status.COMPLETED;

			Todo t = new Todo(id, status, content);
			todos.add(t);
			id++;

			System.out.println("追加しました。 " + id + "[" + content + "]");
		}
		return todos;
	}
}
