public class LaboratoryOnlyClass extends FaceToFaceClass{

    private int numberOfTechnician;
    private String laboratoryRoomNumber;
    private LabTechnician[] labTechniciansList;
    private LabTechnician labTechnicians;

    public LaboratoryOnlyClass(String name, int hour, String laboratoryRoomNumber) {
        super(name, hour);
        this.laboratoryRoomNumber = laboratoryRoomNumber;
    }

    public int getNumberOfTechnician() {
        return numberOfTechnician;
    }

    public void setNumberOfTechnician(int numberOfTechnician) {
        this.numberOfTechnician = numberOfTechnician;
    }

    public String getLaboratoryRoomNumber() {
        return laboratoryRoomNumber;
    }

    public void setLaboratoryRoomNumber(String laboratoryRoomNumber) {
        this.laboratoryRoomNumber = laboratoryRoomNumber;
    }

    public LabTechnician[] getLabTechniciansList() {
        return labTechniciansList;
    }

    public void setLabTechniciansList(LabTechnician[] labTechniciansList) {
        this.labTechniciansList = labTechniciansList;
    }

    public LabTechnician getLabTechnicians(){
        return labTechnicians;
    }


}