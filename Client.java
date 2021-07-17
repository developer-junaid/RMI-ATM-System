
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
                String username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();
                int amount = 0;

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
                        User object = objectsRead.get(i);
                        objects.add(object);
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
                Boolean loggedIn = false;

                // Create Account
                System.out.print("Please enter your user name: ");
                String usernameInput = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String passwordInput = scanner.nextLine();

                // Read User from file
                // Read Objects
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.ser"));
                // User readUser = (User) in.readObject();

                ArrayList<User> objectsRead = (ArrayList<User>) in.readObject();
                in.close();

                // Print objects
                for (int i = 0; i < objectsRead.size(); i++) {

                    User object = objectsRead.get(i);
                    String username = object.getUsername();
                    String password = object.getPassword();

                    // Check if user exists
                    if (username.equals(usernameInput)) {
                        // Check Password
                        if (password.equals(passwordInput)) {
                            loggedIn = true;

                            System.out.println("Access granted.\n\n******** Welcome to your account ********\n");

                            // Choose Operation
                            while (true) {
                                System.out.println(
                                        "\n\t1) Withdraw money.\n\t2) Deposit money.\n\t3) Request balance.\n\t4) Quit the program.\n\n");
                                System.out.println("\nPlease select an option from the menu below:");
                                System.out.println(
                                        " d -> Deposit \n w -> Withdraw Money \n r -> Request Balance \n q -> Quit \n");
                                System.out.print("> ");
                                String choiceOperation = scanner.nextLine();

                                // Operations

                                // If Deposit
                                if (choiceOperation.equalsIgnoreCase("d")) {
                                    // Add balance to account
                                    System.out.print("Amount to deposit: $");
                                    String amountToDeposit = scanner.nextLine(); // Input amount to deposit
                                    object.depositAmount(Integer.parseInt(amountToDeposit));
                                    System.out.println("$" + amountToDeposit + " deposited successfully.");
                                    System.out.println("new amount: " + object.getAmount());

                                    objects.add(object);

                                } else if (choiceOperation.equalsIgnoreCase("r")) {
                                    // Show Account Balance
                                    System.out.println("Your balance is $" + object.getAmount());

                                    objects.add(object);

                                } else if (choiceOperation.equalsIgnoreCase("w")) {
                                    // Withdraw balance from account
                                    System.out.print("Amount of withdrawal: $");
                                    String amountToWithdraw = scanner.nextLine(); // Input amount to deposit
                                    System.out.println("$" + amountToWithdraw + " withdrawn successfully.");

                                    objects.add(object);

                                } else if (choiceOperation.equalsIgnoreCase("q")) {
                                    System.out.println("Thanks for stopping by!");
                                    objects.add(object);

                                    break;
                                }
                            }

                            // Write Objects Back
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.ser"));

                            out.writeObject(objects);
                            out.flush();
                            out.close();

                            objects.clear();
                            // Operations
                        }
                    }
                }

                // If user not found
                if (!loggedIn) {
                    System.out.println("******** LOGIN FAILED! Please try again. Good bye ********");
                }

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