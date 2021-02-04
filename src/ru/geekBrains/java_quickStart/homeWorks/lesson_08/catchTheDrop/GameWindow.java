package ru.geekBrains.java_quickStart.homeWorks.lesson_08.catchTheDrop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {
    // Declare Global Variables
    private static GameWindow go_game_window;                            //
    private static Image go_img_background;                              //
    private static Image go_img_game_over;                               //
    private static Image go_img_drop;                                    //
    private static float gf_drop_left_x = 200;                           //
    private static float gf_drop_top_y = -100;                           //
    private static float gf_drop_hrz_vlty = 50;                          // drop horizontal velocity X (Px per sec)
    private static float gf_drop_vrt_vlty = 100;                         // drop vertical   velocity Y (Px per sec)
    private static long gi_time_frame;                                   // time between_frames
    private static long gi_score = 0;                                    // Game's Score
    private static String go_v_title = "Game example: 'Catch the Drop'";  // Game's Score

    // rum Main Method
    public static void main(String[] args) throws IOException {

//	-- initialization - reading images from the files:
        go_img_background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        go_img_game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        go_img_drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
//	-- initialization time_frame
        gi_time_frame = System.nanoTime();
//	-- initialization the window
        go_game_window = new GameWindow();
        go_game_window.setTitle(go_v_title);
        go_game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        go_game_window.setLocation(200, 100);
        go_game_window.setSize(906, 478);
        go_game_window.setResizable(false);
        go_game_window.setVisible(true);

//	-- add drawing (panel) into the window
        GameField gameField = new GameField();
        go_game_window.add(gameField);

        gameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
                int x = e.getX();
                int y = e.getY();
//  ---- get 'Drop' Right(X)/Buttom(Y) coordinates:
                float drop_right_x = gf_drop_left_x + go_img_drop.getWidth(null);
                float drop_buttom_y = gf_drop_top_y + go_img_drop.getHeight(null);

//  ---- check whether Drop is clicked
                boolean is_drop = x >= gf_drop_left_x && x <= drop_right_x && y >= gf_drop_top_y && y <= drop_buttom_y;
                if (is_drop) {
                    gf_drop_top_y = -100;
                    gf_drop_left_x = (int) (Math.random() * (go_game_window.getWidth() - go_img_drop.getWidth(null)));
//  ------ increase Drop's velocity
                    gf_drop_hrz_vlty += 5;
                    gf_drop_vrt_vlty += 10;
//  ------ increase score
                    gi_score ++;
                    go_game_window.setTitle(go_v_title + " - Score: " + gi_score);
                }
            }
        });
    }

    //  -- new method of display the drawings
    private static void onRepaint(Graphics g) {

//  Get new coordinates for the Drop
        long current_time = System.nanoTime();                             // get delta-time at each step:
        float delta_time = (current_time - gi_time_frame) * 0.000000001f;  // convert into seconds (10^9)
        gi_time_frame = current_time;
        gf_drop_top_y = gf_drop_top_y + (gf_drop_vrt_vlty * delta_time);   // get new coordinates Y:
        gf_drop_left_x = gf_drop_left_x + (gf_drop_hrz_vlty * delta_time); // get new coordinates X:

        g.drawImage(go_img_background, 0, 0, null);
        g.drawImage(go_img_drop, (int) gf_drop_left_x, (int) gf_drop_top_y, null);
        if (gf_drop_top_y > go_game_window.getHeight() || gf_drop_left_x > go_game_window.getWidth()) {
            g.drawImage(go_img_game_over, 280, 120, null);
        }
    }

    //  == new Class for Painting Panel]
    private static class GameField extends JPanel {

        // ==== redefinition of the standard method 'paintComponent'
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            go_game_window.onRepaint(g);
            repaint();  // re-write drop
        }
    }
}
