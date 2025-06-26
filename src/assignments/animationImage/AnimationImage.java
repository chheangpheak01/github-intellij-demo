package assignments.animationImage;
import javax.swing.*;

public class AnimationImage extends JFrame{

    PanelThreadImage panelThreadImage = new PanelThreadImage();

    public AnimationImage(){
        add(panelThreadImage);
        setSize(400,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AnimationImage();
    }
}
