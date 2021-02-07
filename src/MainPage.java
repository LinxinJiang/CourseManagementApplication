import java.util.Scanner;
import java.util.ArrayList;


public class MainPage {

    private static int parkingCounter = 0;
    private static int parkingSpaceLeft = 10; // College open 10 parking space to students

    public static ArrayList<Course> courses = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Instructor> instructors = new ArrayList<>();
    public static ArrayList<Assistant> assistants = new ArrayList<>();
    public static ArrayList<StaffMember> staffMembers = new ArrayList<>();
    public static ArrayList<LabTechnician> labTechnicians = new ArrayList<>();
    public static ArrayList<FaceToFaceClass> faceToFaceClasses = new ArrayList<FaceToFaceClass>();
    public static ArrayList<OnlineClass> onlineClasses = new ArrayList<OnlineClass>();
    public static ArrayList<LectureOnlyClass> lectureOnlyClasses = new ArrayList<LectureOnlyClass>();
    public static ArrayList<HybridClass> hybridClasses = new ArrayList<HybridClass>();
    public static ArrayList<LaboratoryOnlyClass> laboratoryOnlyClasses = new ArrayList<LaboratoryOnlyClass>();


    public static void main(String[] args) {
        boolean start = true;
        while (start) {
            Menu.displayMainMenu();
            start = mainChoiceBar();

        }
    }



    /**
     * Name: choiceBar():
     * Function: get a number from user[0-8], return true. Or return false.
     * Return: boolean
     */
    public static boolean mainChoiceBar()  {
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        switch (choice) {
            case "1":
                try{
                    addCourse(input);
                }catch(NullCourseException e){
                    System.out.println(e.getMessage());
                }catch(NullFacultyException e){
                    System.out.println(e.getMessage());
                }

                break;

            case "2":
                try{
                    addStudent(input);
                }catch (NullStudentException e){
                    System.out.println(e.getMessage());
                }

                break;

            case "3":
                try{
                    createFaculty(input);
                }catch(NullFacultyException e){
                    System.out.println(e.getMessage());
                }

                break;

            case "4":
                try{
                    registerForCourse(input);
                }catch(NullStudentException e){
                    System.out.println(e.getMessage());
                }
                break;


            case "5":
                try{
                    assignInstructorToACourse(input);
                }catch (NullFacultyException e){
                    System.out.println(e.getMessage());
                }

                break;

            case "6":
                try {
                    displayStudents();
                } catch (NullStudentException e) {
                    System.out.println(e.getMessage());

                }

                break;

            case "7":
                try{
                    displayInstructor();
                }catch (NullFacultyException e){
                    System.out.println(e.getMessage());
                }

                break;
            case "8":
                try{
                    displayCourseInformation(input);
                }catch(NullCourseException e){
                    System.out.println(e.getMessage());
                }
                break;

            case "9":
                try {
                    searchFacultyByClasses(input);
                }catch (NullFacultyException e){
                    System.out.println(e.getMessage());
                }catch(NullCourseException e){
                    System.out.println(e.getMessage());
                }

                break;

            case "0":
                System.out.println("Thank you for using our system!");
                return false;


            default:
                System.out.println("The service number you entered does not exist.");
        }
        return true;
    }

    /**
     * Name: addCourse()
     * Function:
     * @param input: a Scanner to get input from user
     */
    public static void addCourse(Scanner input) throws NullCourseException, NullFacultyException{
        System.out.print("Enter the Course name: ");
        String courseName = input.nextLine();
        System.out.print("Enter credit hours: ");
        String cHour = input.nextLine();
        int creditHours = Integer.parseInt(cHour);
        Course course = new Course(courseName, creditHours);
        courses.add(course);
        Menu.courseMenu();
        String courseType = input.nextLine();
        switch (courseType){
            case "1":
                addFaceToFaceCourse(courseName,creditHours,input);
                break;

            case "2":
                addOnlineCourse(courseName,creditHours,input);
                break;

            default:
                throw new NullCourseException("The number you entered does not exist, " +
                        "so the course cannot be added.");
        }
    }

