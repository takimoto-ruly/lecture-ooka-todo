package ruly.lecture.ooka.todo.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
	ByteArrayOutputStream outContent;
	private final PrintStream originalOut = System.out;

	@BeforeEach
	void setUpEach() {
		orgIn = System.in;
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void tearDown() {
		System.setIn(orgIn);
		System.setOut(originalOut);
	}

	@DisplayName("todoDeleteで指定したTODOを削除できること")
	@Test
	void todoDelete() {
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

	@DisplayName("TODOがない場合、\"削除する項目がありません。\"と出力すること")
	@Test
	void todoDelete2() {

		List<Todo> todos = new ArrayList<>();
		TodoDelete todoDelete = new TodoDelete(new ByteArrayInputStream("".getBytes()));

		todoDelete.todoDelete(todos);

		assertEquals("削除する項目がありません。", outContent.toString().trim());
	}

	@DisplayName("TODOを削除した場合、\"削除しました\" + 内容が出力されること")
	@Test
	void todoDelete3() {

		List<Todo> todos = new ArrayList<>();
		todos.add(new Todo(1, Todo.Status.INCOMPLETE, "消すタスク"));
		String input = "1\n";
		mockIn = new ByteArrayInputStream(input.getBytes());
		sut = new TodoDelete(mockIn);

		sut.todoDelete(todos);

		String actual = outContent.toString();

		assertTrue(actual.contains("削除しました消すタスク"));
	}

}
