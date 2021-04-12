import entities.Person;
import services.Management;

import java.util.List;
import java.util.Scanner;

public class Main {

    public final static int PERSON_INFO = 1, COPY_WORD = 2, EXIT =3;

    public static void main(String[] args) {
	// write your code here
        try (Scanner scanner = new Scanner(System.in)){
            Management management = new Management();
            int choice = 0;
            do {
                System.out.println("========= File Processing =========");
                System.out.println("1. Find person info");
                System.out.println("2. Copy Text to new file");
                System.out.println("3. Exit");
                System.out.print("Please choice one option: ");
                try{
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case PERSON_INFO:
                            System.out.println("-------- Person Info --------");
                            String path;
                            double money = 0;
                            System.out.println("Enter path: ");
                            path = scanner.nextLine();
                            while (true) {
                                System.out.println("Enter money: ");
                                try {
                                    money = management.checkInputMoney(scanner.nextLine());
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            System.out.println("-------- Result --------");
                            List<Person> persons = null;
                            try {
                                persons = management.getPerson(path, money);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                break;
                            }
                            if (persons == null)
                                break;
                            System.out.printf("%-20s%-20s%-20s%n", "Name", "Address", "Money");
                            for (Person person : persons) {
                                System.out.printf("%-20s%-20s%-20s%n", person.getName(), person.getAddress(), person.getMoney());
                            }
                            String maxName = "", minName = "";
                            if (persons.size() > 0) {
                                maxName = persons.get(persons.size() - 1).getName();
                                minName = persons.get(0).getName();
                            }
                            System.out.printf("Max: %s\n", maxName);
                            System.out.printf("Min: %s\n", minName);
                            break;
                        case COPY_WORD:
                            System.out.println("-------- Copy text --------");
                            String name,
                                    source;
                            System.out.print("Enter Source: ");
                            source = scanner.nextLine();
                            System.out.print("Enter new file name: ");
                            name = scanner.nextLine();
                            try {
                                if (management.copyWordOneTimes(source, name)) {
                                    System.out.println("Copy done...");
                                } else {
                                    System.out.println("Failure");
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case EXIT:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Please choice(1-3)");
                            break;
                    }
                }catch (NumberFormatException ex){
                    System.out.println(ex.getMessage());
                }
            }while (choice != EXIT);
        }
    }
}
