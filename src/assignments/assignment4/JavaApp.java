package assignments.assignment4;
import javax.swing.*;

public class JavaApp extends JFrame{
    PanelCreation panelCreation = new PanelCreation();
    public JavaApp(){
        add(panelCreation);
        setVisible(true);
        setBounds(350,240,400,200);
    }
    public static void main(String[] args){
        new JavaApp();
    }
}
