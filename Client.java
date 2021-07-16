
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
        String username = "";
        String password = "";
        int amount = 0;
        String choice = "";
        String fileName = "data.txt";

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
                System.out.println("Thank You! Your account has been created!");

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