package calculator.domain;

/**
 * Suorittaa yhteenlaskun kahdella luvulla
 */

public class Addition extends Operator {    

    public Addition() {
    }

    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

 
    
}
