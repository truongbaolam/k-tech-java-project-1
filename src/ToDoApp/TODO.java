package ToDoApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TODO {
	private String title;
	private LocalDate dueDate;
	private boolean done;

	public TODO(String title, LocalDate dueDate) {
		this.title = title;
		this.dueDate = dueDate;
		this.done = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isDone() {
		return done;
	}

	public void markAsDone() {
		this.done = true;
	}

	@Override
	public String toString() {
		if (done) {
			return String.format("%s (Done)", title);
		} else {
			return String.format("%s - %s", title, dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
		}
	}
}
