public class HybridClass extends FaceToFaceClass{
    private String labName;
    private LabTechnician labTechnicians;
    private String lectureRoomNumber;
    private String labRoomNumber;
    private int numberOFTechnician;
    private String[] labTechniciansList;


    public HybridClass(LabTechnician labTechnicians) {
        this.labTechnicians = labTechnicians;
    }

    public HybridClass(String name, int hour, String labName,String lectureRoomNumber,String labRoomNumber) {
        super(name, hour);
        this.labName = labName;
    }

    public String getLab() {
        return labName;
    }

    public void setLab(String lab) {
        this.labName = lab;
    }

    public void setLabTechnicians(LabTechnician labTechnicians) {
        this.labTechnicians = labTechnicians;
    }

    public void setNumberOFTechnician(int numberOFTechnician) {
        this.numberOFTechnician = numberOFTechnician;
    }

    public LabTechnician getLabTechnicians() {
        return labTechnicians;
    }

    public int getNumberOFTechnician() {
        return numberOFTechnician;
    }

    public String[] getLabTechniciansList() {
        return labTechniciansList;
    }

    public String displayTechniciansList(){
        String lis = null;
        for(int i = 0; i < labTechniciansList.length; i++){
            if(lis == null){
                lis = labTechniciansList[i] + "   ";
            }else
                lis = lis + labTechniciansList[i] + "   ";
        }
        return lis;
    }



    public void setLabTechniciansList(String[] labTechniciansList) {
        this.labTechniciansList = labTechniciansList;
    }

    public String toString(){
        return "\n\nCourse: " + this.getName() + "\n" + "Credit Hours: " + this.getHour() + "\nLab: " + this.getLab() + "\n"
                + "Instructor: " +this.getInstructor() + "\n" + "Assistant: " + this.getAssistant() +"\n" + "Staff Member: "
                + this.getStaffMember() + "\nLab Technician: " + displayTechniciansList() + "\n\n";
    }

}

