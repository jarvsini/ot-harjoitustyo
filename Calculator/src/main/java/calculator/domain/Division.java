package calculator.domain;

/**
 * Suorittaa jakolaskun kahdella luvulla
 */

public class Division extends Operator {

    public Division() {
    }

    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }   
}
