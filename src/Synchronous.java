public class Synchronous extends OnlineClass{
    private String time;

    public Synchronous(String information, String time) {
        super(information);
        this.time = time;
    }

    public Synchronous(String name, int hour, String information, String time) {
        super(name, hour, information);
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toString(){
        return "\n\nCourse: " + this.getName() + "\n" + "Credit Hours: " + this.getHour() + "\n" + "Time: " + this.getTime()
                + "\n" + "Instructor: " +this.getInstructor() + "\n" + "Assistant: " + this.getAssistant() +"\n"
                + "Staff Member: " + this.getStaffMember() + "\nCourse information: " + getInformation() + "\n\n";
    }
}