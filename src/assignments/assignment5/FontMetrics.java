package assignments.assignment5;
import javax.swing.*;

public class FontMetrics extends JFrame{
    PanelCreation panelCreation = new PanelCreation();
    public FontMetrics(){
        add(panelCreation);
        setVisible(true);
        setBounds(420,220,350,250);
    }
    public static void main(String[] args){
        new FontMetrics();
    }
}
