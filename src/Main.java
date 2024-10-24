//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




// initialize variable for value of board that was previously selected by user
private static int previousValue = 2;

// initialize variable for value of times a user has clicked on the board
private static int clickNumber = 0;

private static int turnNumber = 0;

public static void main(String[] args) {
    JFrame frame = new JFrame("Swing Chess");
    int numberSquares = 8;
    // define state of  initial board
    int[][] board_setup = new int[][]{{24, 22, 23, 25, 26, 23, 22, 24}, {21, 21, 21, 21, 21, 21, 21, 21}, new int[8], new int[8], new int[8], new int[8], {11, 11, 11, 11, 11, 11, 11, 11}, {14, 12, 13, 15, 16, 13, 12, 14}};
    Map<Integer, String> iconmap = new HashMap<>();
    // Map numbers for pieces to .png files that have the image for the piece
    iconmap.put(11, "wp.png");
    iconmap.put(12, "wn.png");
    iconmap.put(13, "wb.png");
    iconmap.put(14, "wr.png");
    iconmap.put(15, "wq.png");
    iconmap.put(16, "wk.png");

    iconmap.put(21, "bp.png");
    iconmap.put(22, "bn.png");
    iconmap.put(23, "bb.png");
    iconmap.put(24, "br.png");;
    iconmap.put(25, "bq.png");
    iconmap.put(26, "bk.png");


    frame.setPreferredSize(new Dimension(800, 800));
    frame.setDefaultCloseOperation(3);
    JPanel p = new JPanel();

    for (int ii = 0; ii < numberSquares; ++ii) {
        for (int jj = 0; jj < numberSquares; ++jj) {
            JButton b = new JButton();
            if ((ii % 2 != 1 || jj % 2 != 1) && (ii % 2 != 0 || jj % 2 != 0)) {
                b.setBackground(Color.LIGHT_GRAY);
            } else {
                b.setBackground(Color.WHITE);

            }

            Toolkit toolkit = Toolkit.getDefaultToolkit();



            String fooString = Integer.toString(board_setup[ii][jj]);
            ImageIcon icon = new ImageIcon("../resources/" + iconmap.get(Integer.valueOf(fooString)));

            JLabel l = new JLabel(icon);
            b.add(l);

            int finalJj = jj;
            int finalIi = ii;
            // Implement click event to know which square is clicked

            b.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        clickNumber = clickNumber + 1;
                                        System.out.println(clickNumber);

                                                if (clickNumber % 2 == 1) {

                                                    if (board_setup[finalIi][finalJj] !=0) {
                                                        ImageIcon iconTwo = new ImageIcon("../resources/" + iconmap.get(null));
                                                        previousValue = board_setup[finalIi][finalJj];
                                                        board_setup[finalIi][finalJj] = 0;
                                                        Image image = toolkit.getImage("../resources/" + iconmap.get(previousValue));
                                                        Cursor c = toolkit.createCustomCursor(image, new Point(p.getX(),
                                                                p.getY()), "img");
                                                        p.setCursor(c);
                                                        l.setIcon(iconTwo);


                                                    }



                                                } if (clickNumber % 2 == 0 && previousValue !=0) {
                                                    board_setup[finalIi][finalJj] = previousValue;
                                                    ImageIcon iconTwo = new ImageIcon("../resources/" + iconmap.get(previousValue));
                                                    l.setIcon(iconTwo);
                                                    p.setCursor(Cursor.getDefaultCursor());
                                                    turnNumber = turnNumber + 1;

                                                }
                                        }

            });
            p.add(b);
        }
    }

    p.setLayout(new GridLayout(8, 8));

    // Add the panel to the frame
    frame.add(p);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
}