    /**
     * addFaceToFaceCourse()
     *
     * Function: part of addCourse()
     *
     */

    public static void addFaceToFaceCourse(String courseName,int creditHours,Scanner input) throws NullFacultyException, NullCourseException {
        System.out.print("Enter the room number: ");
        String roomNumber = input.nextLine();
        Menu.faceToFaceMenu();
        System.out.print("Enter the class type: ");
        int classType = input.nextInt();
        if (classType == 1) {
            addLectureOnlyCourse(courseName,creditHours);
        } else if (classType == 2) {
            addHybridCourse(courseName,creditHours,roomNumber,input);

        } else if (classType == 3) {
            addLaboratoryOnly(courseName,creditHours,input);
        }else {
            throw new NullCourseException("The number you entered is not correct.");
        }

    }

    /**
     * addLectureOnlyCourse()
     *
     * Function: call by addFaceToFaceCourse()
     *           when class type is 1
     */

    public static void addLectureOnlyCourse(String courseName, int creditHours){
        Course lectureOnlyClass = new LectureOnlyClass(courseName, creditHours);
        faceToFaceClasses.add((FaceToFaceClass) lectureOnlyClass);
        lectureOnlyClasses.add((LectureOnlyClass) lectureOnlyClass);
        System.out.println(courseName + " successfully added to the lecture only course list");
    }

    /**
     * addHybridClass()
     *
     * Function: call by addFaceToFaceCourse()
     *           when class type is 2
     */

    public static void addHybridCourse(String courseName, int creditHours, String roomNumber,Scanner input) throws NullFacultyException{
        System.out.print("Enter the lecture room number: ");
        input.nextLine();
        String lectureRoom = input.nextLine();
        System.out.print("Enter the Laboratory number: ");
        String labNumber = input.nextLine();
        Course hybridClass = new HybridClass(courseName, creditHours, roomNumber, lectureRoom, labNumber);
        faceToFaceClasses.add((FaceToFaceClass) hybridClass);
        hybridClasses.add((HybridClass) hybridClass);
        System.out.print("Enter the lab of the course: ");
        String lab = input.nextLine();
        System.out.print("Enter the number of lab technician: ");
        int numberOfTechnician = input.nextInt();
        ((HybridClass) hybridClass).setNumberOFTechnician(numberOfTechnician);

        if (numberOfTechnician <= 0) {
            System.out.println("Each laboratory has at least one lab technician.");
            System.out.print("Enter the number of lab technician: ");
            numberOfTechnician = input.nextInt();
        }

        if(numberOfTechnician <= 0){
            throw new NullFacultyException("Each laboratory has at least one lab technician.");
        }else{
            String[] name = new String[numberOfTechnician];
            input.nextLine();
            for (int i = 0; i < numberOfTechnician; i++) {
                System.out.print("Enter " + (i + 1) + " lab technician's name: ");
                name[i] = input.nextLine();
            }

            ((HybridClass) hybridClass).setLabTechniciansList(name);
        }





        System.out.println(courseName + " successfully added to the hybrid course list");
    }





    /**
     * addLaboratoryOnly
     *
     * Function: call by addFaceToFaceCourse()
     *           when class type is 3
     *
     */

