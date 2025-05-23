package threads;
import javax.swing.*;
import java.awt.*;

public class UsingThreadToDoAnimation extends JPanel implements Runnable{
    private int x = 0;
    Thread thread;
    public UsingThreadToDoAnimation(){
        thread = new Thread(this);
        thread.start();
    }
    public void paint(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(x,10,30,30);
    }
    public void run(){
        while(true){
            x += 5;
            if(x > getWidth()){
                x = 0;
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
        UsingThreadToDoAnimation panel = new UsingThreadToDoAnimation();
        jFrame.add(panel);
        jFrame.setBounds(120,300,400,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
