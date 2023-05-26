package org.cis1200.snake;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


public class SnakeGameTest {
    private SnakeGame snakeGame;

    @BeforeEach
    public void setUp() {
        snakeGame = new SnakeGame();
    }

    @Test
    public void testSnakeGameInitialConditions() {
        assertNotNull(snakeGame.getGameBoard());
        assertNotNull(snakeGame.getSnake());
        assertNotNull(snakeGame.getFood());
        assertEquals(1, snakeGame.getSnake().size());
    }

    @Test
    public void testSnakeGameMovement() {
        KeyEvent keyEventUp = new KeyEvent(snakeGame, KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        snakeGame.keyPressed(keyEventUp);
        SnakeBodyPart head = snakeGame.getSnake().getFirst();
        int initialX = head.getX();
        int initialY = head.getY();

        snakeGame.actionPerformed(null);
        head = snakeGame.getSnake().getFirst();
        assertEquals(initialX, head.getX());
        assertEquals(initialY - 1, head.getY());
    }


    @Test
    public void testSnakeGameFoodSpawn() {
        GameObject[][] gameBoard = snakeGame.getGameBoard();
        Food food = snakeGame.getFood();
        assertSame(food, gameBoard[food.getX()][food.getY()]);
    }



    @Test
    public void testSnakeGameCollisionWithWall() {
        // Move the snake to the top wall
        KeyEvent keyEventUp = new KeyEvent(snakeGame, KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        snakeGame.keyPressed(keyEventUp);
        SnakeBodyPart head = snakeGame.getSnake().getFirst();

        while (head.getY() > 0) {
            snakeGame.actionPerformed(null);
            head = snakeGame.getSnake().getFirst();
        }

        // Move the snake to collide with the wall
        snakeGame.actionPerformed(null);

        // Check if the game stops running
        assertFalse(snakeGame.isGameRunning());
    }



    //Edge case: when the Board is full of body parts
    @Test
    public void testFullBoard() {
        SnakeGame game = new SnakeGame();
        GameObject[][] gameBoard = game.getGameBoard();
        // Move the snake to fill the entire game board
        for (int x = 0; x < game.getBoardSize(); x++) {
            for (int y = 0; y < game.getBoardSize(); y++) {
                if (gameBoard[x][y] == null) {
                    gameBoard[x][y] = new SnakeBodyPart(x, y);
                    game.getSnake().add(new SnakeBodyPart(x, y));
                }
            }
        }

// Move the snake again to trigger collision
        game.actionPerformed(new ActionEvent(game, ActionEvent.ACTION_PERFORMED, "move"));

// Check that the game ended
        assertFalse(game.isGameRunning());

    }


    //Edge case: tests that the size of the snake at the start is 1
    @Test
    public void testSnakeSizeAtStartOfGame() {
        SnakeGame game = new SnakeGame();
        LinkedList<SnakeBodyPart> snake = game.getSnake();
        assertEquals(1, snake.size()); // The initial snake has only one body part
    }


}
