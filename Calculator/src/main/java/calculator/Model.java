
package calculator;


public class Model {
    
    long result = 0;
    
    public long calculate(long number1, long number2, String operator) {
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
