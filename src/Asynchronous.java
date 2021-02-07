public class Asynchronous extends OnlineClass {

    public Asynchronous(String information) {
        super(information);
    }

    public Asynchronous(String name, int hour, String information) {
        super(name, hour, information);
    }


    public String toString(){
        return "\n\nCourse: " + this.getName() + "\n" + "Credit Hours: " + this.getHour() + "\n"
                + "Instructor: " +this.getInstructor() + "\n" + "Assistant: " + this.getAssistant() +"\n"
                + "Staff Member: " + this.getStaffMember() + "\nCourse information: " + getInformation() + "\n\n";
    }
}