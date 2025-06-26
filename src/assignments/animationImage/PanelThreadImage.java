package assignments.animationImage;
import javax.swing.*;
import java.awt.*;

public class PanelThreadImage extends JPanel implements Runnable {

    int counter = 7;
    Image []img = new Image[counter];
    int currentImage = 0;
    Thread thread;
    MediaTracker tracker = new MediaTracker(this);

    public PanelThreadImage(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int i = 0; i<img.length ; i++){
            //img[i] = toolkit.getImage("image/earth/" + (i*1)  + ".gif");
            img[i] = new ImageIcon("image/earth/" + (i+1) + ".gif").getImage();
            tracker.addImage(img[i],i+1);
        }
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int w = getWidth(), h= getHeight();
        g.clearRect(0,0,w,h);
        //int x = (w-100)/2, y = (h-100)/2;
        //int x = (w - img[0].getWidth(this))/2, y = (h - img[0].getHeight(this))/2;
        int widthImage = img[0].getWidth(this);
        int HeightImage = img[0].getHeight(this);
        if(widthImage > 0 && HeightImage > 0){
            int x = (w - widthImage) / 2;
            int y = (h - HeightImage) / 2;
            g.drawImage(img[currentImage++],x,y,this);
        }
        if(currentImage == img.length ) currentImage = 0;
    }

    @Override
    public void run() {
        while (true){
            repaint();
            try {
                Thread.sleep(1000/10);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
