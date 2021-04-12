package calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    private TextField result = new TextField();
    private long number1 = 0;
    private long number2 = 0;
    private String operator = "";
    
    public void processNumbers(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText() + value);
    }
    
    public void processOperator(ActionEvent event) {
        result.setText("+");
    }
    
    public TextField getResult() {
        return result;
    }
    
    public long getNumber1() {
        return number1;
    }
    
    public long getNumber2() {
        return number2;
    }
    
}
