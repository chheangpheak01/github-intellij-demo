package review;
import javax.swing.*;
import java.awt.*;

public class LayoutManagerWithJPanel extends  JFrame{
    JTextField tfName = new JTextField(10);
    JButton jButton = new JButton("Login");

    public LayoutManagerWithJPanel(){
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(tfName);
        panel.add(jButton);
        setLayout(new BorderLayout());
        add(panel,BorderLayout.WEST);
        setVisible(true);
        setSize(400,300);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new LayoutManagerWithJPanel();
    }
}
