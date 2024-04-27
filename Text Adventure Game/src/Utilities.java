import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

class Utilities extends Student {
    
    //Used for calculations
    String text = "", summaryText = "", changes = "";  int i = 0, stageCount = 2, temp, flag = 0; double ftemp;
    
    //All the utilities defined
    Container container;
    JFrame mainWindow;
    JPanel titlePanel, startButtonPanel, storyPanel, inputNamePanel, continueButtonPanel;
    JPanel choiceButtonPanel, playerStatsPanel, continueStoryButtonPanel, gameStatPanel;
    JPanel endButtonPanel;
    JButton startButton, enter, continueButton, choice1, choice2, choice3, choice4;
    JButton continueStoryButton, endButton;
    JLabel titleText, timeLabel, timeValue, attndLabel, attndValue, cgpaLabel, cgpaValue, friendsLabel, friendsValue;
    JLabel stageValue, stageLabel;
    JTextArea storyText;
    JTextField inputNameField;
    
    //Getting screen dimensions
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
    int width = (int)size.getWidth(); 
    int height = (int)size.getHeight();
    
    //All the fonts
    Font titleFont = new Font("Impact", Font.PLAIN, (int)Math.ceil(height/9.6));
    Font buttonFont = new Font("Garamond", Font.PLAIN, (int)Math.ceil(height/28.8));
    Font choiceFont = new Font("Garamond", Font.BOLD, (int)Math.ceil(height/28.8));
    Font normalFont = new Font("Calisto MT", Font.PLAIN, (int)Math.ceil(height/25));
    Font smallNormalFont = new Font("Calisto MT", Font.PLAIN, (int)Math.ceil(height/25.5));
    
    //Timer to delay story appearing character by character
    Timer timer = new Timer(5, new ActionListener(){
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
    
    //Title panel
    public void addTitlePanel(){
        titlePanel = new JPanel();
        titlePanel.setBounds((int)Math.ceil(width/5.1), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.71), (int)Math.ceil(height/7.2)); //panel resolution
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
    public void addStartButtonPanel(){
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds((int)Math.ceil(width/2.7), (int)Math.ceil(height/2.16), (int)Math.ceil(width/4.9548), (int)Math.ceil(height/7.2));
        startButtonPanel.setBackground(Color.decode("#280a68"));
    }
    
    //Story Panel
    public void addStoryPanel(){
        storyPanel = new JPanel();
        storyPanel.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/5.0), (int)Math.ceil(width/1.3), (int)Math.ceil(height/3.9));
        storyPanel.setBackground(Color.decode("#280a68"));
    }
    
    //Story Text
    public void addStoryText(){
        storyText = new JTextArea();
        storyText.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.3), (int)Math.ceil(height/3.9));
        storyText.setBackground(Color.decode("#280a68"));
        storyText.setForeground(Color.white);
        storyText.setFont(normalFont);
        storyText.setLineWrap(true);
        storyText.setWrapStyleWord(true);
        storyPanel.add(storyText);
        container.add(storyPanel);
    }
    
    //Reset the story panel
    public void resetStoryPanel(){
        storyPanel.remove(storyText);
        storyPanel.revalidate();
        storyPanel = new JPanel();
        storyPanel.setBounds((int)Math.ceil(width/7.4), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.3), (int)Math.ceil(height/4.95));
        storyPanel.setBackground(Color.decode("#280a68"));
        container.add(storyPanel);
    }
    
    //Input Name Panel
    public void addInputNamePanel(){
        inputNamePanel = new JPanel();
        inputNamePanel.setBounds((int)Math.ceil(width/5.1), (int)Math.ceil(height/2.16), (int)Math.ceil(width/1.6), (int)Math.ceil(height/10.8));
        inputNamePanel.setBackground(Color.black);
        inputNamePanel.setLayout(new GridLayout(1,2));
    }
    
    //Input Field
    public void addInputNameField(){
        inputNameField = new JTextField();
        inputNameField.setFont(normalFont);
        inputNameField.setHorizontalAlignment(JTextField.CENTER);
        inputNamePanel.add(inputNameField);
    }
    
    //Continue Button Panel
    public void addContinueButtonPanel(){
        continueButtonPanel = new JPanel();
        continueButtonPanel.setBounds((int)Math.ceil(width/2.6), (int)Math.ceil(height/2.1), (int)Math.ceil(width/4.9548), (int)Math.ceil(height/7.2));
        continueButtonPanel.setBackground(Color.decode("#280a68"));
    }
    
    //Game statistics panel (at the top)
    public void addGameStatPanel(){
        //Top game Stat Panel
        gameStatPanel = new JPanel();
        gameStatPanel.setBounds((int)Math.ceil(width/2.5), (int)Math.ceil(height/55), (int)Math.ceil(width/5), (int)Math.ceil(height/12));
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
    public void addPlayerStatPanel(){
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
        timeValue = new JLabel("");
        timeValue.setFont(smallNormalFont);
        timeValue.setForeground(Color.white);
        
        attndLabel = new JLabel("Attendance:");
        attndLabel.setFont(smallNormalFont);
        attndLabel.setForeground(Color.white);
        attndValue = new JLabel("");
        attndValue.setFont(smallNormalFont);
        attndValue.setForeground(Color.white);
        
        cgpaLabel = new JLabel("  CGPA:");
        cgpaLabel.setFont(smallNormalFont);
        cgpaLabel.setForeground(Color.white);
        cgpaValue = new JLabel("");
        cgpaValue.setFont(smallNormalFont);
        cgpaValue.setForeground(Color.white);
        
        friendsLabel = new JLabel(" Friends:");
        friendsLabel.setFont(smallNormalFont);
        friendsLabel.setForeground(Color.white);
        friendsValue = new JLabel("");
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
    
    //Choice panel
    public void addChoiceButtonPanel(){
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds((int)Math.ceil(width/3.4), (int)Math.ceil(height/2.15), (int)Math.ceil(width/2.4), (int)Math.ceil(height/4.32));
        choiceButtonPanel.setBackground(Color.decode("#280a68"));
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        choiceButtonPanel.setVisible(true);
        container.add(choiceButtonPanel);
    }
    

}
