package calculator.domain;

/**
 * Suorittaa yhteenlaskun kahdella luvulla
 */

public class Sum extends Operator {    

    public Sum() {
    }

    @Override
    Double run(Double num1, Double num2) {
        return num1 + num2;
    } 
    
}
