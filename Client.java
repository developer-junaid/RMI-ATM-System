
// Import
import java.rmi.*; // Remote, RemoteException, NotBoundException, Naming
import java.net.*; // MalformedURLException
import java.util.*; // Scanner
import java.io.*; // File, IOException, FileOutputStream, FileInputStream, FileNotFoundException, ObjectInputStream, ObjectOutputStream

// Client
class Client {
    public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException,
            IOException, FileNotFoundException, ClassNotFoundException, EOFException {
        // Variables
        ATMInterface ATM = (ATMInterface) Naming.lookup("ATMObject");
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> objects = new ArrayList<>();
        String username = "";
        String password = "";
        int amount = 0;
        String choice = "";
        String fileName = "data.ser";

        // My Info
        System.out.println("Hi! Welcome to BSIT Part IV ATM Machine !\n Developed by: IT/2k18/50 (Junaid) \n");

        // Run untill Quit "q"
        while (true) {

            // Display Initial Text
            System.out.println("\nPlease select an option from the menu below:");
            System.out.println(" l -> Login \n c -> Create New Account \n q -> Quit \n");
            System.out.print("> ");

            // Take Input
            choice = scanner.nextLine();

            // If Create Account is Selected
            if (choice.equalsIgnoreCase("c")) {
                // Create Account
                System.out.print("Please enter your user name: ");
                username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                password = scanner.nextLine();

                ///////////////////////////////////////////////////////////////////////////////
                // Add Objects

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

                // Try Catch //
                try {
                    // Create Input Output Streams
                    // Read Objects
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.ser"));
                    // User readUser = (User) in.readObject();

                    ArrayList<User> objectsRead = (ArrayList<User>) in.readObject();
                    in.close();

                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.ser"));

                    // Print objects
                    for (int i = 0; i < objectsRead.size(); i++) {
                        objects.add((User) objectsRead.get(i));
                        // System.out.println("Objects Read :" + objectsRead.get(i).getUsername());
                    }

                    // Call Create Account
                    User user = new User(username, password, 0);
                    objects.add(user);

                    out.writeObject(objects);
                    out.flush();
                    out.close();
                    // System.out.println("Added all objects");
                    // System.out.println("Objects: " + objects.toString());
                    // Print objects
                    // for (int j = 0; j < objects.size(); j++) {
                    // System.out.println("Objects Added :" + objects.get(j).getUsername());
                    // }
                    objects.clear();

                    System.out.println("Thank You! Your account has been created!");

                } catch (FileNotFoundException e) {
                    // System.out.println("File not found");
                    // Create Input Output Streams
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.ser"));

                    // Call Create Account
                    User user = new User(username, password, 0);
                    objects.add(user);

                    out.writeObject(objects);
                    out.flush();
                    out.close();
                    // System.out.println("Created File");
                    objects.clear();

                    System.out.println("Thank You! Your account has been created!");

                }

                // Try Catch //

                // Print objects
                // for (int i = 0; i < objectsRead.size(); i++) {
                // System.out.println("Objects " + ((User) objectsRead.get(i)).getAmount());
                // }
                ///////////////////////////////////////////////////////////////////////////////

                // Create Input Output Streams
                // ObjectOutputStream out = new ObjectOutputStream(new
                // FileOutputStream(fileName));
                // Call Create Account
                // User user = new User(username, password, amount);
                // out.writeObject(user);
                // out.close();

                // ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
                // User readUser = (User) in.readObject();
                // System.out.println("User with Name " + readUser.getUsername() + " saved !");
                // in.close();

            } else if (choice.equalsIgnoreCase("l")) {
                // If Login is Selected
                // Create Account
                System.out.print("Please enter your user name: ");
                username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                password = scanner.nextLine();

                // Read User from file

                // ArrayList<Object> objList = new ArrayList<>();
                // ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

                // int i = 0;
                // while (i != 2) {
                // try {
                // User readUser = (User) in.readObject();
                // // User readUser2 = (User) in.readObject();

                // System.out.println("read user: " + readUser.getUsername());
                // System.out.println("added user");
                // i++;
                // } catch (EOFException e) {
                // System.out.println("Something went wrong !!" + e);
                // i++;
                // }
                // }

                // System.out.println("Broken loop");

                // Validate user

                // Check if user exists
                // if (readUser.getUsername().equalsIgnoreCase(username)) {
                // System.out.println("User exists");

                // // If exists
                // // Check Password
                // if (readUser.getPassword().equalsIgnoreCase(password)) {
                // System.out.println("Access granted.\n******** Welcome to your account
                // ********");
                // } else {
                // System.out.println("******** LOGIN FAILED! Please try again. ********");

                // }
                // } else {
                // System.out.println("User not found!");

                // }

            } else if (choice.equalsIgnoreCase("q")) {
                // Exit out of loop
                break;
            }
        }

    }
}