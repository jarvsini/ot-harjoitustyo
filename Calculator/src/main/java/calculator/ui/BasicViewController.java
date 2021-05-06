/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.ui;

import calculator.domain.Model;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author jarvsini
 */
public class BasicViewController implements EventHandler {
    
    private Model model;
    private BasicView view;
    
    private boolean readingNumber;
    private String operator;

    public BasicViewController(BasicView view, Model model) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
        this.readingNumber = false;
        this.operator = "";
    }
    

    @Override
    public void handle(Event event) {
        String value = ((Button)event.getSource()).getText();
        if(value.equals("AC")) {
            view.resetOutput("");
            view.setResult("0");
            return;
        }
        if(value.equals("=")) {
            this.handleEqual();
            return;
        }
        if (this.isOperator(value)) {
            this.handleOperator(value);
            return;
        }
        readingNumber = true;
        view.addToOutput(value);
        
    }
    
    private void handleEqual() {
        String output = view.getOutput();
        String[] parts = output.split(this.operator);
        int number1 = Integer.valueOf(parts[0]);
        int number2 = Integer.valueOf(parts[1]);
        view.setResult(number1 + this.operator + number2);
    }
    
    private boolean isOperator(String txt) {
        if(txt.equals("+")) {
            return true;
        }
        if(txt.equals("-")) {
            return true;
        }
        if(txt.equals("x")) {
            return true;
        }
        return txt.equals("/");
    }

    private void handleOperator(String value) {
        if(!this.operator.equals("")) {
            return;
        }
        if(!this.readingNumber) {
            return;
        }
        this.operator = value;
        view.addToOutput(value);
        this.readingNumber = false;
    }

    
}
