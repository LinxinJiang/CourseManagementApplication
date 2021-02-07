public class Course {
    private String name;
    private int hour;
    private StaffMember staffMember;
    private Instructor instructor;
    private Assistant assistant;
    private Student[] enrolledStudents;
    private int enrolledStudentsCounter;
    private Instructor[] instructorsInCourse;
    private int instructorsCounter;
    private int CAN_HAVE_NUMBER_OF_STUDENTS = 30;
    private int CAN_HAVE_NUMBER_OF_INSTRUCTORS = 3;



    private Course[] courses;

    public Course(){

    }

    public Course(String name,int hour) {
        this.name = name;
        this.hour = hour;
    }

    public String getName() {
        return name;
    }

    public int getHour() {
        return hour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public StaffMember getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(StaffMember staffMember) {
        this.staffMember = staffMember;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public void addStudentToCourse(Student student) {
        enrolledStudents[enrolledStudentsCounter] = student;
        enrolledStudentsCounter++;
    }

    public boolean canAddStudent(){
        if( enrolledStudentsCounter <= CAN_HAVE_NUMBER_OF_STUDENTS){
            return true;
        }else{
            return false;
        }
    }

    public boolean needInstructor(){
        if(instructorsCounter <= CAN_HAVE_NUMBER_OF_INSTRUCTORS){
            return true;
        }else{
            return false;
        }
    }

    public void addInstructorToCourse(Instructor instructor){
        instructorsInCourse[instructorsCounter] = instructor;
        instructorsCounter++;
    }
}

