# Puzzle Game 

This repository contains the source code for a simple Java-based game. The project consists of the following main components:

1. `User.java`
2. `GameJFrame.java`
3. `LoginJFrame.java`
4. `RegisterJFrame.java`

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Usage](#usage)
- [File Descriptions](#file-descriptions)

## Introduction

This project is a simple game developed using Java Swing for the graphical user interface. The game includes user authentication (login and registration) and a main game frame where the game is played.

## Features

- User Registration
- User Login
- Main Game Interface

## Usage
1. **Register a new user**: Run the program in App.java
2. **Login**
3. **Play the Game**: Once logged in, the `GameJFrame` will open, allowing you to play the game.

## File Descriptions

### User.java

The `User.java` file contains the `User` class, which manages user information such as username and password. This class is used for user authentication.

#### Features
- **User Class**: Manages user information, including username and password.
- **Constructor**: Initializes the user object.
- **Getter and Setter Methods**: Provides access to and modification of the username and password.

### GameJFrame.java

The `GameJFrame.java` file contains the main game interface. This class extends `JFrame` and includes all the components and logic for the game.

#### Features
- **Main Game Interface**: Extends `JFrame`, provides the main game window.
- **Window Settings**: Sets the window title, size, and close operation.
- **Startup Entry Point**: Launches the application using the `main` method and `SwingUtilities.invokeLater` for thread safety.

### LoginJFrame.java

The `LoginJFrame.java` file contains the login interface. This class extends `JFrame` and includes the components for user login, such as text fields for username and password, and a login button.

#### Features
- **Login Interface**: Extends `JFrame`, provides the login window.
- **Component Layout**: Uses `JPanel` for layout, includes username and password fields and login button.
- **Event Handling**: Handles login button click event, retrieves and verifies username and password input.

### RegisterJFrame.java

The `RegisterJFrame.java` file contains the registration interface. This class extends `JFrame` and includes the components for user registration, such as text fields for entering a new username and password, and a registration button.

#### Features
- **Registration Interface**: Extends `JFrame`, provides the registration window.
- **Component Layout**: Uses `JPanel` for layout, includes username and password fields and registration button.
- **Event Handling**: Handles registration button click event, retrieves and saves username and password input.



