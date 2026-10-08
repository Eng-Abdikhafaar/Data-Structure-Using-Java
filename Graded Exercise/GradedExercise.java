import java.util.Date;

/*
* Exercise 2.0: LOAN Class
 */
class Loan {
    // Attributes
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    // no args constructor
    public Loan(){
        annualInterestRate = 2.5;
        numberOfYears = 1;
        loanAmount = 100;
        loanDate = new Date();
    }

    // parameterized constructor
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    // Getters
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public int getNumberOfYears(){
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public java.util.Date getLoanDate(){
        return loanDate;
    }

    // Setters

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount (int loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Calculate monthly payment
    public double getMonthlyPayment(){
        double monthlyInterestRate = annualInterestRate / 1200;
        int numberOfPayments = numberOfYears * 12;

        double Result = loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        return Result;
    }

    // Calculate total payment
    public double getTotalPayment(){
        double Result = getMonthlyPayment() * numberOfYears * 12;
        return Result;
    }
}

/*
Exercise 2.1: BMI class
 */
class BMI{
    // Attributes
    private String name;
    private int age;
    private double weight;
    private double height;

    // Parameterized constructor
    public BMI(String name, int age, double weight, double height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // Constructor with default age = 20
    public BMI(String name, double weight, double height){
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = 20;
    }

    // Getters
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getWeight(){
        return weight;
    }

    public double getHeight(){
        return height;
    }

    // Calculate the person's BMI
    public double getBMI(){
        double BMI = weight * 703 / (height * height);
        return BMI;
    }

    // Return the person's BMI Status
    public String getStatus(){
        if (getBMI() < 18.5)
            return "Underweight";
        else if (getBMI() < 25.0)
            return "Normal";
        else if (getBMI() < 30.0)
            return "Overweight";
        else
            return "Obese";
    }
}

/*
Exercise 2.2: COURSE class
 */
class Course {
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    public Course(String courseName){
        this.courseName = courseName;
        students = new String[100];
        numberOfStudents = 0;
    }

    public String getCourseName(){
        return courseName;
    }

    public String[] getStudents(){
        return students;
    }

    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    public void addStudent(String student){
        if (numberOfStudents >= students.length) {
            String[] temp = new String[students.length * 2];

            for (int i = 0; i < students.length; i++) {
                temp[i] = students[i];
            }

            students = temp;
        }

        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public void dropStudent(String student){
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {

                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[numberOfStudents - 1] = null;
                numberOfStudents--;
                break;
            }
        }

    }


}
public class GradedExercise {
    public static void main(String[] args) {
        /*
        Answer 2.0: LOAN Class
         */

        System.out.println("______________ QUESTION 2.O ______________");

        // Test the no-argument constructor
        Loan ln1 = new Loan();
        System.out.println("Loan 1:");
        System.out.println("Annual Interest Rate: " + ln1.getAnnualInterestRate());
        System.out.println("Number of Years: " + ln1.getNumberOfYears());
        System.out.println("Loan Amount: " + ln1.getLoanAmount());
        System.out.println("Monthly Payment: " + ln1.getMonthlyPayment());
        System.out.println("Total Payment: " + ln1.getTotalPayment());
        System.out.println("Loan Date: " + ln1.getLoanDate());

        System.out.println();

        // Test the constructor with arguments
        Loan ln2 = new Loan(5.0, 5, 5000);
        System.out.println("Loan 2:");
        System.out.println("Annual Interest Rate: " + ln2.getAnnualInterestRate());
        System.out.println("Number of Years: " + ln2.getNumberOfYears());
        System.out.println("Loan Amount: " + ln2.getLoanAmount());
        System.out.println("Monthly Payment: " + ln2.getMonthlyPayment());
        System.out.println("Total Payment: " + ln2.getTotalPayment());
        System.out.println("Loan Date: " + ln2.getLoanDate());

        System.out.println();

        System.out.println("After Modifying ---------------------");

        ln2.setAnnualInterestRate(6.8);
        ln2.setNumberOfYears(7);
        ln2.setLoanAmount(7000);
        System.out.println("Annual Interest Rate: " + ln2.getAnnualInterestRate());
        System.out.println("Number Of Years: " + ln2.getNumberOfYears());
        System.out.println("Loan Amount: " + ln2.getLoanAmount());
        System.out.println("Monthly Payment: " + ln2.getMonthlyPayment());
        System.out.println("Total Payment: " + ln2.getTotalPayment());
        System.out.println("Loan Date: " + ln2.getLoanDate());

        System.out.println();

        /*
        Answer 2.1: BMI Class
         */
        System.out.println("______________ QUESTION 2.1 ______________");

        // Test constructor with age
        BMI person1 = new BMI("Ahmed", 25, 150, 65);

        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Weight: " + person1.getWeight());
        System.out.println("Height: " + person1.getHeight());
        System.out.println("BMI: " + person1.getBMI());
        System.out.println("Status: " + person1.getStatus());

        System.out.println();

        // Test constructor with default age = 20
        BMI p2 = new BMI("Ali", 180, 70);

        System.out.println("Name: " + p2.getName());
        System.out.println("Age: " + p2.getAge());
        System.out.println("Weight: " + p2.getWeight());
        System.out.println("Height: " + p2.getHeight());
        System.out.println("BMI: " + p2.getBMI());
        System.out.println("Status: " + p2.getStatus());

        System.out.println();

        /*
        Answer 2.2: COURSE Class
         */
        System.out.println("______________ QUESTION 2.2 ______________");

        // Create a Course object
        Course course = new Course("Java Programming");

        // Add students
        course.addStudent("Ahmed");
        course.addStudent("Ali");
        course.addStudent("Hassan");

        // Display course name
        System.out.println("Course Name: " + course.getCourseName());

        // Display number of students
        System.out.println("Number of Students: " + course.getNumberOfStudents());

        // Display all students
        System.out.println("Students:");

        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println(course.getStudents()[i]);
        }

        // Drop Ali from the course
        course.dropStudent("Ali");

        // Display updated information
        System.out.println("\nAfter dropping Ali:");
        System.out.println("Number of Students: " + course.getNumberOfStudents());

        // Display remaining students
        for (int i = 0; i < course.getNumberOfStudents(); i++) {
            System.out.println(course.getStudents()[i]);
        }
    }
}
