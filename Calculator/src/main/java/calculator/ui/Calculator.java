package calculator.ui;

import calculator.domain.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application {
    
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
    
    /*
    private CalculatorController controller = new CalculatorController();

    @Override
    public void start(Stage stage) throws Exception {
                
        BorderPane view = new BorderPane();
        
        GridPane buttons = new GridPane();
        
        int n=1;
        for (int x = 4; x >= 2; x--) {
            for (int y = 1; y <= 3; y++) {
                buttons.add(createNumberButton(""+n), y, x);
                n++;
            }
        }
        
        buttons.add(createNumberButton("."), 1, 5);
        buttons.add(createNumberButton("0"), 2, 5);
        buttons.add(createOperatorButton("="), 3, 5);
        
        buttons.add(createOperatorButton("/"), 4, 2);
        buttons.add(createOperatorButton("x"), 4, 3);
        buttons.add(createOperatorButton("-"), 4, 4);
        buttons.add(createOperatorButton("+"), 4, 5);
              
        Button clear = new Button("AC");
        clear.setOnAction((event) -> {
            controller.clear();
        });
        clear.setMinSize(50, 25);
        clear.setMaxSize(50, 25);
        buttons.add(clear, 1, 1);
                
        buttons.setHgap(10);
        buttons.setVgap(10);
            
        view.setBottom(buttons);
                
        Label result = controller.getResult();
        result.setStyle("-fx-font-size: 30px");
        view.setTop(result);
        
        Label output = controller.getOutput();
        output.setStyle("-fx-font-size: 20px");
        view.setLeft(output);
        
        Label history = controller.getHistory();});
        view.setRight(history);

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
        button.setMinSize(50, 50);
        return button;                
    }
    
    public Button createOperatorButton(String title) {
        Button button = new Button(title);
        button.setOnAction((event) -> {
            controller.processOperator(event);
        });
        button.setMinSize(50, 50);
        return button; 
    } 
    
    public static void main(String[] args) {
        launch(args);
    }
*/
}