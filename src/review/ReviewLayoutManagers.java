package review;
import javax.swing.*;
import java.awt.*;

public class ReviewLayoutManagers extends JFrame{
    JTextField tfName = new JTextField(10);
    JButton jButton = new JButton("Ok");

    public ReviewLayoutManagers(){
        //setLayout(new FlowLayout());
        setLayout(new GridLayout(2,1));
        add(tfName);
        add(jButton);
        setVisible(true);
        setSize(400,300);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        new ReviewLayoutManagers();
    }
}
