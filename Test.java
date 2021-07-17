import java.io.*;
import java.util.*;

public class Test {
    public static void main(String args[]) throws Exception, IOException, InvalidClassException,
            StreamCorruptedException, OptionalDataException, ClassNotFoundException {
        // Logic
        // Create JSON Object Format using Classes
        // Create Multiple Objects
        // Store in ArrayList of type Object
        // Store that list inside a file
        // Read list from file
        // Read objects

        // Tasks
        // User1 = ("Junaid", "7junaidq", 40)
        // User2 = ("Hassan", "sainbeloved", 100)

        // User > UserDetails
        // ObjectList > [User1, User2]

        // Add Objects
        ArrayList<User> objects = new ArrayList<>();

        // Create Input Output Streams
        // ObjectOutputStream out = new ObjectOutputStream(new
        // FileOutputStream("test.ser"));
        // // Call Create Account
        // int j = 0;
        // while (j != 2) {
        // User user = new User("junaid", "123", j);
        // objects.add(user);
        // j++;
        // }

        // out.writeObject(objects);
        // out.flush();
        // out.close();

        // Read Objects
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.ser"));
        // User readUser = (User) in.readObject();

        ArrayList<User> objectsRead = (ArrayList<User>) in.readObject();
        in.close();

        // Print objects
        for (int i = 0; i < objectsRead.size(); i++) {
            System.out.println("Objects " + ((User) objectsRead.get(i)).getAmount());
        }

    }
}