    public static void addLaboratoryOnly(String courseName, int creditHours,Scanner input) throws NullCourseException{
        System.out.print("Enter the Laboratory number: ");
        input.nextLine();
        String labNumber = input.nextLine();

        Course laboratoryOnlyClass = new LaboratoryOnlyClass(courseName, creditHours, labNumber);
        System.out.print("Enter the lab of the course: ");
        String lab = input.nextLine();
        System.out.print("Enter the number of lab technician: ");
        int numberOfTechnician = Integer.parseInt(input.nextLine());
        ((LaboratoryOnlyClass) laboratoryOnlyClass).setNumberOfTechnician(numberOfTechnician);

        if (numberOfTechnician <= 0) {
            System.out.println("Each laboratory has at least one lab technician.");
            System.out.println("\n");
            System.out.print("Enter the number of lab technician: ");
            numberOfTechnician = Integer.parseInt(input.nextLine());
        }


        if ((numberOfTechnician >=3)){
            String LabTechName;
            LabTechnician[] labTechnicianList = new LabTechnician[3];
            for (int i = 0; i < numberOfTechnician; i++) {
                System.out.print("Enter " + (i + 1) + " lab technician's name: ");
                input.nextLine();
                LabTechName = input.nextLine();
                System.out.println();
                LabTechnician newTechnician = new LabTechnician(LabTechName);
                labTechnicianList[i] = newTechnician;


            }

            ((LaboratoryOnlyClass) laboratoryOnlyClass).setLabTechniciansList(labTechnicianList);
            faceToFaceClasses.add((FaceToFaceClass) laboratoryOnlyClass);
            laboratoryOnlyClasses.add((LaboratoryOnlyClass) laboratoryOnlyClass);
            System.out.println(courseName + " successfully added to the laboratory only course list");

        }else{
            throw new NullCourseException("This course have 3 lab technicians, " +
                    "so the course cannot be added.");

        }
    }


    /**
     * addOnlineCourse()
     *
     * Function: part of addOnlineCourse()
     *
     */
    public static void addOnlineCourse(String courseName,int creditHours,Scanner input){
        System.out.print("Enter course information: ");
        String inform = input.nextLine();
        System.out.println("1. Asynchronous online class");
        System.out.println("2. Synchronous online class");
        System.out.print("Enter the online class type: ");
        int typeOnlineClass = input.nextInt();
        Course onlineCourse = null;
        if (typeOnlineClass == 1) {
            onlineCourse = new Asynchronous(courseName, creditHours, inform);
        } else {
            System.out.print("Enter the class time: ");
            input.nextLine();
            String onlineClassTime = input.nextLine();
            onlineCourse = new Synchronous(courseName, creditHours, inform, onlineClassTime);
        }

        onlineClasses.add((OnlineClass) onlineCourse);
        System.out.println("Course added successfully!");
    }



    /**
     * addStudent()
     * Function: ask user fpr the student information(name & ID)
     *           Use student information to new student object
     *           then add to student arraylist
     */
    public static void addStudent(Scanner input) throws NullStudentException{
        System.out.print("Enter student's full name: ");
        String name = input.nextLine();
        System.out.print("Enter student ID: ");
        String idString = input.nextLine();
        int id = Integer.parseInt(idString);

        Student newStudent = new Student(name, id);
        students.add(newStudent);
        System.out.println("Student added successfully!");

        System.out.print("Does the student need to apply for a parking permit (yes / no): ");
        String answer = input.nextLine();

        if(answer.equals("yes") && parkingSpaceLeft > parkingCounter) {
            newStudent.parkingPermitDemand(true);
            parkingCounter ++;
        }else if(answer.equals("yes") && parkingSpaceLeft <= parkingCounter){
            System.err.println("Sorry, the parking lot is full.");
            newStudent.parkingPermitDemand(false);
        }else if (answer.equals("no")){
            newStudent.parkingPermitDemand(false);
        }else{
            throw new NullStudentException("Please enter yes or no");

        }


    }


    /**
     * createFaculty()
     * Function: ask user for faculty's name.
     *           call addFacultyByTitle()
     *
     */
    public static void createFaculty(Scanner input) throws NullFacultyException{
        System.out.print("Enter faculty's full name: ");
        String name = input.nextLine();
        addFacultyByTitle(name, input);
        System.out.println(name + " successfully added to the Faculty System.");
    }



    /**
     * addFacultyByTitle()
     * name: inout from createFaculty()
     * Function: ask user for faculty's title
     *           add faculty to arraylist
     */
    public static void addFacultyByTitle(String name, Scanner input) throws NullFacultyException{
        Menu.facultyMenu();
        String title = input.nextLine();
        switch (title) {
            case "1":
                Instructor instructor = new Instructor(name);
                instructors.add(instructor);
                break;

            case "2":
                StaffMember staff = new StaffMember(name);
                staffMembers.add(staff);
                break;

            case "3":
                Assistant assistant = new Assistant(name);
                assistants.add(assistant);
                break;

            case "4":
                LabTechnician labTech = new LabTechnician(name);
                labTechnicians.add(labTech);
                break;

            default:
                throw new NullFacultyException("The number you entered does not exist.");
        }
    }

