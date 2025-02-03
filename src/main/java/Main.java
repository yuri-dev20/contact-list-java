import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================");
        System.out.print("Please enter an option (1) add contact, (2) remove contact, (3) show list or enter any number to stop: ");
        String option = sc.next();
        System.out.println();
        if (Objects.equals(option, "1")) {
            System.out.print("Enter the name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Enter the address: ");
            String address = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            System.out.print("Enter phone: ");
            String phone = sc.nextLine();

            Person p = new Person(name, address, email, phone);
            ContactList.addContact(p);
            System.out.println();

        } else if (Objects.equals(option, "2")) {
            ContactList.showContactInfo();
            System.out.print("Enter an id to removed: ");
            String id = sc.next();
            ContactList.removeContact(id);

        } else if (Objects.equals(option, "3")) {
            ContactList.showContactInfo();
            System.out.println();

        }
        sc.close();

    }

}

