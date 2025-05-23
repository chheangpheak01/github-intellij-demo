package assignments.assignment3;
import javax.swing.*;

public class GraphicsTest extends JFrame{
    DrawingPanel drawingPanel = new DrawingPanel();
    public GraphicsTest(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400,200,900,250);
        add(drawingPanel);
        setVisible(true);
        //setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new GraphicsTest();
    }
}
