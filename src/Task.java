import java.io.Serializable;

public class Task implements Serializable {

    private double operand1;
    private double operand2;
    private String constanta;

    public Task() {}

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setConstanta(String constanta){
        this.constanta = constanta;
    }

    public String getConstanta(){return constanta;}

}
