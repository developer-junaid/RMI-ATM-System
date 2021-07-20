
// Import
import java.rmi.*; // Remote, RemoteException, NotBoundException, Naming
import java.net.*; // MalformedURLException
import java.util.*; // Scanner
import java.io.*; // File, IOException, FileOutputStream, FileInputStream, FileNotFoundException, ObjectInputStream, ObjectOutputStream

// Developer: Junaid (IT/2K18/50)

// Client
class Client {

    // Variables
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> objects = new ArrayList<>();
    static String choice = "";
    static String fileName = "data.ser";

    // Main
    public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException,
            IOException, FileNotFoundException, ClassNotFoundException, EOFException {
        // Variables
        ATMInterface ATM = (ATMInterface) Naming.lookup("ATMObject");

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

                System.out.print("Please enter your user name: ");
                String username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();

                // *** Create Account RMI Method *** //
                String response = ATM.createAccount(username, password);
                System.out.println(response);

            } else if (choice.equalsIgnoreCase("l")) {
                // Login
                login(ATM);

            } else if (choice.equalsIgnoreCase("q")) {
                // Exit out of loop
                break;
            }
        }

    }
    // Main

    //////////// Methods //////////////

    // Login
    public static void login(ATMInterface ATM) throws FileNotFoundException, IOException, ClassNotFoundException {
        // If Login is Selected
        Boolean loggedIn = false;

        // Create Account
        System.out.print("Please enter your user name: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Please enter your password: ");
        String passwordInput = scanner.nextLine();

        // Read Objects
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

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
                            // *** Deposit RMI Method *** //
                            System.out.print("Amount to deposit: $");
                            String amountToDeposit = scanner.nextLine(); // Input amount to deposit

                            // RMI Deposit method
                            String response = ATM.deposit(object, Integer.parseInt(amountToDeposit));
                            System.out.println(response);

                        } else if (choiceOperation.equalsIgnoreCase("r")) {
                            // *** Request RMI Method *** //
                            String response = ATM.request(object);
                            System.out.println(response);

                        } else if (choiceOperation.equalsIgnoreCase("w")) {
                            // Withdraw balance from account
                            System.out.print("Amount of withdrawal: $");
                            String amountToWithdraw = scanner.nextLine(); // Input amount to withdraw

                            // *** Withdraw RMI Method *** //
                            String response = ATM.withdraw(object, Integer.parseInt(amountToWithdraw));
                            System.out.println(response);

                        } else if (choiceOperation.equalsIgnoreCase("q")) {
                            System.out.println("Thanks for stopping by!");
                            objects.add(object);

                            break;
                        }
                    }

                }
            }
        }

        // If user not found
        if (!loggedIn) {
            System.out.println("******** LOGIN FAILED! Please try again. Good bye ********");
        }
    }

    // Login

}