package org.cis1200.snake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeBodyPartTest {
    @Test
    public void testSnakeBodyPartConstructor() {
        SnakeBodyPart snakeBodyPart = new SnakeBodyPart(4, 9);
        assertEquals(4, snakeBodyPart.getX());
        assertEquals(9, snakeBodyPart.getY());
    }
}
