import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class CGTemplate {

    public static class MyPanel extends JPanel {
        
        public MyPanel() {
            setSize(300, 300);
            setLayout(new GridLayout(1, 2));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.RED);
            g.drawRect(10, 100, 30, 20);
            g.setColor(Color.BLUE);
            g.fillRect(100, 100, 50, 40);
            g.drawOval(100, 150, 40, 30);
        }
    }

    private static void createAndShowGUI() {
        
        final JFrame frame = new JFrame("Paint Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(1, 2));

        JPanel panel = new MyPanel();

        JPanel panel1 = new JPanel();
        panel.setBackground(Color.GRAY);

        JButton button1 = new JButton();
        

        frame.add(panel);
        frame.add(panel1);
        panel1.add(button1);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}