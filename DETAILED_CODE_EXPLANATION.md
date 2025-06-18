# PolygonCalculatorApp.java - Line-by-Line Code Explanation

This document provides a comprehensive, line-by-line explanation of the `PolygonCalculatorApp.java` file, breaking down every aspect of the code for educational purposes.

## File Header and Package Declaration

```java
package com.polygon;
```
**Line 1**: Declares the package name `com.polygon`. This follows Java naming conventions where package names are typically lowercase and use reverse domain notation.

## Import Statements (Lines 3-14)

```java
import javafx.application.Application;
```
**Line 3**: Imports the `Application` class from JavaFX, which serves as the base class for all JavaFX applications. Every JavaFX app must extend this class.

```java
import javafx.geometry.Insets;
```
**Line 4**: Imports `Insets` class used for setting padding and margins around UI components.

```java
import javafx.geometry.Pos;
```
**Line 5**: Imports `Pos` enumeration used for positioning and alignment of UI components within their containers.

```java
import javafx.scene.Scene;
```
**Line 6**: Imports `Scene` class which represents the content area of a JavaFX window/stage.

```java
import javafx.scene.canvas.Canvas;
```
**Line 7**: Imports `Canvas` class which provides a drawing surface for 2D graphics operations.

```java
import javafx.scene.canvas.GraphicsContext;
```
**Line 8**: Imports `GraphicsContext` class which provides the drawing API for the Canvas. This is similar to a graphics context in other GUI frameworks.

```java
import javafx.scene.control.*;
```
**Line 9**: Wildcard import for all JavaFX controls (Button, Label, TextField, Alert, etc.). The asterisk (*) imports all classes from the `javafx.scene.control` package.

```java
import javafx.scene.layout.HBox;
```
**Line 10**: Imports `HBox` layout container that arranges children horizontally in a single row.

```java
import javafx.scene.layout.VBox;
```
**Line 11**: Imports `VBox` layout container that arranges children vertically in a single column.

```java
import javafx.scene.paint.Color;
```
**Line 12**: Imports `Color` class for defining colors used in graphics operations.

```java
import javafx.scene.text.Font;
```
**Line 13**: Imports `Font` class for customizing text appearance.

```java
import javafx.scene.text.FontWeight;
```
**Line 14**: Imports `FontWeight` enumeration for specifying font thickness (NORMAL, BOLD, etc.).

```java
import javafx.stage.Stage;
```
**Line 15**: Imports `Stage` class which represents the top-level container (window) in JavaFX.

## Class Declaration (Line 17)

```java
public class PolygonCalculatorApp extends Application {
```
**Line 17**: 
- `public`: Makes the class accessible from anywhere
- `class PolygonCalculatorApp`: Defines the class name following CamelCase convention
- `extends Application`: Inherits from JavaFX Application class, making this a JavaFX application

## Instance Variables (Lines 19-24)

```java
private TextField sidesInput;
```
**Line 19**: Declares a private TextField for user input of polygon sides. `private` ensures encapsulation.

```java
private TextField sideLength;
```
**Line 20**: Declares a private TextField for user input of side length.

```java
private Label areaResult;
```
**Line 21**: Declares a private Label to display the calculated area result.

```java
private Label perimeterResult;
```
**Line 22**: Declares a private Label to display the calculated perimeter result.

```java
private Canvas canvas;
```
**Line 23**: Declares a private Canvas for drawing the polygon visualization.

```java
private GraphicsContext gc;
```
**Line 24**: Declares a private GraphicsContext for performing drawing operations on the canvas.

## Start Method - Application Entry Point (Line 26)

```java
@Override
public void start(Stage primaryStage) {
```
**Line 26-27**: 
- `@Override`: Annotation indicating this method overrides the parent class method
- `public void start(Stage primaryStage)`: The main entry point method for JavaFX applications, called after the JavaFX runtime initializes
- `primaryStage`: The primary window/stage provided by JavaFX

```java
primaryStage.setTitle("Regular Polygon Area & Perimeter Calculator");
```
**Line 28**: Sets the window title that appears in the title bar.

