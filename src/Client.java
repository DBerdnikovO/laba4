import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {
    }

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Task task = new Task();
            Scanner input = new Scanner(System.in);
            Registry registry = LocateRegistry.getRegistry(host);
            Calculator stub = (Calculator) registry.lookup("Calculator");
            System.out.println("Input X");
            task.setOperand1(input.nextDouble());
            System.out.println("Input Y");
            task.setOperand2(input.nextDouble());
            System.out.println("Input operator");
            task.setConstanta(input.next());
            double answer = stub.calculate(task);
            System.out.println("answer:" + answer);

        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}