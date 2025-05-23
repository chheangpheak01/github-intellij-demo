package assignments.assignments7_1;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;


public class DigitalClockPanel extends JPanel implements Runnable{

    Font font = new Font("Times New Roman",Font.PLAIN,50);
    Color color = new Color(123,124,125);

    Thread thread;
    public DigitalClockPanel(){
        thread = new Thread(this);
        thread.start();
    }
    public void paint(Graphics g){
        int w = getWidth(), h = getHeight();
        String time = "";
        g.clearRect(0,0,w,h);

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int amPm = cal.get(Calendar.AM_PM);

        time += hour + " : ";
        if(minute < 10) time += "0";
        time += minute + " : ";
        if(second < 10) time += "0";
        time += second + " ";
        String suffix = ( amPm == Calendar.AM) ? "AM" : "PM";

        time += suffix;

        g.setColor(color);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics(font);
        int wStr = fm.stringWidth(time);
        int x = (w - wStr)/2;
        g.drawString(time,x,h/2);
    }

    public void run(){
        while(true){
            repaint();
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
