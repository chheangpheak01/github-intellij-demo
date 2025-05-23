package review;
import javax.swing.*;

public class ReviewJFrameUsingExtends extends JFrame{
    public ReviewJFrameUsingExtends(){
        setTitle("JFrame Using Extents");
        setSize(400,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new ReviewJFrameUsingExtends();
    }
}
