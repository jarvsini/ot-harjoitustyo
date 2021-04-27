
package calculator.ui;

import calculator.domain.CalculatorController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    
    private CalculatorController controller = new CalculatorController();

    @Override
    public void start(Stage stage) throws Exception {
                
        BorderPane view = new BorderPane();
        
        GridPane buttons = new GridPane();
        
        int n=1;
        for (int x = 3; x >= 1; x--) {
            for (int y = 1; y <= 3; y++) {
                buttons.add(createNumberButton(""+n), y, x);
                n++;
            }
        }
        
        buttons.add(createOperatorButton("."), 1, 4);
        buttons.add(createNumberButton("0"), 2, 4);
        buttons.add(createOperatorButton("="), 3, 4);
        
        buttons.add(createOperatorButton("/"), 4, 1);
        buttons.add(createOperatorButton("x"), 4, 2);
        buttons.add(createOperatorButton("-"), 4, 3);
        buttons.add(createOperatorButton("+"), 4, 4);
                
        buttons.setHgap(10);
        buttons.setVgap(10);
            
        view.setCenter(buttons);
        
        Label result = controller.getResult();
        view.setTop(result);

        Scene scene = new Scene(view);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
    
    public Button createNumberButton(String title) {
        Button button = new Button(title);
        button.setOnAction((event) -> {
            controller.processNumbers(event);
        });
        return button;                
    }
    
    public Button createOperatorButton(String title) {
        Button button = new Button(title);
        button.setOnAction((event) -> {
            controller.processOperator(event);
        });
        return button; 
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
}