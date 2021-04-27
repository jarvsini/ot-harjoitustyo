package calculator.domain;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    private Label result;
    private long number1;
    private String operator;
    private boolean start;
    private Model model;

    public CalculatorController() {
        result = new Label();
        number1 = 0;
        operator = "";
        start = true;
        model = new Model();
    }
    
    
    
    public void processNumbers(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText() + value);
    }
    
    public void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        
        if(!value.equals("=")) {
            if(!operator.isEmpty()) {
                return;
            }      
            operator = value;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        } else {
            if(operator.isEmpty()) {
                return;
            }
            long number2 = Long.parseLong(result.getText());
            float output = model.calculate(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator = "";
            start = true;
        }
    }
        
        
    
    
    public Label getResult() {
        return result;
    }

    
    
}