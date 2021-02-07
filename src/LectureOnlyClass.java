public class LectureOnlyClass extends FaceToFaceClass {


    public LectureOnlyClass(String name, int hour) {
        super(name, hour);
    }

    public String toString(){
        return "\n\nCourse: " + this.getName() + "\n" + "Credit Hours: " + this.getHour() + "\n"
                + "Instructor: " +this.getInstructor() + "\n" + "Assistant: " + this.getAssistant() +"\n"
                + "Staff Member: " + this.getStaffMember() + "\n\n";
    }

}
