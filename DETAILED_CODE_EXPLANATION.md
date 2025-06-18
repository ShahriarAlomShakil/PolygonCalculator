# Detailed Code Explanation: PolygonCalculatorApp.java

This document provides a comprehensive line-by-line explanation of the `PolygonCalculatorApp.java` file, which implements a JavaFX application for calculating polygon area and perimeter with visual representation.

## Package Declaration and Imports (Lines 1-14)

### Line 1:
```java
package com.polygon;
```
Declares the package name as `com.polygon`, organizing the class within this namespace to avoid naming conflicts.

### Lines 3-14: Import Statements
```java
import javafx.application.Application;
```
**Line 3**: Imports the `Application` class, which is the base class for all JavaFX applications. Our class must extend this to create a GUI application.

```java
import javafx.geometry.Insets;
```
**Line 4**: Imports `Insets` class for defining padding/margins around UI components.

```java
import javafx.geometry.Pos;
```
**Line 5**: Imports `Pos` enumeration for positioning/alignment of UI elements within containers.

```java
import javafx.scene.Scene;
```
**Line 6**: Imports `Scene` class, which represents the content of a stage (window) in JavaFX.

```java
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
```
**Lines 7-8**: Import canvas-related classes for drawing graphics. `Canvas` provides a drawing surface, and `GraphicsContext` provides the drawing API.

```java
import javafx.scene.control.*;
```
**Line 9**: Wildcard import for all JavaFX control classes (Button, TextField, Label, Alert, etc.).

```java
import javafx.scene.layout.*;
```
**Line 10**: Wildcard import for all JavaFX layout classes (BorderPane, VBox, HBox, etc.).

```java
import javafx.scene.paint.Color;
```
**Line 11**: Imports `Color` class for defining colors in the UI.

```java
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
```
**Lines 12-13**: Import font-related classes for text styling.

```java
import javafx.stage.Stage;
```
**Line 14**: Imports `Stage` class, which represents a window in JavaFX applications.

## Class Declaration and Instance Variables (Lines 16-23)

### Line 16:
```java
public class PolygonCalculatorApp extends Application {
```
Declares the main class `PolygonCalculatorApp` that extends `Application`. This inheritance makes it a JavaFX application that can be launched.

### Lines 18-23: Instance Variables
```java
private TextField sidesInput;
private TextField sideLength;
```
**Lines 18-19**: Declare text fields for user input - number of polygon sides and side length.

```java
private Label areaResult;
private Label perimeterResult;
```
**Lines 20-21**: Declare labels to display calculated area and perimeter results.

```java
private Canvas canvas;
private GraphicsContext gc;
```
**Lines 22-23**: Declare canvas for drawing polygon visualization and its graphics context for drawing operations.

## Main Application Entry Point (Lines 25-51)

### Line 25:
```java
@Override
public void start(Stage primaryStage) {
```
Overrides the abstract `start()` method from `Application` class. This is the main entry point where the UI is constructed and displayed.

### Line 26:
```java
primaryStage.setTitle("Polygon Calculator Pro");
```
Sets the window title that appears in the title bar.

### Lines 28-30:
```java
// Create main container with gradient background
BorderPane root = new BorderPane();
root.setStyle("-fx-background-color: linear-gradient(to bottom, #667eea 0%, #764ba2 100%);");
```
**Line 29**: Creates a `BorderPane` as the root container, which allows positioning components in five regions (top, bottom, left, right, center).
**Line 30**: Applies CSS styling to create a blue-to-purple gradient background.

### Lines 32-34:
```java
// Create header
VBox header = createHeader();
root.setTop(header);
```
Creates the header section by calling `createHeader()` method and positions it at the top of the BorderPane.

### Lines 36-38:
```java
// Create main content area
HBox mainContent = createMainContent();
root.setCenter(mainContent);
```
Creates the main content area and positions it in the center of the BorderPane.

### Lines 40-42:
```java
// Create footer
HBox footer = createFooter();
root.setBottom(footer);
```
Creates the footer section and positions it at the bottom of the BorderPane.

### Line 44:
```java
Scene scene = new Scene(root, 1000, 700);
```
Creates a new Scene with the root BorderPane, setting initial dimensions to 1000x700 pixels.

### Lines 46-47:
```java
// Add CSS styling
scene.getStylesheets().add("data:text/css," + getCustomCSS());
```
Adds custom CSS styling to the scene by calling `getCustomCSS()` method.

