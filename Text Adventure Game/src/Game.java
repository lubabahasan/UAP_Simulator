import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends Buttons {
    
    //Handlers
    MainScreenHandler actionHandler = new MainScreenHandler();
    InputHandler inputHandler = new InputHandler();
    ContinueHandler continueHandler = new ContinueHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    ContStoryHandler contStoryHandler = new ContStoryHandler();
    
    //main method
    public static void main(String[] args) {
        Game game = new Game();
    }
    
    //Game class's constructor
    public Game(){
        
        mainWindow = new JFrame();
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);             //fullscreen
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //exits program by closing the window
        mainWindow.getContentPane().setBackground(Color.decode("#280a68")); 
        mainWindow.setLayout(null); 
        mainWindow.setVisible(true); 
        container = mainWindow.getContentPane(); 
        
        addTitlePanel();       //shows the title
        addStartButtonPanel(); //shows start button panel
        addStartButton();         //shows the start button
        
        SwingUtilities.updateComponentTreeUI(mainWindow); //to make newly added components appear 
    }
    
    //Summary of the effect a choice brings    ------------- W O R K      H E R E
    public void summary(String text){
        setPlayerStat();
        resetStoryPanel();
        this.text = text;
        setStoryText();
        i = 0;
        timer.start();
    }
    
    //Getting student's name
    public void gettingStudentName(){
            titlePanel.setVisible(false);
            startButtonPanel.setVisible(false);

            text = "Please enter your name: ";
            addStoryPanel();
            setStoryText();
            container.add(storyPanel);
            timer.start();

            addInputNamePanel();
            addInputNameField();

            addEnterButton();
            enter.addActionListener(inputHandler);

            inputNamePanel.add(enter);
            container.add(inputNamePanel);
        }
    
    
    //------------------------- S T A G E S --------------------------
    
    
    //Stage 1 : Student Initialization
    public void stage1_welcomeStudent(){
        //Hiding input panel
        inputNamePanel.setVisible(false);
        
        resetStoryPanel();
        
        text = "Welcome " + studentName + "! You are a new student at the University of Asia Pacific. Explore the opportunities that lie ahead, and make wise choices as you have limited time to balance academics, extracurricular activities, and personal growth. Good Luck!";
        setStoryText();
        timer.start();
        
        addContinueButtonPanel();
        addContinueButton();
        
        //Updates the screen to show latest addition to the panels
        SwingUtilities.updateComponentTreeUI(mainWindow);
    }
    
    public void stage2(){
        
        if(contStoryCount<2){
            continueButtonPanel.setVisible(false); //Hiding Continue Button
            resetStoryPanel(); //Removing previous story
            addPlayerStatPanel(); //Setting up player stat panel at the top
            addGameStatPanel();
            setPlayerStat();
            text = "You enter your first class at UAP. Seems like your teacher isn’t here yet.\nWhat do you want to do?";
        
        } else if(contStoryCount>=2){
            resetStoryPanel(); //Removing previous story
            addGameStatPanel();
            setPlayerStat();
            text = "As the familiar routine of classes resumes, you find yourself once again at a crossroads.\nWhat do you want to do?";
            continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        }
        
        setStoryText();
        timer.start();
       
        //Adding Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();
        
        //Attend Button
        choice1.setText("Attend Class");
        choice1.setActionCommand("attend");
        
        //Skip Button
        choice2.setText("Skip Class");
        choice2.setActionCommand("skip");
        
        //Hangout with Friends
        choice3.setText("Hangout With Friends");
        choice3.setActionCommand("hangout");
        
        if(contStoryCount>6){
            //Club Activity
            choice4.setText("Club Activities");
            choice4.setActionCommand("clubActivity");
            choiceButtonPanel.add(choice4);
        }
        
        //Adding buttons to the panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
        container.revalidate(); //In case something's not loading, this helps
    }
    
    public void stage3(){
        continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        text = "During a break in your schedule, you have a chance to catch your breath and decide how to make the most of your free time.";
        setStoryText();
        timer.start();

        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();

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
        continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        text = "The first event of the semester is here! UAP is hosting a club fair in the Plaza. You're presented with the opportunity to explore various clubs on campus. Which club will you join?";
        setStoryText();
        timer.start();

        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();
        
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
        continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        text = "With midterms approaching, your teacher announces a surprise class test.\nWhat do you want to do?";
        setStoryText();
        timer.start();

        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();

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
        continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        if(contStoryCount<8)
            text = "As the semester progresses, the students of UAP involve themselves in arranging several different events, creating a joyous atmosphere.\nWhat do you plan to do?";
        else
            text = "As the end of the semester comes close, The Math Club is hosting a math olympiad, while the Programming Contest Club is planning a hackathon. You have been invited to assist in organizing the event, or you can choose to participate. What will you do?";

        setStoryText();
        timer.start();
        
        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();

        if(club.length()>=1){
            //Do Club Work
            choice3.setText("Do Club Work");
            choice3.setActionCommand("clubActivity");
            //Study
            choice4.setText("Study");
            choice4.setActionCommand("library");
            choiceButtonPanel.add(choice4);
        } else {
            //Study
            choice3.setText("Study");
            choice3.setActionCommand("library");
        }

        //Participate In The Competitions
        choice1.setText("Participate In Competitions");
        choice1.setActionCommand("extraCurr");

        //Volunteer For The Events
        choice2.setText("Volunteer For Events");
        choice2.setActionCommand("clubActivity");
        
        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
        container.revalidate(); //refresh
    }
    
    public void stage9(){
        continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top
        
        if(contStoryCount<11){
            if(attendance<1){
                text = "Midterms are finally here. Unfortunately, due to low attendance, you did not get the permission to sit for the exam.\nBe careful next time.";
                setStoryText();
                timer.start();
                CGPA-=0.5;
                if(CGPA<0) CGPA=0;
                addContinueStoryButton();
            } else {
                text = "Midterms are finally here. What choice will you make?";
            }
        } else {
            if(attendance<3){
                text = "The finals are finally here. Unfortunately, due to low attendance, you did not get the permission to sit for the exam. This automatically results in a semester drop for you.\nSee you next time...";
                setStoryText();
                timer.start();
                CGPA-=2.0;
                if(CGPA<0) CGPA=0;
                addContinueStoryButton();
            } else {
                text = "The finals are finally here. How do you plan on proceeding?";
            }
        }
        
        setStoryText();
        timer.start();

        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();

        //attend honestly
        choice1.setText("Attend Honestly");
        choice1.setActionCommand("attend");

        //skip the exam
        choice2.setText("Skip The Exam");
        choice2.setActionCommand("skip");

        //Cheat in the exam
        choice3.setText("Cheat In The Exam");
        choice3.setActionCommand("cheat");

        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
        container.revalidate(); //refresh
    }
    
    public void stage13(){
        continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        text = "It's the final stretch of the semester, and you're feeling the pressure. With finals approaching, you must weigh the importance of studying against the opportunity to relax and bond with friends on a road trip.\nWhat will you do?";
        setStoryText();
        timer.start();
        
        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();
        
        //Go on the trip
        choice1.setText("Go On The Trip");
        choice1.setActionCommand("hangout");

        //study
        choice2.setText("Study For The Exam");
        choice2.setActionCommand("libary");
        
        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        
        container.revalidate(); //refresh
    }
    
    
    //------------------------ C H O I C E S --------------------------
    
    
    public void attend(){
        time-=10; //reduces time by 10
        attendance++;
        CGPA+=0.5;
        if(CGPA>4) CGPA=4;
        if(contStoryCount==4){
            CGPA+=(attendance*0.5)+(study*0.1);
            if(CGPA>4) CGPA=4;
            summary("Prepared with knowledge and confidence, you decide to sit for the surprise test.");
        } else if(contStoryCount==0){
            study++;
            friend+=ThreadLocalRandom.current().nextInt(0, 2 + 1); //increase friend by a random number between 0 to 2
            summary("You decide to attend your first class at UAP, eager to make a good impression on your professors.");
        } else if(contStoryCount==7){
            summary("Armed with knowledge and preparation, you attend your midterm exams with confidence.");
            CGPA+=(attendance*0.5)+(study*0.1);
            if(CGPA>4) CGPA=4;
        }else {
            study++;
            friend+=ThreadLocalRandom.current().nextInt(0, 2 + 1); //increase friend by a random number between 0 to 2
            summary("You decide to attend the class, with a sense of determination to engage with the material and seize the opportunities the class offers");
        }
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }
    
    public void library(){
        time-=10; //reduces time by 10
        CGPA+=0.5;
        if(CGPA>4) CGPA=4;
        study++;
        if(contStoryCount==6){
            summary("With midterms approaching, you prioritize studying and preparing for your exams to ensure academic success.");
        } else {
            summary("You decide to spend the time in the library, looking through academic materials.");
        }
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }
    
    public void skip(){
        time-=10; //reduces time by 10
        if(contStoryCount==4){
            CGPA-=0.2;
            if(CGPA<0) CGPA=0;
            summary("Feeling unprepared and overwhelmed, you consider skipping class to avoid the surprise test.");
        } else if(contStoryCount==0){
            summary("You decide to skip your first class at UAP.\nYou mope around all day doing nothing of significance.");
        } else if(contStoryCount==7){
            CGPA-=0.5;
            if(CGPA<0) CGPA=0;
            summary("Overwhelmed by the pressure of exams, you consider skipping your midterms to avoid the stress.");
        } else
            summary("You decide to skip the class and prioritise a task of greater importance to you.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }
    
    public void cheat(){
        time-=10; //reduce time by 10
        attendance++;
        if(contStoryCount==7){
            String temp = "Tempted by the desire to succeed at any cost, you contemplate cheating on your exams to secure a passing grade.";
            if(attendance<2){
                temp+=" The invigilator catches you in the process and deducts marks from your paper.";
            } else if(study>=3){
                temp+=" Knowing the whereabouts of the course materials helps you with it.";
            }
            summary(temp);
        } else {
            if(friend>=2){
                CGPA+=ThreadLocalRandom.current().nextFloat(0.5f, 1 + 1);
                if(CGPA>4) CGPA=4;
                summary("Fearing the consequences of failure, you resort to cheating on the test. Your friends help you with it.");
            } else if(friend<=1 && friend>0){
                CGPA+=ThreadLocalRandom.current().nextFloat(0, 0.5f + 1);
                if(CGPA>4) CGPA=4;
                summary("Fearing the consequences of failure, you resort to cheating on the test. Your friend helps you with it.");
            } else if(attendance<=1 && study<=1){
                CGPA+=ThreadLocalRandom.current().nextFloat(0, -0.5f + 1);
                if(CGPA>4) CGPA=4;
                summary("Fearing the consequences of failure, you resort to cheating on the test. Alas, the teacher catches you in the process and deducts marks");
            } else {
                CGPA+=(attendance*0.2)+(study*0.1);
                if(CGPA>4) CGPA=4;
                summary("Fearing the consequences of failure, you resort to cheating on the test. Knowing the whereabouts of the course materials helps you with it.");
            }
        }
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }
    
    public void homework() {
        CGPA+=0.5;  //increase cgpa by 0.5
        if(CGPA>4) CGPA=4;
        study++;
        time-=10; //reduce time by 10
        summary("You use the break to finish up some homework assignments, determined to stay on top of your studies.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }

    public void hangout() {
        time-=10; //reduce time by 10
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 0 to 2
        summary("You decided to take a break and hangout with your friends, enjoying some quality time and fun activities. You can feel your bond strengthening.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }
    
    public void noClub() {
        awards+="Nothing Fazes Me";
        summary("With your schedule already packed, you decide to focus on your academics and forgo joining any clubs.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }

    public void mathClub() {
        club+="Math Club";
        CGPA-=0.1;
        if(CGPA<0) CGPA=0;
        if(CGPA>4) CGPA=4;
        awards+="Math Enthusiast";
        time-= 10; //reduce time by 10
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 1 to 2
        summary("Intrigued by your love for mathematics, you decide to join the Math Club to meet like-minded individuals and participate in math-related activities.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }

    public void pccClub() {
        club+="Programming Contest Club";
        CGPA-=0.1;
        if(CGPA<0) CGPA=0;
        if(CGPA>4) CGPA=4;
        awards+="Pro-grammer";
        time-= 10; //reduce time by 10
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 1 to 2
        summary("With a passion for coding, you eagerly sign up for the Programming Contest Club to sharpen your programming skills and compete in coding competitions.");
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }
    
    public void clubActivity(){
        time-= 10; //reduce time by 10
        clubActivity++;
        CGPA-=0.02;
        if(CGPA<0) CGPA=0;
        if(contStoryCount==6 && club.length()>0){
            summary("As a member of the "+club+", you help organize and promote the club's events, contributing to its success and growth.");
        }else if(contStoryCount==6){
            summary("You help organize and promote the club events as a volunteer, contributing to their success and growth.");
        } else if(contStoryCount==5){
            summary("Since you've joined the "+club+", you decide to spend your break attending a club meeting and discussing upcoming activities and events.");
        } else {
            summary("You continue to participate in club activities during your breaks, enjoying the camaraderie and sense of belonging that comes with being part of the "+club+".");
        }
        /*switch (clubActivity) {
                case 1:
                    awards+=", Executive Member";
                    summary("Since you've joined the "+club+", you decide to spend your break attending a club meeting and discussing upcoming activities and events.");
                    break;
                case 2:
                    awards+=", Vice President";
                    CGPA-=0.1;
                    summary("You continue to participate in club activities during your breaks, enjoying the camaraderie and sense of belonging that comes with being part of the "+club+".");
                    break;
                case 3:
                    awards+=", President";
                    CGPA-=0.2;
                    break;
                default:
                    break;
        }*/
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton(); //showing the continue story button
    }
    
    
    //------------------------ H A N D L E R S --------------------------

    
    public class MainScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            gettingStudentName();
        }
    }
    
    public class InputHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String name = inputNameField.getText();
            studentName = name;
            stage1_welcomeStudent();
        }
    }
    
    public class ContinueHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            timer.stop();
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
                case 0, 4, 8:
                    stage3();
                    contStoryCount++;
                    break;
                case 1:
                    stage4();
                    contStoryCount++;
                    break;
                case 2, 7:
                    stage2();
                    contStoryCount++;
                    break;
                case 3:
                    stage6();
                    contStoryCount++;
                    break;
                case 5, 9:
                    stage8();
                    contStoryCount++;
                    break;
                case 6, 11:
                    stage9();
                    contStoryCount++;
                    break;
                case 10:
                    stage13();
                    contStoryCount++;
                    break;
                default:
                    break;
            }
        }
    }
    
    
    //------------------------- B U T T O N S --------------------------
    
    
    //Start Game button
    public void addStartButton(){
        startButton = new JButton("S T A R T  G A M E");
        startButton.setBackground(Color.decode("#280a68"));
        startButton.setForeground(Color.white);
        startButton.setFont(buttonFont);
        startButton.setPreferredSize(new Dimension((int)Math.ceil(width/5.12), (int)Math.ceil(height/10.8)));
        startButton.addActionListener(actionHandler);
        startButton.setFocusPainted(false);
        
        //Adding Labels to Panels, then to container
        startButtonPanel.add(startButton);
        container.add(startButtonPanel);
    }
    
    //Choice buttons
    public void choiceButtons(){
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
        continueStoryButton.addActionListener(contStoryHandler);
        
        continueStoryButtonPanel.add(continueStoryButton);
        container.add(continueStoryButtonPanel);
    }
    
    //A single continue button (used once)
    public void addContinueButton(){
        continueButton = new JButton("C O N T I N U E");
        continueButton.setBackground(Color.decode("#280a68"));
        continueButton.setForeground(Color.white);
        continueButton.setFont(buttonFont);
        continueButton.setPreferredSize(new Dimension((int)Math.ceil(width/5.12), (int)Math.ceil(height/12)));
        continueButton.addActionListener(continueHandler);
        continueButton.setFocusPainted(false);
        continueButtonPanel.add(continueButton);
        container.add(continueButtonPanel);
    }
    
    
}