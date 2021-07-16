import java.rmi.*; // Remote, RemoteException

// Interface
interface ATMInterface extends Remote {
    // Definition
    String initialize() throws RemoteException;
}