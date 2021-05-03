package calculator.domain;


public class Times extends Operator {

    public Times() {
    }

    @Override
    Double run(Double num1, Double num2) {
        return num1 * num2;
    } 
}
