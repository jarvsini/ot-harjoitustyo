package calculator.domain;

/**
 * Luokka vastaa vähennyslaskusta
 */

public class Subtraction extends Operator {

    public Subtraction() {
    }
    
    /**
     * 
     * @param firstNumber
     * @param secondNumber
     * @return annettujen lukujen vähennyslaskun tulos
     */
    @Override
    int run(int firstNumber, int secondNumber) {
        return (firstNumber - secondNumber);
    }


    
}
