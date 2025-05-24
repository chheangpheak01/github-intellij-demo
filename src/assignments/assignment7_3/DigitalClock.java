package assignments.assignment7_3;
import javax.swing.*;

public class DigitalClock extends JFrame {

    DigitalClockPanel panel = new DigitalClockPanel();

    public DigitalClock(){
        add(panel);
        setSize(400,300);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new DigitalClock();
    }
}
