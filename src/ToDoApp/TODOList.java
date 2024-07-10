package ToDoApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TODOList {
	private List<TODO> todos;

	public TODOList() {
		this.todos = new ArrayList<>();
	}

	public int getTotalTODOs() {
		return todos.size();
	}

	public void displayTODOs() {
		todos.stream().filter(todo -> !todo.isDone()).sorted(Comparator.comparing(TODO::getDueDate))
				.forEach(System.out::println);
	}

	public boolean addTODOItem(String title, String dueDate) {
		try {
			LocalDate date = LocalDate.parse(dueDate, DateTimeFormatter.ISO_LOCAL_DATE);
			TODO todo = new TODO(title, date);
			todos.add(todo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean editTODOItem(int index, String title, String dueDate) {
		if (!isValidTODOIndex(index)) {
			return false;
		}

		TODO todo = todos.get(index - 1);

		if (!title.isEmpty()) {
			todo.setTitle(title);
		}

		if (!dueDate.isEmpty()) {
			try {
				LocalDate date = LocalDate.parse(dueDate, DateTimeFormatter.ISO_LOCAL_DATE);
				todo.setDueDate(date);
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}

	public void finishTODOItem(int index) {
		if (isValidTODOIndex(index)) {
			todos.get(index - 1).markAsDone();
		}
	}

	public void deleteTODOItem(int index) {
		if (isValidTODOIndex(index)) {
			todos.remove(index - 1);
		}
	}

	public boolean isValidTODOIndex(int index) {
		return index >= 1 && index <= todos.size();
	}
}
