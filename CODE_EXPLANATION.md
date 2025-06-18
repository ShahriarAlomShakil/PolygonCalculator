# Polygon Calculator Codebase Explanation

## Overview
This document provides a detailed explanation of the Polygon Calculator JavaFX application codebase, focusing on the main application file and its components.

## Project Structure

### Maven Configuration (`pom.xml`)
- **Group ID**: `com.polygon`
- **Artifact ID**: `polygon-calculator`
- **Version**: 1.0.0
- **Java Version**: 11
- **JavaFX Version**: 17.0.2

**Key Dependencies:**
- `javafx-controls`: Provides UI controls like buttons, text fields, labels
- `javafx-fxml`: For FXML-based UI (though not used in this implementation)

**Build Plugins:**
- `maven-compiler-plugin`: Compiles Java source code
- `javafx-maven-plugin`: Runs JavaFX applications with proper module path setup

### Module Configuration (`module-info.java`)
```java
module polygon.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    exports com.polygon;
}
```
This defines the Java module system requirements and exports.

## Main Application File: `PolygonCalculatorApp.java`

### Class Overview
`PolygonCalculatorApp` extends `javafx.application.Application` and serves as the main entry point for the JavaFX application.

### Instance Variables
```java
private TextField sidesInput;      // Input field for number of sides
private TextField sideLength;      // Input field for side length
private Label areaResult;          // Display calculated area
private Label perimeterResult;     // Display calculated perimeter
private Canvas canvas;             // Drawing area for polygon visualization
private GraphicsContext gc;        // Graphics context for drawing operations
```

### Key Methods Breakdown

#### 1. `start(Stage primaryStage)` - Application Initialization
**Purpose**: Sets up the entire user interface and scene graph.

**UI Components Created:**
- **Title Label**: Application header with bold font
- **Input Fields**: 
  - `sidesInput`: For number of polygon sides (minimum 3)
  - `sideLength`: For length of each side
- **Buttons**:
  - `calculateButton`: Triggers polygon calculations
  - `clearButton`: Resets all fields and canvas
- **Result Labels**: Display calculated area and perimeter
- **Canvas**: 300x300 pixel drawing area for polygon visualization

**Layout Structure:**
```
HBox (root)
├── VBox (leftPanel) - Controls
│   ├── Title Label
│   ├── Input Fields
│   ├── Calculate Button
│   ├── Result Labels
│   └── Clear Button
└── VBox (rightPanel) - Visualization
    ├── Canvas Label
    └── Canvas (300x300)
```

**Event Handlers:**
- Calculate button: `e -> calculatePolygon()`
- Clear button: `e -> clearFields()`

#### 2. `calculatePolygon()` - Core Calculation Logic
**Purpose**: Validates input and performs mathematical calculations.

**Input Validation:**
- Checks if sides ≥ 3 (minimum for a polygon)
- Ensures side length > 0
- Handles `NumberFormatException` for invalid input

**Mathematical Formulas:**
1. **Perimeter**: `sides × length` (simple multiplication)
2. **Area**: `(sides × length²) / (4 × tan(π/sides))`
   - This is the standard formula for regular polygon area
   - Uses `Math.tan()` and `Math.PI` for trigonometric calculations

**Output Formatting:**
- Area: Displayed to 2 decimal places
- Perimeter: Displayed to 2 decimal places
- Automatically triggers polygon drawing

#### 3. `drawPolygon(int sides)` - Visualization Logic
**Purpose**: Renders a visual representation of the calculated polygon.

**Drawing Process:**
1. **Canvas Preparation**:
   - Clears previous drawings
   - Sets light gray background
   - Draws black border

2. **Polygon Geometry Calculation**:
   - Centers polygon at canvas midpoint
   - Calculates radius to fit polygon in canvas (with 30px margin)
   - Computes vertex coordinates using trigonometry:
     ```java
     angle = 2 × π × i / sides - π/2
     x = centerX + radius × cos(angle)
     y = centerY + radius × sin(angle)
     ```
   - Starts from top vertex (angle offset of -π/2)

3. **Visual Elements**:
   - **Filled Polygon**: Light blue fill color
   - **Polygon Outline**: Blue stroke, 3px width
   - **Vertices**: Red circles (6px diameter) at each corner
   - **Center Point**: Black circle (4px diameter)
   - **Radial Lines**: Gray lines from center to each vertex (shows structure)

**Graphics Context Operations:**
- `fillPolygon()`: Creates filled shape
- `strokePolygon()`: Draws outline
- `fillOval()`: Draws circular points
- `strokeLine()`: Draws radial lines

#### 4. `clearFields()` - Reset Functionality
**Purpose**: Resets the application to initial state.
- Clears both input text fields
- Resets result labels to default text
- Calls `clearCanvas()` to reset visualization

#### 5. `clearCanvas()` - Canvas Reset
**Purpose**: Prepares canvas for new drawing or resets to empty state.
- Clears all existing graphics
- Redraws background and border
- Places red center point indicator

#### 6. `showAlert(String title, String message)` - Error Handling
**Purpose**: Displays error dialogs for user feedback.
- Creates `Alert.AlertType.ERROR` dialog
- Used for input validation failures

#### 7. `main(String[] args)` - Application Entry Point
**Purpose**: Standard JavaFX application launcher.
- Calls `launch(args)` which triggers JavaFX runtime initialization

## Mathematical Background

### Regular Polygon Properties
A regular polygon has:
- All sides of equal length
- All interior angles equal
- All vertices equidistant from center

### Area Formula Derivation
The area formula `(n × s²) / (4 × tan(π/n))` comes from:
1. Dividing polygon into `n` triangular sections from center
2. Each triangle has base `s` and height `r × cos(π/n)`
3. Using relationships between side length, radius, and central angle
4. The tangent function relates the apothem (perpendicular distance from center to side) to the polygon geometry

### Coordinate Calculation
Vertices are positioned using polar coordinates:
- Each vertex is at angle `2πi/n` from center
- Converting to Cartesian: `(r×cos(θ), r×sin(θ))`
- Offset by `-π/2` to start from top vertex

## Error Handling
1. **Input Validation**: Checks for valid numbers and logical constraints
2. **Exception Handling**: Catches `NumberFormatException` for invalid input
3. **User Feedback**: Alert dialogs inform users of errors
4. **Graceful Degradation**: Application remains functional after errors

## UI/UX Features
1. **Responsive Layout**: Uses JavaFX layout managers for proper sizing
2. **Visual Feedback**: Immediate polygon drawing after calculation
3. **Clear Functionality**: Easy reset of all fields
4. **Professional Styling**: Consistent fonts, colors, and spacing
5. **Input Prompts**: Placeholder text guides user input

## Technical Architecture
- **MVC Pattern**: UI components separated from calculation logic
- **Event-Driven**: Button clicks trigger specific actions
- **Modular Design**: Each method has a single responsibility
- **JavaFX Best Practices**: Proper use of Scene Graph and Graphics Context

This application demonstrates solid software engineering principles with clean code organization, proper error handling, and an intuitive user interface.
