package assignments.assignment4;
import javax.swing.*;
import java.awt.*;

public class PanelCreation extends JPanel{
    public void paint(Graphics g){
        int width = getWidth(), height = getHeight();
        g.setColor(Color.BLACK);
        g.drawRect(10,10,width - 20,height -20);

        Font font = new Font("Arial",Font.PLAIN,15);
        Color myColor = new Color(120,130,140);
        String text = "Welcome to java graphics";
        //g.setColor(myColor);
        g.setColor(Color.PINK);
        g.setFont(font);
        g.drawString(text,20,height/2);
    }
}
