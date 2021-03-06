package calculator.gui;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Ulkonäöstä vastaava luokka, muodostaa näppäimet ja labelit
 */

public class BasicView extends BorderPane {
    
    private GridPane buttons;
    private Label result;
    private Label output;
    
    private ArrayList<Button> buttonList;

    public BasicView() {
        buttonList = new ArrayList<>();
       
        buttons = new GridPane();
        
        int n = 1;
        for (int x = 3; x >= 1; x--) {
            for (int y = 1; y <= 3; y++) {
                Button b = new Button(""+n);
                b.setMinSize(50, 50);
                buttonList.add(b);
                buttons.add(b, y, x);
                n++;
            }
        }
        
        Button zero = new Button("0");
        zero.setMinSize(50, 50);
        buttonList.add(zero);
        buttons.add(zero, 2, 4);
        
        Button equal = new Button("=");
        equal.setMinSize(50, 50);
        buttonList.add(equal);        
        buttons.add(equal, 3, 4);
        
        buttons.add(createOperatorButton("/"), 4, 1);
        buttons.add(createOperatorButton("x"), 4, 2);
        buttons.add(createOperatorButton("--"), 4, 3);
        buttons.add(createOperatorButton("+"), 4, 4);
        
        Button clear = new Button("C");
        clear.setMinSize(50, 50);
        clear.setMaxSize(50, 50);
        buttonList.add(clear);
        buttons.add(clear, 1, 4);
        
        Button memory = new Button("M");
        memory.setStyle("-fx-base: red;");
        memory.setMinSize(50, 25);
        buttonList.add(memory);
        buttons.add(memory, 1, 5);
        
        buttons.setHgap(10);
        buttons.setVgap(10);
        
        result = new Label("0");
        result.setStyle("-fx-font-size: 30px");
        
        output = new Label("");
        output.setStyle("-fx-font-size: 20px");
        
        setBottom(buttons);
        setTop(result);
        setLeft(output);
        
    }
    /**
     * Metodi luo napin ja lisää sen nappilistalle
     * @param title napin nimi eli operaation symboli
     * @return palauttaa nappi-olion
     */
    private Button createOperatorButton(String title) {
        Button b = new Button(title);
        b.setMinSize(50, 50);
        buttonList.add(b);
        return b; 
    }
    /**
     * Asettaa kontrollerin eli nappien painallusten kuuntelijan
     * @param listener 
     */
    public void setController(EventHandler listener){
        for (Button b : buttonList) {
            b.setOnAction(listener);
        }
    }
    
    public String getOutput() {
        return output.getText();
    }
    
    public String getResult() {
        return result.getText();
    }
    
    public void setOutput(String txt) {
        output.setText(txt);
    }
    
    public void setResult(String txt) {
        result.setText(txt);
    }

    
    
}
