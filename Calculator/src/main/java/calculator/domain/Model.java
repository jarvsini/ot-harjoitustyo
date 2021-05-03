package calculator.domain;

import java.util.HashMap;

/**
 * Laskimen mallista vastaava luokka, sisältää laskimen varsinaiset laskuoperaatiot
 */

public class Model {  
    private HashMap<String, Operator> operators;
    private Operator unknown;

    public Model() {
        operators = new HashMap<String, Operator>();
        operators.put("+", new Sum());
        operators.put("-", new Minus());
        operators.put("/", new Divide());
        operators.put("x", new Times());
        unknown = new Unknow();
    }

    public Operator get(String operator) {
        return operators.getOrDefault(operator, unknown);
    }


}