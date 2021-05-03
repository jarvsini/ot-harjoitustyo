package calculator.domain;

/**
 * Suorittaa jakolaskun kahdella luvulla
 */

public class Divide extends Operator {

    public Divide() {
    }

    @Override
    Double run(Double num1, Double num2) {
        return num1 / num2;
    }    
}
