
/**
 * @author Pablo Edgar
 * Date: 11/13/17
 * Lab # 8 - GUI Layout Practice
 * 
 * Create a simple GUI that has a composite layout, and two customized JPanels.
 * 
 *  - Contains a button that triggers a dialog to be displayed. The dialog should display 
 *  a message informing the user of how many times the button was clicked.
 *  
 *  - A label that displays how many times the button was clicked.
 *  
 *  - Added motion to cube that is drawn in left JPanel, allowing user to control movement with keyboard
 *  
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class LayoutPractice extends JFrame {

    // Default serial version ID
    private static final long serialVersionUID = 1L;
    private static int clicked = 0;

    public LayoutPractice() {

        // Initialize borders
        Border blackline;
        Border loweredBevel;
        Border compound;

        // Create border around panel
        blackline = BorderFactory.createLineBorder(Color.black, 2);
        loweredBevel = BorderFactory.createLoweredBevelBorder();
        compound = BorderFactory.createCompoundBorder(blackline, loweredBevel);

        // Dimension of GUI
        Dimension d = new Dimension();
        d.setSize(600, 500);

        // Set GUI Properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(d);

        // Make GUI Visible
        this.setVisible(true);

        // Create a container with 2 panels inside
        JPanel container = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();

        // Make a new 3D cube that goes inside left panel
        myCube cube = new myCube();

        // Make a new label that shows number of clicks on button
        JLabel numberOfClicks = new JLabel();

        // Create a button with required specification as listed
        JButton button1 = new JButton();
        button1.setText("Click Me!");

        button1.addActionListener(new ActionListener() {

            // On click, set text equal to 1, after button has been pressed
            public void actionPerformed(ActionEvent event) {

                clicked++;
                numberOfClicks.setText("Button clicks = " + clicked);

                // Output a dialog with number of clicks
                JOptionPane.showMessageDialog(panelTwo,
                        "You have clicked " + clicked + " times.", "Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        // Set layout of container
        container.setLayout(new GridLayout(1, 2));
        container.add(panelOne);
        container.add(panelTwo);

        // Add components to panelOne
        panelOne.add(cube);

        // Add components to panelTwo
        panelTwo.add(numberOfClicks);
        panelTwo.add(button1);
        panelTwo.setBorder(compound);

        // JLabels for box movement
        JLabel moveBox = new JLabel();
        JLabel moveBox1 = new JLabel();

        // Set alignment, text, and style of JLabels
        moveBox.setText("Move box up/down/left/right with");
        moveBox.setFont(new Font("Chalkboard", Font.ITALIC, 14));

        moveBox.setVerticalAlignment(SwingConstants.BOTTOM);
        moveBox.setHorizontalAlignment(SwingConstants.CENTER);
        moveBox1.setText("keyboard arrows");
        moveBox1.setFont(new Font("Chalkboard", Font.ITALIC, 14));
        moveBox1.setVerticalAlignment(SwingConstants.BOTTOM);
        moveBox1.setHorizontalAlignment(SwingConstants.CENTER);

        // Add labels to panelTwo
        panelTwo.add(moveBox);
        panelTwo.add(moveBox1);
        
        // Set panel background color
        panelTwo.setBackground(Color.LIGHT_GRAY);

        // Adds container to frame
        getContentPane().add(container);
    }

    /**
     * 
     * 3D Cube Architecture - Added basic left/right movement to shape
     * 
     */
    class myCube extends JPanel {

        // Default serial version ID
        private static final long serialVersionUID = 1L;
        private static final int HEIGHT_1 = 310;
        private static final int WIDTH_1 = 410;

        // Create new cube
        Cube cube1;
        Float centerx = CENTER_ALIGNMENT;

        public myCube() {

            // InputMap to connect keystroke and cube object
            InputMap map1 = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

            // Create new cube object with dimensions as parameter
            cube1 = new Cube(250 / 2, 250 / 2, 115, 24);

            // Put "right" keystroke to map
            map1.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");

            // Determine what action is performed for keystroke
            getActionMap().put("moveRight", new AbstractAction() {
                private static final long serialVersionUID = 1L;

                // Shift cube to the right when right arrow is pressed
                public void actionPerformed(ActionEvent e) {
                    cube1.right();
                    // Redraw cube in new location
                    repaint();
                }
            });

            // Put "left" keystroke to map
            map1.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");

            getActionMap().put("moveLeft", new AbstractAction() {
                private static final long serialVersionUID = 1L;

                public void actionPerformed(ActionEvent e) {
                    cube1.left();
                    repaint();
                }
            });

            // Put "down" keystroke to map
            map1.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");

            getActionMap().put("moveDown", new AbstractAction() {
                private static final long serialVersionUID = 1L;

                public void actionPerformed(ActionEvent e) {
                    cube1.down();
                    repaint();
                }
            });

            // Put "up" keystroke to map
            map1.put(KeyStroke.getKeyStroke("UP"), "moveUp");

            getActionMap().put("moveUp", new AbstractAction() {
                private static final long serialVersionUID = 1L;

                public void actionPerformed(ActionEvent e) {
                    cube1.up();
                    repaint();
                }
            });
        }

        // Container size
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH_1, HEIGHT_1);
        }

        // General override for paint component
        @Override
        public void paintComponent(Graphics g2) {
            super.paintComponent(g2);
            cube1.drawCube((Graphics2D) g2);
        }

        public class Cube {

            // Amount that cube moves
            private static final int MOVE_INCREMENT = 17;

            int cubesize;
            int spacing;
            int x1;
            int y1;

            // Create two arrays based on points
            Point[] cube1Point;
            Point[] cube2Point;

            /**
             * Cube constructor that takes in 4 parameters for points, size,
             * and spacing between 2 boxes(determines if cube is square or
             * rectangular)
             * 
             * @param x
             * @param y
             * @param size
             * @param shift
             */
            public Cube(int x1, int y1, int cubesize, int spacing) {

                this.x1 = x1;
                this.y1 = y1;
                this.spacing = spacing;
                this.cubesize = cubesize;
                cube1Point = c1Points();
                cube2Point = c2Points();

            }

            // Points of first square
            private Point[] c1Points() {

                // Create an array of Points for each corner of the square
                Point[] p = new Point[4];

                // Add point to array based on location on square. Add to x/y repectively 
                // to place points in correct location
                p[0] = new Point(x1, y1);
                p[1] = new Point(x1 + cubesize, y1);
                p[2] = new Point(x1 + cubesize, y1 + cubesize);
                p[3] = new Point(x1, y1 + cubesize);

                return p;
            }

            // Points of second square
            private Point[] c2Points() {

                // New x/y points that are shifted by spacing
                int x2 = x1 + spacing;
                int y2 = y1 + spacing;

                // New array of Points for each corner,with new x/y
                Point[] p = new Point[4];

                p[0] = new Point(x2, y2);
                p[1] = new Point(x2 + cubesize, y2);
                p[2] = new Point(x2 + cubesize, y2 + cubesize);
                p[3] = new Point(x2, y2 + cubesize);

                return p;
            }

            /**
            * Method to move cube to right
            */
            public void right() {

                // += because we are moving right on the x-axis
                x1 += MOVE_INCREMENT;

                // Loop through all points in box1 and move to right based on
                // increment
                for (Point p : cube1Point) {
                    p.x += MOVE_INCREMENT;
                }

                // Loop through all points in box2 and move to right same
                // increment
                for (Point p : cube2Point) {
                    p.x += MOVE_INCREMENT;
                }
            }
            
           /**
            * Method to move cube to left
            */
            public void left() {

                // -= because we are moving left on x-axis
                x1 -= MOVE_INCREMENT;

                // Loop through all points in box1 and move to left based on
                // increment
                for (Point p : cube1Point) {
                    p.x -= MOVE_INCREMENT;
                }

                // Loop through all points in box2 and move to left same
                // increment
                for (Point p : cube2Point) {
                    p.x -= MOVE_INCREMENT;
                }
            }

            // Same concept as left()/right()
            public void down() {

                y1 += MOVE_INCREMENT;

                for (Point p : cube1Point) {
                    p.y += MOVE_INCREMENT;
                }

                for (Point p : cube2Point) {
                    p.y += MOVE_INCREMENT;
                }
            }

            // Same concept as left()/right()
            public void up() {

                y1 -= MOVE_INCREMENT;

                for (Point p : cube1Point) {
                    p.y -= MOVE_INCREMENT;
                }

                for (Point p : cube2Point) {
                    p.y -= MOVE_INCREMENT;
                }
            }

            /**
             * Create Cube by drawing multiple squares and connecting dots
             * 
             * @param g
             */
            public void drawCube(Graphics2D g1) {

                // Set line thickness
                g1.setStroke(new BasicStroke(5));

                // Draw first rectangle
                g1.drawRect(x1, y1, cubesize, cubesize);

                // Add different color to line
                g1.setColor(Color.BLUE);

                // Draw second rectangle
                g1.drawRect(x1 + spacing, y1 + spacing, cubesize, cubesize);

                // Add different color to line
                g1.setColor(Color.GREEN);

                // Connect the dots with line between cube 1 & 2 to form cube
                for (int i = 0; i < 4; i++) {
                    g1.drawLine(cube1Point[i].x, cube1Point[i].y,
                            cube2Point[i].x, cube2Point[i].y);
                }
            }
        }
    }

    /**
     * Main Method
     * 
     * @param args
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            // Run layoutpractice
            public void run() {
                new LayoutPractice();
            }
        });
    }
}
