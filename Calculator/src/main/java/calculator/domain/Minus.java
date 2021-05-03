package calculator.domain;

public class Minus extends Operator {

    public Minus() {
    }

    @Override
    Double run(Double num1, Double num2) {
        return num1 - num2;
    }

    
}
