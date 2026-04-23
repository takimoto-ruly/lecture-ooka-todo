package ruly.lecture.ooka.todo.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ruly.lecture.ooka.todo.dto.Todo;

public class TodoWriter {

	/**
	 * TODOリストをファイルに書き込み保存する
	 * @throws IOException 
	 */

	public void write(String filePath, List<Todo> todos) throws IOException {

		try (FileWriter fw = new FileWriter(filePath)) {
			for (Todo todo : todos) {
				fw.write(todo.getId() + "(" + todo.getStatus().getMark() + ")" + todo.getContent());
				fw.write(System.lineSeparator());
			}
		}

	}
}
