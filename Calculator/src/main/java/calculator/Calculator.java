
package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        CalculatorController controller = new CalculatorController();
        
        BorderPane view = new BorderPane();
        
        GridPane buttons = new GridPane();
        
        int n=1;
        for (int x = 3; x >= 1; x--) {
            for (int y = 1; y <= 3; y++) {
                Button b = new Button(""+n);
                b.setOnAction((event) -> {
                    controller.processNumbers(event);
                });
                buttons.add(b, y, x);
                n++;
            }
        }
        
        Button dot = new Button(".");
        dot.setOnAction((event) -> {
            controller.processOperator(event);
        });
        buttons.add(dot, 1, 4);
        
        Button zero = new Button("0");
        zero.setOnAction((event) -> {
            controller.processNumbers(event);
        }
        );
        buttons.add(zero, 2, 4);
        
        Button equal = new Button("=");
        equal.setOnAction((event) -> {
            controller.processOperator(event);
        });
        buttons.add(equal, 3, 4);
        
        Button divide = new Button("/");
        divide.setOnAction((event) -> {
            controller.processOperator(event);
        });
        buttons.add(divide, 4, 1);
        
        Button times = new Button("x");
        times.setOnAction((event) -> {
            controller.processOperator(event);
        });
        buttons.add(times, 4, 2);
        
        Button minus = new Button("-");
        minus.setOnAction((event) -> {
            controller.processOperator(event);
        });
        buttons.add(minus, 4, 3);
        
        Button plus = new Button("+");
        plus.setOnAction((event) -> {
            controller.processOperator(event);
        });
        buttons.add(plus, 4, 4);
        
        
        buttons.setHgap(10);
        buttons.setVgap(10);
            
        view.setCenter(buttons);
        
        TextField textfield = controller.getResult();
        view.setTop(textfield);

        Scene scene = new Scene(view);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