### Lines 49-51:
```java
primaryStage.setScene(scene);
primaryStage.setMinWidth(800);
primaryStage.setMinHeight(600);
primaryStage.show();
```
**Line 49**: Sets the scene to the primary stage.
**Line 50**: Sets minimum window width to 800 pixels.
**Line 51**: Sets minimum window height to 600 pixels.
**Line 52**: Makes the window visible.

## Header Creation Method (Lines 54-72)

### Line 55:
```java
private VBox createHeader() {
```
Private method that creates and returns the header section as a VBox container.

### Lines 56-58:
```java
VBox header = new VBox(10);
header.setAlignment(Pos.CENTER);
header.setPadding(new Insets(20, 20, 10, 20));
```
**Line 56**: Creates a VBox with 10 pixels spacing between children.
**Line 57**: Centers all child elements horizontally.
**Line 58**: Sets padding (top: 20, right: 20, bottom: 10, left: 20).

### Lines 60-63:
```java
Label titleLabel = new Label("🔷 Polygon Calculator Pro");
titleLabel.setFont(Font.font("System", FontWeight.BOLD, 32));
titleLabel.setTextFill(Color.WHITE);
titleLabel.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 2);");
```
**Line 60**: Creates main title label with diamond emoji.
**Line 61**: Sets font to bold system font, size 32.
**Line 62**: Sets text color to white.
**Line 63**: Adds drop shadow effect for visual depth.

### Lines 65-67:
```java
Label subtitleLabel = new Label("Calculate area and perimeter of regular polygons");
subtitleLabel.setFont(Font.font("System", FontWeight.NORMAL, 16));
subtitleLabel.setTextFill(Color.LIGHTGRAY);
```
Creates subtitle with description, normal weight font size 16, and light gray color.

### Lines 69-71:
```java
header.getChildren().addAll(titleLabel, subtitleLabel);
return header;
```
Adds both labels to the header VBox and returns it.

## Main Content Creation Method (Lines 74-87)

### Line 75:
```java
private HBox createMainContent() {
```
Creates the main content area as a horizontal box container.

### Lines 76-78:
```java
HBox mainContent = new HBox(30);
mainContent.setAlignment(Pos.CENTER);
mainContent.setPadding(new Insets(20));
```
Creates HBox with 30 pixels spacing, center alignment, and 20 pixels padding.

### Lines 80-85:
```java
// Left panel - Input controls
VBox leftPanel = createInputPanel();

// Right panel - Visualization
VBox rightPanel = createVisualizationPanel();

mainContent.getChildren().addAll(leftPanel, rightPanel);
return mainContent;
```
Creates left panel for inputs, right panel for visualization, adds both to main content, and returns it.

## Input Panel Creation Method (Lines 89-178)

### Lines 90-96:
```java
private VBox createInputPanel() {
VBox panel = new VBox(20);
panel.setAlignment(Pos.TOP_CENTER);
panel.setPrefWidth(350);
panel.setStyle("-fx-background-color: rgba(255, 255, 255, 0.95); " +
              "-fx-background-radius: 15; " +
              "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 5);");
panel.setPadding(new Insets(30));
```
Creates the left input panel with white semi-transparent background, rounded corners, drop shadow, and padding.

### Lines 98-101:
```java
// Input controls section
Label inputLabel = new Label("📐 Input Parameters");
inputLabel.setFont(Font.font("System", FontWeight.BOLD, 18));
inputLabel.setTextFill(Color.valueOf("#2c3e50"));
```
Creates section header with ruler emoji, bold font, and dark blue-gray color.

### Lines 103-117:
```java
// Number of sides input
VBox sidesGroup = new VBox(8);
Label sidesLabel = new Label("Number of Sides");
sidesLabel.setFont(Font.font("System", FontWeight.MEDIUM, 14));
sidesLabel.setTextFill(Color.valueOf("#34495e"));

sidesInput = new TextField();
sidesInput.setPromptText("Enter 3 or more sides");
sidesInput.setPrefHeight(40);
sidesInput.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; " +
                   "-fx-border-color: #bdc3c7; -fx-border-width: 1; " +
                   "-fx-font-size: 14px; -fx-padding: 10;");
// Remove auto-calculation - only calculate when button is pressed

sidesGroup.getChildren().addAll(sidesLabel, sidesInput);
```
Creates the number of sides input group with label and styled text field.

