import java.util.ArrayList;
import java.util.Scanner;
class Contact{
    String firstName, lastName, address, city, state, zipCode, phoneNumber, email;
    public Contact(String firstName, String lastName, String address, String city, String state, String zipCode,
            String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public void printContact(){
        System.out.println("First Name : " + firstName);
        System.out.println("Last Name : " + lastName);
        System.out.println("Address: " + address);
        System.out.println("city: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip code: " + zipCode);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("E-mail: " + email);

    }
}
class AddressBookSystem {
    ArrayList<Contact> contactBook = new ArrayList<Contact>();
    
    public int addContacts(Contact contact){
        contactBook.add(contact);
        contact.printContact();
        return contactBook.size();


    }
    public static void main(String[] args) {
        String firstName, lastName, address, city, state, zipCode, phoneNumber, email;
        AddressBookSystem addressBook = new AddressBookSystem();
        System.out.println("Welcome to Address Book System");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first Name");
        firstName = sc.nextLine();
        System.out.println("Enter Last Name");
        lastName = sc.nextLine();
        System.out.println("Enter Address");
        address = sc.nextLine();
        System.out.println("Enter City Name");
        city = sc.nextLine();
        System.out.println("Enter state Name");
        state = sc.nextLine();
        System.out.println("Enter zip code");
        zipCode = sc.nextLine();
        System.out.println("Enter Phone Number");
        phoneNumber = sc.nextLine();
        System.out.println("Enter E-mail");
        email = sc.nextLine();

        Contact contact = new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
        addressBook.addContacts(contact);

    }
}

