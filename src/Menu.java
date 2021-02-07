public class Menu {

    /**
     * displayMainMenu()
     *
     * Function: the main menu that user can choose.
     */

    public static void displayMainMenu() {
        System.out.println("Welcome to our system!");
        System.out.println("1. Add course");
        System.out.println("2. Add student");
        System.out.println("3. Add faculty");
        System.out.println("4. Register for a course");
        System.out.println("5. Assign instructor to a course");
        System.out.println("6. Display list of students");
        System.out.println("7. Display list of instructors");
        System.out.println("8. Display course information");
        System.out.println("9. Search a courses by faculty");
        System.out.println("0. Exit Application");
        System.out.print("Enter the service number that you like to choose: ");
    }

    /**
     * courseMenu()
     * Function: display course type
     *           Face-to-face classes / Online classes
     */

    public static void courseMenu(){
        System.out.println("1. Face-to-face class");
        System.out.println("2. Online class");
        System.out.print("Enter course type: ");
    }


    /**
     * faceToFaceMenu()
     *
     * Function: display 3 type of face to face course
     *
     * Call by MainPage.addFaceToFaceCourse()
     */

    public static void faceToFaceMenu(){
        System.out.println("1. Lecture-only class");
        System.out.println("2. Hybrid class");
        System.out.println("3. Laboratory-only class");
    }

    /**
     * facultyMenu()
     * Function: display different title
     */
    public static void facultyMenu(){
        System.out.println("1. Instructor");
        System.out.println("2. Staff");
        System.out.println("3. Teaching assistant");
        System.out.println("4. Lab technician");
        System.out.print("Enter faculty's title: ");
    }

    /**
     *  displayCourseMenu()
     *  Function: display course information menu;
     *            Face-to-face class including "Lecture-only class",
     *                                         "Hybrid class",
     *                                         "Laboratory-only class"
     */

    public static void displayCourseMenu(){
        System.out.println("1. Face-to-face class (Including Number: 2,3,4)");
        System.out.println("2. Lecture-only class");
        System.out.println("3. Hybrid class");
        System.out.println("4. Laboratory-only class");
        System.out.println("5. Online classes (Including asynchronous and synchronous)");
        System.out.print("Enter course type: ");
    }

}
