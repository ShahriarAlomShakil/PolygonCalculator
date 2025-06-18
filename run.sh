#!/bin/bash
# Script to run the Polygon Calculator JavaFX Application

echo "Starting Polygon Calculator..."
cd "$(dirname "$0")"
mvn javafx:run
