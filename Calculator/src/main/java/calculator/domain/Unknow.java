package calculator.domain;

/**
 * Tuntemattomasta operaatiosta vastaava luokka
 */
public class Unknow extends Operator {

    public Unknow() {
    }

    @Override
    Double run(Double num1, Double num2) {
        return 0.0;
    }
    
}
