package ruly.lecture.ooka.todo.file;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoWriterTest {

	TodoWriter sut;

	@TempDir
	Path tempDir;

	@BeforeEach
	void setUpEach() {
		sut = new TodoWriter();
	}

	@DisplayName("write は List<TODO> を書き込んでファイルに保存すること")
	@Test
	void write() throws IOException {
		List<Todo> todos = new ArrayList<>();
		todos.add(new Todo(1, Todo.Status.INCOMPLETE, "タスク1"));
		todos.add(new Todo(2, Todo.Status.COMPLETED, "タスク2"));

		String tempFile = tempDir.resolve("todo.txt").toString();
		sut.write(tempFile, todos);

		//期待値
		String expected = "1(未完了)タスク1\n2(完了)タスク2";

		//実測値
		String actual = Files.readString(Path.of(tempFile)).replace("\r\n", "\n").trim();

		//検証
		assertEquals(expected, actual);
	}

}