    /**
     * registerForCourse()
     * Function: ask user(student) for ID.
     *           if ID exist:
     *                 ask for course name:
     *                      if course exist:
     *                          if course can be added(student credit & course space):
     *                              success!
     *                          else:
     *                              print out message
     *                      else:
     *                          print out message
     *           else:
     *              print out message
     *
     */
    public static void registerForCourse(Scanner input) throws NullStudentException{
        System.out.print("Enter your ID: ");
        int uncheckedId = input.nextInt();
        Student resultStudent = ifStudentExists(uncheckedId);

        if(null != resultStudent){
            System.out.print("Enter the name of the course you want to register : ");
            input.nextLine();
            String courseName = input.nextLine();
            Course resultCourse = ifCourseExists(courseName);
            if(null != resultCourse && resultCourse.canAddStudent() ){
                if( resultCourse.getHour()+ resultStudent.getCurrentCredits() <= resultStudent.getCREDIT_LIMIT()){
                    resultCourse.addStudentToCourse(resultStudent);
                    resultStudent.addCredits(resultCourse.getHour());
                    System.out.println("Congratulations, "+ resultStudent.getName() +
                            ". You have successfully added this class.");
                }else{
                    throw new NullStudentException("Registration failure (no more than 18 credits per semester)");
                }
            }else{
                throw new NullStudentException("The course name you entered does not exist. Please try again. " +
                        "Or call the support center at 718-951-5065.");
            }

        }else{
            throw new NullStudentException("Your profile is not in the system yet. " +
                    "Please go back to the home page to add your information.");
        }

    }

    /**
     * assignInstructorToACourse()
     * Function:
     *          enter the instructor name.
     *          if the course is not null, exist in the list and need instructor:
     *              success!
     *          else:
     *              print out message
     *
     */

    public static void assignInstructorToACourse(Scanner input) throws NullFacultyException{
        System.out.print("Enter the instructor's full name: " );
        String NeedCheckName = input.nextLine();
        Instructor resultInstructors = ifInstructorExists(NeedCheckName);

        if (null != resultInstructors){
            System.out.println("Enter the course that this instructor teach: ");
            String NeedCheckCourse = input.nextLine();
            Course resultCourse = ifCourseExists(NeedCheckCourse);
            if(null != resultCourse && resultCourse.needInstructor()){
                resultCourse.addInstructorToCourse(resultInstructors);
                throw new NullFacultyException("Instructor ["+ resultInstructors.getName()+"] successfully assigned to " + resultCourse);
            }else{
                throw new NullFacultyException("Instructor ["+ resultInstructors.getName()+"] can't be assigned to the class.");
            }
        }else{
            throw new NullFacultyException("This instructor's profile is not in the system yet."
                    + "Please go back to the home page to add your information.");
        }
    }





    /**
     * ifStudentExists()
     *
     * Function: return a Students type when id exist in the list
     *           return null when id is not exist
     */

