package calculator.domain;

public abstract class Operator {

    public Operator() {
    }
    
    abstract int run(int firstNumber, int secondNumber);
    
}
