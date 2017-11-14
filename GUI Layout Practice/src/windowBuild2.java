

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class windowBuild2 extends JFrame {

    private static final long serialVersionUID = 1L;

    int click1 = 0;

    public int getClicks(int clicks) {
        click1 = clicks;
        return clicks;
    }
int clicked;
    public windowBuild2() {

        Border blackline, raisedetched, loweredetched, raisedbevel,
                loweredbevel, empty, compound;

        blackline = BorderFactory.createLineBorder(Color.black, 2);
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        empty = BorderFactory.createEmptyBorder();

        // This creates a frame.
        compound = BorderFactory.createCompoundBorder(blackline, loweredbevel);

        Dimension d = new Dimension();
        d.setSize(500, 500);
int clicked;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(d);
        this.setVisible(true);

        JPanel container = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();

        myCube cube = new myCube();

        JButton button1 = new JButton();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               
                clicked++;

                JOptionPane.showMessageDialog(panelTwo,
                        "You have clicked " + clicked + " times.", "Alert",
                        JOptionPane.INFORMATION_MESSAGE);
                getClicks(clicked);
            }
        });

        JLabel numberOfClicks = new JLabel();

        numberOfClicks.setText("Button clicks = " + click1);
        button1.setText("Click Me!");

        panelOne.add(cube);
        panelTwo.add(numberOfClicks);
        panelTwo.add(button1);
        panelTwo.setBorder(compound);

        container.setLayout(new GridLayout(1, 2));
        container.add(panelOne);
        container.add(panelTwo);

        this.add(container);
    }

    class myPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.red);
            g.fill3DRect(100, 100, 100, 100, true);
        }
    }

    class myCube extends JPanel {
        private static final int D_W = 400;
        private static final int D_H = 300;
        Float centerx = CENTER_ALIGNMENT;

        Cube cube;

        public myCube() {
            cube = new Cube(250 / 2, 250 / 2, 115, 20);
            InputMap map1 = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            map1.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
            getActionMap().put("moveRight", new AbstractAction() {

                private static final long serialVersionUID = 1L;

                public void actionPerformed(ActionEvent e) {
                    cube.shiftRight();
                    repaint();
                }
            });
            map1.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
            getActionMap().put("moveLeft", new AbstractAction() {

                private static final long serialVersionUID = 1L;

                public void actionPerformed(ActionEvent e) {
                    cube.shiftLeft();
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            cube.drawCube((Graphics2D) g);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(D_W, D_H);
        }

        public class Cube {
            private static final int SHIFT_INC = 5;
            int x, y, size, shift;
            Point[] cubeOnePoints;
            Point[] cubeTwoPoints;

            public Cube(int x, int y, int size, int shift) {
                this.x = x;
                this.y = y;
                this.size = size;
                this.shift = shift;
                cubeOnePoints = getCubeOnePoints();
                cubeTwoPoints = getCubeTwoPoints();
            }

            private Point[] getCubeOnePoints() {
                Point[] points = new Point[4];
                points[0] = new Point(x, y);
                points[1] = new Point(x + size, y);
                points[2] = new Point(x + size, y + size);
                points[3] = new Point(x, y + size);
                return points;
            }

            private Point[] getCubeTwoPoints() {
                int newX = x + shift;
                int newY = y + shift;
                Point[] points = new Point[4];
                points[0] = new Point(newX, newY);
                points[1] = new Point(newX + size, newY);
                points[2] = new Point(newX + size, newY + size);
                points[3] = new Point(newX, newY + size);
                return points;
            }

            public void shiftLeft() {
                x -= SHIFT_INC;
                for (Point p : cubeOnePoints) {
                    p.x -= SHIFT_INC;
                }
                for (Point p : cubeTwoPoints) {
                    p.x -= SHIFT_INC;
                }
            }

            public void shiftRight() {
                x += SHIFT_INC;
                for (Point p : cubeOnePoints) {
                    p.x += SHIFT_INC;
                }
                for (Point p : cubeTwoPoints) {
                    p.x += SHIFT_INC;
                }
            }

            public void drawCube(Graphics2D g) {
                g.setStroke(new BasicStroke(5));
                g.drawRect(x, y, size, size);
                g.setColor(Color.BLUE);

                g.drawRect(x + shift, y + shift, size, size);
                g.setColor(Color.GREEN);
                // draw connecting lines
                for (int i = 0; i < 4; i++) {
                    g.drawLine(cubeOnePoints[i].x, cubeOnePoints[i].y,
                            cubeTwoPoints[i].x, cubeTwoPoints[i].y);
                }
                // g.drawOval(60, 60, 200, 200);
                // g.fillOval(90, 120, 50, 20);
                // g.fillOval(190, 120, 50, 20);
                // g.drawLine(165, 125, 165, 175);
                // g.drawArc(110, 130, 95, 95, 0, -180);

            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new windowBuild();
            }
        });
    }
}