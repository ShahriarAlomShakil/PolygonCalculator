# Regular Polygon Area Calculator

A JavaFX desktop application that calculates the area and perimeter of regular polygons based on the number of sides and side length.

**Repository:** https://github.com/ShahriarAlomShakil/PolygonCalculator

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed on your PC:

- **Java 11 or higher** - [Download from Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
- **Maven 3.6 or higher** - [Download from Apache Maven](https://maven.apache.org/download.cgi)
- **Visual Studio Code** - [Download from Microsoft](https://code.visualstudio.com/)
- **Git** (optional, for cloning) - [Download from Git](https://git-scm.com/)

### Getting the Source Code to Your PC

#### Option 1: Clone with Git (Recommended)
If you have Git installed:
```bash
git clone https://github.com/ShahriarAlomShakil/PolygonCalculator.git
cd PolygonCalculator
```

#### Option 2: Download ZIP
1. Go to the repository page: https://github.com/ShahriarAlomShakil/PolygonCalculator
2. Click the "Code" button and select "Download ZIP"
3. Extract the ZIP file to your desired location
4. Navigate to the extracted folder (it will be named `PolygonCalculator-main` or similar)

### Setting Up VS Code

1. **Install Required Extensions:**
   - Open VS Code
   - Go to Extensions (Ctrl+Shift+X)
   - Install the following extensions:
     - "Extension Pack for Java" by Microsoft (includes Language Support for Java, Debugger for Java, Test Runner for Java, Maven for Java, Project Manager for Java, and Visual Studio IntelliCode)
     - "Java Extension Pack" (if not already included)

2. **Open the Project:**
   - Open VS Code
   - File → Open Folder
   - Select the `PolygonAreaCalculator` folder
   - VS Code will automatically detect it as a Maven project

3. **Wait for Project Setup:**
   - VS Code will automatically download dependencies and set up the project
   - You may see notifications about configuring the Java project - follow the prompts
   - Wait for the "Java project imported" notification

### Running the Project in VS Code

#### Method 1: Using VS Code Tasks
1. Press `Ctrl+Shift+P` to open the command palette
2. Type "Tasks: Run Task"
3. Select "Run JavaFX Polygon Calculator"

#### Method 2: Using Terminal in VS Code
1. Open the integrated terminal (Ctrl+`)
2. Run the following commands:
   ```bash
   mvn clean compile
   mvn javafx:run
   ```

#### Method 3: Using the Java Extension
1. Open `src/main/java/com/polygon/PolygonCalculatorApp.java`
2. Click the "Run" button that appears above the `main` method
3. Or press `F5` to run with debugging

### Troubleshooting VS Code Setup

- **If Java is not detected:** 
  - Check that Java is installed: `java -version`
  - Configure Java path in VS Code settings (File → Preferences → Settings → search "java.home")

- **If Maven is not working:**
  - Check Maven installation: `mvn -version`
  - Reload VS Code window (Ctrl+Shift+P → "Developer: Reload Window")

- **If JavaFX modules are missing:**
  - Ensure you're using Java 11+ (JavaFX is not included in newer JDK versions by default)
  - The project's `pom.xml` handles JavaFX dependencies automatically

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
- Visual Studio Code with Java extensions (see setup instructions above)

## Command Line Build and Run (Alternative to VS Code)

If you prefer using the command line directly:

1. **Build the project:**
   ```bash
   mvn clean compile
   ```

2. **Run the application:**
   ```bash
   mvn javafx:run
   ```

## Alternative Run Method

You can also use the provided shell script (Linux/Mac):
```bash
./run.sh
```

Or if you have JavaFX installed separately:
```bash
mvn exec:java -Dexec.mainClass="com.polygon.PolygonCalculatorApp"
```

## Development in VS Code

### Project Structure
```
PolygonAreaCalculator/
├── src/main/java/
│   ├── module-info.java          # Java module configuration
│   └── com/polygon/
│       └── PolygonCalculatorApp.java  # Main application class
├── pom.xml                       # Maven configuration
├── README.md                     # This file
└── run.sh                       # Shell script to run the app
```

### Making Changes
1. Open the project in VS Code
2. Edit the Java files in `src/main/java/com/polygon/`
3. VS Code will automatically compile changes
4. Run the application using any of the methods described above

### Debugging
1. Set breakpoints by clicking in the left margin of the code editor
2. Press `F5` or use "Run and Debug" from the sidebar
3. The application will start in debug mode, stopping at your breakpoints

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
