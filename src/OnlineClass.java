public class OnlineClass extends Course {
    private String information;

    public OnlineClass(String information) {
        this.information = information;
    }

    public OnlineClass(String name, int hour, String information) {
        super(name, hour);
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String toString(){
        return "\n\nCourse: " + this.getName() + "\n" + "Credit Hours: " + this.getHour() + "\n"
                + "Instructor: " +this.getInstructor() + "\n" + "Assistant: " + this.getAssistant() +"\n"
                + "Staff Member: " + this.getStaffMember() + "\nCourse information: " + getInformation() + "\n\n";
    }
}