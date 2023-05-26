package org.cis1200.snake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameObjectTest {
    @Test
    public void testGameObjectConstructor() {
        GameObject gameObject = new GameObject(3, 7);
        assertEquals(3, gameObject.getX());
        assertEquals(7, gameObject.getY());
    }
}
