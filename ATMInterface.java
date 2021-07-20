import java.io.IOException;
import java.rmi.*; // Remote, RemoteException

// Interface
interface ATMInterface extends Remote {
    // Definition
    String initialize() throws RemoteException;

    String createAccount(String username, String password) throws IOException, RemoteException, ClassNotFoundException;

    String request(User object) throws RemoteException;

}