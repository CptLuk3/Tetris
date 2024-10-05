package Tetris;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Tetris extends Methods{

    public static void main(String[] args) {
        JFrame f = new JFrame("Tetris");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(12*26+10,26*23+25);
        f.setVisible(true);

        final Tetris game = new Tetris();
        game.init();
        f.add(game);

        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> game.rotate(-1);
                    case KeyEvent.VK_DOWN -> game.rotate(+1);
                    case KeyEvent.VK_LEFT -> game.move(-1);
                    case KeyEvent.VK_RIGHT -> game.move(+1);
                    case KeyEvent.VK_SPACE -> game.dropDown();
                    default -> {}
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        new Thread() {
            @Override
            public void run(){
                while (true) {
                    try {
                        Thread.sleep(1000);
                        game.dropDown();
                    } catch (InterruptedException e) {

                    }
                }
            }
        }.start();
    }
}
