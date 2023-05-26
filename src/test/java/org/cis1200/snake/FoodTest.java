package org.cis1200.snake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FoodTest {
    @Test
    public void testFoodConstructor() {
        Food food = new Food(5, 10);
        assertEquals(5, food.getX());
        assertEquals(10, food.getY());
    }

    @Test
    public void testFoodSpawnedInsideBounds() {
        for (int i = 0; i < 100; i++) { // Perform the test 100 times
            Food food = new Food(640, 480);
            assertTrue(food.getX() >= 0 && food.getX() <= 640);
            assertTrue(food.getY() >= 0 && food.getY() <= 480);
        }
    }

}


