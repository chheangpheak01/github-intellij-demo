package assignments.assignment5;
import javax.swing.*;
import java.awt.*;
import java.awt.FontMetrics;

public class PanelCreation extends JPanel{
    public void paint(Graphics g){
        String text = "Hello FontMetrics";
        Font font = new Font("Serif",Font.PLAIN,12);
        g.setFont(font);
        g.setColor(Color.MAGENTA);

        FontMetrics fontMetrics = g.getFontMetrics(font);
        int x = (getWidth() - fontMetrics.stringWidth(text))/2;
        int y = (getHeight() - fontMetrics.getHeight())/2 + fontMetrics.getAscent();

        g.drawString(text,x,y);

    }
}
