package ruly.lecture.ooka.todo.file;

import static org.junit.jupiter.api.Assertions.*;
import static ruly.lecture.ooka.todo.dto.Todo.Status.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ruly.lecture.ooka.todo.dto.Todo;

class TodoReaderTest {
	TodoReader sut;

	@BeforeEach
	void setUpEach() {
		sut = new TodoReader();
	}

	@DisplayName("read は todo.txt を読み込んでTODO一覧を返すこと")
	@Test
	void read() {
		// 期待値
		List<Todo> expected = List.of(
				new Todo(1, Todo.Status.INCOMPLETE, "TodoReaderの実装"),
				new Todo(2, COMPLETED, "TodoReaderの実装"));

		// 実測値
		List<Todo> actual = sut.read("todo-test.txt");

		// 検証
		assertIterableEquals(expected, actual);
	}

}
