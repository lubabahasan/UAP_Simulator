import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
    
    JFrame window;
    JPanel titlePanel;
    JLabel titleText;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 69);
    Container container;
    
    public static void main(String[] args) {
        
        new Game();
    }
    
    public Game(){
        
        window = new JFrame();
        window.setSize(1000, 800); // set resolution
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //give an option to exist program by closing the window
        window.getContentPane().setBackground(Color.white); //sets background colour
        window.setLayout(null); //for custom layout
        window.setVisible(true); //make it appear on screen
        container = window.getContentPane(); //for title screen
        
        titlePanel = new JPanel(); //new panel
        titlePanel.setBounds(100, 100, 600, 150); //panel resolution
        titlePanel.setBackground(Color.white); //panel background colour
        
        titleText = new JLabel("UAP SIMULATOR"); //setting title text
        titleText.setFont(titleFont);
        
        titlePanel.add(titleText);
        
        container.add(titlePanel); //adding the panel to our screen
        
    }
    
}
