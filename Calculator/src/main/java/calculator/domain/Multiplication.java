package calculator.domain;

/**
 * Luokka vastaa kertolaskusta
 */

public class Multiplication extends Operator {

    public Multiplication() {
    }

    /**
     * 
     * @param firstNumber
     * @param secondNumber
     * @return annettujen lukujen kertolaskun tulos
     */
    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
