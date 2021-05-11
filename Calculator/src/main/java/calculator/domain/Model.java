package calculator.domain;

import calculator.data.History;
import java.util.HashMap;

/**
 * Laskimen mallista vastaava luokka, jossa varsinainen laskenta tapahtuu,
 * saa parametrit kontrollerilta, ei tunne käyttöliittymää
 */

public class Model {
    private HashMap<String, Operator> operators;
    private Operator unknown;
    
    private History history;

    public Model() {
        operators = new HashMap<String, Operator>();
        operators.put("+", new Addition());
        operators.put("--", new Subtraction());
        operators.put("/", new Division());
        operators.put("x", new Multiplication());
        unknown = new Unknown();
        history = new History();
    }

    public Operator getOperator(String operator) {
        return operators.getOrDefault(operator, unknown);
    }
    
    /**
    * Metodi suorittaa annetun operaation annetuilla luvuilla
    *
    * @param  firstNumber   Kontrollerin ensimmäiseksi antava numero
    * @param  secondNumber  Kontrollerin toisena antava numero
    * @param  operator      Laskuoperaatio, joka halutaan suorittaa
    *
    * @return laskun tulos
    */
    public int calculateTwoNumbers(int firstNumber, int secondNumber, String operator) {
        int result = getOperator(operator).run(firstNumber, secondNumber);
        history.writeHistory(firstNumber + operator + secondNumber + "=" + result);
        return result;
    }
    
    /**
     * Metodi tulostaa laskimen muistista, history.txt -tiedostosta, aiemmin suoritetut laskut
     */
    public void tulostahistoria() {
        history.readHistory();        
    }
    



}