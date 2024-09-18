# Bank Application 🏦💻

A Java-based GUI bank application built using JavaFX. The application allows users to create, manage, and delete bank accounts. It includes features such as account creation, deposit, withdrawal, and balance checking. This project demonstrates object-oriented programming principles and graphical user interface design.

Table of Contents
Introduction
Features
Technologies Used
Installation
Usage
Code Structure
Contributions
License
## Introduction

The Bank Application is a GUI-based Java application developed using JavaFX. It provides functionalities for creating customer accounts, performing banking operations (deposit, withdraw, check balance), and managing customers through a simple interface. This project showcases skills in Java programming, file handling, and GUI design with JavaFX.

## Features

Login System: Supports login for both customers and managers with role-based access.
Account Creation: Managers can add new customer accounts by providing a username and password.
Deposit and Withdraw: Customers can deposit money into their accounts or withdraw funds, provided they meet the requirements.
Purchase: Allows customers to make purchases, updating their account balance accordingly.
Check Balance: Customers can view their current account balance.
Account Deletion: Managers can delete customer accounts.
Logout Functionality: Provides a confirmation alert for logging out.
Error Handling: Displays error messages for invalid input or incorrect actions (e.g., incorrect username or password).
## Technologies Used

Java: Core programming language for building the application.
JavaFX: For creating the graphical user interface.
File Handling: Uses Java's File, FileReader, FileWriter, and BufferedReader for reading and writing customer data to text files.
Object-Oriented Programming (OOP): Implements principles of OOP for managing customer accounts.
## Installation

To run the application locally, follow these steps:

Clone the repository: ```bash git clone https://github.com/yourusername/bank-application.git ```

Navigate to the project directory: ```bash cd bank-application ```

Compile the Java files: ```bash javac -d bin src/hellofx/*.java ```

Run the application: ```bash java -cp bin hellofx.hellofx ```

## Usage

Launch the application:

Use the command provided in the installation steps to start the application.
Login:

For managers: Use the username "admin", password "admin", and role "manager".
For customers: Enter a valid username, password, and role "customer". The customer data is stored in text files created during account registration.
Managing Customer Accounts (Manager):

Add Customer: Enter a username and password, then click Add Customer to create a new account.
Delete Customer: Enter the customer's username and click Delete Customer to remove the account.
Banking Operations (Customer):

Deposit: Enter an amount in the "Deposit/Withdraw Amount" field, then click Deposit.
Withdraw: Enter an amount in the "Deposit/Withdraw Amount" field, then click Withdraw. The amount must be less than or equal to the current balance.
Purchase: Enter an amount in the "Purchase Amount" field, then click Purchase. The balance is updated based on the transaction.
Check Balance: Click Get Balance to display the current account balance.
Logout:

Click the Logout button to log out. A confirmation dialog will appear to confirm the action.
## Code Structure

JavaFX Files:
Controller.java: Handles the login process, logout, and user interaction for customers.
Controller2.java: Manages customer account creation, deletion, and additional manager-related actions.
Customer.java: Contains methods for banking operations (deposit, withdraw, purchase, check balance) and enforces business logic and rules.
hellofx.java: The main entry point for the application that sets up the initial GUI.
FXML Files:
hellofx.fxml: Layout for the login screen and the customer interface.
addCustomer.fxml: Layout for the manager's interface for adding and deleting customer accounts.
Resource Files:
Text Files: Stores customer data (username, password, balance) for persistence across sessions.
## Contributions

Contributions are welcome! If you have suggestions for new features, code improvements, or bug fixes, feel free to submit a pull request or open an issue.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
