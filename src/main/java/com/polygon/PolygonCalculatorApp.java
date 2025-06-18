package com.polygon;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PolygonCalculatorApp extends Application {
    
    private TextField sidesInput;
    private TextField sideLength;
    private Label areaResult;
    private Label perimeterResult;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Regular Polygon Area & Perimeter Calculator");
        
        // Create UI components
        Label titleLabel = new Label("Regular Polygon Calculator");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        
        Label sidesLabel = new Label("Number of sides:");
        sidesInput = new TextField();
        sidesInput.setPromptText("Enter number of sides (3 or more)");
        sidesInput.setPrefWidth(200);
        
        Label lengthLabel = new Label("Side length:");
        sideLength = new TextField();
        sideLength.setPromptText("Enter side length");
        sideLength.setPrefWidth(200);
        
        Button calculateButton = new Button("Calculate");
        calculateButton.setPrefWidth(150);
        calculateButton.setOnAction(e -> calculatePolygon());
        
        areaResult = new Label("Area: ");
        areaResult.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        perimeterResult = new Label("Perimeter: ");
        perimeterResult.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        Button clearButton = new Button("Clear");
        clearButton.setPrefWidth(150);
        clearButton.setOnAction(e -> clearFields());
        
        // Layout
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
            titleLabel,
            sidesLabel,
            sidesInput,
            lengthLabel,
            sideLength,
            calculateButton,
            areaResult,
            perimeterResult,
            clearButton
        );
        
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private void calculatePolygon() {
        try {
            int sides = Integer.parseInt(sidesInput.getText().trim());
            double length = Double.parseDouble(sideLength.getText().trim());
            
            if (sides < 3) {
                showAlert("Error", "Number of sides must be 3 or more!");
                return;
            }
            
            if (length <= 0) {
                showAlert("Error", "Side length must be positive!");
                return;
            }
            
            // Calculate perimeter (simple: sides * length)
            double perimeter = sides * length;
            
            // Calculate area using the formula: (sides * length^2) / (4 * tan(π/sides))
            double area = (sides * Math.pow(length, 2)) / (4 * Math.tan(Math.PI / sides));
            
            // Display results
            areaResult.setText(String.format("Area: %.2f square units", area));
            perimeterResult.setText(String.format("Perimeter: %.2f units", perimeter));
            
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter valid numbers!");
        }
    }
    
    private void clearFields() {
        sidesInput.clear();
        sideLength.clear();
        areaResult.setText("Area: ");
        perimeterResult.setText("Perimeter: ");
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
