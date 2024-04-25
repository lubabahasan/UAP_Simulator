public class Student {
    private int time = 1000, attendance = 0, friend = 0;
    private float CGPA = 4.00f;
    private String club = "", awards = "", name;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void loseTime(int time) {
        this.time -= time;
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
    
    public void gainFriends() {
        friend++;
    }
    
    public void loseFriends() {
        friend--;
    }
}
