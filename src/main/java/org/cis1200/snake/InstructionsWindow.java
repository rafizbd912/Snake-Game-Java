package org.cis1200.snake;

import javax.swing.*;
import java.awt.*;


public class InstructionsWindow extends JDialog {
    public InstructionsWindow() {
        setTitle("Instructions");
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        instructionsArea.setText("Welcome to the Snake Game!\n\n"
                + "In this game, you control a snake that grows in length as it eats food. "
                + "The goal is to eat as much food as possible without colliding with "
                + "the snake's own body or the walls of the game board.\n\n"
                + "Control the snake using the arrow keys:\n"
                + "- UP arrow: Move up\n"
                + "- DOWN arrow: Move down\n"
                + "- LEFT arrow: Move left\n"
                + "- RIGHT arrow: Move right\n"
                + "The game starts when you press 'Start Game' or when you exit this window.");

        JScrollPane scrollPane = new JScrollPane(instructionsArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Start Game");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);

        pack();
    }
}
