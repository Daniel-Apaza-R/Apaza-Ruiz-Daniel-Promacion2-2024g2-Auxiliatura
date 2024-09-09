import java.util.Scanner;

public class App {
    public static void main(String[] args){
        AdressBook adressbook = new AdressBook();
        Scanner scanner= new Scanner(System.in);
        Integer option;
        do{
            adressbook.loadContacts();
            System.out.println("\n***Contact Adress Book***");
            System.out.println("1. Add contact");
            System.out.println("2. View contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            
            switch(option){
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    Contact contact = new Contact(name, email, age, phone);
                    adressbook.addContact(contact);
                    adressbook.storeContacts();
                    break;
                case 2:
                    adressbook.viewContacts();
                    break;
                case 3:
                    System.out.print("ENter the email of the contact to search: ");
                    email = scanner.nextLine();
                    adressbook.searchContact(email);
                    break;
                case 4:
                    System.out.print("Enter the email of the contact to delete: ");
                    email = scanner.nextLine();
                    adressbook.delteContact(email);
                    adressbook.storeContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option please try again.");



            }
        } while (option !=5);
       
    }
}
