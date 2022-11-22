package contacts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private static final String PATTERN_BIRTH_DATA = "^(0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2}$";
    private static final String PATTERN_GENDER = "[Mm]|[Ff]";
    private static List<Essence> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private final String PATTERN_NUMBER = "\\+?(\\([0-9a-zA-Z]+\\)|[0-9a-zA-Z]+([ -][(][0-9a-zA-Z]{2,}[)])?)([ -][0-9a-zA-Z]{2,})*";
    private final String NO_PHONE_NUMBER = "[no number]";
    private final String NO_DATA = "[no data]";
    private Essence setContact;
    private LocalDateTime dateTimeEdit;
    private String nameConcat;
    private boolean back;
    private int idContact;

    public void addContact(String essence) {
        if ("person".equals(essence)) {
            Person contact = new Person();
            setContact(contact);
            contacts.add(contact);
        } else if ("organization".equals(essence)) {
            Organization org = new Organization();
            setContact(org);
            contacts.add(org);
        }
    }

    private void setContact(Organization org) {
        System.out.print("Enter the organization name: ");
        String name = scanner.nextLine();
        org.setName(name);
        addAddress(org);
        addNumberPhone(org);
    }

    private void addAddress(Essence org) {
        System.out.print("Enter the address: ");
        String address = scanner.nextLine();
        org.setAddress(address);
    }

    private void setContact(Person contact) {
        addName(contact);
        addSurname(contact);
        addBirthData(contact);
        addGender(contact);
        addNumberPhone(contact);
    }

    private void addName(Essence contact) {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        contact.setName(name);
    }

    private void addSurname(Essence contact) {
        System.out.print("Enter the surname: ");
        String surname = scanner.nextLine();
        contact.setSurname(surname);
    }

    private void addBirthData(Essence contact) {
        System.out.print("Enter the birth date: ");
        String birthDate = scanner.nextLine();
        birthDate = getStringResult(birthDate, PATTERN_BIRTH_DATA, NO_DATA);
        contact.setBirthDate(birthDate);
        if (!isCheck(birthDate, PATTERN_BIRTH_DATA)) {
            System.out.println("Bad birth date!");
        }
    }

    private void addGender(Essence contact) {
        System.out.print("Enter the gender (M, F): ");
        String gender = scanner.nextLine();
        gender = getStringResult(gender, PATTERN_GENDER, NO_DATA);
        contact.setGender(gender);
        if (!isCheck(gender, PATTERN_GENDER)) {
            System.out.println("Bad gender!");
        }
    }

    private void addNumberPhone(Essence contact) {
        System.out.print("Enter the number: ");
        String number = scanner.nextLine();
        number = getStringResult(number, PATTERN_NUMBER, NO_PHONE_NUMBER);
        contact.setPhoneNumber(number);
        System.out.println(isCheck(getStringResult(number, PATTERN_NUMBER, NO_PHONE_NUMBER), PATTERN_NUMBER) ? "The record added." : "Wrong number format!\n" +
                "The record added.");
    }

    private String getStringResult(String str, String pattern, String printPattern) {
        return isCheck(str, pattern) ? str : printPattern;
    }

    private boolean isCheck(String str, String pattern) {
        return str.matches(pattern);
    }

    public void removeContact() {
        if (contacts.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            viewContact(contacts);
            System.out.print("Select a record: ");
            int idContact = scanner.nextInt();
            contacts.removeIf(сontact -> сontact.getId() == idContact);
            System.out.println("The record removed!");
            setIdInList(contacts);
        }
    }

    private void setIdInList(List<Essence> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i + 1);
        }
    }

    public void editContact() {
       /* if (contacts.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            viewContact(contacts);
            System.out.print("Select a record: ");
            int idContact = Integer.parseInt(scanner.nextLine());*/
        for (Essence contact : contacts) {
            if (contact.getId() == idContact) {
                setContact = contacts.get(contact.getId() - 1);
            }
        }
        if (setContact.getClass() == Person.class) {
            System.out.print("Select a field (name, surname, birth, gender, number): ");
        } else if (setContact.getClass() == Organization.class) {
            System.out.println("Select a field (address, number): ");
        }
        String field = scanner.nextLine();
        switch (field) {
            case "name":
                addName(setContact);
                break;
            case "surname":
                addSurname(setContact);
                break;
            case "birth":
                addBirthData(setContact);
                break;
            case "gender":
                addGender(setContact);
                break;
            case "number":
                addNumberPhone(setContact);
                break;
            case "address":
                addAddress(setContact);
                break;
        }
        System.out.println("Saved");
        setContact.setDataEdit(LocalDateTime.now().withSecond(0).withNano(0));
        setContact.toStringInfo();
    }


    public void countContact() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public void info() {
        viewContact(contacts);
        System.out.print("\n[list] Enter action ([number], back): ");
        String command;
        command = scanner.nextLine();
        if (!"back".equals(command)) {
            inputIndexShowInfo(command);
            record();
        }
        back = false;
    }

    public void viewContact(List<Essence> list) {
        list.forEach(System.out::print);
    }

    private void inputIndexShowInfo(String index) {
        idContact = Integer.parseInt(index);
        searchContactInList(idContact);
    }

    private void searchContactInList(int idContact) {
        for (Essence contact : contacts) {
            if (contact.getId() == idContact) {
                System.out.println(contact.toStringInfo());
            }
        }
    }

    public void search() {
        searchContact();
        back = true;
        while (back) {
            System.out.println("\n[search] Enter action ([number], back, again): ");
            String command = scanner.nextLine();
            switch (command) {
                case "back":
                    back = false;
                    break;
                case "again":
                    searchContact();
                    break;
                default:
                    try {
                        int inputId = Integer.parseInt(command);
                        searchContactInList(inputId);
                        record();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid command");
                    }
                    break;
            }
        }
    }

    private void record() {
        System.out.println("\n[record] Enter action (edit, delete, menu): ");
        switch (scanner.nextLine()) {
            case "edit":
                editContact();
                break;
            case "menu":
                back = false;
                break;
            case "delete":
                removeContact();
                break;
            default:
                break;
        }
    }

    private void searchContact() {
        List<Essence> searchResultList = new ArrayList<>();
        System.out.print("Enter search query: ");
        String searchPattern = ".*?" + scanner.nextLine().toLowerCase() + ".*?";
        for (Essence contact : contacts) {
            if (contact.getSurname() != null) {
                nameConcat = (contact.getName() + contact.getSurname() + contact.getPhoneNumber()).toLowerCase();
            } else {
                nameConcat = (contact.getName() + contact.getPhoneNumber()).toLowerCase();
            }
            if (nameConcat.matches(searchPattern)) {
                searchResultList.add(contact);
            }
        }
        System.out.println("Found " + searchResultList.size() + " results:");
        setIdInList(searchResultList);
        viewContact(searchResultList);
    }
}
