import java.rmi.*; // Remote, RemoteException

// Implementation
class ATMImplementation implements ATMInterface {
    // Logic
    public String initialize() throws RemoteException {
        return "Initialized";
    }
}