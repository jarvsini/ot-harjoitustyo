package calculator.domain;

/**
 * Suorittaa vähennyslaskun kahdella luvulla
 */

public class Subtraction extends Operator {

    public Subtraction() {
    }
    
    @Override
    int run(int firstNumber, int secondNumber) {
        return (firstNumber - secondNumber);
    }


    
}
