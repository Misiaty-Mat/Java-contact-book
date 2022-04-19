package phone;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static MobilePhone phone = new MobilePhone();
    public static void main(String[] args) {
        System.out.println("1: Print contacts");
        System.out.println("2: Add contact");
        System.out.println("3: Remove contact");
        System.out.println("4: Update contact name");
        System.out.println("5: Update contact phone number");
        System.out.println("Everything else: Close and print");
        loop: while (true) {
            System.out.print("Choose option: ");
            switch (sc.nextInt()) {
                case 1:
                    phone.queryContacts();
                    break;
                case 2:
                    phone.addContact();
                    break;
                case 3:
                    phone.removeContact();
                    break;
                case 4:
                    phone.updateContactName();
                    break;
                case 5:
                    phone.updateContactNumber();
                    break;
                default:
                    break loop;
            }
        }
        phone.queryContacts();
    }
}
