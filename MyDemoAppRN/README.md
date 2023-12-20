# MyDemoApp - Automated Testing

## Overview
This project includes automated tests for "MyDemoApp", targeting the login and product sorting functionalities. Tests are developed using Appium, Selenium, and JUnit, written in Java.

## Prerequisites
- Java JDK 8 or higher
- Appium
- Selenium WebDriver
- JUnit 4 or 5

## Setup Instructions

### Clone the Repository
Clone the project repository to your local machine:
git clone [Your Repository URL]

### Install Dependencies
Ensure all dependencies are installed. If using Maven or Gradle, this step is typically automated.

### Appium Server
Start the Appium server. Ensure it is running before executing tests.

### Device Setup
Configure your testing environment with either a physical device or an emulator.

## Running Tests

### Via Command Line
Execute the tests using:
./gradlew test

### Via IntelliJ IDEA
Alternatively, tests can be run directly in IntelliJ IDEA by right-clicking on the test files/directory and selecting 'Run'.

## Test Scenarios

### Login Functionality Tests
- **Valid Login:** Verifies successful login with correct credentials.
- **Invalid Login:** Checks the system's response to incorrect credentials.

### Product Sorting Tests
- **Sort By Price:** Validates correct sorting of products by price.
- **Sort By Name:** Ensures products are correctly sorted by name.

## Test Reports
Post-execution, test reports can be found in the `build/reports` directory.

## Contributing
Contributions to enhance or expand the test suite are welcome. Please adhere to the standard pull request process.




