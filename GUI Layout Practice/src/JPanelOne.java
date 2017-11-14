
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class JPanelOne extends JPanel {

    public JPanelOne() {

        FlowLayout layoutPanel = new FlowLayout();
        JPanel panel = new JPanel(layoutPanel);
        JPanel panel2 = new JPanel(layoutPanel);
        JButton button = new JButton("test");
        Canvas canvas1 = new Canvas();
        panel.add(button);
        panel2.add(canvas1);
        panel2.setVisible(true);
        panel.setVisible(true);

    }

}