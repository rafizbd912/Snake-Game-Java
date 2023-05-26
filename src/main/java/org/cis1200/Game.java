package org.cis1200;

import javax.swing.*;

import org.cis1200.snake.InstructionsWindow;
import org.cis1200.snake.SnakeGame;

public class Game {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InstructionsWindow instructionsWindow = new InstructionsWindow();
            instructionsWindow.setVisible(true);
            instructionsWindow.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    JFrame frame = new JFrame("Snake Game");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setContentPane(new SnakeGame());
                    frame.pack();
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
        });
    }
}
