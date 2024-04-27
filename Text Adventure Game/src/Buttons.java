import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons extends UpdateHandler{

    //Start Button
    public void addStartButton(){
        startButton = new JButton("S T A R T  G A M E");
        startButton.setBackground(Color.decode("#280a68"));
        startButton.setForeground(Color.white);
        startButton.setFont(buttonFont);
        startButton.setPreferredSize(new Dimension((int)Math.ceil(width/5.12), (int)Math.ceil(height/10.8)));
        startButton.setFocusPainted(false);
        
        //Adding Labels to Panels, then to container
        startButtonPanel.add(startButton);
        container.add(startButtonPanel);
    }
    
    //Enter Button
    public void addEnterButton(){
        enter = new JButton("E N T E R");
        enter.setForeground(Color.black);
        enter.setFont(buttonFont);
        enter.setFocusPainted(true);
    }
    
    //A single continue button (used once)
    public void addContinueButton(){
        continueButton = new JButton("C O N T I N U E");
        continueButton.setBackground(Color.decode("#280a68"));
        continueButton.setForeground(Color.white);
        continueButton.setFont(buttonFont);
        continueButton.setPreferredSize(new Dimension((int)Math.ceil(width/5.12), (int)Math.ceil(height/12)));
        continueButton.setFocusPainted(false);
        continueButtonPanel.add(continueButton);
        container.add(continueButtonPanel);
    }
    
    //Choice buttons
    public void choiceButtons(){
        choice1 = new JButton();
        choice1.setBackground(Color.decode("#a70c70"));
        choice1.setForeground(Color.white);
        choice1.setFont(choiceFont);
        choice1.setFocusPainted(false);
        
        choice2 = new JButton();
        choice2.setBackground(Color.decode("#a70c70"));
        choice2.setForeground(Color.white);
        choice2.setFont(choiceFont);
        choice2.setFocusPainted(false);
        
        choice3 = new JButton();
        choice3.setBackground(Color.decode("#a70c70"));
        choice3.setForeground(Color.white);
        choice3.setFont(choiceFont);
        choice3.setFocusPainted(false);
        
        choice4 = new JButton();
        choice4.setBackground(Color.decode("#a70c70"));
        choice4.setForeground(Color.white);
        choice4.setFont(choiceFont);
        choice4.setFocusPainted(false);
    }
    
    //Continue story button
    public void addContinueStoryButton(){
        continueStoryButtonPanel = new JPanel();
        continueStoryButtonPanel.setBounds((int)Math.ceil(width/3.4), (int)Math.ceil(height/2), (int)Math.ceil(width/2.4), (int)Math.ceil(height/4.32));
        continueStoryButtonPanel.setBackground(Color.decode("#280a68"));
        continueStoryButtonPanel.setLayout(new GridLayout(4,1));
        
        continueStoryButton = new JButton("Continue");
        continueStoryButton.setBackground(Color.decode("#a70c70"));
        continueStoryButton.setForeground(Color.white);
        continueStoryButton.setFont(choiceFont);
        continueStoryButton.setFocusPainted(false);
        
        continueStoryButtonPanel.add(continueStoryButton);
        container.add(continueStoryButtonPanel);
    }
    
}
