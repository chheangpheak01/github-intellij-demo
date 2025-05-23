package assignments;
import javax.swing.*;
import java.awt.*;

public class Assignment6 extends JPanel implements Runnable{

    int y = 100;
    Font khmerFont = new Font("Khmer OS Freehand",Font.PLAIN,20);
    Color myColor = new Color(123,124,125);
    String khmerText = "សួស្តីឆ្នាំថ្មី";

    public Assignment6(){
        Thread thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g){
        int w = getWidth(), h = getHeight();
        super.paintComponent(g);
        g.setColor(myColor);
        g.setFont(khmerFont);
        FontMetrics fm = g.getFontMetrics(khmerFont);
        int wStr = fm.stringWidth(khmerText);
        int x = (w - wStr) / 2;
        g.drawString(khmerText,x,y--);
    }

    public void run(){
        while(true){
            if(y<0){
                y = getHeight();
            }
            repaint();
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Assignment6 panel = new Assignment6();
        JFrame jFrame = new JFrame();
        jFrame.add(panel);
        jFrame.setSize(400,300);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
    }
}