## UI Component Creation (Lines 30-55)

```java
// Create UI components
Label titleLabel = new Label("Regular Polygon Calculator");
```
**Line 30-31**: 
- Line 30: Comment explaining the following code section
- Line 31: Creates a Label with the title text for the application header

```java
titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
```
**Line 32**: Sets the font for the title label:
- `Font.font()`: Static method to create a Font object
- `"Arial"`: Font family name
- `FontWeight.BOLD`: Makes text bold
- `18`: Font size in points

```java
Label sidesLabel = new Label("Number of sides:");
```
**Line 34**: Creates a descriptive label for the sides input field.

```java
sidesInput = new TextField();
```
**Line 35**: Instantiates the TextField for sides input (previously declared as instance variable).

```java
sidesInput.setPromptText("Enter number of sides (3 or more)");
```
**Line 36**: Sets placeholder text that appears when the field is empty, providing user guidance.

```java
sidesInput.setPrefWidth(200);
```
**Line 37**: Sets the preferred width of the text field to 200 pixels.

```java
Label lengthLabel = new Label("Side length:");
```
**Line 39**: Creates a descriptive label for the side length input field.

```java
sideLength = new TextField();
```
**Line 40**: Instantiates the TextField for side length input.

```java
sideLength.setPromptText("Enter side length");
```
**Line 41**: Sets placeholder text for the side length field.

```java
sideLength.setPrefWidth(200);
```
**Line 42**: Sets the preferred width to match the sides input field for visual consistency.

```java
Button calculateButton = new Button("Calculate");
```
**Line 44**: Creates a button with "Calculate" text.

```java
calculateButton.setPrefWidth(150);
```
**Line 45**: Sets the button width to 150 pixels.

```java
calculateButton.setOnAction(e -> calculatePolygon());
```
**Line 46**: Sets the button's click event handler using a lambda expression:
- `e ->`: Lambda parameter (the ActionEvent, though not used here)
- `calculatePolygon()`: Method to call when button is clicked

```java
areaResult = new Label("Area: ");
```
**Line 48**: Initializes the area result label with default text.

```java
areaResult.setFont(Font.font("Arial", FontWeight.BOLD, 14));
```
**Line 49**: Sets bold font for the area result display.

```java
perimeterResult = new Label("Perimeter: ");
```
**Line 51**: Initializes the perimeter result label with default text.

```java
perimeterResult.setFont(Font.font("Arial", FontWeight.BOLD, 14));
```
**Line 52**: Sets bold font for the perimeter result display.

```java
Button clearButton = new Button("Clear");
```
**Line 54**: Creates a "Clear" button for resetting the application.

```java
clearButton.setPrefWidth(150);
```
**Line 55**: Sets the clear button width to match the calculate button.

```java
clearButton.setOnAction(e -> clearFields());
```
**Line 56**: Sets the clear button's click event handler to call the `clearFields()` method.

## Canvas Setup (Lines 58-61)

```java
// Create canvas for drawing polygon
canvas = new Canvas(300, 300);
```
**Line 58-59**: 
- Line 58: Comment describing the canvas creation
- Line 59: Creates a 300x300 pixel canvas for polygon visualization

```java
gc = canvas.getGraphicsContext2D();
```
**Line 60**: Gets the 2D graphics context from the canvas, which provides drawing methods.

```java
clearCanvas();
```
**Line 61**: Calls the `clearCanvas()` method to initialize the canvas with a clean state.

## Layout Creation - Left Panel (Lines 63-78)

```java
// Left side layout with controls
VBox leftPanel = new VBox(15);
```
**Line 63-64**: 
- Line 63: Comment explaining the left panel
- Line 64: Creates a vertical box layout with 15 pixels spacing between children

```java
leftPanel.setAlignment(Pos.CENTER);
```
**Line 65**: Centers all child components horizontally within the VBox.

```java
leftPanel.setPadding(new Insets(20));
```
**Line 66**: Adds 20 pixels of padding around all sides of the VBox.

