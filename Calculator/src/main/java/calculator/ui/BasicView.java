/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.ui;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author jarvsini
 */
public class BasicView extends BorderPane {
    
   // private BasicViewController controller;
    private GridPane buttons;
    private Label result;
    private Label output;
    
    private ArrayList<Button> buttonList;

    public BasicView() {
        //controller = new BasicViewController();
        buttonList = new ArrayList<>();
       
        buttons = new GridPane();
        
        int n = 1;
        for (int x = 3; x >= 1; x--) {
            for (int y = 1; y <= 3; y++) {
                Button b = new Button(""+n);
         //       b.setOnAction(pr);
         //       b.setOnAction((event) -> {
         //           controller.processNumber(event);
         //       });
                b.setMinSize(50, 50);
                buttonList.add(b);
                buttons.add(b, y, x);
                n++;
            }
        }
        
        Button zero = new Button("0");
   //     zero.setOnAction((event) -> {
   //         controller.processNumber(event);
   //     });
        zero.setMinSize(50, 50);
        buttonList.add(zero);
        buttons.add(zero, 2, 4);
        
        Button equal = new Button("=");
    //    equal.setOnAction((event) -> {
    //        controller.processEqual(event);
    //    });
        equal.setMinSize(50, 50);
        buttonList.add(equal);        
        buttons.add(equal, 3, 4);
        
        buttons.add(createOperatorButton("/"), 4, 1);
        buttons.add(createOperatorButton("x"), 4, 2);
        buttons.add(createOperatorButton("--"), 4, 3);
        buttons.add(createOperatorButton("+"), 4, 4);
        
        Button clear = new Button("C");
   //     clear.setOnAction((event) -> {
     //       controller.processClear(event);
       // });
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
    
    private Button createOperatorButton(String title) {
        Button b = new Button(title);
    //    button.setOnAction((event) -> {
    //        controller.processOperator(event);
     //   });
        b.setMinSize(50, 50);
        buttonList.add(b);
        return b; 
    }
    
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
