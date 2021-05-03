package calculator.domain;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Sovelluslogiikasta vastaava luokka
 */

public class CalculatorController {
    private Label result;
    private Label output;
    private Label history;
    private Double number1;
    private String operator;
    private boolean readingNumbers;
    private Model model;
    private boolean includeDot;

    public CalculatorController() {
        result = new Label("");
        output = new Label("");
        history = new Label("");
        readingNumbers = false;
        model = new Model();
        number1 = null;
        includeDot = false;
    }
    
    /**
    * Käsittelee numeronappulan käyttöliittymässä klikkaamisen
    *
    * @param   event   tapahtuma käyttöliittymästä
    */
    public void processNumbers(ActionEvent event) {  
        if(history.getText().equals("anna numero")) {
            history.setText("");
        }
        String value = ((Button)event.getSource()).getText();
        
        if (value.endsWith(".")) {
            processDot();
            return;
        }
        
        output.setText(output.getText() + value);
        history.setText(history.getText() + value);
        readingNumbers = true;                
    }
    
    /**
    * Käsittelee muun kuin numeronappulan käyttöliittymässä klikkaamisen
    *
    * @param   event   tapahtuma käyttöliittymästä
    */
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
    

    /**
    * Nollaa laskimen, asettaa tuloksen tyhjäksi
    */
    public void clear() {
        result.setText("");
        output.setText("");
        history.setText("");
        operator = "";
        number1 = null;
        readingNumbers = false;
    }
    
    /**
    * Käsittelee binäärioperaation loppuun ja antaa tuloksen
    */    
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

    /**
    * Käsittelee piste-komennon, kirjoittaa pisteen kun sallittu, muuten ei tee mitään
    */
    private void processDot() {
        if(output.getText().equals("") || (includeDot)) {
            return;
        }
        output.setText(output.getText() + ".");
        history.setText(history.getText() + ".");
        includeDot = true;
    }
}