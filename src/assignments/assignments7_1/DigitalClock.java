package assignments.assignments7_1;
import javax.swing.*;

public class DigitalClock extends JFrame{

    DigitalClockPanel panel = new DigitalClockPanel();

    public DigitalClock(){
        add(panel);
        setVisible(true);
        setBounds(560,300,430,300);
    }

    public static void main(String[] args){
        new DigitalClock();
    }
}
