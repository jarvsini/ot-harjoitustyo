package calculator.domain;

/**
 * Suorittaa kertolaskun kahdella luvulla
 */

public class Multiplication extends Operator {

    public Multiplication() {
    }

    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
