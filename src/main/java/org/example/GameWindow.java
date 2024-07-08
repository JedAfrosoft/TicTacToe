package org.example;

import javax.swing.*;

public class GameWindow extends JFrame {

    GameWindow() {
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Title Here");

        this.setVisible(true);
    }

}