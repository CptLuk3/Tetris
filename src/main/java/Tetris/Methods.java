package Tetris;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static Tetris.Tetraminos.*;


public class Methods extends JPanel {
    private int rotation;
    private int currentPiece;
    private Point pieceOrigin;
    private final ArrayList<Integer> nextPieces = new ArrayList<>();

    private Color[][] well;
    private long score;

    public void init() {
        well = new Color[12][24];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                if (j == 22) {
                    well[i][j] = Color.GRAY;
                } else {
                    well[i][j] = Color.BLACK;
                }
            }
        }
        newPiece();
    }

    public void rotate(int i) {
        int newRotation = (rotation + i) % 4;
        if (newRotation < 0) {
            newRotation = 3;
        }
        if (collidesNotAt(pieceOrigin.x, pieceOrigin.y, newRotation)) {
            rotation = newRotation;
        }
        repaint();
    }

    public void move(int move) {
        if (collidesNotAt(pieceOrigin.x, pieceOrigin.y, rotation)) {
            pieceOrigin.x += move;
        }
        repaint();
    }

    public void dropDown() {
        if (collidesNotAt(pieceOrigin.x, pieceOrigin.y, rotation)) {
            pieceOrigin.y += 1;
        } else {
            fixToWell();
        }
        repaint();
    }

//    ---------------------------------------------------------------------------------

    private void newPiece() {
        pieceOrigin = new Point(5, 2);
        rotation = 0;
        if (nextPieces.isEmpty()) {
            Collections.addAll(nextPieces, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6);
            Collections.shuffle(nextPieces);
        }
        currentPiece = nextPieces.getFirst();
        nextPieces.removeFirst();
    }

    private void fixToWell() {
        for (Point p : getTetramino(currentPiece, rotation)) {
            well[pieceOrigin.x + p.x][pieceOrigin.y + p.y] = Tetraminos.getTetraminoColor(currentPiece);
        }
        clearRows();
        newPiece();
    }

    private void clearRows() {
        boolean gap;
        int numClears = 0;

        for (int i = 21; i > 0; i--) {
            gap = false;
            for (int j = 1; j < 11; j++) {
                if (well[j][i] == Color.BLACK) {
                    gap = true;
                    break;
                }
            }
            if (!gap) {
                deleteRows(i);
                i += 1;
                numClears += 1;
            }
        }
        score += switch (numClears) {
            case 1 -> 100;
            case 2 -> 300;
            case 3 -> 500;
            case 4 -> 800;
            default -> 0;
        };
    }

    private void deleteRows(int row) {
        for (int i = row - 1; i > 0; i--) {
            for (int j = 1; j < 11; j++) {
                well[j][i + 1] = well[j][i];
            }
        }
    }

    private boolean collidesNotAt(int x, int y, int rotation) {
        for (Point p : getTetramino(currentPiece, rotation)) {
            if (well[p.x + x][p.y + y] != Color.BLACK) {
                return false;
            }
        }
        return true;
    }

    private void drawPiece(Graphics g) {
        g.setColor(getTetraminoColor(currentPiece));
        for (Point p : getTetramino(currentPiece, rotation)) {
            g.fillRect((p.x + pieceOrigin.x) * 26,
                    (p.y + pieceOrigin.y) * 26,
                    25, 25);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, 26 * 12, 26 * 23);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                g.setColor(well[i][j]);
                g.fillRect(26 * i, 26 * j, 25, 25);
            }
        }

        // Display the score
        g.setColor(Color.WHITE);
        g.drawString("" + score, 19 * 12, 25);

        drawPiece(g);
    }
}
