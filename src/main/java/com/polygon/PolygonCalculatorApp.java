package com.polygon;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PolygonCalculatorApp extends Application {
    
    private TextField sidesInput;
    private TextField sideLength;
    private Label areaResult;
    private Label perimeterResult;
    private Canvas canvas;
    private GraphicsContext gc;
    
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
        
        // Create canvas for drawing polygon
        canvas = new Canvas(300, 300);
        gc = canvas.getGraphicsContext2D();
        clearCanvas();
        
        // Left side layout with controls
        VBox leftPanel = new VBox(15);
        leftPanel.setAlignment(Pos.CENTER);
        leftPanel.setPadding(new Insets(20));
        leftPanel.getChildren().addAll(
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
        
        // Right side layout with canvas
        VBox rightPanel = new VBox(10);
        rightPanel.setAlignment(Pos.CENTER);
        rightPanel.setPadding(new Insets(20));
        Label canvasLabel = new Label("Polygon Visualization");
        canvasLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        rightPanel.getChildren().addAll(canvasLabel, canvas);
        
        // Main layout
        HBox root = new HBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(leftPanel, rightPanel);
        
        Scene scene = new Scene(root, 750, 400);
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
            
            // Draw the polygon
            drawPolygon(sides);
            
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter valid numbers!");
        }
    }
    
    private void clearFields() {
        sidesInput.clear();
        sideLength.clear();
        areaResult.setText("Area: ");
        perimeterResult.setText("Perimeter: ");
        clearCanvas();
    }
    
    private void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Set background color
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Draw border
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Draw center point
        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getHeight() / 2;
        gc.setFill(Color.RED);
        gc.fillOval(centerX - 2, centerY - 2, 4, 4);
    }
    
    private void drawPolygon(int sides) {
        clearCanvas();
        
        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getHeight() / 2;
        
        // Use a fixed radius that fits nicely in the canvas
        double radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2 - 30;
        
        // Calculate polygon vertices
        double[] xPoints = new double[sides];
        double[] yPoints = new double[sides];
        
        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides - Math.PI / 2; // Start from top
            xPoints[i] = centerX + radius * Math.cos(angle);
            yPoints[i] = centerY + radius * Math.sin(angle);
        }
        
        // Draw the polygon
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(3);
        gc.setFill(Color.LIGHTBLUE);
        
        // Fill the polygon
        gc.fillPolygon(xPoints, yPoints, sides);
        
        // Draw the polygon outline
        gc.strokePolygon(xPoints, yPoints, sides);
        
        // Draw vertices
        gc.setFill(Color.RED);
        for (int i = 0; i < sides; i++) {
            gc.fillOval(xPoints[i] - 3, yPoints[i] - 3, 6, 6);
        }
        
        // Draw center point
        gc.setFill(Color.BLACK);
        gc.fillOval(centerX - 2, centerY - 2, 4, 4);
        
        // Draw lines from center to vertices (optional - shows structure)
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(1);
        for (int i = 0; i < sides; i++) {
            gc.strokeLine(centerX, centerY, xPoints[i], yPoints[i]);
        }
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
