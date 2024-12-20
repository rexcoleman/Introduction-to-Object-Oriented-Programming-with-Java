import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld_AnonymousInnerClass extends Application {
    
    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("Hello World Program");

        Button btn = new Button();
        btn.setText("Print Hello World!");

        EventHandler<ActionEvent> handler = new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        };
        
        // Attach the handler to the button
        btn.setOnAction(handler);

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 300);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}