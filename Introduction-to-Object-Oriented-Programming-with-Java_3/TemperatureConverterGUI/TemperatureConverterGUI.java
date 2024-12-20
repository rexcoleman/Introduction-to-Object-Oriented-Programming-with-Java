import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TemperatureConverterGUI extends Application {
    public void start(Stage stage) {
        // Create UI components that were missing
        TextField userInput = new TextField();
        Label inputValue = new Label("Temperature: ");
        Label from = new Label("From:");
        Label to = new Label("To:");
        Label result = new Label("Result will appear here");

        Button convertButton = new Button();
        convertButton.setText("Convert");

        ComboBox<String> pickScaleFrom = new ComboBox<>();
        ComboBox<String> pickScaleTo = new ComboBox<>();
        pickScaleFrom.getItems().add("Fahrenheit");
        pickScaleFrom.getItems().add("Celsius");

        pickScaleTo.getItems().add("Fahrenheit");
        pickScaleTo.getItems().add("Celsius");

        pickScaleFrom.getSelectionModel().selectFirst();
        pickScaleTo.getSelectionModel().selectLast();

        convertButton.setOnAction(event -> {
            String temperatureString = userInput.getText();
            try {
                double temperature = Double.parseDouble(temperatureString);
                String scaleFrom = pickScaleFrom.getValue();
                String scaleTo = pickScaleTo.getValue();
                double conversionResult = convert(scaleFrom, scaleTo, temperature);
                result.setText(String.format("%.2f", conversionResult));
            } catch (NumberFormatException e) {
                Alert a = new Alert(AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid Temperature");
                a.setContentText("That is not a valid Temperature.");
                a.showAndWait();
            }
        });

        HBox input = new HBox();
        input.setAlignment(Pos.CENTER);
        input.getChildren().add(inputValue);
        input.getChildren().add(userInput);

        HBox scales = new HBox();  // Fixed typo in HBox
        scales.setAlignment(Pos.CENTER);
        scales.setSpacing(10);
        scales.getChildren().add(from);
        scales.getChildren().add(pickScaleFrom);
        scales.getChildren().add(to);
        scales.getChildren().add(pickScaleTo);

        VBox root = new VBox();    // Fixed typo in VBox
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().add(input);
        root.getChildren().add(scales);
        root.getChildren().add(convertButton);
        root.getChildren().add(result);

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    private double convert(String from, String to, double value) {
        double converted = 0;
        if (from.equals(to)) {
            converted = value;
        } else if (from.charAt(0) == 'F') {
            converted = (value - 32) * (5.0 / 9);
        } else {
            converted = value * (9.0 / 5) + 32;
        }
        return converted;
    }

    public static void main(String[] args) {
        launch(args);
    }
}