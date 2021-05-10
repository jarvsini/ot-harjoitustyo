package calculator.domain;

import calculator.data.History;
import java.util.HashMap;

/**
 * Laskimen mallista vastaava luokka, sisältää laskimen varsinaiset laskuoperaatiot
 */

public class Model {
    private HashMap<String, Operator> operators;
    private Operator unknown;
    
    private History history;

    public Model() {
        operators = new HashMap<String, Operator>();
        operators.put("+", new Sum());
        operators.put("--", new Minus());
        operators.put("/", new Divide());
        operators.put("x", new Times());
        unknown = new Unknow();
        history = new History();
    }

    public Operator get(String operator) {
        return operators.getOrDefault(operator, unknown);
    }
    
    public int calculateTwoNumbers(int firstNumber, int secondNumber, String operator) {
        int result = get(operator).run(firstNumber, secondNumber);
        history.writeHistory( firstNumber + operator + secondNumber + "=" + result + ",");
        return result;
    }
    
    public void tulostahistoria() {
        history.readHistory();
        
    }
    



}