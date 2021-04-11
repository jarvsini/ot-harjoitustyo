
package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button n7 = new Button("7");
        Button n8 = new Button("8");
        Button n9 = new Button("9");
        Button n4 = new Button("4");
        Button n5 = new Button("5");
        Button n6 = new Button("6");
        Button n1 = new Button("1");
        Button n2 = new Button("2");
        Button n3 = new Button("3");
        Label tulos = new Label("0");
        
        GridPane buttons = new GridPane();

        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                buttons.add(new Button("" + x + ", " ), x, y);
            }
        }

        
        FlowPane komponentit = new FlowPane();
        komponentit.getChildren().add(tulos);
        komponentit.getChildren().add(n7);
        komponentit.getChildren().add(n8);
        komponentit.getChildren().add(n9);
        komponentit.getChildren().add(n4);
        komponentit.getChildren().add(n5);
        komponentit.getChildren().add(n6);
        komponentit.getChildren().add(n1);
        komponentit.getChildren().add(n2);
        komponentit.getChildren().add(n3);
        
        
        komponentit.setPrefSize(400, 600);
        
        


        Scene scene = new Scene(komponentit);
        stage.setTitle("Laskin");
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
