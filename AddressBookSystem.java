import java.util.Scanner;

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
    public static void main(String[] args) {
        String[] values = new String[8];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<values.length; i++){
            System.out.println("enter" + Contact.fields[i] + ": ");
            values[i] = sc.nextLine();
        }
        Contact contact = new Contact(values);
        contact.printContact();
    }
}