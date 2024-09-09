import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
public class AdressBook {
    private HashMap<String, Contact> contacts;

    public AdressBook(){
        this.contacts = new HashMap<>();
    }
    public void addContact (Contact contact){
        if(contacts.containsKey(contact.getEmail())){
        } else{
            contacts.put(contact.getEmail(), contact);
            System.out.println("COntact added succesfully");
        }
    }
    public void viewContacts(){
        if(contacts.isEmpty()){
            System.out.println("the adress book is empty");
            return;
        }
        for(Contact contact: this.contacts.values()){
            System.out.println(contact.print());
        }
    }
    public void searchContact(String email){
        if(contacts.containsKey(email)){
            System.out.println(contacts.get(email));
        }else{
            System.out.println("Contact not found");
        }
    }
    public void delteContact(String email){
        if(contacts.containsKey(email)){
            contacts.remove(email);
            System.out.println("Contact deleted.");
        }else{
            System.out.println("NO contact found with the provided email.");
        }
    }
    public void storeContacts(){
        //direccion en donde se va guardar el archivo y nombre del archivo que se va crear 
        try { FileOutputStream fileOut = new FileOutputStream("C:\\Users\\apaza\\OneDrive\\Desktop\\Agend\\agend.txt"); 
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(contacts);
            System.out.println("file with contacts is ready");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public void loadContacts(){
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\apaza\\OneDrive\\Desktop\\Agend\\agend.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            contacts = (HashMap<String, Contact>) in.readObject();
            if (contacts != null) {
                contacts.forEach((key, value) -> System.out.println(key + ": " + value));
            }
        } catch (IOException i) {
            i.printStackTrace();
            
        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        // hay un error que no supe como corregir que cuando carga los archivos guardados se muestran cosas como er: Contact@41cf53f9
        //hoe@gmail.com: Contact@277050dc que creo que es por lo de  "contacts = (HashMap<String, Contact>) in.readObject();" pero como dije no se como corregirlo
    }

}
