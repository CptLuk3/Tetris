package Tetris;

import java.awt.*;

public class Tetraminos {

    private static final Point[][][] tetraminos = {
            // I-Piece
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
            },

            // J-Piece
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
            },

            // L-Piece
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
            },

            // O-Piece
            {
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
            },

            // S-Piece
            {
                    { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
                    { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
            },

            // T-Piece
            {
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
            },

            // Z-Piece
            {
                    { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
                    { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
            }
    };

    private static final Color[] tetraminoColors = {
      Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red
    };

//    Getter------------------------------------------------------------------------------------------------------

    public static Color getTetraminoColor(int farbe) {
        return tetraminoColors[farbe];
    }

    public static Point[] getTetramino(int piece, int rotate) {
        return tetraminos[piece][rotate];
    }
}
