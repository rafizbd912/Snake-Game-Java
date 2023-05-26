=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 1200 Game Project README
PennKey: 54585036
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D Arrays
The 2D array gameBoard is used to store the GameObjects (SnakeBodyPart and Food) on the game board.
Using a 2D array provides an easy and efficient way to manage and access game objects based on their coordinates.

  2. Collections
The LinkedList<SnakeBodyPart> collection is used to manage the snake's body parts.
This collection allows for easy manipulation of the snake's body, such as adding and removing parts, and is efficient when updating the snake's position.

  3. JUnit testable component
Test classes have been created to test the functionality of each class.
JUnit testing ensures that the individual components of the game work as intended and promotes maintainable and robust code.

  4. Inheritance and subtyping
GameObject is the superclass for SnakeBodyPart and Food classes, which allows for common properties and methods to be shared.
Inheritance and subtyping promote code reusability and reduce redundancy.

===============================
=: File Structure Screenshot :=
===============================
- Include a screenshot of your project's file structure. This should include
  all of the files in your project, and the folders they are in. You can
  upload this screenshot in your homework submission to gradescope, named 
  "file_structure.png".

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.


SnakeGame: The main class that sets up the game board, handles user input, manages game logic, and updates the game state.
GameObject: The superclass for game objects, containing common properties like coordinates.
SnakeBodyPart: A subclass of GameObject that represents a segment of the snake's body.
Food: A subclass of GameObject that represents food items on the game board.
FoodTest: A test class for the Food class.
GameObjectTest: A test class for the GameObject class.
SnakeBodyPartTest: A test class for the SnakeBodyPart class.
SnakeGameTest: A test class for the SnakeGame class.

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

Implementing the scoreboard without getting in the way of the snake was initially a challenge for me, but I figured it out later using JPanel.

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
The design is modular, with a clear separation of functionality among the different classes. 
Each class is responsible for a specific aspect of the game, making the code easier to understand and maintain.
Private state is mostly encapsulated, with only necessary getters provided for testing purposes. 
However, there might be room for further improvement in terms of encapsulation or other best practices.


========================
=: External Resources :=
========================

- Cite any external resources (images, tutorials, etc.) that you may have used 
  while implementing your game.
