package ruly.lecture.ooka.todo.file;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoWriterTest {

	TodoWriter sut;
	
	@BeforeEach
	void steUpEach() {
		sut = new TodoWriter();
	}
	@DisplayName("write は List<TODO> を書き込んでファイルに保存すること")
	@Test
	void write() {
		List <Todo> todos = new ArrayList<>();
		todos.add(new Todo(1,Todo.Status.INCOMPLETE,"タスク1"));
		todos.add(new Todo(2,Todo.Status.INCOMPLETE,"タスク２"));	}
	
	
}