```java
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
```
**Line 67-77**: Adds all the UI components to the left panel in vertical order. The `addAll()` method accepts multiple components and adds them as children of the VBox.

## Layout Creation - Right Panel (Lines 79-87)

```java
// Right side layout with canvas
VBox rightPanel = new VBox(10);
```
**Line 79-80**: Creates a vertical box for the right side with 10 pixels spacing.

```java
rightPanel.setAlignment(Pos.CENTER);
```
**Line 81**: Centers the canvas and its label horizontally.

```java
rightPanel.setPadding(new Insets(20));
```
**Line 82**: Adds 20 pixels padding around the right panel.

```java
Label canvasLabel = new Label("Polygon Visualization");
```
**Line 83**: Creates a label to describe the canvas area.

```java
canvasLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
```
**Line 84**: Sets bold font for the canvas label.

```java
rightPanel.getChildren().addAll(canvasLabel, canvas);
```
**Line 85**: Adds the canvas label and canvas to the right panel.

## Main Layout Creation (Lines 87-95)

```java
// Main layout
HBox root = new HBox(20);
```
**Line 87-88**: Creates a horizontal box layout with 20 pixels spacing to hold the left and right panels side by side.

```java
root.setAlignment(Pos.CENTER);
```
**Line 89**: Centers the panels vertically within the main layout.

```java
root.setPadding(new Insets(10));
```
**Line 90**: Adds 10 pixels padding around the entire layout.

```java
root.getChildren().addAll(leftPanel, rightPanel);
```
**Line 91**: Adds both panels to the main horizontal layout.

## Scene and Stage Configuration (Lines 93-97)

```java
Scene scene = new Scene(root, 750, 400);
```
**Line 93**: Creates a Scene with the root layout and sets the window size to 750x400 pixels.

```java
primaryStage.setScene(scene);
```
**Line 94**: Attaches the scene to the primary stage (window).

```java
primaryStage.setResizable(false);
```
**Line 95**: Prevents the user from resizing the window to maintain the intended layout.

```java
primaryStage.show();
```
**Line 96**: Makes the window visible to the user.

## Calculate Polygon Method (Lines 99-129)

```java
private void calculatePolygon() {
```
**Line 99**: Declares a private method for polygon calculations.

```java
try {
```
**Line 100**: Begins a try-catch block for error handling.

```java
int sides = Integer.parseInt(sidesInput.getText().trim());
```
**Line 101**: 
- `sidesInput.getText()`: Gets the text from the input field
- `.trim()`: Removes leading and trailing whitespace
- `Integer.parseInt()`: Converts the string to an integer
- Stores the result in the `sides` variable

```java
double length = Double.parseDouble(sideLength.getText().trim());
```
**Line 102**: Similar to above, but converts to a double for the side length.

```java
if (sides < 3) {
    showAlert("Error", "Number of sides must be 3 or more!");
    return;
}
```
**Line 104-107**: 
- Validates that the polygon has at least 3 sides (minimum for a polygon)
- If invalid, shows an error alert and exits the method early

```java
if (length <= 0) {
    showAlert("Error", "Side length must be positive!");
    return;
}
```
**Line 109-112**: 
- Validates that the side length is positive
- If invalid, shows an error alert and exits the method

```java
// Calculate perimeter (simple: sides * length)
double perimeter = sides * length;
```
**Line 114-115**: 
- Comment explaining the perimeter calculation
- Calculates perimeter using the simple formula: number of sides multiplied by side length

```java
// Calculate area using the formula: (sides * length^2) / (4 * tan(π/sides))
double area = (sides * Math.pow(length, 2)) / (4 * Math.tan(Math.PI / sides));
```
**Line 117-118**: 
- Comment explaining the area formula
- Calculates area using the mathematical formula for regular polygons:
  - `Math.pow(length, 2)`: Side length squared
  - `Math.PI / sides`: Central angle in radians
  - `Math.tan()`: Tangent function
  - This formula derives from dividing the polygon into triangular sections

