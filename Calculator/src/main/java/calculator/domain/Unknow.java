package calculator.domain;

/**
 * Tuntemattomasta operaatiosta vastaava luokka
 */
public class Unknow extends Operator {

    public Unknow() {
    }

    @Override
    int run(int firstNumber, int secondNumber) {
        return 0;
    }


    
}
