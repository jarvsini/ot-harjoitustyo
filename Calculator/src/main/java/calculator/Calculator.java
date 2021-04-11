
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
        
        BorderPane view = new BorderPane();
        
        GridPane buttons = new GridPane();
        
        int n=1;
        for (int x = 3; x >= 1; x--) {
            for (int y = 1; y <= 3; y++) {
                buttons.add(new Button(""+n), y, x);
                n++;
            }
        }
        
        buttons.add(new Button("."), 1, 4);
        buttons.add(new Button("0"), 2, 4);
        buttons.add(new Button("="), 3, 4);
        
        buttons.add(new Button("/"), 4, 1);
        buttons.add(new Button("x"), 4, 2);
        buttons.add(new Button("-"), 4, 3);
        buttons.add(new Button("+"), 4, 4);
        
        
        buttons.setHgap(10);
        buttons.setVgap(10);
            
        view.setCenter(buttons);
        view.setTop(new TextField());

        Scene scene = new Scene(view);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
