package ToDoApp;

import java.util.Scanner;

public class TODOApplication {

	public static void main(String[] args) {
		TODOList todoList = new TODOList();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			displayMainMenu(todoList);

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			switch (choice) {
			case 1:
				createTODOItem(scanner, todoList);
				break;
			case 2:
				editTODOItem(scanner, todoList);
				break;
			case 3:
				finishTODOItem(scanner, todoList);
				break;
			case 4:
				deleteTODOItem(scanner, todoList);
				break;
			case 5:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid input. Please try again.");
			}
			scanner.close();
		}
	}

	private static void displayMainMenu(TODOList todoList) {
		System.out.println("Welcome!\n");

		if (todoList.getTotalTODOs() == 0) {
			System.out.println("You have no more TODOs left!!!\n");
		} else {
			System.out.printf("You have %d TODO%s left.\n\n", todoList.getTotalTODOs(),
					todoList.getTotalTODOs() == 1 ? "" : "s");
			todoList.displayTODOs();
			System.out.println();
		}

		System.out.println("1. Create TODO");
		System.out.println("2. Edit TODO");
		System.out.println("3. Finish TODO");
		System.out.println("4. Delete TODO");
		System.out.println("5. Exit\n");
		System.out.print("Input: ");
	}

	private static void createTODOItem(Scanner scanner, TODOList todoList) {
		System.out.print("Title: ");
		String title = scanner.nextLine().trim();

		System.out.print("Until (yyyy-mm-dd): ");
		String dueDate = scanner.nextLine().trim();

		if (todoList.addTODOItem(title, dueDate)) {
			System.out.println("Saved!!!");
		} else {
			System.out.println("Invalid date format. TODO item not saved.");
		}
	}

	private static void editTODOItem(Scanner scanner, TODOList todoList) {
		System.out.print("Edit TODO number: ");
		int todoNumber = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		if (!todoList.isValidTODOIndex(todoNumber)) {
			System.out.println("Invalid TODO number.");
			return;
		}

		System.out.print("Title (leave blank to keep current): ");
		String title = scanner.nextLine().trim();

		System.out.print("Until (yyyy-mm-dd, leave blank to keep current): ");
		String dueDate = scanner.nextLine().trim();

		if (todoList.editTODOItem(todoNumber, title, dueDate)) {
			System.out.println("Saved!!!");
		} else {
			System.out.println("Invalid date format. TODO item not saved.");
		}
	}

	private static void finishTODOItem(Scanner scanner, TODOList todoList) {
		System.out.print("Finish TODO number: ");
		int todoNumber = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		if (!todoList.isValidTODOIndex(todoNumber)) {
			System.out.println("Invalid TODO number.");
			return;
		}

		todoList.finishTODOItem(todoNumber);
		System.out.println("TODO marked as done.");
	}

	private static void deleteTODOItem(Scanner scanner, TODOList todoList) {
		System.out.print("Delete TODO number: ");
		int todoNumber = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		if (!todoList.isValidTODOIndex(todoNumber)) {
			System.out.println("Invalid TODO number.");
			return;
		}

		todoList.deleteTODOItem(todoNumber);
		System.out.println("TODO deleted.");

	}
}
