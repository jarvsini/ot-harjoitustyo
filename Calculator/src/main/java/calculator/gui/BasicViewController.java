package calculator.gui;

import calculator.domain.Model;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * BasicViewin muutoksista ja tapahtumista vastaava luokka, käsittelee klikkaukset, toimii näkymän ja modelin välillä
 */
public class BasicViewController implements EventHandler {
    
    private Model model;
    private BasicView view;
    
    private String operator;
    
    /**
     * tuntee sekä näkymän että mallin, jotka eivät toisiaan
     * @param view näkymä, jota käsitellään
     * @param model malli, jossa sovelluslogiikka tapahtuu
     */
    public BasicViewController(BasicView view, Model model) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
        operator = "";
    }
    

    /**
     * Metodi käsittelee nappien painallukset
     * @param event käyttäjän napin klikkauksesta aiheutunut tapahtuma 
     */
    @Override
    public void handle(Event event) {
        String value = ((Button)event.getSource()).getText();
        if(value.equals("C")) {
            view.setOutput("");
            view.setResult("0");
            operator = "";
            return;
        }
        if(value.equals("=")) {
            handleEqual();
            return;
        }
        if(value.equals("M")) {
            model.tulostahistoria();
            return; 
       }
        if (isOperator(value)) {
            handleOperator(value);
            return;
        }
        if(view.getOutput().length() > 11) {
            return;
        }
        view.setOutput(view.getOutput()+value);
        
    }
    
    /**
     * Metodi tarkistaa, onko kaikki tarvittava laskun suoritukseen ja lopulta kutsuu sovelluslogiikkaa eli modelia
     */
    public void handleEqual() {
        if(view.getOutput().equals("")) {
            return;
        }
        if(operator.equals("")) {
            view.setResult(view.getOutput());
            view.setOutput("");
            return;
        }        
        String output = view.getOutput();
        if(output.endsWith(operator)) {
            return;
        }
        String splitter = operator;
        if(operator.equals("+")) {
            splitter = "\\+";
        }
        String[] parts = output.split(splitter);
        int firstNumber = Integer.valueOf(parts[0]);
        int secondNumber = Integer.valueOf(parts[1]);

        view.setResult("" + model.calculateTwoNumbers(firstNumber, secondNumber, operator));
        view.setOutput("");
        operator = "";
    }
    /**
     * Tarkistaa, onko kysytty operaatio sallittu laskutoiminta
     * @param txt napin nimestä saatu operaatio
     * @return palauttaa totuusarvon sen mukaan, onko
     */
    private boolean isOperator(String txt) {
        if(txt.equals("+")) {
            return true;
        }
        if(txt.equals("--")) {
            return true;
        }
        if(txt.equals("x")) {
            return true;
        }
        return txt.equals("/");
    }

    /**
     * Metodi käsittelee operaation
     * @param value näppäimen nimenä saatu operaatio
     */
    private void handleOperator(String value) {
        if(!operator.equals("")) {
            return;
        }
        operator = value;
        if(view.getOutput().equals("")) {
            view.setOutput(view.getResult() + value);
            return;
        }
        view.setResult(view.getOutput());
        view.setOutput(view.getResult() + value);    
   
    }



    
}