### Lines 119-133:
```java
// Side length input
VBox lengthGroup = new VBox(8);
Label lengthLabel = new Label("Side Length");
lengthLabel.setFont(Font.font("System", FontWeight.MEDIUM, 14));
lengthLabel.setTextFill(Color.valueOf("#34495e"));

sideLength = new TextField();
sideLength.setPromptText("Enter side length");
sideLength.setPrefHeight(40);
sideLength.setStyle("-fx-background-radius: 8; -fx-border-radius: 8; " +
                   "-fx-border-color: #bdc3c7; -fx-border-width: 1; " +
                   "-fx-font-size: 14px; -fx-padding: 10;");
// Remove auto-calculation - only calculate when button is pressed

lengthGroup.getChildren().addAll(lengthLabel, sideLength);
```
Creates the side length input group with similar styling to the sides input.

### Lines 135-154:
```java
// Buttons
HBox buttonBox = new HBox(15);
buttonBox.setAlignment(Pos.CENTER);

Button calculateButton = new Button("🧮 Calculate");
calculateButton.setPrefWidth(120);
calculateButton.setPrefHeight(45);
calculateButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; " +
                        "-fx-background-radius: 8; -fx-font-size: 14px; " +
                        "-fx-font-weight: bold; -fx-cursor: hand;");
calculateButton.setOnAction(e -> calculatePolygon());

Button clearButton = new Button("🗑️ Clear");
clearButton.setPrefWidth(120);
clearButton.setPrefHeight(45);
clearButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; " +
                    "-fx-background-radius: 8; -fx-font-size: 14px; " +
                    "-fx-font-weight: bold; -fx-cursor: hand;");
clearButton.setOnAction(e -> clearFields());

buttonBox.getChildren().addAll(calculateButton, clearButton);
```
Creates Calculate and Clear buttons with styling and event handlers.

### Lines 156-177:
```java
// Results section
VBox resultsGroup = new VBox(15);
Label resultsLabel = new Label("📊 Results");
resultsLabel.setFont(Font.font("System", FontWeight.BOLD, 18));
resultsLabel.setTextFill(Color.valueOf("#2c3e50"));

areaResult = new Label("Area: Press Calculate to see result");
areaResult.setFont(Font.font("System", FontWeight.BOLD, 16));
areaResult.setTextFill(Color.valueOf("#95a5a6"));
areaResult.setStyle("-fx-background-color: #ecf0f1; -fx-padding: 10; -fx-background-radius: 5;");

perimeterResult = new Label("Perimeter: Press Calculate to see result");
perimeterResult.setFont(Font.font("System", FontWeight.BOLD, 16));
perimeterResult.setTextFill(Color.valueOf("#95a5a6"));
perimeterResult.setStyle("-fx-background-color: #ecf0f1; -fx-padding: 10; -fx-background-radius: 5;");

resultsGroup.getChildren().addAll(resultsLabel, areaResult, perimeterResult);

panel.getChildren().addAll(inputLabel, sidesGroup, lengthGroup, buttonBox, resultsGroup);
return panel;
```
Creates the results section with placeholder text and assembles the complete input panel.

## Visualization Panel Creation Method (Lines 181-221)

### Lines 182-188:
```java
private VBox createVisualizationPanel() {
VBox panel = new VBox(20);
panel.setAlignment(Pos.CENTER);
panel.setPrefWidth(500);
panel.setStyle("-fx-background-color: rgba(255, 255, 255, 0.95); " +
              "-fx-background-radius: 15; " +
              "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 5);");
panel.setPadding(new Insets(30));
```
Creates the visualization panel with similar styling to the input panel but wider (500px).

### Lines 190-193:
```java
Label visualLabel = new Label("👁️ Polygon Visualization");
visualLabel.setFont(Font.font("System", FontWeight.BOLD, 18));
visualLabel.setTextFill(Color.valueOf("#2c3e50"));
```
Creates the visualization section header with eye emoji.

### Lines 195-200:
```java
canvas = new Canvas(400, 400);
canvas.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 5, 0, 0, 2);");
gc = canvas.getGraphicsContext2D();
clearCanvas();
addPlaceholderText();
```
Creates a 400x400 pixel canvas with white background and drop shadow, gets graphics context, clears it, and adds placeholder text.

