
package calculator.domain;


public class Model {
    
    //tänne komennot hashmappiin, oma luokka command jonka voi suorittaa ja periytyy sitten kaikille muille
    
    Double result = 0.0;
    
    public Double calculate(Double number1, Double number2, String operator) {
        if(operator.equals("+")) {
            result = number1 + number2;
        }
        if(operator.equals("-")) {
            result = number1 - number2;
        }
        if(operator.equals("x")) {
            result = number1 * number2;
        }
        if(operator.equals("/")) {
            result = number1 / number2;
        }
        return result;
    }
}
