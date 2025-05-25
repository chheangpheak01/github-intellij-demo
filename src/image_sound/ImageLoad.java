package image_sound;
import javax.swing.*;

public class ImageLoad extends JFrame {

    ImageLoadPanel panel = new ImageLoadPanel();

    public ImageLoad(){
        add(panel);
        setSize(400,300);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new ImageLoad();
    }

}
