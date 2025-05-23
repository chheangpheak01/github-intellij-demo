package assignments.assignment3;
import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel{
    public void paint(Graphics g){
        int w = getWidth(), h = getHeight();

        g.setColor(Color.BLUE);
        g.drawRect(20,30,100,150);

        g.setColor(Color.PINK);
        g.fillRect(130,30,100,150);

        g.setColor(Color.GREEN);
        g.drawOval(240,30,100,150);

        g.setColor(Color.CYAN);
        g.fillOval(350,30,100,150);

        g.setColor(Color.BLACK);
        g.drawArc(490,30,100,100,0,180);

        g.setColor(Color.WHITE);
        g.fillArc(630,30,100,100,0,180);

        g.setColor(Color.RED);
        g.fillArc(740,30,100,100,180,180);

        g.setColor(Color.RED);
        g.drawString("Hello java graphics learners" ,22 ,h/2);
    }
}
