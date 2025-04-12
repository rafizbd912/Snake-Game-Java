# Game Project

## Overview

This project is an implementation of the classic Snake game. It showcases several core programming concepts such as data structures, collections, testing, and object-oriented design. The project emphasizes maintainability and efficient game state management while providing a solid foundation in software development practices.

## Core Concepts

### 1. 2D Arrays
- **Purpose:** The game board is represented by a 2D array.
- **Features:** Each cell in the array stores game objects (such as snake body parts or food).
- **Benefits:** This structure simplifies access to and management of game objects based on their coordinates, making spatial computations straightforward and efficient.

### 2. Collections
- **Purpose:** The snake's body parts are managed using a `LinkedList<SnakeBodyPart>`.
- **Features:** The linked list allows dynamic modifications like adding or removing snake segments.
- **Benefits:** This data structure is ideal for supporting the continuous growth and real-time updates of the snake’s body as it moves.

### 3. JUnit Testing
- **Purpose:** Each component of the game is thoroughly tested using JUnit.
- **Features:** Individual test classes verify the functionality of game objects and logic.
- **Benefits:** Rigorous testing ensures that the game functions correctly, helping to maintain robust, error-resistant code.

### 4. Inheritance and Subtyping
- **Purpose:** The project leverages object-oriented principles by using inheritance.
- **Features:** A `GameObject` superclass serves as the parent for both the `SnakeBodyPart` and `Food` classes.
- **Benefits:** This setup encourages code reusability and reduces redundancy by sharing common attributes and methods across subclasses.

## File Structure

A screenshot of the complete project file structure is provided in the submission as `file_structure.png`. This image includes all the project folders and files.

## Implementation Overview

- **SnakeGame:**  
  The main class that initializes the game board, handles user input, controls game logic, and updates the game state.

- **GameObject:**  
  A base class that defines common properties (such as coordinates) and methods for all game objects.

- **SnakeBodyPart:**  
  A subclass of `GameObject` representing a segment of the snake's body. Managed within a linked list for efficient dynamic updates.

- **Food:**  
  Another subclass of `GameObject` that represents food items on the game board, which the snake consumes to grow.

## Running the Game

1. **Compile the Project:**  
   Ensure you have the appropriate Java development environment set up and compile the project files.

2. **Execute the Game:**  
   Run the `SnakeGame` class. The game will launch, displaying the game board and initiating the Snake game.

## Conclusion

This project demonstrates the effective integration of advanced programming concepts into a functional and engaging game. By using 2D arrays for spatial management, collections for dynamic game state handling, thorough JUnit tests for reliability, and inheritance for code reuse, the project underscores best practices in software development and game design.
