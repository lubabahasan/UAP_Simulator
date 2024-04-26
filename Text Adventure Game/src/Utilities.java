import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Utilities extends Student {
    
    //All the utilities defined
    Container container;
    JFrame mainWindow;
    JPanel titlePanel, startButtonPanel, storyPanel, inputTextPanel, inputPanel, contButtonPanel;
    JPanel choiceButtonPanel, playerStatsPanel, contStoryPanel, gameStatPanel;
    JButton startButton, enter, contButton, choice1, choice2, choice3, choice4, contStory;
    JLabel titleText, timeLabel, timeValue, attndLabel, attndValue, cgpaLabel, cgpaValue, friendsLabel, friendsValue;
    JLabel stageValue, stageLabel;
    JTextArea storyText, inputText;
    JTextField inputField;
    
    //Getting screen dimensions
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
    int width = (int)size.getWidth(); 
    int height = (int)size.getHeight();
    
    //All the fonts
    Font titleFont = new Font("Impact", Font.PLAIN, (int)Math.ceil(height/9.6));
    Font buttonFont = new Font("Garamond", Font.PLAIN, (int)Math.ceil(height/28.8));
    Font choiceFont = new Font("Garamond", Font.BOLD, (int)Math.ceil(height/28.8));
    Font normalFont = new Font("Calisto MT", Font.PLAIN, (int)Math.ceil(height/23));
    Font smallNormalFont = new Font("Calisto MT", Font.PLAIN, (int)Math.ceil(height/25.5));
    
    //title panel
    public void titlePanel(){
        titlePanel = new JPanel();
        titlePanel.setBounds((int)Math.ceil(width/4.8), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.71), (int)Math.ceil(height/7.2)); //panel resolution
        titlePanel.setBackground(Color.decode("#a70c70")); //panel background colour
        
        //title text
        titleText = new JLabel("U A P  S I M U L A T O R");
        titleText.setForeground(Color.white);
        titleText.setFont(titleFont);
        
        //Adding Labels to Panels, then to container
        titlePanel.add(titleText);
        container.add(titlePanel);
    }
    
    //Start button panel
    public void startButtonPanel(){
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds((int)Math.ceil(width/2.6), (int)Math.ceil(height/2.16), (int)Math.ceil(width/4.9548), (int)Math.ceil(height/7.2));
        startButtonPanel.setBackground(Color.decode("#280a68"));
        
        //Adding Labels to Panels, then to container
        startButtonPanel.add(startButton);
        container.add(startButtonPanel);

    }
    
    //Game statistics panel (at the top)
    public void gameStatPanel(){
        //Top game Stat Panel
        gameStatPanel = new JPanel();
        gameStatPanel.setBounds((int)Math.ceil(width/6), (int)Math.ceil(height/55), (int)Math.ceil(width/1.5), (int)Math.ceil(height/12));
        gameStatPanel.setBackground(Color.decode("#280a68"));
        gameStatPanel.setLayout(new GridLayout(1,4));
        
        //Adding Stat Labels to Panel
        stageLabel = new JLabel("    Stage:");
        stageLabel.setFont(smallNormalFont);
        stageLabel.setForeground(Color.white);
        
        stageValue = new JLabel();
        stageValue.setFont(smallNormalFont);
        stageValue.setForeground(Color.white);
        
        gameStatPanel.add(stageLabel);
        gameStatPanel.add(stageValue);
    }

    //Player statistics panel (at the top)
    public void playerStatPanel(){
        //Top Player Stat Panel
        playerStatsPanel = new JPanel();
        playerStatsPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        playerStatsPanel.setBounds((int)Math.ceil(width/30), (int)Math.ceil(height/9), (int)Math.ceil(width/1.05), (int)Math.ceil(height/12));
        playerStatsPanel.setBackground(Color.decode("#280a68"));
        playerStatsPanel.setLayout(new GridLayout(1,8));
        
        //Adding Stat Labels to Panel
        timeLabel = new JLabel("    Time:");
        timeLabel.setFont(smallNormalFont);
        timeLabel.setForeground(Color.white);
        timeValue = new JLabel();
        timeValue.setFont(smallNormalFont);
        timeValue.setForeground(Color.white);
        
        attndLabel = new JLabel("Attendance:");
        attndLabel.setFont(smallNormalFont);
        attndLabel.setForeground(Color.white);
        attndValue = new JLabel();
        attndValue.setFont(smallNormalFont);
        attndValue.setForeground(Color.white);
        
        cgpaLabel = new JLabel("  CGPA:");
        cgpaLabel.setFont(smallNormalFont);
        cgpaLabel.setForeground(Color.white);
        cgpaValue = new JLabel();
        cgpaValue.setFont(smallNormalFont);
        cgpaValue.setForeground(Color.white);
        
        friendsLabel = new JLabel(" Friends:");
        friendsLabel.setFont(smallNormalFont);
        friendsLabel.setForeground(Color.white);
        friendsValue = new JLabel();
        friendsValue.setFont(smallNormalFont);
        friendsValue.setForeground(Color.white);
        
        playerStatsPanel.add(timeLabel);
        playerStatsPanel.add(timeValue);
        playerStatsPanel.add(attndLabel);
        playerStatsPanel.add(attndValue);
        playerStatsPanel.add(cgpaLabel);
        playerStatsPanel.add(cgpaValue);
        playerStatsPanel.add(friendsLabel);
        playerStatsPanel.add(friendsValue);
    }
    
    //Story panel
    public void resetStoryPanel(){
        storyPanel.remove(storyText);
        storyPanel.revalidate();
        storyPanel = new JPanel();
        storyPanel.setBounds((int)Math.ceil(width/7.4), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.3), (int)Math.ceil(height/5));
        storyPanel.setBackground(Color.decode("#280a68"));
        container.add(storyPanel);
    }
    
    //Choice panel
    public void choiceButtonPanel(){
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds((int)Math.ceil(width/3.4), (int)Math.ceil(height/2.15), (int)Math.ceil(width/2.4), (int)Math.ceil(height/4.32));
        choiceButtonPanel.setBackground(Color.decode("#280a68"));
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        choiceButtonPanel.setVisible(true);
        container.add(choiceButtonPanel);
    }
    
    
    
}
