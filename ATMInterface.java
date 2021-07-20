import java.io.*;
import java.rmi.*; // Remote, RemoteException

// Interface
interface ATMInterface extends Remote {
    // Definition
    String initialize() throws RemoteException;

    String createAccount(String username, String password) throws IOException, RemoteException, ClassNotFoundException;

    String request(User object) throws RemoteException, FileNotFoundException, IOException, ClassNotFoundException;

    String withdraw(User object, int amountToWithdraw)
            throws RemoteException, ClassNotFoundException, FileNotFoundException, IOException;

    String deposit(User object, int amountToDeposit)
            throws RemoteException, ClassNotFoundException, FileNotFoundException, IOException;

}