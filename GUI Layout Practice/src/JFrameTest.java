
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class JFrameTest extends JFrame {

    public JFrameTest() {

        FlowLayout mainLayout = new FlowLayout();
        setSize(320, 480);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(mainLayout);

        JPanel panelMain = new JPanel(mainLayout);

        JButton testButton = new JButton("Test12");
        panelMain.add(testButton);

        JPanelOne panel = new JPanelOne();
        panelMain.add(panel);
        panelMain.add(panel);
        panel.setVisible(true);
        add(panelMain);
        
        



    }

    public static void main(String[] args) {

        JFrameTest frame = new JFrameTest();
        frame.setVisible(true);


    }
}
