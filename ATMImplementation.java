import java.io.*;
import java.rmi.*; // Remote, RemoteException
import java.util.*;

// Implementation
class ATMImplementation implements ATMInterface {

    // Variables
    static ArrayList<User> objects = new ArrayList<>();
    static String fileName = "data.ser";

    // Logic
    public String initialize() throws RemoteException {
        return "Initialized";
    }

    // Write
    public static void write() throws FileNotFoundException, IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));

        out.writeObject(objects);
        out.flush();
        out.close();
        objects.clear();
    }
    // Write

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

    // Request
    public String request(User object)
            throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException {

        // Read Objects
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.ser"));

        ArrayList<User> objectsRead = (ArrayList<User>) in.readObject();
        in.close();

        // Print objects
        for (int i = 0; i < objectsRead.size(); i++) {
            User objectRead = objectsRead.get(i);
            String username = objectRead.getUsername();
            String matchUsername = object.getUsername();
            if (username.equals(matchUsername)) {
                return ("Your balance is $" + objectRead.getAmount());

            }
        }

        return ("No balance found");

        // Show Account Balance

    }
    // Request

    // Withdraw
    public String withdraw(User object, int amountToWithdraw)
            throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException {

        // Read Objects
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

        ArrayList<User> objectsRead = (ArrayList<User>) in.readObject();
        in.close();

        // Print objects
        for (int i = 0; i < objectsRead.size(); i++) {
            User objectRead = objectsRead.get(i);
            String username = objectRead.getUsername();
            String matchUsername = object.getUsername();
            if (username.equals(matchUsername)) {

                if (objectRead.getAmount() >= amountToWithdraw) {
                    // Withdraw amount
                    objectRead.withdrawAmount(amountToWithdraw);
                    objects.add(objectRead);

                } else {
                    // Insufficient Balance
                    objects.add(objectRead);

                    return ("Insufficient Balance !");

                }

            } else {
                objects.add(objectRead);
            }

        }

        write();

        return ("$" + amountToWithdraw + " withdrawn successfully.");

    }
    // Withdraw

    // Deposit
    public String deposit(User object, int amountToDeposit)
            throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException {

        // Read Objects
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

        ArrayList<User> objectsRead = (ArrayList<User>) in.readObject();
        in.close();

        // Print objects
        for (int i = 0; i < objectsRead.size(); i++) {
            User objectRead = objectsRead.get(i);
            String username = objectRead.getUsername();
            String matchUsername = object.getUsername();

            if (username.equals(matchUsername)) {

                objectRead.depositAmount(amountToDeposit);
                objects.add(objectRead);

            } else {
                objects.add(objectRead);
            }

        }

        write();

        return ("$" + amountToDeposit + " deposited successfully.");
    }
    // Deposit

}
