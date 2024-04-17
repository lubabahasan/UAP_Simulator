import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
    
    Container container;
    JFrame window;
    JPanel titlePanel, startButtonPanel, storyPanel, choicePanel;
    RoundedButton startButton, choice1, choice2, choice3, choice4;
    JLabel titleText;
    JTextArea storyText;
    Font titleFont = new Font("Impact", Font.PLAIN, 90);
    Font buttonFont = new Font("Garamond", Font.PLAIN, 30);
    Font normalFont = new Font("Calisto MT", Font.PLAIN, 40);
    
    MainScreenHandler actionHandler = new MainScreenHandler();
    
    public static void main(String[] args) {
        
        new Player();
        new Game();
    }
    
    public Game(){
        
        window = new JFrame();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program by closing the window
        window.getContentPane().setBackground(Color.decode("#280a68")); //sets background colour
        window.setLayout(null); //for custom layout
        window.setVisible(true); //make it appear on screen
        container = window.getContentPane(); //for title screen
        
        //title panel
        titlePanel = new JPanel(); //new panel
        titlePanel.setBounds(320, 200, 900, 120); //panel resolution
        titlePanel.setBackground(Color.decode("#a70c70")); //panel background colour
        
        //title text
        titleText = new JLabel("U A P  S I M U L A T O R"); //setting title text
        titleText.setForeground(Color.white); //title tex colour setting
        titleText.setFont(titleFont); //assingng font properties
        
        //start button panel
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(590, 400, 310, 90);
        startButtonPanel.setBackground(Color.decode("#280a68"));
        
        //start button
        startButton = new RoundedButton("S T A R T  G A M E");
        startButton.setBackground(Color.decode("#280a68"));
        startButton.setForeground(Color.white);
        startButton.setFont(buttonFont);
        startButton.setPreferredSize(new Dimension(300, 80));
        startButton.addActionListener(actionHandler);
        
        //Adding Labels to Panels
        titlePanel.add(titleText); //adding title text to panel
        startButtonPanel.add(startButton);
        
        //Adding panels to screen
        container.add(titlePanel);
        container.add(startButtonPanel);
        
    }
    
    public void createGameScreen(){
        
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        
        storyPanel = new JPanel();
        storyPanel.setBounds(320, 200, 900, 200);
        storyPanel.setBackground(Color.decode("#280a68"));
        
        storyText = new JTextArea("Welcome to UAP, dear "+"Lubaba"+". Make wise choices and enjoy your journey. Good Luck!");
        storyText.setBounds(320, 200, 900, 200);
        storyText.setBackground(Color.decode("#280a68"));
        storyText.setForeground(Color.white);
        storyText.setFont(normalFont);
        storyText.setLineWrap(true);
        
        storyPanel.add(storyText);
        container.add(storyPanel);
        
        
        //Choice buttons
        choicePanel = new JPanel();
        choicePanel.setBounds(530, 400, 500, 300);
        choicePanel.setBackground(Color.blue);
        choicePanel.setLayout(new GridLayout(4,1));
        container.add(choicePanel);
        
        //Choices
        choice1 = new RoundedButton("Attend Class");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setPreferredSize(new Dimension(300, 80));
        choice1.setFont(buttonFont);
        choicePanel.add(choice1);
    }
    
    public class MainScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            
            createGameScreen();
            
        }
    }
    
    
   
    
}
 
class Player {
    
    String name;
    
    public void getName( String name ){
        this.name = name;
    }
    
}