```java
// Display results
areaResult.setText(String.format("Area: %.2f square units", area));
```
**Line 120-121**: 
- Comment explaining result display
- Updates the area label with formatted text showing 2 decimal places

```java
perimeterResult.setText(String.format("Perimeter: %.2f units", perimeter));
```
**Line 122**: Updates the perimeter label with formatted text.

```java
// Draw the polygon
drawPolygon(sides);
```
**Line 124-125**: 
- Comment explaining polygon drawing
- Calls the method to visualize the polygon

```java
} catch (NumberFormatException e) {
    showAlert("Error", "Please enter valid numbers!");
}
```
**Line 127-129**: 
- Catches exceptions thrown when text cannot be parsed as numbers
- Shows an error alert to inform the user

## Clear Fields Method (Lines 132-138)

```java
private void clearFields() {
```
**Line 132**: Declares a method to reset the application state.

```java
sidesInput.clear();
```
**Line 133**: Clears the sides input field.

```java
sideLength.clear();
```
**Line 134**: Clears the side length input field.

```java
areaResult.setText("Area: ");
```
**Line 135**: Resets the area result to default text.

```java
perimeterResult.setText("Perimeter: ");
```
**Line 136**: Resets the perimeter result to default text.

```java
clearCanvas();
```
**Line 137**: Clears the canvas visualization.

## Clear Canvas Method (Lines 140-155)

```java
private void clearCanvas() {
```
**Line 140**: Declares a method to reset the canvas.

```java
gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
```
**Line 141**: Clears the entire canvas area using the graphics context.

```java
// Set background color
gc.setFill(Color.LIGHTGRAY);
```
**Line 143-144**: 
- Comment explaining background color setting
- Sets the fill color to light gray

```java
gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
```
**Line 145**: Fills the entire canvas with the light gray background.

```java
// Draw border
gc.setStroke(Color.BLACK);
```
**Line 147-148**: 
- Comment explaining border drawing
- Sets the stroke (outline) color to black

```java
gc.setLineWidth(2);
```
**Line 149**: Sets the border line width to 2 pixels.

```java
gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
```
**Line 150**: Draws a black border around the entire canvas.

```java
// Draw center point
double centerX = canvas.getWidth() / 2;
double centerY = canvas.getHeight() / 2;
```
**Line 152-154**: 
- Comment explaining center point
- Calculates the center coordinates of the canvas

```java
gc.setFill(Color.RED);
```
**Line 155**: Sets the fill color to red for the center point.

```java
gc.fillOval(centerX - 2, centerY - 2, 4, 4);
```
**Line 156**: Draws a small red circle (4x4 pixels) at the center of the canvas.

## Draw Polygon Method (Lines 159-210)

```java
private void drawPolygon(int sides) {
```
**Line 159**: Declares a method to draw a polygon with the specified number of sides.

```java
clearCanvas();
```
**Line 160**: Clears the canvas before drawing the new polygon.

```java
double centerX = canvas.getWidth() / 2;
double centerY = canvas.getHeight() / 2;
```
**Line 162-163**: Calculates the center coordinates for polygon placement.

```java
// Use a fixed radius that fits nicely in the canvas
double radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2 - 30;
```
**Line 165-166**: 
- Comment explaining radius calculation
- Calculates radius as half the smaller canvas dimension minus 30 pixels for margin
- `Math.min()` ensures the polygon fits in both width and height

```java
// Calculate polygon vertices
double[] xPoints = new double[sides];
double[] yPoints = new double[sides];
```
**Line 168-170**: 
- Comment explaining vertex calculation
- Creates arrays to store the x and y coordinates of each polygon vertex

```java
for (int i = 0; i < sides; i++) {
```
**Line 172**: Begins a loop to calculate each vertex position.

