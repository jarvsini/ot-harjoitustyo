package calculator.gui;

import calculator.domain.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Graafisen käyttöliittymän kokoava luokka
 */

public class CalculatorFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        
        BasicView view = new BasicView();
        BasicViewController controller = new BasicViewController(view, model);
        
        Scene scene = new Scene(view, 250, 350);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}