package org.cis1200.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    private static final int BOARD_SIZE = 20;
    private static final int CELL_SIZE = 20;
    private static final int DELAY = 100;

    private GameObject[][] gameBoard;
    private LinkedList<SnakeBodyPart> snake;
    private Food food;
    private Timer timer;

    private Random random = new Random();




    private boolean gameRunning = true;
    private int score = 0;
    private int dx = 0;
    private int dy = -1;

    // Scoreboard components
    private JPanel scoreboardPanel;
    private JLabel scoreLabel;

    public SnakeGame() {
        setFocusable(true);
        addKeyListener(this);


        setLayout(new BorderLayout());

        // Initialize scoreboard
        initScoreboard();


        // Create the game board
        JPanel gameBoardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.BLACK); // Set the background color to black
                g.fillRect(0, 0, getWidth(), getHeight()); // Clear the background with black color
                super.paintComponent(g);
                for (int x = 0; x < BOARD_SIZE; x++) {
                    for (int y = 0; y < BOARD_SIZE; y++) {
                        GameObject obj = gameBoard[x][y];
                        if (obj instanceof SnakeBodyPart) {
                            g.setColor(Color.GREEN);
                            g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        } else if (obj instanceof Food) {
                            g.setColor(Color.RED);
                            g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        }
                    }
                }
            }
        };
        gameBoardPanel.setOpaque(false); // Make the game board panel transparent
        gameBoardPanel.setPreferredSize(new Dimension(BOARD_SIZE * CELL_SIZE,
                                                      BOARD_SIZE * CELL_SIZE));
        add(gameBoardPanel, BorderLayout.CENTER);

        initGame();

    }

    private void initScoreboard() {
        scoreboardPanel = new JPanel();
        scoreboardPanel.setBackground(Color.LIGHT_GRAY); // Set the background color to light gray

        scoreLabel = new JLabel("Score: 0");
        scoreboardPanel.add(scoreLabel);
        add(scoreboardPanel, BorderLayout.SOUTH);
    }

    private void updateScore() {
        scoreLabel.setText("Score: " + score);
    }

    private void initGame() {
        gameBoard = new GameObject[BOARD_SIZE][BOARD_SIZE];
        snake = new LinkedList<>();
        SnakeBodyPart head = new SnakeBodyPart(BOARD_SIZE / 2, BOARD_SIZE / 2);
        snake.add(head);
        gameBoard[BOARD_SIZE / 2][BOARD_SIZE / 2] = head;

        spawnFood();

        timer = new Timer(DELAY, this);
        timer.start();
    }



    private void spawnFood() {
        int x, y;
        do {
            x = random.nextInt(BOARD_SIZE);
            y = random.nextInt(BOARD_SIZE);
        } while (gameBoard[x][y] != null);

        food = new Food(x, y);
        gameBoard[x][y] = food;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                GameObject obj = gameBoard[x][y];
                if (obj instanceof SnakeBodyPart) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else if (obj instanceof Food) {
                    g.setColor(Color.RED);
                    g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (!gameRunning) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over. Your score: " + score);
            System.exit(0);
        }

        SnakeBodyPart head = snake.getFirst();
        int newX = head.getX() + dx;
        int newY = head.getY() + dy;

        if (newX < 0 || newY < 0 || newX >= BOARD_SIZE || newY >= BOARD_SIZE ||
                (gameBoard[newX][newY] != null && gameBoard[newX][newY] instanceof SnakeBodyPart)) {
            gameRunning = false;
            return;
        }

        SnakeBodyPart newHead = new SnakeBodyPart(newX, newY);
        snake.addFirst(newHead);

        if (gameBoard[newX][newY] != null && gameBoard[newX][newY] == food) {
            score++;
            spawnFood();
            updateScore(); // Update the score on the scoreboard
        } else {
            SnakeBodyPart tail = snake.removeLast();
            gameBoard[tail.getX()][tail.getY()] = null;
        }

        gameBoard[newX][newY] = newHead;

        repaint();
    }




    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP -> {
                if (dy != 1) {
                    dx = 0;
                    dy = -1;
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (dy != -1) {
                    dx = 0;
                    dy = 1;
                }
            }
            case KeyEvent.VK_LEFT -> {
                if (dx != 1) {
                    dx = -1;
                    dy = 0;
                }
            }
            case KeyEvent.VK_RIGHT -> {
                if (dx != -1) {
                    dx = 1;
                    dy = 0;
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + keyCode);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    //For testing

    public GameObject[][] getGameBoard() {
        return gameBoard;
    }

    public LinkedList<SnakeBodyPart> getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }





}