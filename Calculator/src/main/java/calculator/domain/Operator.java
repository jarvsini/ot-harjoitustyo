package calculator.domain;
/**
 * 
 * Luokka käsittelee lukuja ja palauttaa uuden luvun
 */
public abstract class Operator {

    public Operator() {
    }
    /**
     * metodi saa kaksi numeroa, joilla tekee jotain ja palauttaa uuden
     * @param firstNumber 
     * @param secondNumber
     * @return tulos
     */
    abstract int run(int firstNumber, int secondNumber);
    
}