### Lines 202-218:
```java
// Info panel for polygon properties
VBox infoPanel = new VBox(10);
infoPanel.setStyle("-fx-background-color: #f8f9fa; -fx-padding: 15; -fx-background-radius: 8;");

Label infoLabel = new Label("ℹ️ Polygon Properties");
infoLabel.setFont(Font.font("System", FontWeight.BOLD, 14));
infoLabel.setTextFill(Color.valueOf("#2c3e50"));

Label formulaArea = new Label("Area = (n × s²) / (4 × tan(π/n))");
formulaArea.setFont(Font.font("Monospace", FontWeight.NORMAL, 12));
formulaArea.setTextFill(Color.valueOf("#7f8c8d"));

Label formulaPerimeter = new Label("Perimeter = n × s");
formulaPerimeter.setFont(Font.font("Monospace", FontWeight.NORMAL, 12));
formulaPerimeter.setTextFill(Color.valueOf("#7f8c8d"));

infoPanel.getChildren().addAll(infoLabel, formulaArea, formulaPerimeter);
```
Creates an information panel displaying the mathematical formulas used for calculations.

### Lines 220-222:
```java
panel.getChildren().addAll(visualLabel, canvas, infoPanel);
return panel;
```
Assembles the visualization panel and returns it.

## Footer Creation Method (Lines 224-235)

### Lines 225-235:
```java
private HBox createFooter() {
HBox footer = new HBox();
footer.setAlignment(Pos.CENTER);
footer.setPadding(new Insets(10, 20, 20, 20));

Label footerLabel = new Label("© 2025 Polygon Calculator Pro - Made with JavaFX");
footerLabel.setFont(Font.font("System", FontWeight.NORMAL, 12));
footerLabel.setTextFill(Color.LIGHTGRAY);

footer.getChildren().add(footerLabel);
return footer;
```
Creates a simple footer with copyright information.

## CSS Styling Method (Lines 237-248)

### Lines 238-248:
```java
private String getCustomCSS() {
return ".button:hover {\n" +
       "    -fx-scale-x: 1.05;\n" +
       "    -fx-scale-y: 1.05;\n" +
       "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 8, 0, 0, 3);\n" +
       "}\n" +
       "\n" +
       ".text-field:focused {\n" +
       "    -fx-border-color: #3498db;\n" +
       "    -fx-border-width: 2;\n" +
       "    -fx-effect: dropshadow(three-pass-box, rgba(52,152,219,0.3), 5, 0, 0, 0);\n" +
       "}";
```
Returns CSS string defining hover effects for buttons (scaling and shadow) and focus effects for text fields (blue border and glow).

## Polygon Calculation Method (Lines 252-284)

### Lines 253-255:
```java
private void calculatePolygon() {
try {
int sides = Integer.parseInt(sidesInput.getText().trim());
double length = Double.parseDouble(sideLength.getText().trim());
```
Method to perform polygon calculations. Parses input values with error handling using try-catch.

### Lines 257-264:
```java
if (sides < 3) {
    showAlert("⚠️ Invalid Input", "Number of sides must be 3 or more!");
    return;
}

if (length <= 0) {
    showAlert("⚠️ Invalid Input", "Side length must be positive!");
    return;
}
```
Validates input values - sides must be 3 or more, length must be positive.

### Lines 266-270:
```java
// Calculate perimeter (simple: sides * length)
double perimeter = sides * length;

// Calculate area using the formula: (sides * length^2) / (4 * tan(π/sides))
double area = (sides * Math.pow(length, 2)) / (4 * Math.tan(Math.PI / sides));
```
**Line 267**: Calculates perimeter using simple multiplication.
**Line 270**: Calculates area using the regular polygon formula.

### Lines 272-277:
```java
// Display results with better formatting and proper colors
areaResult.setText(String.format("📐 Area: %.3f square units", area));
areaResult.setTextFill(Color.valueOf("#27ae60"));

perimeterResult.setText(String.format("📏 Perimeter: %.3f units", perimeter));
perimeterResult.setTextFill(Color.valueOf("#e67e22"));
```
Updates result labels with formatted values (3 decimal places) and appropriate colors (green for area, orange for perimeter).

### Lines 279-284:
```java
// Draw the polygon
drawPolygon(sides);

} catch (NumberFormatException e) {
    showAlert("❌ Input Error", "Please enter valid numbers!");
}
```
Calls method to draw the polygon and handles parsing errors.

## Clear Fields Method (Lines 286-298)

### Lines 287-298:
```java
private void clearFields() {
sidesInput.clear();
sideLength.clear();

// Reset result labels to placeholder state
areaResult.setText("Area: Press Calculate to see result");
areaResult.setTextFill(Color.valueOf("#95a5a6"));

perimeterResult.setText("Perimeter: Press Calculate to see result");
perimeterResult.setTextFill(Color.valueOf("#95a5a6"));

clearCanvas();
addPlaceholderText();
```
Clears all input fields, resets result labels to placeholder state with gray color, clears canvas, and adds placeholder text.

