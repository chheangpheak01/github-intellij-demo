package image_sound;
import javax.swing.*;
import java.awt.*;

public class ImageLoadPanel extends JPanel {
    Image image;
    public ImageLoadPanel(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage("image/image.jpg");
    }
    public void paint(Graphics g){
        int w = getWidth();
        int h = getHeight();
        System.out.println("w = " + w + "h = " + h);
        g.drawImage(image,0,0,w,h,this);
    }
}

