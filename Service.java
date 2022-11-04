import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Service extends Remote {

    String print(String filename, String printer) throws RemoteException;

    String queue(String printer) throws RemoteException;

    String topQueue(String printer, int job) throws RemoteException;

    String start() throws RemoteException;

    String stop() throws RemoteException;

    String restart() throws RemoteException;

    String status(String printer) throws RemoteException;

    String readConfig(String parameter) throws RemoteException;

    String setConfig(String parameter, String value) throws RemoteException;

    // This function was supposed to be used to access
    // The database of User_ID, Username and Password
    public List<Worker> getCredentials() throws Exception;
}