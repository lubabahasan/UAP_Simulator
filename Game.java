import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
    
    Container container;
    JFrame window;
    JPanel titlePanel, startButtonPanel;
    JButton startButton;
    JLabel titleText;
    Font titleFont = new Font("Calisto MT", Font.PLAIN, 90);
    Font buttonFont = new Font("Courier", Font.PLAIN, 30);

    
    public static void main(String[] args) {
        
        new Game();
    }
    
    public Game(){
        
        window = new JFrame();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program by closing the window
        window.getContentPane().setBackground(Color.black); //sets background colour
        window.setLayout(null); //for custom layout
        window.setVisible(true); //make it appear on screen
        container = window.getContentPane(); //for title screen
        
        //title panel
        titlePanel = new JPanel(); //new panel
        titlePanel.setBounds(250, 200, 1000, 100); //panel resolution
        titlePanel.setBackground(Color.black); //panel background colour
        
        //title text
        titleText = new JLabel("UAP SIMULATOR"); //setting title text
        titleText.setForeground(Color.white); //title tex colour setting
        titleText.setFont(titleFont); //assingng font properties
        
        //start button panel
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(580, 400, 300, 90);
        startButtonPanel.setBackground(Color.black);
        
        //start button
        startButton = new JButton("S T A R T  G A M E");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(buttonFont);
        startButton.setPreferredSize(new Dimension(300, 80));
        
        //Adding Labels to Panels
        titlePanel.add(titleText); //adding title text to panel
        startButtonPanel.add(startButton);
        
        //Adding panels to screen
        container.add(titlePanel);
        container.add(startButtonPanel);
        
    }
    
}
