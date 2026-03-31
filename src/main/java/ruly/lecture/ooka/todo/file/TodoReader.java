package ruly.lecture.ooka.todo.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoReader {

	/**
	 * ファイルを読込み、TODOに変換する.
	 * 
	 * @param filePath 読込み対象のファイル
	 */
	public List<Todo> read(String filePath) {
		String file = filePath.startsWith("/") ? filePath : "/" + filePath;
		try (InputStream is = getClass().getResourceAsStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

			return br.readAllLines().stream().map(this::parseLine).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	private Todo parseLine(String line) {
		String[] parts = line.split(",");
		return new Todo(Integer.parseInt(parts[0]), Todo.Status.valueOf(parts[1]), parts[2]);
	}
}