```java
double angle = 2 * Math.PI * i / sides - Math.PI / 2; // Start from top
```
**Line 173**: 
- Calculates the angle for each vertex
- `2 * Math.PI * i / sides`: Divides full circle by number of sides
- `- Math.PI / 2`: Offset to start from top (12 o'clock position)

```java
xPoints[i] = centerX + radius * Math.cos(angle);
```
**Line 174**: Calculates x-coordinate using cosine function (polar to Cartesian conversion).

```java
yPoints[i] = centerY + radius * Math.sin(angle);
```
**Line 175**: Calculates y-coordinate using sine function.

```java
// Draw the polygon
gc.setStroke(Color.BLUE);
```
**Line 178-179**: 
- Comment explaining polygon drawing
- Sets stroke color to blue for the polygon outline

```java
gc.setLineWidth(3);
```
**Line 180**: Sets line width to 3 pixels for a prominent outline.

```java
gc.setFill(Color.LIGHTBLUE);
```
**Line 181**: Sets fill color to light blue for the polygon interior.

```java
// Fill the polygon
gc.fillPolygon(xPoints, yPoints, sides);
```
**Line 183-184**: 
- Comment explaining polygon filling
- Fills the polygon with the light blue color

```java
// Draw the polygon outline
gc.strokePolygon(xPoints, yPoints, sides);
```
**Line 186-187**: 
- Comment explaining outline drawing
- Draws the blue outline around the polygon

```java
// Draw vertices
gc.setFill(Color.RED);
for (int i = 0; i < sides; i++) {
    gc.fillOval(xPoints[i] - 3, yPoints[i] - 3, 6, 6);
}
```
**Line 189-192**: 
- Comment explaining vertex drawing
- Sets fill color to red
- Loops through each vertex and draws a 6x6 pixel red circle
- Centers each circle on the vertex by subtracting 3 from coordinates

```java
// Draw center point
gc.setFill(Color.BLACK);
gc.fillOval(centerX - 2, centerY - 2, 4, 4);
```
**Line 194-196**: 
- Comment explaining center point
- Sets fill color to black
- Draws a small black circle at the polygon center

```java
// Draw lines from center to vertices (optional - shows structure)
gc.setStroke(Color.GRAY);
gc.setLineWidth(1);
for (int i = 0; i < sides; i++) {
    gc.strokeLine(centerX, centerY, xPoints[i], yPoints[i]);
}
```
**Line 198-202**: 
- Comment explaining radial lines
- Sets stroke color to gray and line width to 1
- Draws lines from center to each vertex to show polygon structure
- Helps visualize how the polygon is constructed

## Show Alert Method (Lines 205-211)

```java
private void showAlert(String title, String message) {
```
**Line 205**: Declares a method to display error alerts with custom title and message.

```java
Alert alert = new Alert(Alert.AlertType.ERROR);
```
**Line 206**: Creates an error-type alert dialog.

```java
alert.setTitle(title);
```
**Line 207**: Sets the alert window title.

```java
alert.setHeaderText(null);
```
**Line 208**: Removes the header text (sets to null) for a cleaner appearance.

```java
alert.setContentText(message);
```
**Line 209**: Sets the main message content of the alert.

```java
alert.showAndWait();
```
**Line 210**: Displays the alert and waits for user to close it before continuing.

## Main Method (Lines 213-215)

```java
public static void main(String[] args) {
```
**Line 213**: Standard Java main method entry point.

```java
launch(args);
```
**Line 214**: Calls the JavaFX `launch()` method which:
- Initializes the JavaFX runtime
- Creates an instance of the Application class
- Calls the `start()` method
- Handles the application lifecycle

## Summary

This JavaFX application demonstrates:

1. **Object-Oriented Programming**: Proper use of classes, methods, and encapsulation
2. **Event-Driven Programming**: Button clicks trigger specific actions
3. **Error Handling**: Try-catch blocks and input validation
4. **Mathematical Computations**: Trigonometric functions for polygon calculations
5. **Graphics Programming**: Canvas drawing with various shapes and colors
6. **UI Design**: Responsive layouts with proper spacing and alignment
7. **User Experience**: Clear feedback, input validation, and visual representations

The code follows Java best practices with proper naming conventions, comments, and logical organization of functionality.
