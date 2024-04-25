import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
   
    Container container;
    JFrame mainWindow;
    JPanel titlePanel, startButtonPanel, storyPanel, inputTextPanel, inputPanel, contButtonPanel;
    JPanel choiceButtonPanel, playerStatsPanel, contStoryPanel;
    JButton startButton, enter, contButton, choice1, choice2, choice3, choice4, contStory;
    JLabel titleText, timeLabel, timeValue, attndLabel, attndValue, cgpaLabel, cgpaValue, friendsLabel, friendsValue;
    JTextArea storyText, inputText;
    JTextField inputField;

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
    int width = (int)size.getWidth(); 
    int height = (int)size.getHeight();

    Font titleFont = new Font("Impact", Font.PLAIN, (int)Math.ceil(height/9.6));
    Font buttonFont = new Font("Garamond", Font.PLAIN, (int)Math.ceil(height/28.8));
    Font choiceFont = new Font("Garamond", Font.BOLD, (int)Math.ceil(height/28.8));
    Font normalFont = new Font("Calisto MT", Font.PLAIN, (int)Math.ceil(height/23));
    Font smallNormalFont = new Font("Calisto MT", Font.PLAIN, (int)Math.ceil(height/25));

    int time = 100, attendance = 0, friend = 0;
    float CGPA = 0.00f;
    String studentName, club = "", awards = "";
    
    String text;
    int i = 0, flag = 0, contStoryCount = 0;
    
    MainScreenHandler actionHandler = new MainScreenHandler();
    InputHandler inputHandler = new InputHandler();
    ContinueHandler continueHandler = new ContinueHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    ContStoryHandler contStoryHandler = new ContStoryHandler();
    
    public static void main(String[] args) {
        Game game = new Game();
    }
    
    public Game(){
        
        mainWindow = new JFrame();
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program by closing the window
        mainWindow.getContentPane().setBackground(Color.decode("#280a68")); //sets background colour
        mainWindow.setLayout(null); //for custom layout
        mainWindow.setVisible(true); //make it appear on screen
        container = mainWindow.getContentPane(); //for title screen
        
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
        startButton.setFocusPainted(false);
        
        //Adding Labels to Panels
        titlePanel.add(titleText); //adding title text to panel
        startButtonPanel.add(startButton);
        
        //Adding panels to screen
        container.add(titlePanel);
        container.add(startButtonPanel);
        SwingUtilities.updateComponentTreeUI(mainWindow);
        
    }
    
    Timer timer1 = new Timer(5, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            char character[] = text.toCharArray();
            int arrayLen = character.length;
            String s = String.valueOf(character[i]);
            inputText.append(s);
            i++;
            if(i == arrayLen){
                i = 0;
                timer1.stop();
            }
        }
    });
    
    Timer timer2 = new Timer(5, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            char character[] = text.toCharArray();
            int arrayLen = character.length;
            String s = String.valueOf(character[i]);
            storyText.append(s);
            i++;
            if(i == arrayLen){
                i = 0;
                timer2.stop();
            }
        }
    });
    
    public void resetStoryPanel(){
        storyPanel.remove(storyText);
        storyPanel.revalidate();
        storyPanel = new JPanel();
        storyPanel.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/5.0), (int)Math.ceil(width/1.3), (int)Math.ceil(height/3.9));
        storyPanel.setBackground(Color.decode("#280a68"));
        container.add(storyPanel);
    }
    
    public void setStoryText(){
        storyText = new JTextArea();
        storyText.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.3), (int)Math.ceil(height/3.9));
        storyText.setBackground(Color.decode("#280a68"));
        storyText.setForeground(Color.white);
        storyText.setFont(normalFont);
        storyText.setLineWrap(true);
        storyText.setWrapStyleWord(true);
        storyPanel.add(storyText);
    }
    
    public void playerStatPanel(){
        //Top Player Stat Panel
        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds((int)Math.ceil(width/15), (int)Math.ceil(height/86.4), (int)Math.ceil(width), (int)Math.ceil(height/7.2));
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
        
        cgpaLabel = new JLabel("    CGPA:");
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
    
    public void setPlayerStat(){
        
        timeValue.setText(""+time);
        attndValue.setText(""+attendance);
        cgpaValue.setText(""+CGPA);
        friendsValue.setText(""+friend);
        
        container.add(playerStatsPanel);
    }
    
    public void choiceButtonPanel(){
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds((int)Math.ceil(width/3.4), (int)Math.ceil(height/2.16), (int)Math.ceil(width/2.4), (int)Math.ceil(height/4.32));
        choiceButtonPanel.setBackground(Color.decode("#280a68"));
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        choiceButtonPanel.setVisible(true);
        container.add(choiceButtonPanel);
    }
    
    public void buttons(){
        choice1 = new JButton();
        choice1.setBackground(Color.decode("#a70c70"));
        choice1.setForeground(Color.white);
        choice1.setFont(choiceFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        
        choice2 = new JButton();
        choice2.setBackground(Color.decode("#a70c70"));
        choice2.setForeground(Color.white);
        choice2.setFont(choiceFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        
        choice3 = new JButton();
        choice3.setBackground(Color.decode("#a70c70"));
        choice3.setForeground(Color.white);
        choice3.setFont(choiceFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        
        choice4 = new JButton();
        choice4.setBackground(Color.decode("#a70c70"));
        choice4.setForeground(Color.white);
        choice4.setFont(choiceFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
    }
    
    public void contButton(){
        contStoryPanel = new JPanel();
        contStoryPanel.setBounds((int)Math.ceil(width/3.4), (int)Math.ceil(height/2), (int)Math.ceil(width/2.4), (int)Math.ceil(height/4.32));
        contStoryPanel.setBackground(Color.decode("#280a68"));
        contStoryPanel.setLayout(new GridLayout(4,1));
        
        contStory = new JButton("Continue");
        contStory.setBackground(Color.decode("#a70c70"));
        contStory.setForeground(Color.white);
        contStory.setFont(choiceFont);
        contStory.setFocusPainted(false);
        contStory.addActionListener(contStoryHandler);
        
        contStoryPanel.add(contStory);
        container.add(contStoryPanel);
    }
    
    public void introduction(){
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
       
        //Input Text Panel
        inputTextPanel = new JPanel();
        inputTextPanel.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/5.0), (int)Math.ceil(width/1.3), (int)Math.ceil(height/4.32));
        inputTextPanel.setBackground(Color.decode("#280a68"));
        
        //Input Text
        text = "Please enter your name: ";
        inputText = new JTextArea();
        inputText.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/5.0), (int)Math.ceil(width/1.3), (int)Math.ceil(height/4.32));
        inputText.setBackground(Color.decode("#280a68"));
        inputText.setForeground(Color.white);
        inputText.setFont(normalFont);
        inputText.setLineWrap(true);
        inputText.setWrapStyleWord(true);
        inputTextPanel.add(inputText);
        container.add(inputTextPanel);
        timer1.start();
        
        //Input Panel
        inputPanel = new JPanel();
        inputPanel.setBounds((int)Math.ceil(width/5.1), (int)Math.ceil(height/2.16), (int)Math.ceil(width/1.6), (int)Math.ceil(height/10.8));
        inputPanel.setBackground(Color.black);
        inputPanel.setLayout(new GridLayout(1,2));
        
        //Input Field
        inputField = new JTextField();
        inputField.setFont(normalFont);
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(inputField);
        
        //Enter Button
        enter = new JButton("E N T E R");
        //enter.setBackground(Color.decode("#280a68"));
        enter.setForeground(Color.black);
        enter.setFont(buttonFont);
        enter.addActionListener(inputHandler);
        enter.setFocusPainted(false);
        
        inputPanel.add(enter);
        container.add(inputPanel);
    }
    
    public void summary(String text){
        setPlayerStat();
        resetStoryPanel();
        this.text = text;
        setStoryText();
        i = 0;
        timer2.start();
    }
    
    public void stage1(){
        //Hiding input panel
        inputPanel.setVisible(false);
        inputTextPanel.setVisible(false);
        
        //Story Panel
        storyPanel = new JPanel();
        storyPanel.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/5.0), (int)Math.ceil(width/1.3), (int)Math.ceil(height/3.9));
        storyPanel.setBackground(Color.decode("#280a68"));
        
        //Body
        text = "Welcome " + studentName + "! You are a new student at the University of Asia Pacific. Explore the opportunities that lie ahead, and make wise choices as you have limited time to balance academics, extracurricular activities, and personal growth. Good Luck!";
        storyText = new JTextArea();
        storyText.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.3), (int)Math.ceil(height/3.9));
        storyText.setBackground(Color.decode("#280a68"));
        storyText.setForeground(Color.white);
        storyText.setFont(normalFont);
        storyText.setLineWrap(true);
        storyText.setWrapStyleWord(true);
        storyPanel.add(storyText);
        container.add(storyPanel);
        timer2.start();
        
        //Continue Button Panel
        contButtonPanel = new JPanel();
        contButtonPanel.setBounds((int)Math.ceil(width/2.6), (int)Math.ceil(height/2.16), (int)Math.ceil(width/4.9548), (int)Math.ceil(height/7.2));
        contButtonPanel.setBackground(Color.decode("#280a68"));
        
        //Continue Button
        contButton = new JButton("C O N T I N U E");
        contButton.setBackground(Color.decode("#280a68"));
        contButton.setForeground(Color.white);
        contButton.setFont(buttonFont);
        contButton.setPreferredSize(new Dimension((int)Math.ceil(width/5.12), (int)Math.ceil(height/10.8)));
        contButton.addActionListener(continueHandler);
        contButton.setFocusPainted(false);
        contButtonPanel.add(contButton);
        container.add(contButtonPanel);
        
        //Updates the screen to show latest addition to the panels
        SwingUtilities.updateComponentTreeUI(mainWindow);
    }
    
    public void stage2(){
        //Hiding Continue Button
        contButtonPanel.setVisible(false);
        
        //Removing previous story
        resetStoryPanel();
        
        //Setting up player stat panel at the top
        playerStatPanel();
        setPlayerStat();
        
        //Body
        text = "You enter your first class at UAP. Seems like your teacher isn’t here yet.\n\nWhat do you want to do?";
        setStoryText();
        timer2.start();
       
        //Adding Choice Buttons
        choiceButtonPanel();
        buttons();
        
        //Attend Button
        choice1.setText("Attend Class");
        choice1.setActionCommand("attend");
        
        //Bunk Button
        choice2.setText("Bunk Class");
        choice2.setActionCommand("bunk");
        
        //Adding buttons to the panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        
        //In case something's not loading, this helps
        container.revalidate();
    }
    
    public void stage3(){
        contStoryPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        text = "During a break in your schedule, you have a chance to catch your breath and decide how to make the most of your free time.";
        setStoryText();
        timer2.start();

        //Choice Buttons
        choiceButtonPanel();
        buttons();

        //Finish Homework Button
        choice1.setText("Finish Homework");
        choice1.setActionCommand("hw");

        //Hangout with friends button
        choice2.setText("Hangout With Friends");
        choice2.setActionCommand("hangout");
        
        if(club.length()>=1){
            //Club Activities button
            choice3.setText("Club Activities");
            choice3.setActionCommand("clubActivity");
            choiceButtonPanel.add(choice3);
        }
        
        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        
        container.revalidate(); //refresh
    }
    
    public void stage4(){
        contStoryPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        text = "UAP is hosting a club fair in the Plaza. You're presented with the opportunity to explore various clubs on campus.\n\nWhich club will you join?";
        setStoryText();
        timer2.start();

        //Choice Buttons
        choiceButtonPanel();
        buttons();

        //No Club button
        choice1.setText("None, I'm too busy");
        choice1.setActionCommand("none");

        //Math Club button
        choice2.setText("Math Club");
        choice2.setActionCommand("math");
        
        //Programming Contest Club
        choice3.setText("Programming Contest Club");
        choice3.setActionCommand("pcc");

        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
        container.revalidate(); //refresh
    }
    
    public void attend(){
        attendance++;
        CGPA+=0.5;
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 1 to 2
        time-=ThreadLocalRandom.current().nextInt(1, 10 + 1); //reduce time by a random number between 1 to 10
        summary("You decide to attend your first class at UAP, eager to make a good impression on your professors.\n\n");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void bunk(){
        friend+=ThreadLocalRandom.current().nextInt(1, 5 + 1); //increase friend by a random number between 1 to 5
        time-=ThreadLocalRandom.current().nextInt(1, 10 + 1); //reduce time by a random number between 1 to 10
        summary("Feeling a bit overwhelmed by the new environment, you decide to skip your first class and explore the campus instead.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void homework() {
        CGPA+=0.5;  //increase cgpa by 0.5
        time-=ThreadLocalRandom.current().nextInt(1, 10 + 1); //reduce time by a random number between 1 to 10
        summary("You use the break to finish up some homework assignments, determined to stay on top of your studies.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }

    public void hangout() {
        time-=ThreadLocalRandom.current().nextInt(1, 10 + 1); //reduce time by a random number between 1 to 10
        friend+=ThreadLocalRandom.current().nextInt(1, 3 + 1);
        summary("you decided to take a break and hangout with your friends, enjoying some quality time and fun activities. You can feel your bond strengthening.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void noClub() {
        awards+="Nothing Fazes Me";
        summary("With your schedule already packed, you decide to focus on your academics and forgo joining any clubs.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }

    public void mathClub() {
        club+="math";
        CGPA-=0.1;
        awards+="Math Enthusiast";
        time-=20;
        friend+=ThreadLocalRandom.current().nextInt(1, 3 + 1);
        summary("Intrigued by your love for mathematics, you decide to join the Math Club to meet like-minded individuals and participate in math-related activities.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }

    public void pccClub() {
        club+="pcc";
        CGPA-=0.1;
        awards+="Pro-grammer";
        time-=20;
        friend+=ThreadLocalRandom.current().nextInt(1, 3 + 1);
        summary("With a passion for coding, you eagerly sign up for the Programming Contest Club to sharpen your programming skills and compete in coding competitions.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public class MainScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            introduction();
        }
    }
    
    public class InputHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String name = inputField.getText();
            studentName = name;
            stage1();
        }
    }
    
    public class ContinueHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            timer2.stop();
            i=0;
            stage2();
        }
    }
    
    public class ChoiceHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String choice = event.getActionCommand();
            
            switch(choice){
                case "attend":
                    attend();
                    break;
                case "bunk":
                    bunk();
                    break;
                case "hw":
                    homework();
                    break;
                case "hangout":
                    hangout();
                    break;
                case "none":
                    noClub();
                    break;
                case "math":
                    mathClub();
                    break;
                case "pcc":
                    pccClub();
                    break;
                default:
                    break;
            }
        }
    }
    
    public class ContStoryHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            i = 0;
            switch(contStoryCount){
                case 0, 2:
                    stage3();
                    contStoryCount++;
                    break;
                case 1:
                    stage4();
                    contStoryCount++;
                    break;
                case 3:
                    //stage6();
                    contStoryCount++;
                    break;
                default:
                    break;
            }
        }
    }
    
    
}