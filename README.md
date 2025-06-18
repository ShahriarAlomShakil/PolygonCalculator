# Regular Polygon Area Calculator

A JavaFX desktop application that calculates the area and perimeter of regular polygons based on the number of sides and side length.

## Features

- Input number of sides (3 or more)
- Input side length
- Calculate area using the mathematical formula: (sides × length²) / (4 × tan(π/sides))
- Calculate perimeter: sides × length
- Clear function to reset inputs
- Error handling for invalid inputs

## Requirements

- Java 11 or higher
- Maven 3.6 or higher

## How to Build and Run

1. **Build the project:**
   ```bash
   mvn clean compile
   ```

2. **Run the application:**
   ```bash
   mvn javafx:run
   ```

## Alternative Run Method

If you have JavaFX installed separately, you can also run:
```bash
mvn exec:java -Dexec.mainClass="com.polygon.PolygonCalculatorApp"
```

## Usage

1. Enter the number of sides for your regular polygon (minimum 3)
2. Enter the length of each side
3. Click "Calculate" to see the area and perimeter
4. Use "Clear" to reset all fields

## Examples

- **Triangle (3 sides, length 5):** Area ≈ 10.83, Perimeter = 15
- **Square (4 sides, length 5):** Area = 25.00, Perimeter = 20
- **Pentagon (5 sides, length 5):** Area ≈ 43.01, Perimeter = 25
- **Hexagon (6 sides, length 5):** Area ≈ 64.95, Perimeter = 30
