
import java.awt.Color;
import javax.swing.JButton;

public class Buttons extends Stages{
    //Enter Button
    public void addEnterButton(){
        enter = new JButton("E N T E R");
        enter.setForeground(Color.black);
        enter.setFont(buttonFont);
        enter.setFocusPainted(true);
    }
    
}
