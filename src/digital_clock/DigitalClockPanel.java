package digital_clock;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class DigitalClockPanel extends JPanel implements Runnable{

    Font font = new Font("Times New Roman",Font.PLAIN,25);
    Color color = new Color(123,124,125);
    String[] day_Of_Week = {"","Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    String[] day_Of_Month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    Thread thread;
    public DigitalClockPanel(){
       thread = new Thread(this);
       thread.start();
    }

    String getTimeString(){
        String time = "";
        Calendar cal = Calendar.getInstance();

        int amPm = cal.get(Calendar.AM_PM);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String suffix = (amPm == Calendar.AM) ? "AM" : "PM";

        if(hour == 0) hour = 12;
        time += hour + " : ";
        if(minute<10) time += "0";
        time += minute + " : ";
        if(second<10) time += "0";
        time += second + " ";

        time += suffix;

        return time;
    }

    String getDateString(){
        String date = "";
        Calendar calendar = Calendar.getInstance();
        date += day_Of_Week[calendar.get(Calendar.DAY_OF_WEEK)] + " ";
        date += day_Of_Month[calendar.get(Calendar.MONTH)] + " ";
        date += calendar.get(Calendar.DAY_OF_MONTH) + " - ";
        date += calendar.get(Calendar.YEAR);

        return date;
    }


    public void paint(Graphics g){
        int w = getWidth(), h = getHeight();
        g.clearRect(0,0,w,h);

        String timeString = getTimeString();
        String dateString = getDateString();

        FontMetrics fm = g.getFontMetrics(font);

        int wholeString = fm.stringWidth(timeString + " - " + dateString);

        int x = (w - wholeString)/2;

        g.setFont(font);
        g.setColor(color);
        g.drawString(timeString + " - " + dateString,x,h/2);
        //g.drawString(dateString,timeStr,h/2 + 35);
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
