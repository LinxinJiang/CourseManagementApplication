public class FaceToFaceClass extends Course {
    private String roomNumber;


    public FaceToFaceClass() {
    }

    public FaceToFaceClass(String name, int hour) {
        super(name, hour);
    }


    public FaceToFaceClass(String name, int hour, String roomNumber) {
        super(name, hour);
        this.roomNumber = roomNumber;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String toString(){
        return "\n\nCourse: " + this.getName() + "\n" + "Credit Hours: " + this.getHour() + "\n"
                + "Instructor: " +this.getInstructor() + "\n" + "Assistant: " + this.getAssistant() +"\n"
                + "Staff Member: " + this.getStaffMember() + "\n" + "Room Number: " + getRoomNumber() + "\n\n";
    }
}