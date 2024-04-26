import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Stages extends Utilities{
    
    //Story text setting
    public void setStoryText(){
        storyText = new JTextArea();
        storyText.setBounds((int)Math.ceil(width/7.4), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.3), (int)Math.ceil(height/100));
        storyText.setBackground(Color.decode("#280a68"));
        storyText.setForeground(Color.white);
        storyText.setFont(normalFont);
        storyText.setLineWrap(true);
        storyText.setWrapStyleWord(true);
        storyPanel.add(storyText);
    }
    
    //Updates player state Panel
    public void setPlayerStat(){
        
        timeValue.setText(""+time);
        attndValue.setText("   "+attendance);
        cgpaValue.setText(""+String.format("%.2f", CGPA));
        friendsValue.setText(" "+friend);
        stageValue.setText(" "+contStoryCount);
        
        
        container.add(playerStatsPanel);
        container.add(gameStatPanel);
        SwingUtilities.updateComponentTreeUI(mainWindow);

    }
}
