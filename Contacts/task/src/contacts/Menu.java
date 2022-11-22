package contacts;

import java.util.Scanner;

public class Menu {

    private static String command;
    private static Scanner scanner = new Scanner(System.in);
    private static PhoneBook phoneBook = new PhoneBook();
    private static boolean exit = true;


    public static void processExecution() {
        while (exit) {
            System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");

            switch (getCommand()) {
                case "add":
                    System.out.print("Enter the type (person, organization): ");
                    phoneBook.addContact(getCommand());
                    break;
                case "remove":
                    phoneBook.removeContact();
                    break;
                case "edit":
                    //phoneBook.editContact();
                    break;
                case "count":
                    phoneBook.countContact();
                    break;
                case "list":
                    phoneBook.info();
                    break;
                case "exit":
                    exit = false;
                    break;
                case "search":
                    phoneBook.search();
                    break;
                default:
                    break;
            }
        }
    }

    private static String getCommand() {
        return scanner.nextLine();
    }

}
