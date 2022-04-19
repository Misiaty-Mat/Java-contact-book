package phone;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Contact> contactsArrayList = new ArrayList<>();

    public void queryContacts() {
        int index = 1;
        for(Contact con: contactsArrayList) {
            System.out.println(index+". "+con.getName()+": "+con.getPhoneNumber());
            index++;
        }
    }

    public void addContact() {
        System.out.print("Write contact name: ");
        String name = sc.nextLine();
        System.out.print("Write contact phone number: ");
        String phoneNumber = sc.nextLine();

        if(isNameTaken(name)) {
            System.out.println("You already have a contact with that name");
        }
        else if (isNumberTaken(phoneNumber)){
            System.out.println("You already have a contact with that number");
        }
        else {
            contactsArrayList.add(new Contact(name, phoneNumber));
        }
    }

    public void removeContact() {
        System.out.print("Enter a name of a contact to delete: ");
        String name = sc.nextLine();
        if (isNameTaken(name)) {
            contactsArrayList.remove(findContactIndex(name));
            System.out.println("Removed '"+name+"' from your contacts");
        }

    }

    public void updateContactName() {
        System.out.print("Enter a name of a contact to change its name: ");
        String oldName = sc.nextLine();
        if(isNameTaken(oldName)){
            System.out.print("Write a new name to a contact: ");
            String newName = sc.nextLine();
            contactsArrayList.get(findContactIndex(oldName)).setName(newName);
            System.out.println("Changed "+oldName+"'s name to "+newName);
        }
        else {
            System.out.println("There is no contact with that name");
        }
    }

    public void updateContactNumber() {
        System.out.print("Enter a contact name to change its number: ");
        String name = sc.nextLine();
        if(isNameTaken(name)){
            System.out.print("Enter a new number to your contact: ");
            String newNumber = sc.nextLine();
            contactsArrayList.get(findContactIndex(name)).setPhoneNumber(newNumber);
            System.out.println("Changed "+name+"'s number to "+newNumber);
        }
        else {
            System.out.println("There is no contact with that name");
        }
    }

    private int findContactIndex(String name, String phoneNumber) {
        for(Contact con: contactsArrayList) {
            if(con.getName().equals(name) || con.getPhoneNumber().equals(phoneNumber)){
                return contactsArrayList.indexOf(con);
            }
        }
        return -1;
    }

    private int findContactIndex(String name) {
        return findContactIndex(name, "");
    }

    private boolean isNameTaken(String name) {
        return findContactIndex(name) >= 0;
    }

    private boolean isNumberTaken(String number) {
        return findContactIndex("", number) >= 0;
    }
}
