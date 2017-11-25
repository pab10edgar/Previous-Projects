
/**
 * @author Pablo Edgar
 * Nov 20, 2017
 * 
 * Final Project - Snake Game
 * 
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameManagerTester extends JFrame {

    GameManagerTester() {

        add(new gameBoard());
        setResizable(false);
        pack();

        setTitle("Game of Snake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        // Creates a new thread so our GUI can process itself
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new GameManagerTester();
                frame.setVisible(true);
            }
        });
    }
}
