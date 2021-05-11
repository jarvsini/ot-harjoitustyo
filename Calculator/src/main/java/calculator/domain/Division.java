package calculator.domain;

/**
 * Luokka vastaa jakolaskusta
 */

public class Division extends Operator {

    public Division() {
    }

    /**
     * 
     * @param firstNumber
     * @param secondNumber
     * @return annettujen lukujen jakolaskun tulos
     */
    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }   
}