## Canvas Methods (Lines 300-310)

### Lines 301-310:
```java
private void clearCanvas() {
gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

// Set a clean white background
gc.setFill(Color.WHITE);
gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
```
Clears the entire canvas and fills it with white background.

## Polygon Drawing Method (Lines 312-349)

### Lines 313-320:
```java
private void drawPolygon(int sides) {
// Clear canvas
gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

// Set a clean white background
gc.setFill(Color.WHITE);
gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

double centerX = canvas.getWidth() / 2;
double centerY = canvas.getHeight() / 2;
```
Clears canvas, sets white background, and calculates center coordinates for polygon placement.

### Lines 322-325:
```java
// Use a dynamic radius that fits nicely in the canvas
double maxRadius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2 - 40;
double radius = Math.min(maxRadius, 150);
```
Calculates appropriate radius for the polygon to fit nicely in the canvas with 40-pixel margin.

### Lines 327-334:
```java
// Calculate polygon vertices
double[] xPoints = new double[sides];
double[] yPoints = new double[sides];

for (int i = 0; i < sides; i++) {
    double angle = 2 * Math.PI * i / sides - Math.PI / 2; // Start from top
    xPoints[i] = centerX + radius * Math.cos(angle);
    yPoints[i] = centerY + radius * Math.sin(angle);
}
```
Calculates vertices of the regular polygon using trigonometry. Starting angle is adjusted by -π/2 to start from the top.

### Lines 336-348:
```java
// Fill the polygon with a semi-transparent blue
gc.setFill(Color.valueOf("#3498db"));
gc.setGlobalAlpha(0.3);
gc.fillPolygon(xPoints, yPoints, sides);

gc.setGlobalAlpha(1.0);

// Draw the polygon outline
gc.setStroke(Color.valueOf("#2980b9"));
gc.setLineWidth(3);
gc.strokePolygon(xPoints, yPoints, sides);
```
Fills polygon with semi-transparent blue, resets alpha, then draws solid blue outline with 3-pixel width.

## Alert Dialog Method (Lines 350-365)

### Lines 351-365:
```java
private void showAlert(String title, String message) {
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle(title);
alert.setHeaderText(null);
alert.setContentText(message);

// Style the alert dialog
alert.getDialogPane().setStyle("-fx-background-color: #f8f9fa; " +
                              "-fx-border-color: #e74c3c; " +
                              "-fx-border-width: 2; " +
                              "-fx-border-radius: 10; " +
                              "-fx-background-radius: 10;");

// Style the content
alert.getDialogPane().lookup(".content.label").setStyle("-fx-font-size: 14px; " +
                                                       "-fx-text-fill: #2c3e50;");

alert.showAndWait();
```
Creates and displays a styled error alert dialog with custom appearance.

## Placeholder Text Method (Lines 367-374)

### Lines 368-374:
```java
private void addPlaceholderText() {
double centerX = canvas.getWidth() / 2;
double centerY = canvas.getHeight() / 2;
gc.setFill(Color.valueOf("#bdc3c7"));
gc.setFont(Font.font("System", FontWeight.NORMAL, 16));
gc.fillText("Enter polygon parameters and press Calculate", centerX - 150, centerY - 20);
gc.fillText("to see visualization", centerX - 70, centerY + 5);
```
Adds instructional text to the canvas when no polygon is displayed.

## Main Method (Lines 376-379)

### Lines 377-379:
```java
public static void main(String[] args) {
launch(args);
}
```
Standard main method that launches the JavaFX application by calling the inherited `launch()` method.

## Summary

This JavaFX application creates a modern, user-friendly polygon calculator with the following key features:

1. **Clean UI Design**: Uses CSS styling, gradients, shadows, and modern color scheme
2. **Input Validation**: Checks for valid number of sides (≥3) and positive side length
3. **Mathematical Calculations**: Implements correct formulas for regular polygon area and perimeter
4. **Visual Feedback**: Draws the calculated polygon on a canvas
5. **Error Handling**: Shows user-friendly error messages for invalid inputs
6. **Responsive Layout**: Uses JavaFX layout containers for proper component arrangement
7. **Interactive Elements**: Hover effects on buttons and focus effects on text fields

The code follows good object-oriented practices by separating concerns into different methods and maintaining clean, readable structure with comprehensive comments.