    public static Student ifStudentExists(int id){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                return students.get(i);
            }
        }
        return null;
    }

    /**
     * ifCourseExists
     * Function: return a Course type when name exist in the list
     *           return null when name is not exist
     */

    public static Course ifCourseExists(String name){
        for(int i = 0; i <courses.size(); i++){
            if(courses.get(i).getName() == name){
                return courses.get(i);
            }
        }
        return null;
    }

    /**
     * ifInstructorExists()
     * Function: return a Instructors type when name exist in the list
     *           return null when name is not exist
     */

    public static Instructor ifInstructorExists(String name){
        for(int i = 0; i <instructors.size(); i++){
            if(instructors.get(i).getName() == name){

                return instructors.get(i);

            }

        }
        return null;
    }


    /**
     * displayStudents()
     * Function: if students list is not empty.
     *           Go through the list and print out all student's name
     *
     */

    public static void displayStudents() throws NullStudentException {

        if (students.size() == 0) {
            System.out.println();
            throw new NullStudentException("Please add some students first.");

        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName() != null) {
                System.out.println("Name: " + students.get(i).getName() + " | " + "ID: " + students.get(i).getId()
                        + " | "  + "Parking Permit Status: " + students.get(i).parking);
            }
        }


    }


    /** displayInstructor
     *
     *      display the name
     *
     * @throws NullFacultyException
     */


    public static void displayInstructor() throws NullFacultyException {
        if (instructors.size() == 0) {
            System.out.println();
            throw new NullFacultyException("Please add a Instructor first.");

        }

        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getName() != null) {
                System.out.println(instructors.get(i).getName());
            }
        }
    }






    /**
     * displayCourseInformation()
     * Function: ask user for course type.
     *           call arrayCourse() to go through the list
     *
     */

    public static void displayCourseInformation(Scanner input) throws NullCourseException{
        Menu.displayCourseMenu();
        int checkNumber = input.nextInt();

        switch(checkNumber){
            case 1:
                arrayCourse(faceToFaceClasses);
                System.out.println();
                break;
            case 2:
                arrayCourse(lectureOnlyClasses);
                System.out.println();
                break;
            case 3:
                arrayCourse(hybridClasses);
                System.out.println();
                break;
            case 4:
                arrayCourse(laboratoryOnlyClasses);
                System.out.println();
                break;
            case 5:
                arrayCourse(onlineClasses);
                System.out.println();
                break;
            default:
                throw new NullCourseException("The number you entered is currently unavailable." );
        }

    }


    /**
     * arrayCourse()
     * Function: if the course if not empty.
     *           Go through the course list
     *
     */

    public static void arrayCourse(ArrayList lis) throws NullCourseException{
        if (lis.size() == 0){
            throw new NullCourseException("Please add some course first");
        }
        for(int i = 0; i < lis.size(); i ++) {
            System.out.println(lis.get(i));
        }

    }


    /**
     * searchFacultyByClasses()
     *
     * Function: Search assistant / instructor / staff member / lab technician by class.
     *           Ask user for faculty's full name. If the name in Course(ArrayList).
     *
     * Note: Assume this person can't have two positions. ( it makes this program more efficient)
     *       If he/she can have two positions, delete return
     */

    public static void searchFacultyByClasses(Scanner input) throws NullFacultyException,NullCourseException{
        System.out.print("Enter faculty's full name: ");
        String facultyName = input.nextLine();
        if(null == facultyName){
            throw new NullFacultyException( "You didn't enter the information. Please try again.");
        }

        if(courses.size() == 0){
            throw new NullCourseException("Faculty didn't in the system because there is no course.");
        }

        for(int i = 0; i < courses.size(); i++){
            // if he/she is an assistant
            if(courses.get(i).getName() == facultyName){
                System.out.println(facultyName + "is an assistant in " + courses.get(i).getName() +". ");
                // if he/she is an instructor
            }else if(courses.get(i).getInstructor().getName() == facultyName){
                System.out.println(facultyName + "is an instructor in " + courses.get(i).getName() +". ");
                // if he/she is a staff member
            }else if(courses.get(i).getStaffMember().getName() == facultyName){
                System.out.println(facultyName + "is a staff member in " + courses.get(i).getName() +". ");
                // if he/she is a lab technician in hybrid class.
            } else if(hybridClasses.get(i).getLabTechnicians().getName() == facultyName){
                System.out.println(facultyName + "is a lab technician in " + hybridClasses.get(i).getName() +" (hybrid class) . ");
                // if he/she is a lab technician in laboratory only.
            }else if(laboratoryOnlyClasses.get(i).getLabTechnicians().getName() == facultyName){
                System.out.println(facultyName + "is a lab technician in " + hybridClasses.get(i).getName() +" (laboratory only class) . ");
            }else{
                throw new NullFacultyException("Faculty didn't in the system");
            }


        }
    }


}