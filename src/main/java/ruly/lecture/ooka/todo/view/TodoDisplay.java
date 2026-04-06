package ruly.lecture.ooka.todo.view;

import java.util.List;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoDisplay {
	/**
	 * TODOの一覧表示
	 */

	public void todoDisplay(List<Todo> todos) {
		System.out.println("--------------------");
		for (Todo t : todos) {
			System.out.println(t.getId() + t.getStatusMark() + t.getContent());
		}
		System.out.println("--------------------");
	}
}
