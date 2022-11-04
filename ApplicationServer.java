import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ApplicationServer extends Server {

    public ApplicationServer() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException {

        // Connecting to the database from the server
        try {
            Server server = new Server();

            Server stub = (Server) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Server", stub);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}