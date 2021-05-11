package calculator.domain;

/**
 * Luokka vastaa yhteenlaskusta
 */

public class Addition extends Operator {    

    public Addition() {
    }

    /**
     * 
     * @param firstNumber
     * @param secondNumber
     * @return annettujen lukujen yhteenlaskun tulos
     */
    @Override
    int run(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

 
    
}
