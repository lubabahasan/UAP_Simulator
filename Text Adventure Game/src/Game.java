import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
   
    Container container;
    JFrame mainWindow;
    JPanel titlePanel, startButtonPanel, storyPanel, choicePanel, inputTextPanel, inputPanel;
    JButton startButton, enter, choice1, choice2, choice3, choice4;
    JLabel titleText;
    JTextArea storyText, inputText;
    JTextField inputField;

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
    int width = (int)size.getWidth(); 
    int height = (int)size.getHeight();

    Font titleFont = new Font("Impact", Font.PLAIN, (int)Math.ceil(height/9.6));
    Font buttonFont = new Font("Garamond", Font.PLAIN, (int)Math.ceil(height/28.8));
    Font normalFont = new Font("Calisto MT", Font.PLAIN, (int)Math.ceil(height/23));

    static String text, studentName;
    int i = 0;
    
    MainScreenHandler actionHandler = new MainScreenHandler();
    InputHandler inputHandler = new InputHandler();
    
    public static void main(String[] args) {
        new Game();
        Student student = new Student();
        student.setName(studentName);
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
        
        //Adding Labels to Panels
        titlePanel.add(titleText); //adding title text to panel
        startButtonPanel.add(startButton);
        
        //Adding panels to screen
        container.add(titlePanel);
        container.add(startButtonPanel);
        
    }
    
    Timer timer1 = new Timer(10, new ActionListener(){
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
    
    Timer timer2 = new Timer(10, new ActionListener(){
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
        
        inputPanel.add(enter);
        container.add(inputPanel);
    }
    
    public void stage1(){
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
        
        //Continue Button
//        choice1 = new JButton("Attend Class");
//        choice1.setBackground(Color.black);
//        choice1.setForeground(Color.white);
//        choice1.setPreferredSize(new Dimension(300, 80));
//        choice1.setFont(buttonFont);
//        choicePanel.add(choice1);
    }
    
    public void stage2(){
        inputPanel.setVisible(false);
        inputTextPanel.setVisible(false);
        
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
        
//        (Attend) You decide to attend your first class at UAP, eager to make a good impression on your professors.
//        (Bunk) Feeling a bit overwhelmed by the new environment, you decide to skip your first class and explore the campus instead.

        
        //Continue Button
//        choice1 = new JButton("Attend Class");
//        choice1.setBackground(Color.black);
//        choice1.setForeground(Color.white);
//        choice1.setPreferredSize(new Dimension(300, 80));
//        choice1.setFont(buttonFont);
//        choicePanel.add(choice1);
        
        //Choice panel
//        choicePanel = new JPanel();
//        choicePanel.setBounds((int)Math.ceil(width/2.8981), (int)Math.ceil(height/2.16), (int)Math.ceil(width/3.072), (int)Math.ceil(height/2.88));
//        choicePanel.setBackground(Color.blue);
//        choicePanel.setLayout(new GridLayout(4,1));
//        container.add(choicePanel);
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
}

class Student {
    private int time = 1000, attendance = 0;
    private float CGPA = 4.00f;
    private String club = "", awards = "", name;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setTime(int time) {
        this.time += time;
    }

    public void setAttendance(boolean attendance) {
        if(attendance)
            this.attendance += 1;
    }

    public void setCGPA(boolean status) {
        if(status)
            this.CGPA += 0.5;
        else
            this.CGPA -= 0.5;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setAwards(String awards) {
        this.awards += awards;
        this.awards += " ";
    }
}
