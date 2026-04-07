package ruly.lecture.ooka.todo.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoDeleteTest {

	TodoDelete sut;
	InputStream orgIn;
	InputStream mockIn;

	@BeforeEach
	void sweUpEach() {
		orgIn = System.in;
	}

	@AfterEach
	void tearDown() {
		System.setIn(orgIn);
	}

	@DisplayName("todoDeleteで指定したTODOを削除できること")
	@Test
	void TodoDelete() {
		List<Todo> todos = new ArrayList<>();
		todos.add(new Todo(1, Todo.Status.INCOMPLETE, "消さないタスク"));
		todos.add(new Todo(2, Todo.Status.INCOMPLETE, "消すタスク"));

		String input = "2\n";
		mockIn = new ByteArrayInputStream(input.getBytes());
		sut = new TodoDelete(mockIn);

		//期待値
		List<Todo> expected = List.of(new Todo(1, Todo.Status.INCOMPLETE, "消さないタスク"));

		//実測値
		List<Todo> actual = sut.todoDelete(todos);

		//検証
		assertIterableEquals(expected, actual);

	}

}
