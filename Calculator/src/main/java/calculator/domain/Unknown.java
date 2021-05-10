package calculator.domain;

/**
 * Tuntemattoman operaation käsittelevä luokka
 */
public class Unknown extends Operator {

    public Unknown() {
    }

    @Override
    int run(int firstNumber, int secondNumber) {
        return 0;
    }


    
}
