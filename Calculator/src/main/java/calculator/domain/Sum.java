package calculator.domain;

/**
 * Suorittaa yhteenlaskun kahdella luvulla
 */

public class Sum extends Operator {    

    public Sum() {
    }

    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

 
    
}
