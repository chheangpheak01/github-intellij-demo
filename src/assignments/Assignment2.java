package assignments;
import javax.swing.*;
import java.awt.*;

public class Assignment2{
    JLabel jName = new JLabel("Name");
    JTextField tfName = new JTextField(" Enter your name ");
    JButton jButton = new JButton("Login");

    public Assignment2(){
        JFrame frame = new JFrame("Layout Manager");
        frame.setLayout(new FlowLayout());
        frame.add(jName);
        frame.add(tfName);
        frame.add(jButton);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,300);
        frame.setLocation(300,200);
    }
    public static void main(String[] args) {
        new Assignment2();
    }
}
