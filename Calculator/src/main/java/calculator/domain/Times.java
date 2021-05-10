package calculator.domain;

/**
 * Suorittaa kertolaskun kahdella luvulla
 */

public class Times extends Operator {

    public Times() {
    }

    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
