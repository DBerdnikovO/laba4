import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calculator {
    public Server() {}
    
    public double calculate(Task task) throws RemoteException {

        switch (task.getConstanta()) {

            case "*":
                return task.getOperand1()*task.getOperand2();
            case "/":
                return task.getOperand1()/task.getOperand2();
            case "+":
                return task.getOperand1()+task.getOperand2();
            case "-":
                return task.getOperand1()-task.getOperand2();
        }

        return 0;
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Calculator", stub);

            System.err.println("Server ready");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}