import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game extends Buttons {
    
    //Handlers
    MainScreenHandler actionHandler = new MainScreenHandler();
    InputHandler inputHandler = new InputHandler();
    ContinueHandler continueHandler = new ContinueHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    ContinueStoryHandler continueStoryHandler = new ContinueStoryHandler();
    
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
        addStartButton();      //shows the start button
        startButton.addActionListener(actionHandler);

        SwingUtilities.updateComponentTreeUI(mainWindow); //to make newly added components appear 
    }
    
    //Summary of the effect a choice brings    ------------- W O R K      H E R E
    public void summary(String text, String changes){
        setPlayerStat();
        resetStoryPanel();
        this.text = text + "\n" + changes;
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
    public void stage1_WelcomeStudent(){
        //Hiding input panel
        inputNamePanel.setVisible(false);
        
        resetStoryPanel();
        
        text = "Welcome " + studentName + "! You are a new student at the University of Asia Pacific. Explore the opportunities that lie ahead, and make wise choices as you have limited time to balance academics, extracurricular activities, and personal growth. Good Luck!";
        setStoryText();
        timer.start();
        
        addContinueButtonPanel();
        addContinueButton();
        continueButton.addActionListener(continueHandler);
        
        //Updates the screen to show latest addition to the panels
        SwingUtilities.updateComponentTreeUI(mainWindow);
    }
    
    //Stage 2 : Class
    public void stage2_Class(){
        continueButtonPanel.setVisible(false); //Hiding Continue Button
        
        if(stageCount==2){
            resetStoryPanel(); 
            addPlayerStatPanel(); 
            addGameStatPanel();
            setPlayerStat();
            text = "You enter your first class at UAP. Seems like your teacher isn’t here yet.\nWhat do you want to do?";
        
        } else {
            resetStoryPanel(); 
            setPlayerStat();
            text = "As the familiar routine of classes resumes, you find yourself once again at a crossroads.\nWhat do you want to do?";
            //continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        }
        
        setStoryText();
        timer.start();
       
        //Adding Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();
        
        
        //Setting up the buttons
            //Attend Button
            choice1.setText("Attend Class");
            choice1.setActionCommand("attend");

            //Skip Button
            choice2.setText("Skip Class");
            choice2.setActionCommand("skip");

            //Hangout with Friends
            choice3.setText("Hangout With Friends");
            choice3.setActionCommand("hangout");
            
            addChoiceHandler();

            if(stageCount>4 && club.length()>1){
                //Club Activity
                choice4.setText("Club Activities");
                choice4.setActionCommand("clubActivity");
                choiceButtonPanel.add(choice4);
            }
        
        //Adding buttons to the panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
    }  //------------- W O R K      H E R E
    
    public void stage3(){
        continueStoryButtonPanel.setVisible(false); 
        resetStoryPanel();  //resetting story panel
        setPlayerStat();    //updating status bar at the top

        //Body
        text = "During a break in your schedule, you have a chance to catch your breath and decide how to make the most of your free time.";
        setStoryText();
        timer.start();

        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();

        //Setting up the buttons
            //Finish Homework Button
            choice1.setText("Finish Homework");
            choice1.setActionCommand("homework");

            //Hangout with friends button
            choice2.setText("Hangout With Friends");
            choice2.setActionCommand("hangout");

            //Go To The Library
            choice3.setText("Go To The Library");
            choice3.setActionCommand("library");

            if(club.length()>=1 && stageCount>4){
                //Club Activities button
                choice4.setText("Club Activities");
                choice4.setActionCommand("clubActivity");
                choiceButtonPanel.add(choice4);
            }
            
            addChoiceHandler();
        
        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
    }  //------------- W O R K      H E R E
    
    public void stage4(){
        continueStoryButtonPanel.setVisible(false); 
        resetStoryPanel(); 
        setPlayerStat(); 

        //Body
        text = "The first event of the semester is here! UAP is hosting a club fair in the Plaza. You're presented with the opportunity to explore various clubs on campus. Which club will you join?";
        setStoryText();
        timer.start();

        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();
        
        //Setting up the buttons
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
        
    }  //------------- W O R K      H E R E
    
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
        
    }  //------------- W O R K      H E R E
    
    public void stage8(){
        continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top

        //Body
        if(stageCount<8)
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
        
    }  //------------- W O R K      H E R E
    
    public void stage9(){
        continueStoryButtonPanel.setVisible(false); //Hiding story continue button
        resetStoryPanel(); //resetting story panel
        setPlayerStat(); //updating status bar at the top
        
        if(stageCount<11){
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
        
    }  //------------- W O R K      H E R E
    
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
        
    } //------------- W O R K      H E R E
    
    
    //------------------------ C H O I C E S --------------------------
    
    
    public void attend(){
        time-=10;       //reduces time by 10
        attendance++;   //attendance gained
        study+=0.5;     //study gained
        ftemp=0.5;      //for CGPA gained
        
        //Summary texts
        switch (stageCount) {
            case 3:
                summaryText = "You decide to attend your first class at UAP, eager to make a good impression on your professors.";
                break;
            case 7:
                summaryText = "Prepared with knowledge and confidence, you decide to sit for the surprise test.";
                break;
            case 9:
                summaryText = "Armed with knowledge and preparation, you attend your mid term exams with confidence.";
                break;
            case 14:
                summaryText = "Armed with knowledge and preparation, you attend your final term exams with confidence.";
                break;
            default:
                summaryText = "You decide to attend the class, with a sense of determination to engage with the material and seize the opportunities the class offers.";
                break;
        }
        
        //Attribute Changes
        switch(stageCount){
            case 7, 9, 14:
                ftemp = (attendance*0.25)+(study*0.1);
                if(ftemp>0){
                    if(stageCount==14)
                        CGPA=0;
                    changes = "CGPA : +"+String.format("%.2f", ftemp);
                    CGPA+=ftemp;
                    if(CGPA>4) CGPA=4;
                }
                break;
            default:
                changes = "CGPA : +"+String.format("%.2f", ftemp)+"\n";
                CGPA+=ftemp;
                temp = ThreadLocalRandom.current().nextInt(0, 2 + 1); //increase friend by a random number between 0 to 2
                if(temp>0){
                    changes += "Friend : +"+temp;
                    friend+=temp;
                }
                break;
        }
        
        addChoiceUtilities();
        
    }  //------------- W O R K      H E R E
    
    public void skip(){
        time-=10;  //reduces time by 10
        
        //Summary Texts
        switch (stageCount) {
            case 3:
                summaryText = "You decide to skip your first class at UAP.\nYou mope around all day doing nothing of significance.";
                break;
            case 7:
                summaryText = "Feeling unprepared and overwhelmed, you consider skipping class to avoid the surprise test.";
                break;
            case 9:
                summaryText = "Overwhelmed by the pressure of exams, you consider skipping your midterms to avoid the stress.";
                break;
            default:
                summaryText = "You decide to skip the class and prioritise a task of greater importance to you.";
                break;
        }
        
        //Attribute Changes
        switch(stageCount){
            case 7, 9:
                if(stageCount==7)
                    ftemp = 0.2;
                else
                    ftemp = 0.5;
                changes = "CGPA : -"+String.format("%.2f", ftemp)+"\n";
                CGPA-=ftemp;
                if(CGPA<0) CGPA=0;
                break;
            default:
                break;
        }
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E
    
    public void library(){
        time-=10; //reduces time by 10
        CGPA+=0.5;
        if(CGPA>4) CGPA=4;
        study++;
        if(stageCount==6){
            summary("With midterms approaching, you prioritize studying and preparing for your exams to ensure academic success.");
        } else {
            summary("You decide to spend the time in the library, looking through academic materials.");
        }
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E
  
    public void cheat(){
        time-=10; //reduce time by 10
        attendance++;
        if(stageCount==7){
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
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E
    
    public void homework() {
        CGPA+=0.5;  //increase cgpa by 0.5
        
        if(CGPA>4) CGPA=4;
        study++;
        time -= 10; //reduce time by 10
        
        summaryText = "You use the break to finish up some homework assignments, determined to stay on top of your studies";
        changes = "CGPA gained : +0.5";
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E

    public void hangout() {
        time-=10; //reduce time by 10
        temp = ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 0 to 2
        
        //Summary Texts
        summaryText = "You decided to take a break and hangout with your friends, enjoying some quality time and fun activities. You can feel your bond strengthening.";
        
        //Attribute Changes
        changes = "Friend : +"+temp;
        friend += temp;
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E
    
    public void noClub() {
        awards+="Nothing Fazes Me";
        summary("With your schedule already packed, you decide to focus on your academics and forgo joining any clubs.");
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E

    public void mathClub() {
        club+="Math Club";
        CGPA-=0.1;
        if(CGPA<0) CGPA=0;
        if(CGPA>4) CGPA=4;
        awards+="Math Enthusiast";
        time-= 10; //reduce time by 10
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 1 to 2
        summary("Intrigued by your love for mathematics, you decide to join the Math Club to meet like-minded individuals and participate in math-related activities.");
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E

    public void pccClub() {
        club+="Programming Contest Club";
        CGPA-=0.1;
        if(CGPA<0) CGPA=0;
        if(CGPA>4) CGPA=4;
        awards+="Pro-grammer";
        time-= 10; //reduce time by 10
        friend+=ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 1 to 2
        summary("With a passion for coding, you eagerly sign up for the Programming Contest Club to sharpen your programming skills and compete in coding competitions.");
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E
    
    public void clubActivity(){
        time-= 10; //reduce time by 10
        clubActivity++;
        CGPA-=0.02;
        if(CGPA<0) CGPA=0;
        if(stageCount==6 && club.length()>0){
            summary("As a member of the "+club+", you help organize and promote the club's events, contributing to its success and growth.");
        }else if(stageCount==6){
            summary("You help organize and promote the club events as a volunteer, contributing to their success and growth.");
        } else if(stageCount==5){
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
        
        addChoiceUtilities();
        
    } //------------- W O R K      H E R E
    
    
    //------------------------ H A N D L E R S --------------------------

    
    public class MainScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            i=0;
            gettingStudentName();
        }
    }
    
    public class InputHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            i=0;
            String name = inputNameField.getText();
            studentName = name;
            stage1_WelcomeStudent();
        }
    }
    
    public class ContinueHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            timer.stop();
            i=0;
            stage2_Class();
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
                case "homework":
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
    } //------------- W O R K      H E R E
     
    public class ContinueStoryHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            i = 0;
            
            if(CGPA>4) CGPA=4;
            if(CGPA<0) CGPA=0;
            
            SwingUtilities.updateComponentTreeUI(mainWindow); //to make newly added components appear 
            
            stageCount++;
            switch(stageCount){
                case 3, 6, 11:
                    stage3();
                    break;
                case 4:
                    stage4();
                    //stageCount++;
                    break;
                case 5, 10:
                    stage2_Class();
                    //stageCount++;
                    break;
                case 7:
                    stage6();
                    //stageCount++;
                    break;
                case 8, 12:
                    stage8();
                    //stageCount++;
                    break;
                case 9, 14:
                    stage9();
                    //stageCount++;
                    break;
                case 13:
                    stage13();
                    //stageCount++;
                    break;
                default:
                    break;
            }
        }
    } //------------- W O R K      H E R E
    
    public void addChoiceHandler(){
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
    }
    
    public void addChoiceUtilities(){
        summary(summaryText, changes);
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton();
        continueStoryButton.addActionListener(continueStoryHandler);       
    }
    
}