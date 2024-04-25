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

    int time = 100, attendance = 0, friend = 0, clubActivity = 0, study = 0;
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
        cgpaValue.setText(""+String.format("%.2f", CGPA));
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
        contButtonPanel.setVisible(false); //Hiding Continue Button

        resetStoryPanel(); //Removing previous story
        
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
        
        //Skip Button
        choice2.setText("Skip Class");
        choice2.setActionCommand("skip");
        
        //Hangout with Friends
        choice3.setText("Hangout With Friends");
        choice3.setActionCommand("hangout");
        
        //Adding buttons to the panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
        container.revalidate(); //In case something's not loading, this helps
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
        
        //Go To The Library
        choice3.setText("Go To The Library");
        choice3.setActionCommand("library");
        
        if(club.length()>=1){
            //Club Activities button
            choice3.setText("Club Activities");
            choice3.setActionCommand("clubActivity");
            choiceButtonPanel.add(choice3);
        }
        
        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
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
        
        //Math Club button
        choice1.setText("Math Club");
        choice1.setActionCommand("math");
        
        //Programming Contest Club
        choice2.setText("Programming Contest Club");
        choice2.setActionCommand("pcc");
        
        //No Club button
        choice3.setText("None, I'm too busy");
        choice3.setActionCommand("none");

        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
        container.revalidate(); //refresh
    }
    
    public void stage6(){
        contStoryPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        text = "With midterms approaching, your teacher announces a surprise class test.\n\nWhat do you want to do?";
        setStoryText();
        timer2.start();

        //Choice Buttons
        choiceButtonPanel();
        buttons();

        //Attend the test button
        choice1.setText("Attend The Test");
        choice1.setActionCommand("attend");

        //Flunk the test button
        choice2.setText("Skip The Test");
        choice2.setActionCommand("skip");
        
        //Cheat button
        choice3.setText("Cheat In The Test");
        choice3.setActionCommand("cheat");

        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
        container.revalidate(); //refresh
    }
    
    public void stage8(){
        contStoryPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        text = "As the semester progresses, the students of UAP involve themselves in arranging several different events, creating a joyous atmosphere.\n\nWhat do you plan to do?";
        setStoryText();
        timer2.start();
        
        //Choice Buttons
        choiceButtonPanel();
        buttons();

        if(club.length()>=1){
            //Do Club Work
            choice2.setText("Do Club Work");
            choice2.setActionCommand("clubActivity");
            choiceButtonPanel.add(choice2);
        }

        //Study
        choice1.setText("Study");
        choice1.setActionCommand("library");
        
        //Participate In The Competitions
        choice3.setText("Participate In Competitions");
        choice3.setActionCommand("extraCurr");

        //Volunteer For The Events
        choice4.setText("Volunteer For Events");
        choice4.setActionCommand("clubActivity");
        
        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice3);
        choiceButtonPanel.add(choice4);
        
        container.revalidate(); //refresh
    }
    
    public void attend(){
        attendance++;
        CGPA+=0.5;
        if(contStoryCount==4){
            CGPA+=(attendance*0.5)+(study*0.1);
            summary("Armed with knowledge and confidence, you decide to sit for the surprise test.");
        } else {
            study++;
            friend+=ThreadLocalRandom.current().nextInt(0, 2 + 1); //increase friend by a random number between 0 to 2
            summary("You decide to attend your first class at UAP, eager to make a good impression on your professors.\n\n");
        }
        if(CGPA>4) CGPA=4;
        time-=10; //reduces time by 10
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void library(){
        time-=10; //reduces time by 10
        if(contStoryCount==6){
            CGPA+=0.5;
            study++;
            if(CGPA>4) CGPA=4;
            summary("With midterms approaching, you prioritize studying and preparing for your exams to ensure academic success.");
        } else if(attendance>0 || study>0){
            CGPA+=0.5;
            study++;
            if(CGPA>4) CGPA=4;
            summary("You decide to spend the time in the library, looking through academic materials.");
        } else {
            summary("You decide to spend the time in the library, searching for comics and fictions.");
        }
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void skip(){
        time-=10; //reduces time by 10
        if(contStoryCount==4)
            summary("Feeling unprepared and overwhelmed, you consider skipping class to avoid the surprise test.");
        else
            summary("You decide to skip your first class at UAP.\nYou mope around all day doing nothing of significance.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void bunk(){
        if(contStoryCount==4){
            CGPA-=1.0;
            if(CGPA<0) CGPA=0;
            if(CGPA>4) CGPA=4;
        }
        friend+=ThreadLocalRandom.current().nextInt(0, 2 + 1); //increase friend by a random number between 0 to 2
        time-=ThreadLocalRandom.current().nextInt(5, 10 + 1);; //reduces time by a random number between 5 to 10
        summary("Feeling a bit overwhelmed by the new environment, you decide to skip your first class and explore the campus instead.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void cheat(){
        attendance++;
        if(friend>=2){
            CGPA+=ThreadLocalRandom.current().nextFloat(0.5f, 1 + 1);
            summary("Fearing the consequences of failure, you resort to cheating on the test. Your friends help you with it.");
        } else if(friend<=1 && friend>0){
            CGPA+=ThreadLocalRandom.current().nextFloat(0, 0.5f + 1);
            summary("Fearing the consequences of failure, you resort to cheating on the test. Your friend helps you with it.");
        } else if(attendance<2 && study<=1){
            CGPA+=ThreadLocalRandom.current().nextFloat(0, -0.5f + 1);
            summary("Fearing the consequences of failure, you resort to cheating on the test. Alas, the teacher catches you in the process and deducts marks");
        } else {
            CGPA+=(attendance*0.2)+(study*0.1);
            summary("Fearing the consequences of failure, you resort to cheating on the test. Knowing the whereabouts of the course materials helps you with it.");
        }
        if(CGPA>4) CGPA=4;
        if(CGPA<0) CGPA=0;
        time-=10; //reduce time by 10
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void homework() {
        CGPA+=0.5;  //increase cgpa by 0.5
        study++;
        if(CGPA>4) CGPA=4;
        time-=ThreadLocalRandom.current().nextInt(5, 10 + 1); //reduce time by a random number between 5 to 10
        summary("You use the break to finish up some homework assignments, determined to stay on top of your studies.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }

    public void hangout() {
        time-=ThreadLocalRandom.current().nextInt(5, 10 + 1); //reduce time by a random number between 5 to 10
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 0 to 2
        summary("You decided to take a break and hangout with your friends, enjoying some quality time and fun activities. You can feel your bond strengthening.");
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
        club+="Math Club";
        CGPA-=0.1;
        if(CGPA<0) CGPA=0;
        if(CGPA>4) CGPA=4;
        awards+="Math Enthusiast";
        time-= ThreadLocalRandom.current().nextInt(5, 10 + 1); //reduce time by a random number between 5 to 10
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 1 to 2
        summary("Intrigued by your love for mathematics, you decide to join the Math Club to meet like-minded individuals and participate in math-related activities.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }

    public void pccClub() {
        club+="Programming Contest Club";
        CGPA-=0.1;
        if(CGPA<0) CGPA=0;
        if(CGPA>4) CGPA=4;
        awards+="Pro-grammer";
        time-= ThreadLocalRandom.current().nextInt(5, 10 + 1); //reduce time by a random number between 5 to 10
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 1 to 2
        summary("With a passion for coding, you eagerly sign up for the Programming Contest Club to sharpen your programming skills and compete in coding competitions.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        contButton(); //showing the continue story button
    }
    
    public void clubActivity(){
        time-= ThreadLocalRandom.current().nextInt(5, 10 + 1); //reduce time by a random number between 5 to 10
        clubActivity++;
        if(contStoryCount==6 && club.length()>0){
            summary("As a member of the "+club+", you help organize and promote the club's events, contributing to its success and growth.");
        }else if(contStoryCount==6){
            summary("You help organize and promote the club events as a volunteer, contributing to their success and growth.");
        } else{
            switch (clubActivity) {
                case 2:
                    awards+=", Executive Member";
                    summary("Since you've joined the "+club+", you decide to spend your break attending a club meeting and discussing upcoming activities and events.");
                    break;
                case 3:
                    awards+=", Vice President";
                    CGPA-=0.1;
                    summary("You continue to participate in club activities during your breaks, enjoying the camaraderie and sense of belonging that comes with being part of the "+club+".");
                    break;
                case 4:
                    awards+=", President";
                    CGPA-=0.2;
                    break;
                default:
                    break;
            }
        }
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
                case "skip":
                    skip();
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
                case "clubActivity":
                    clubActivity();
                    break;
                case "cheat":
                    cheat();
                    break;
                case "library":
                    library();
                    break;
                case "extraCurr":
                    
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
                case 0, 2, 4:
                    stage3();
                    contStoryCount++;
                    break;
                case 1:
                    stage4();
                    contStoryCount++;
                    break;
                case 3:
                    stage6();
                    contStoryCount++;
                    break;
                case 5:
                    stage8();
                    contStoryCount++;
                    break;
                default:
                    break;
            }
        }
    }
    
    
}