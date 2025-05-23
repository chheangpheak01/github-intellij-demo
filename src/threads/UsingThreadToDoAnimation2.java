package threads;
import javax.swing.*;
import java.awt.*;

public class UsingThreadToDoAnimation2 extends JPanel implements Runnable{

    String text = "សួស្តីឆ្នាំថ្មី";
    Font font = new Font("Khmer OS Freehand",Font.PLAIN,15);
    int y = 100;

    public UsingThreadToDoAnimation2(){
        Thread thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); // Clears the previous frame
        int w = getWidth() ,h = getHeight();
        FontMetrics fm = g.getFontMetrics(font);
        int strW = fm.stringWidth(text);
        int x = (w - strW) / 2;
        g.setFont(font);
        g.drawString(text,x,y--);
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

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        UsingThreadToDoAnimation2 panel = new UsingThreadToDoAnimation2();
        jFrame.add(panel);
        jFrame.setVisible(true);
        //jFrame.setBounds(300,250,400,300);
        jFrame.setSize(400,300);
        jFrame.setLocationRelativeTo(null);
    }
}
