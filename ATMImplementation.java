import java.io.*;
import java.rmi.*; // Remote, RemoteException
import java.util.*;

// Implementation
class ATMImplementation implements ATMInterface {
    // Logic
    public String initialize() throws RemoteException {
        return "Initialized";
    }

    // Create Account //
    public String createAccount(String username, String password)
            throws IOException, RemoteException, ClassNotFoundException {

        ArrayList<User> objects = new ArrayList<>();
        String fileName = "data.ser";

        try {
            // Create Input Output Streams
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

            ArrayList<User> objectsRead = (ArrayList<User>) in.readObject();
            in.close();

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));

            // Print objects
            for (int i = 0; i < objectsRead.size(); i++) {
                User object = objectsRead.get(i);
                objects.add(object);
            }

            // Call Create Account
            User user = new User(username, password, 0);
            objects.add(user);

            out.writeObject(objects);
            out.flush();
            out.close();

            objects.clear();

        } catch (FileNotFoundException e) {
            // Create Input Output Streams
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));

            // Call Create Account
            User user = new User(username, password, 0);
            objects.add(user);

            out.writeObject(objects);
            out.flush();
            out.close();
            objects.clear();

        }

        return ("Thank You! Your account has been created!");

    }
    // Create Account // //

}