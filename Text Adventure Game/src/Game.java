import java.awt.Color;
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
    ContinueStoryHandler continueStoryHandler = new ContinueStoryHandler();
    EndHandler endHandler = new EndHandler();
    
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
        mainWindow.setFocusable(false);
        container = mainWindow.getContentPane();
        
        addTitlePanel();       //shows the title
        addStartButtonPanel(); //shows start button panel
        addStartButton();      //shows the start button
        startButton.addActionListener(actionHandler);

        SwingUtilities.updateComponentTreeUI(mainWindow); //to make newly added components appear 
    }   //lubaba
    
    //Summary of the effect a choice brings    ------------- W O R K      H E R E
    public void summary(String text, String changes){
        setPlayerStat();
        resetStoryPanel();
        this.text = text + "\n" + changes;
        changes = " ";
        setStoryText();
        i = 0;
        timer.start();
    }  //nujhat
    
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
        }   //rifah
    
    
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
    }  //rahi
    
    //Stage 2,5,10 : Class
    public void stage2_Class(){
        continueButtonPanel.setVisible(false); //Hiding Continue Button
        
        if(stageCount==2){
            resetStoryPanel(); 
            addPlayerStatPanel(); 
            addGameStatPanel();
            setPlayerStat();
            text = "You enter your first class at UAP. Seems like your teacher isn’t here yet.\nWhat do you want to do?";
        
        } else {
            continueStoryButtonPanel.setVisible(false);
            resetStoryPanel(); 
            setPlayerStat();
            text = "As the familiar routine of classes resumes, you find yourself once again at a crossroads.\nWhat do you want to do?";
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
            
            if(stageCount>4 && club.length()>0){
                //Club Activity
                choice4.setText("Club Activities");
                choice4.setActionCommand("clubActivity");
                choiceButtonPanel.add(choice4);
            }
            
            addChoiceHandler();
        
        //Adding buttons to the panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
    }    //nujhat
    
    //Stage 3,6,11 : Break
    public void stage3_Break(){
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
        
    }     //rifah
    
    //Stage 4 : Club Fair
    public void stage4_ClubFair(){
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
            
            addChoiceHandler();

        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
    }   //nujhat
    
    //Stage 7 : Class Test
    public void stage7_ClassTest(){
        continueStoryButtonPanel.setVisible(false); 
        resetStoryPanel(); 
        setPlayerStat(); 

        //Body
        text = "With midterms approaching, your teacher announces a surprise class test. Your teacher isn't here yet\nWhat do you want to do?";
        setStoryText();
        timer.start();

        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();
        
        //Setting up choices
            //Attend the test button
            choice1.setText("Attend The Test");
            choice1.setActionCommand("attend");

            //Skip the test button
            choice2.setText("Skip The Test");
            choice2.setActionCommand("skip");

            //Cheat button
            choice3.setText("Cheat In The Test");
            choice3.setActionCommand("cheat");
            
            addChoiceHandler();

        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        
    }   //rifah
    
    //Stage 8,12 : Club Event
    public void stage8_ClubEvent(){
        continueStoryButtonPanel.setVisible(false); 
        resetStoryPanel(); 
        setPlayerStat(); 

        //Body
        if(stageCount==8)
            text = "As the semester progresses, the students of UAP involve themselves in arranging several different events, creating a joyous atmosphere. ";
        else
            text = "As the end of the semester comes close, The Math Club is hosting a math olympiad, while the Programming Contest Club is planning a hackathon.";
        
        if(club.length()>1){
            text += " You have been invited to assist in organizing the event.";
        } else
            text += " You have been invited to participate.";
        text += " What will you do?";
        
        setStoryText();
        timer.start();
        
        //Choice Buttons
        addChoiceButtonPanel();
        choiceButtons();

        //Setting up choices
            //Study
            choice2.setText("Study For Exam");
            choice2.setActionCommand("library");

            /*//Participate In The Competitions
            choice3.setText("Participate In Competitions");
            choice3.setActionCommand("extra");*/

            //Volunteer For The Events
            if(club.length()>1)
                choice1.setText("Do Club Work");
            else
                choice1.setText("Volunteer For Events");
            choice1.setActionCommand("clubActivity");

            addChoiceHandler();
        
        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        //choiceButtonPanel.add(choice3);
        
    }   //lubaba
    
    //Stage 9,14 : Term Exam
    public void stage9_TermExam(){
        continueStoryButtonPanel.setVisible(false); 
        resetStoryPanel(); 
        setPlayerStat(); 
        
        if(stageCount==9){
            if(attendance<1){
                text = "Midterm exams are finally here. Unfortunately, due to low attendance, you did not get the permission to sit for the exam. Be careful next time.";
                if(CGPA>0)
                    text += "\nCGPA : -0.50";
                
                CGPA -= 0.5;
                if(CGPA<0) CGPA=0;
                
                setStoryText();
                timer.start();
                addContinueStoryButton();
                continueStoryButton.addActionListener(continueStoryHandler);
            
            } else {
                text = "Midterm exams are finally here. What choice will you make?";
                flag = 1;
            }
        } else {
            if(attendance<2){
                text = "The Final term is here. Unfortunately, due to low attendance, you did not get the permission to sit for the exam. This automatically results in a semester drop for you.\nSee you next time...";
                setStoryText();
                timer.start();
            } else {
                text = "The Final term is here. How do you plan on proceeding?";
                flag = 1;
            }
        }
        
        setStoryText();
        timer.start();
        
        if(flag==1){
            //Choice Buttons
            addChoiceButtonPanel();
            choiceButtons();

            //Setting up the buttons
                //Attend honestly
                choice1.setText("Attend Honestly");
                choice1.setActionCommand("attend");

                //Skip the exam
                choice2.setText("Skip The Exam");
                choice2.setActionCommand("skip");

                //Cheat in the exam
                choice3.setText("Cheat In The Exam");
                choice3.setActionCommand("cheat");

                addChoiceHandler();

            //Adding buttons to panel
            choiceButtonPanel.add(choice1);
            choiceButtonPanel.add(choice2);
            choiceButtonPanel.add(choice3);
        }

        
        
    }    //lubaba
    
    //Stage 13 : Relax
    public void stage13_Relax(){
        continueStoryButtonPanel.setVisible(false); 
        resetStoryPanel(); 
        setPlayerStat(); 

        //Body
        text = "It's the final stretch of the semester, and you're feeling the pressure. With finals approaching, you must weigh the importance of studying against the opportunity to relax and bond with friends on a road trip.\nWhat will you do?";
        setStoryText();
        timer.start();
        
        //Setting up buttons
            //Choice Buttons
            addChoiceButtonPanel();
            choiceButtons();

            //Go on the trip
            choice1.setText("Go On The Trip");
            choice1.setActionCommand("hangout");

            //study
            choice2.setText("Study For The Exam");
            choice2.setActionCommand("libary");

            addChoiceHandler();
        
        //Adding buttons to panel
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        
    }   //rahi
    
    //Stage 15 : End of Semester
    public void stage15_SemesterEnds(){
        continueStoryButtonPanel.setVisible(false); 
        resetStoryPanel(); 
        setPlayerStat(); 
        int flag1 = 0;
        
        //Body
        text = "And with that, the semester comes to an end...\nYou've earned the following achievements\n";
        
        if(club.length()>1){
            switch (clubActivity) {
                case 1:
                    achievement5 = "Junior Executive Member";
                    break;
                case 2:
                    achievement5 = "Senior Executive Member";
                    break;
                case 3:
                    achievement5 = "Vice President";
                    break;
                default:
                    if(clubActivity!=0)
                        achievement5 = "President";
                    break;
            }
        } else if(clubActivity!=0) {
            achievement5 = "Spirit of Service";
        }
        
        if(achievement1.length()>1){
            text+="\n"+achievement1;
            if(club.length()>1)
                text+=" - What a journey it has been with the "+club+".\n";
            else
                text+=" - You have demonstrate exceptional resilience my friend. I commend you\n";
            flag1 = 1;
        }
        if(achievement5.length()>1){
            
            if(club.length()>1)
                text+="\n"+achievement5+" - Your hard work towards the club has been rewarded. You've been promoted to the "+achievement5+" of the "+club+". Congratulations!\n";
            else
                text+="\n"+achievement5+" - Thank you for all the help with the events comrade\n";
            flag1 = 1;
        }
        if(achievement3.length()>1){
            text+="\n"+achievement3+" - You've made the impossible possible. I commend you\n";
            flag1 = 1;
        }
        if(achievement4.length()>1){
            text+="\n"+achievement4+" - \"Maybe The Real Treasure Was the Friends We Made Along the Way. :>\"\n";
            flag1 = 1;
        }
        if(achievement2.length()>1){
            text+="\n"+achievement2+" - You've made the impossible possible. I commend you\n";
            flag1 = 1;
        }
        
        setStoryText();
        storyText.setBounds((int)Math.ceil(width/7.4), (int)Math.ceil(height/4.32), (int)Math.ceil(width/1.3), (int)Math.ceil(height/1.2));
        storyPanel.setBounds((int)Math.ceil(width/7.2), (int)Math.ceil(height/5.0), (int)Math.ceil(width/1.3), (int)Math.ceil(height/1.2));
        timer.start();
        
        //Setting up buttons
            addEndButton();
        
        SwingUtilities.updateComponentTreeUI(mainWindow);

    }    //lubaba
    
    
    //------------------------ C H O I C E S --------------------------
    
    public void attend(){
        time-=10;       //reduces time by 10
        attendance++;   //attendance gained
        study+=0.5;     //study gained
        ftemp=0.75;      //for CGPA gained
        changes = " ";
        summaryText = " ";
        achievement2 = " ";
        
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
                if(stageCount==7)
                    ftemp = (attendance*0.25)+(study*0.25);
                else if(stageCount==9)
                    ftemp = (attendance*0.15)+(study*0.15);
                else
                    ftemp = (attendance*0.1)+(study*0.15);
                
                if(ftemp>0){
                    changes = "CGPA : +"+String.format("%.2f", ftemp);
                    CGPA+=ftemp;
                    if(CGPA>=4 || ftemp==0)
                        changes = " ";
                    if(CGPA>4) CGPA=4;
                }
                break;
            default:
                changes = "CGPA : +"+String.format("%.2f", ftemp)+"\n";
                if(CGPA>=4 || ftemp==0)
                    changes = " ";
                CGPA+=ftemp;
                if(CGPA>4) CGPA=4;
                temp = ThreadLocalRandom.current().nextInt(0, 2 + 1); //increase friend by a random number between 0 to 2
                if(temp>0){
                    changes += "Friend : +"+temp;
                    friend+=temp;
                }
                break;
        }
        
        addChoiceUtilities();
        
    }    //nujhat
    
    public void skip(){
        time-=10;  //reduces time by 10
        changes = " ";
        ftemp = 0.1;
        summaryText = " ";
        
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
            case 7, 9, 14:
                
                if(stageCount==7)
                    ftemp = 0.1;
                else if(stageCount==9)
                    ftemp = 0.2;
                else
                    ftemp = 0.5;
                
                changes = "CGPA : -"+String.format("%.2f", ftemp)+"\n";
                if(CGPA==0)
                    changes = " ";
                CGPA-=ftemp;
                if(CGPA<0) CGPA=0;
                break;
            default:
                changes = " ";
                break;
        }
        
        addChoiceUtilities();
        
    }      //rahi
    
    public void library(){
        time -= 10;   //reduces time by 10
        ftemp = 0.5;
        study += 0.25;
        changes = " ";
        summaryText = " ";
        
        //Summary Texts
        if(stageCount==6){
            summaryText = "With mid term approaching, you prioritize studying and preparing for your exams to ensure academic success.";
        } else if (stageCount==11 || stageCount==13){
            summaryText = "With final term approaching, you prioritize studying and preparing for your exams to ensure academic success.";
        } else {
            summaryText = "You decide to spend the time in the library, looking through academic materials.";
        }
        
        //Attribute Changes
        switch(stageCount){
            case 2:
                break;
            default:
                changes = "CGPA : +"+String.format("%.2f", ftemp)+"\n";
                CGPA+=ftemp;
                if(CGPA>4) CGPA=4;
                break;
        }
        
        addChoiceUtilities();
        
    }     //rifah
  
    public void cheat(){
        changes = " ";
        summaryText = " ";
        time-=10; //reduce time by 10
        attendance++;
        achievement2 = "";
        
        //Summary Text
        switch(stageCount){
            case 7:
                summaryText = "Fearing the consequences of failure, you resort to cheating on the test.";
                break;
            case 9, 14:
                summaryText = "Tempted by the desire to succeed at any cost, you contemplate cheating on your exams to secure a passing grade.";
                break;
            default:
                break;
        }
        
        //Attribute Changes and some more texts
        switch(stageCount){
            case 7:
                if(attendance<1 || study<0.25f){
                    summaryText += " The invigilator catches you in the process and deducts marks from your paper.";
                    ftemp = -0.1;
                } else if(friend>7){
                    summaryText += " Your friends help you with it.";
                    achievement2 = "Apes Together Strong";
                    ftemp = ThreadLocalRandom.current().nextFloat(0, 0.5f + 1);
                } else {
                    summaryText += " Knowing the whereabouts of the course materials helps you with it.";
                    ftemp = (attendance*0.2)+(study*0.2);
                }
                break;
            case 9:
                if(study<0.5f){
                    summaryText += " The invigilator catches you in the process and deducts marks from your paper.";
                    ftemp = -0.2;
                } else if(friend>7){
                    summaryText += " Your friends help you with it.";
                    achievement2 = "Apes Together Strong";
                    ftemp = ThreadLocalRandom.current().nextFloat(0, 0.5f + 1);
                } else {
                    summaryText += " Knowing the whereabouts of the course materials helps you with it.";
                    ftemp = (attendance*0.25)+(study*0.25);
                }
                break;
            case 14:
                if(study<1 && friend<7) {
                    summaryText += " The invigilator catches you in the process and deducts marks from your paper.";
                    ftemp = -0.5;
                } else if(friend>=9){
                    summaryText += " Your friends help you with it.";
                    achievement3 = "The Power of Friendship";
                    ftemp = ThreadLocalRandom.current().nextFloat(0, 0.5f + 1);
                } else {
                    ftemp = (attendance*0.15)+(study*0.15);
                }
                break;
            default:
                break;
        }
        
        //Attribute Changes
        if(ftemp>0)
            changes = "CGPA : +"+String.format("%.2f", ftemp)+"\n";
            if(CGPA>=4)
                changes = " ";
            CGPA+=ftemp;
            if(CGPA>4) CGPA = 4;
        else
            changes = "CGPA : "+String.format("%.2f", ftemp)+"\n";
            if(CGPA<0)
                changes = " ";
            CGPA+=ftemp;
            if(CGPA<0) CGPA = 0;
        
        addChoiceUtilities();
        
    }       //lubaba
    
    public void homework() {
        ftemp = 0.25; 
        study++;
        time -= 10; //reduce time by 10
        changes = " ";
        summaryText = " ";
        
        //Summary Text
        summaryText = "You use the break to finish up some homework assignments, determined to stay on top of your studies.";
        
        //Attribute Changes
        changes = "CGPA : +"+ftemp;
        CGPA+=ftemp;
        
        addChoiceUtilities();
        
    }  //nujhat

    public void hangout() {
        time-=10; //reduce time by 10
        temp = ThreadLocalRandom.current().nextInt(1, 2 + 1); //increase friend by a random number between 0 to 2
        changes = " ";
        summaryText = " ";
        
        //Summary Texts
        if(stageCount==2){
            summaryText = "You decide to take advantage of the break to hang out with some new friends you've made on campus.";
        } else if(stageCount==3 || stageCount==6 || stageCount==11) {
            summaryText = "You decide to take a break and hangout with your friends, enjoying some quality time and fun activities. You can feel your bond strengthening.";
        } else if(stageCount==13){
            summaryText = "You decide to to go on the trip. As you explore new places and create unforgettable memories together, you feel the pressure of exams leaving your body."; 
            achievement4 = "Explorer";
        } else {
            summaryText = "You decide to take a break from your studies and spend time with your friends.";
        }
        
        //Attribute Changes
        changes = "Friend : +"+temp;
        friend += temp;
        
        addChoiceUtilities();
        
    }    //rahi
    
    public void Club(){
        time -= 10; //reduce time by 10
        ftemp = 0.01;
        clubActivity++;
        changes = " ";
        summaryText = " ";
        
        //Summary Text
        switch(stageCount){
            case 5, 10:
                summaryText = "Since you've joined the "+club+", you decide to spend your break attending a club meeting and discussing upcoming activities and events.";
                break;
            case 6, 11:
                summaryText = "You continue to participate in club activities during your breaks, enjoying the camaraderie and sense of belonging that comes with being part of the "+club+".";
                break;
            case 8, 12:
                if(club.length()>1)
                    summaryText = "As a member of the "+club+", you help organize and promote the club's events, contributing to its success and growth.";
                else
                    summaryText = "You help organize and promote the club events as a volunteer, contributing to their success and growth.";
                summaryText += " However, everything comes at a cost...";
                break;
            default:
                break;
        }
        
        //Attribute Changes
        changes = "CGPA : -"+ftemp+"\n";
        if(CGPA==0)
            changes = " ";
        CGPA-=ftemp;
        
        addChoiceUtilities();
        
    }          //rifah
    
    public void Club(String club) {
        time -= 10; //reduce time by 10
        if(club!="none"){
            temp=ThreadLocalRandom.current().nextInt(1, 2 + 1); 
            ftemp = 0.1;
        } else{
            temp=0;
            ftemp = 0;
        }
        changes = " ";
        summaryText = " ";
        
        switch(club){
            case "pcc":
                this.club = "Programming Contest Club";
                achievement1 += "Pro-grammer";
                summaryText = "With a passion for coding, you eagerly sign up for the Programming Contest Club to sharpen your programming skills and compete in coding competitions.";
                break;
            case "math":
                this.club = "Math Club";
                achievement1 += "Math Enthusiast";
                summaryText = "Intrigued by your love for mathematics, you decide to join the Math Club to meet like-minded individuals and participate in math-related activities.";
                break;
            case "none":
                achievement1 += "Nothing Fazes Me";
                summaryText = "With your schedule already packed, you decide to focus on your academics and forgo joining any clubs.";
                break;
            default:
                break;
        }
        
        //Attribute Changes
        changes = "CGPA : -"+ftemp+"\n";
        if(CGPA==0 || ftemp==0)
            changes = " ";
        CGPA-=ftemp;
        changes += "Friend : +"+temp;
        if(temp==0)
            changes = " ";
        friend+=temp;
        
        addChoiceUtilities();
        
    }     //rahi
    
    public void extra(){
        time-=10;
        changes = " ";
        summaryText = " ";
        
        //Summary Text
        summaryText = "Can't figure out what to add here ";
        
        //Attribute Changes
        changes = "CGPA : +"+ftemp;
        CGPA+=ftemp;
        
        addChoiceUtilities();
    }   //lubaba
   
    //------------------------ H A N D L E R S --------------------------

    public class MainScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            i=0;
            gettingStudentName();
        }
    }       //rifah
    
    public class InputHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            i=0;
            String name = inputNameField.getText();
            studentName = name;
            stage1_WelcomeStudent();
        }
    }       //nujhat
    
    public class ContinueHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            timer.stop();
            i=0;
            stage2_Class();
        }
    }     //rifah
    
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
                case "none","math","pcc":
                    Club(choice);
                    break;
                case "clubActivity":
                    Club();
                    break;
                case "cheat":
                    cheat();
                    break;
                case "library":
                    library();
                    break;
                case "extra":
                    break;
                default:
                    break;
            }
        }
    }       //rahi
     
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
                    stage3_Break();
                    break;
                case 4:
                    stage4_ClubFair();
                    break;
                case 5, 10:
                    stage2_Class();
                    break;
                case 7:
                    stage7_ClassTest();
                    break;
                case 8, 12:
                    stage8_ClubEvent();
                    break;
                case 9, 14:
                    stage9_TermExam();
                    break;
                case 13:
                    stage13_Relax();
                    break;
                case 15:
                    stage15_SemesterEnds();
                default:
                    break;
            }
        }
    }   //lubaba
    
    public class EndHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainWindow.dispose();
        }

    }     //lubaba

    //-----------------  B L O C K S   O F   C O D E  ---------------
    
    public void addChoiceHandler(){
        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
    }   //rahi
    
    public void addChoiceUtilities(){
        summary(summaryText, changes);
        choiceButtonPanel.setVisible(false); //hiding the choice panel
        addContinueStoryButton();
        continueStoryButton.addActionListener(continueStoryHandler);       
    }   //lubaba
    
    public void addEndButton(){
        endButtonPanel = new JPanel();
        endButtonPanel.setBounds((int)Math.ceil(width/3.4), (int)Math.ceil(height/2), (int)Math.ceil(width/2.4), (int)Math.ceil(height/4.32));
        endButtonPanel.setBackground(Color.decode("#280a68"));
        endButtonPanel.setLayout(new GridLayout(4,1));
        
        endButton = new JButton("End Game");
        endButton.setBackground(Color.decode("#a70c70"));
        endButton.setForeground(Color.white);
        endButton.setFont(choiceFont);
        endButton.setFocusPainted(false);
        
        endButtonPanel.add(endButton);
        endButton.addActionListener(endHandler);
        container.add(endButtonPanel);
        mainWindow.getContentPane().add(endButton);
        
    }  //lubaba
    
}