
# Cucumber JDBC UI and Database Test Lab

![Cucumber](https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF7300?style=for-the-badge&logo=testng&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-00758F?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)
![Apache POI](https://img.shields.io/badge/Apache%20POI-231F20?style=for-the-badge&logo=apache&logoColor=white)

## 📋 Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Applications Under Test](#applications-under-test)
4. [Database Used](#database-used)
5. [Reporting](#reporting)
6. [Installation](#installation)
7. [Configuration](#configuration)
8. [Usage](#usage)
9. [Parallel Testing](#parallel-testing)
10. [Folder Structure](#folder-structure)
11. [Dependencies](#dependencies)
12. [Contributing](#contributing)
13. [License](#license)
14. [Contact](#contact)

## 💡 Introduction

The **cucumber-jdbc-ui-db-test-lab** framework combines Cucumber for BDD, Selenium for UI testing, JDBC for database interactions, and TestNG for test execution. This robust automation solution is designed to facilitate thorough testing of both front-end and back-end aspects, with support for cross-browser compatibility and detailed reporting.

## ✨ Features

- **Behavior-Driven Development (BDD)** with Cucumber and Gherkin syntax for easy-to-read test scenarios.
- **UI Automation** using Selenium WebDriver, supporting Chrome, Firefox, Edge, and Safari browsers.
- **Database Testing** through JDBC, allowing direct interactions with the database.
- **Apache POI Integration** for reading and writing Excel files as test data sources.
- **Datafaker Library** for generating realistic test data.
- **Detailed Reporting** in HTML and PDF formats using Extent Reports, with screenshots for failed scenarios.
- **Parallel Execution** to expedite test runs across multiple threads.
- **Page Object Model (POM)** structure for better maintainability and readability.
- **Jenkins CI/CD Integration** for automated build and test pipelines, configured via the Maven Surefire plugin.

## 🌐 Applications Under Test

This framework is designed to test two applications:

1. **[Mersys Application](https://test.mersys.io/)**: A comprehensive application that requires thorough UI and back-end testing.
2. **[ZeroBank Application](http://zero.webappsecurity.com/)**: An online banking platform used to simulate scenarios such as login, payee management, and foreign currency purchase.

## 💾 Database Used

This project uses the **[Sakila](https://dev.mysql.com/doc/sakila/en/)** MySQL sample database for educational and testing purposes. It enables realistic database testing scenarios within the framework.

## 📝 Reporting

- **HTML and PDF Reports**: Generated using Extent Reports and located in `test-output` and `testReports`.
- **ScenarioResults.xlsx**: Captures the result of each test scenario, including the status and browser used. Managed through the `Hooks` class.

Example `ScenarioResults.xlsx`:

| Scenario Name     | Status   | Browser |
|-------------------|----------|---------|
| Login Test        | Passed   | Chrome  |
| Search Test       | Failed   | Firefox |
| Checkout Test     | Passed   | Edge    |

## 📥 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/cihat-kose/cucumber-jdbc-ui-db-test-lab.git
   ```

2. Open in IntelliJ IDEA:
   - File > New > Project from Version Control
   - Enter the repository URL and click Clone.

3. Ensure necessary plugins are installed:
   - **Cucumber for Java** and **Gherkin** plugins for IntelliJ IDEA.

4. Wait for Maven dependencies to be downloaded and project setup to complete.

## 🔧 Configuration

1. **Extent Report Configuration**:
   - Customize `extent.properties` for report and screenshot paths:
     ```properties
     reportPath=test-output/extent-report.html
     screenshotPath=test-output/screenshots/
     ```

2. **Browser Selection**:
   - The default browser is set in `GWD`. You can override it by setting the `browser` system property:
     ```bash
     mvn test -Dbrowser=chrome
     ```

## ⚙️ Usage

1. **Running Tests**:
   - In IntelliJ IDEA, navigate to `src/test/java`.
   - Right-click any test file or directory and select `Run 'TestName'`.
   - Or execute all tests from the command line:
     ```bash
     mvn clean test
     ```

2. **Jenkins Integration**:
   - Set up a Jenkins job to automatically build and test the project. Steps:
     - Add a Maven project with `clean test` goals.
     - Configure source code management to link to this repository.
     - Add post-build actions to publish the HTML reports generated by Extent Reports.
    - The `pom.xml` contains a Maven Surefire configuration that specifies which test runners Jenkins will execute.

## ⚡ Parallel Testing

To run tests in parallel, configure the `ParallelTest.xml` or use your own TestNG XML files with parallel attributes. This will allow concurrent execution of multiple test cases, speeding up the test suite.

## 📂 Folder Structure

```plaintext
cucumber-jdbc-ui-db-test-lab/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── apachePOI/           # Excel handling with Apache POI
│       │   ├── features/            # Cucumber feature files
│       │   ├── jdbc/                # JDBC related code
│       │   ├── pages/               # Page Object Model (POM) classes
│       │   ├── runners/             # TestNG runner classes
│       │   ├── stepDefinitions/     # Cucumber step definitions
│       │   ├── utilities/           # Utility classes
│       │   └── xml/                 # TestNG XML configurations
│       └── resources/
│           └── extent.properties    # Extent report configurations
│
├── pom.xml                          # Maven configuration file
└── README.md                        # Project README file
```

## 📦 Dependencies

Essential dependencies in `pom.xml` include:

- **Selenium WebDriver** for browser automation.
- **Cucumber** for BDD using Gherkin syntax.
- **TestNG** for test execution and parallel testing.
- **Apache POI** for reading and writing Excel files.
- **MySQL Connector** for database connectivity with JDBC.
- **Extent Reports** for detailed reporting.
- **Datafaker** for generating test data dynamically.

## 🤝 Contributing

We welcome contributions! To contribute:

1. Fork this repository.
2. Create a feature branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a Pull Request.

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

For questions or issues, please open an issue in this repository.

---
