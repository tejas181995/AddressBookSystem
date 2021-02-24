import java.util.Scanner;
import java.util.ArrayList;

class Contact {
    public static final String[] fields = new String[] { "firstName", "lastName", "address", "city", "state", "zipCode",
            "phoneNumber", "email" };
    public String[] values;

    public Contact(String[] values) {
        this.values = values;

    }

    public void printContact() {
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i] + ":" + values[i]);
        }
    }
    
}

class AddressBookSystem {

    ArrayList<Contact> contactBook = new ArrayList<Contact>();

    public int addContacts(Contact contact) {
        contactBook.add(contact);
        contact.printContact();
        return contactBook.size();

    }

    public int findContact(String firstName) {
        for (int i = 0; i < contactBook.size(); i++) {
            if (contactBook.get(i).values[0].equals(firstName))
                return i;
        }
        return -1;
    }
    public Contact getContact(int index){
        return contactBook.get(index);
    }

    public void editContact(int index, int field, String val){
        contactBook.get(index).values[field] = val;
    }

    public void deleteContact(int index){
        contactBook.remove(index);
    }

    public void printall(){
        for(Contact a:contactBook){
            System.out.println("------------------------------------------------");
            a.printContact();
        }
        System.out.println("------------------------------------------------");

    }
    public static void main(String[] args) {
        int  noOfContacts;
        int reply = 1;
        int present = 0;
        AddressBookSystem addressBook = new AddressBookSystem();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Contact to be saved: ");
        noOfContacts = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < noOfContacts; j++) {
            String[] values = new String[8];
            for (int i = 0; i < values.length; i++) {
                System.out.print("\nenter" + Contact.fields[i] + ": ");
                values[i] = sc.nextLine();
            }
            Contact contact = new Contact(values);
            // contact.printContact();
            addressBook.addContacts(contact);
        }
        System.out.println("Enter Contact to be edit");
        String searchName = sc.nextLine();
        present = addressBook.findContact(searchName);
        if(present >= 0){
            addressBook.getContact(present).printContact();
            while(reply == 1){
                System.out.println("enter choice to edit = ");
                for(int i=0; i< Contact.fields.length; i++){
                    System.out.println(i +1 + " :" + " " + Contact.fields[i]);
                }
                int choice = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter new value of "+ Contact.fields[choice - 1]);
                String newVal = sc.nextLine();
                addressBook.editContact(present, choice-1, newVal);
                addressBook.getContact(present).printContact();
                System.out.println("want to make more changes then press 1");
                reply =  sc.nextInt();
            }
        }else{
            System.out.println("Contact not presnt");
        }
        sc.nextLine();
        System.out.println("Enter contact Name to be deleted");
        String deleteName = sc.nextLine();
        present = addressBook.findContact(deleteName);
        if(present >=0){
            addressBook.getContact(present).printContact();
            addressBook.deleteContact(present);
            System.out.println("Contact Deleted successfully");
        }else{
            System.out.println("contact not found");
        }
        addressBook.printall();
    }
}
