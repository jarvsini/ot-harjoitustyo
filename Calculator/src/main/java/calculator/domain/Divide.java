package calculator.domain;

/**
 * Suorittaa jakolaskun kahdella luvulla
 */

public class Divide extends Operator {

    public Divide() {
    }

    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }   
}
