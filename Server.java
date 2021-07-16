
// Import
import java.rmi.*; // Remote, RemoteException, NotBoundException, Naming
import java.rmi.server.*; // UnicastRemoteObject
import java.net.*; // MalformedURLException

// Server
class Server {

    public static void main(String args[]) throws RemoteException, MalformedURLException {
        // Logic
        ATMImplementation ATMObject = new ATMImplementation();
        UnicastRemoteObject.exportObject(ATMObject);
        Naming.rebind("ATMObject", ATMObject);
        System.out.println("Server Started.");

    }

}