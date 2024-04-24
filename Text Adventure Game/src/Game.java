import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
    
    Container container;
    JFrame window;
    JPanel titlePanel, startButtonPanel, storyPanel, choicePanel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JLabel titleText;
    JTextArea storyText;
    
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
    int width = (int)size.getWidth(); 
    int height = (int)size.getHeight();
    
    Font titleFont = new Font("Impact", Font.PLAIN, (int)Math.ceil(height/9.6));
    Font buttonFont = new Font("Garamond", Font.PLAIN, (int)Math.ceil(height/28.8));
    Font normalFont = new Font("Calisto MT", Font.PLAIN, (int)Math.ceil(height/23));
    
    String text;
    int i = 0;
    
    MainScreenHandler actionHandler = new MainScreenHandler();
    
    public static void main(String[] args) {
        
        //new Player();
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
        titlePanel.setBounds((int)Math.ceil(width/4.8), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.71), (int)Math.ceil(height/7.2)); //panel resolution
        titlePanel.setBackground(Color.decode("#a70c70")); //panel background colour
        
        //title text
        titleText = new JLabel("U A P  S I M U L A T O R"); //setting title text
        titleText.setForeground(Color.white); //title tex colour setting
        titleText.setFont(titleFont); //assingng font properties
        
        //start button panel
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds((int)Math.ceil(width/2.6), (int)Math.ceil(height/2.16), (int)Math.ceil(width/4.9548), (int)Math.ceil(height/7.2));
        startButtonPanel.setBackground(Color.decode("#280a68"));
        
        //start button
        startButton = new JButton("S T A R T  G A M E");
        startButton.setBackground(Color.decode("#280a68"));
        startButton.setForeground(Color.white);
        startButton.setFont(buttonFont);
        startButton.setPreferredSize(new Dimension((int)Math.ceil(width/5.12), (int)Math.ceil(height/10.8)));
        startButton.addActionListener(actionHandler);
        
        //Adding Labels to Panels
        titlePanel.add(titleText); //adding title text to panel
        startButtonPanel.add(startButton);
        
        //Adding panels to screen
        container.add(titlePanel);
        container.add(startButtonPanel);
        
    }
    
    Timer timer = new Timer(10, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            char character[] = text.toCharArray();
            int arrayLen = character.length;

            String s = String.valueOf(character[i]);
            storyText.append(s);
            i++;

            if(i == arrayLen){
                i = 0;
                timer.stop();
            }
        }
    });
    
    public void createGameScreen(){
        
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        
        //Story Panel
        storyPanel = new JPanel();
        storyPanel.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/5.0), (int)Math.ceil(width/1.3), (int)Math.ceil(height/4.32));
        storyPanel.setBackground(Color.decode("#280a68"));
        
        //Choice panel
        choicePanel = new JPanel();
        choicePanel.setBounds((int)Math.ceil(width/2.8981), (int)Math.ceil(height/2.16), (int)Math.ceil(width/3.072), (int)Math.ceil(height/2.88));
        choicePanel.setBackground(Color.blue);
        choicePanel.setLayout(new GridLayout(4,1));
        container.add(choicePanel);
        
    }
    
    public void stage1(){
        //Body
        text = "You are a new student at the University of Asia Pacific, eager to explore the opportunities that lie ahead. Make wise choices as you have limited time to balance academics, extracurricular activities, and personal growth. Good Luck!";
        storyText = new JTextArea();
        storyText.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.3), (int)Math.ceil(height/4.32));
        storyText.setBackground(Color.decode("#280a68"));
        storyText.setForeground(Color.white);
        storyText.setFont(normalFont);
        storyText.setLineWrap(true);
        storyText.setWrapStyleWord(true);
        storyPanel.add(storyText);
        container.add(storyPanel);
        timer.start();
        
        //Choices
//        choice1 = new JButton("Attend Class");
//        choice1.setBackground(Color.black);
//        choice1.setForeground(Color.white);
//        choice1.setPreferredSize(new Dimension(300, 80));
//        choice1.setFont(buttonFont);
//        choicePanel.add(choice1);
    }
    
    public class MainScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            
            createGameScreen();
            stage1();
        }
    }
    
}
