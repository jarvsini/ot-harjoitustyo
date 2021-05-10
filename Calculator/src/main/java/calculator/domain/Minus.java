package calculator.domain;

/**
 * Suorittaa vähennyslaskun kahdella luvulla
 */

public class Minus extends Operator {

    public Minus() {
    }
    
    @Override
    int run(int firstNumber, int secondNumber) {
        return (firstNumber - secondNumber);
    }


    
}
