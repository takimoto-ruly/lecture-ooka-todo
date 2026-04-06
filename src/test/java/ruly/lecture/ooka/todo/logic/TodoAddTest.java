package ruly.lecture.ooka.todo.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoAddTest {
	TodoAdd sut;
	InputStream orgIn;
	InputStream mockIn;

	@BeforeEach
	void setUpEach() {
		orgIn = System.in;
	}

	@AfterEach
	void tearDown() {
		System.setIn(orgIn);
	}

	@DisplayName("todoAdd で未完了のTODOを追加できること")
	@Test
	void todoAdd() {
		String input = "テストTODO（未完了）\n1\n";
		InputStream mockIn = new ByteArrayInputStream(input.getBytes());
		sut = new TodoAdd(mockIn);

		// 期待値
		List<Todo> expected = List.of(new Todo(1, Todo.Status.INCOMPLETE, "テストTODO（未完了）"));

		// 実測値（テスト対象メソッドの戻り値）
		List<Todo> actual = sut.todoAdd();

		// 検証（期待値 == 実測値）
		assertIterableEquals(expected, actual);
	}

	@DisplayName("todoAdd で完了したTODOを追加できること")
	@Test
	void todoAdd2() {
		String input = "テストTODO（完了）\n2\n";
		InputStream mockIn = new ByteArrayInputStream(input.getBytes());
		sut = new TodoAdd(mockIn);

		// 期待値
		List<Todo> expected = List.of(new Todo(1, Todo.Status.COMPLETED, "テストTODO（完了）"));

		// 実測値（テスト対象メソッドの戻り値）
		List<Todo> actual = sut.todoAdd();

		// 検証（期待値 == 実測値）
		assertIterableEquals(expected, actual);
	}
}
