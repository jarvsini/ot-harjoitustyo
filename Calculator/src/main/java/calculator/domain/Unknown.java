package calculator.domain;

/**
 * Tuntemattoman operaation käsittelevä luokka
 */
public class Unknown extends Operator {

    public Unknown() {
    }
    /**
     * metodi ei tee luvuille mitään
     * @param firstNumber
     * @param secondNumber
     * @return palauttaa 0
     */
    @Override
    int run(int firstNumber, int secondNumber) {
        return 0;
    }


    
}
