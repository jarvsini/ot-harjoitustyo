package calculator.domain;

public abstract class Operator {

    public Operator() {
    }
    
    abstract Double run(Double num1, Double num2);
    
}
