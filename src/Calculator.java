import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    double calculate(Task task) throws RemoteException;
}