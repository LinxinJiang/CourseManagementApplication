public class Student implements ParkingPermit{
    private String name;
    private int id;
    private final int CREDIT_LIMIT = 18;
    private int currentCredits;
    public boolean parking;

    public Student() {
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCREDIT_LIMIT() {
        return CREDIT_LIMIT;
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void setCurrentCredits(int currentCredits) {
        this.currentCredits = currentCredits;
    }

    public void addCredits(int credits) {
        currentCredits = currentCredits + credits;
    }



    public void parkingPermitDemand(boolean answer) {
        if(answer == true){
            parking = true;
            System.out.println("Your application is being processed.");
        }else{
            parking = false;
        }


    }

}

