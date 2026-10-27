import java.util.Scanner;


class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException(String message) {
        super(message);
    }
}

public class ExamRegistration {

    private String studentId;
    private String studentName;
    private int age;
    private int examMark;
    private int numSubjects;

    public void collectDetails(Scanner scanner) throws InvalidRegistrationException {
        System.out.print("Enter Student ID: ");
        studentId = scanner.nextLine().trim();

        System.out.print("Enter Student Name: ");
        studentName = scanner.nextLine().trim();

        age = readInt(scanner, "Enter Age: ", "Age must be a whole number.");
        examMark = readInt(scanner, "Enter Exam Mark: ", "Exam mark must be a whole number.");
        numSubjects = readInt(scanner, "Enter Number of Subjects: ",
                "Number of subjects must be a whole number.");
    }

    private int readInt(Scanner scanner, String prompt, String errorMessage)
            throws InvalidRegistrationException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidRegistrationException(errorMessage);
        }
    }


    public void validate() throws InvalidRegistrationException {
        if (studentId == null || studentId.isEmpty()) {
            throw new InvalidRegistrationException("Student ID cannot be empty.");
        }
        if (age < 18) {
            throw new InvalidRegistrationException("Student must be at least 18 years old.");
        }
        if (examMark < 0 || examMark > 100) {
            throw new InvalidRegistrationException("Exam mark must be between 0 and 100.");
        }
        if (numSubjects < 1) {
            throw new InvalidRegistrationException("Minimum allowed subjects is 1.");
        }
        if (numSubjects > 5) {
            throw new InvalidRegistrationException("Maximum allowed subjects is 5.");
        }
    }

    public void displaySuccess() {
        System.out.println("\nRegistration Successful!");
        System.out.println("Student: " + studentName);
        System.out.println("Registered Subjects: " + numSubjects);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExamRegistration registration = new ExamRegistration();

        System.out.println("===== EXAM REGISTRATION SYSTEM =====\n");

        try {
            registration.collectDetails(scanner);
            registration.validate();
            registration.displaySuccess();
        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("\nRegistration attempt completed.");
            scanner.close();
        }
    }
}
