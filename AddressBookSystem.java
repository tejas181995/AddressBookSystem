import java.util.Scanner;
import java.util.ArrayList;

class Contact{
    public static final String[] fields = new String[]{"firstName", "lastName", "address", "city", "state", "zipCode", "phoneNumber", "email" } ;
    private String[] values;
    public Contact(String[] values){
        this.values = values;
        
    }
    public void printContact(){
        for(int i=0; i<fields.length; i++){
            System.out.println(fields[i] + ":" + values[i]);
        }
    }
}

class AddressBookSystem{

    ArrayList<Contact> contactBook = new ArrayList<Contact>();

    public int addContacts(Contact contact){
        contactBook.add(contact);
        contact.printContact();
        return contactBook.size();
        
    }
    public static void main(String[] args) {
        int totalContacts;
        AddressBookSystem addressBook = new AddressBookSystem();
        String[] values = new String[8];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<values.length; i++){
            System.out.println("enter" + Contact.fields[i] + ": ");
            values[i] = sc.nextLine();
        }
        Contact contact = new Contact(values);
        contact.printContact();
        totalContacts = addressBook.addContacts(contact);
        System.out.println("Total contacts is Address Book: " + totalContacts);
    }
}
