package calculator.domain;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    private Label result;
    private Label output;
    private Label history;
    private Double number1;
    private String operator;
    private boolean readingNumbers;
    private Model model;

    public CalculatorController() {
        result = new Label("");
        output = new Label("");
        history = new Label("");
        readingNumbers = false;
        model = new Model();
        number1 = null;
    }
    
    
    public void processNumbers(ActionEvent event) {
        
        
        if(history.getText().equals("anna numero")) {
            history.setText("");
        }
        String value = ((Button)event.getSource()).getText();
        if(value.equals(".") && output.getText().equals("")) {
            return;
        }
        output.setText(output.getText() + value);
        history.setText(history.getText() + value);
        readingNumbers = true;
                
    }
    
    public void processOperator(ActionEvent event) {
        
        String value = ((Button)event.getSource()).getText();
        
        
        if (number1 != null && output.getText().equals("")) {
            operator = value;
            history.setText(number1 + value);
            return;
        }
        
        if(!readingNumbers) {
            history.setText("anna numero");
            return;
        } 
        
        
        
        if(number1 == null) {
            if (value.equals("=")) {
                return;
            }
            number1 = Double.parseDouble(output.getText());
            operator = value;
            history.setText(number1 + value);
            output.setText("");
            readingNumbers = false;
            return;
        }
        
        
            equal();
             

        
    }

        
    public void processClear(ActionEvent event) {
        clear();
    }
    
    public void clear() {
        result.setText("");
        output.setText("");
        history.setText("");
        operator = "";
        number1 = null;
        readingNumbers = false;
    }
    
    
    public void equal() {
        Double number2 = Double.parseDouble(output.getText());
        String answer = String.valueOf(model.get(operator).run(number1, number2));
        result.setText(answer);
        output.setText("");
        history.setText(history.getText() + "=" + answer + "  ");
        number1=null;
        operator="";
        readingNumbers = false;
    }
    
    
    public Label getResult() {
        return result;
    }


    public Label getOutput() {
        return output;
    }

    public Label getHistory() {
        return history;
    }



    
    
}