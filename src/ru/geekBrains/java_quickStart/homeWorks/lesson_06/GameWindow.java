package ru.geekBrains.java_quickStart.homeWorks.lesson_06;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    // Deaclare Global Variables
    private static GameWindow gameWindow;

    // rum Main Method
    public static void main(String[] args) {
        gameWindow = new GameWindow();

//	-- initilaization the window
        gameWindow.setTitle("Window DUMMY-Title");
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocation(200, 100);
        gameWindow.setSize(906, 478);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);

//	-- add drawing (in the panel) to the window
        GameField gameField = new GameField();
        gameWindow.add(gameField);
    }

    //  -- new method of display the drowings
    private static void onRepaint(Graphics g) {
        g.fillOval(10, 10, 50, 100);
        g.drawLine(20, 20, 200, 200);
    }

    //  == new Class for Painting Panel]
    private static class GameField extends JPanel {

        // ==== redefinition of the standard method 'paintComponent'
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            gameWindow.onRepaint(g);
        }
    }
}
