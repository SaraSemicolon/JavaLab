package Lab4;

import java.util.ArrayList;
import java.util.Arrays;

class Date
{
    private byte day;
    private byte month;
    private int year;

    public Date(byte day ,byte month ,int year)
    {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public byte getDay() {return day;}
    public void setDay(byte day) {this.day = day;}
    public byte getMonth() {return month;}
    public void setMonth(byte month) {this.month = month;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    public static boolean equals(Date d1 , Date d2)
    {
        return (d1.day == d2.day && d1.month == d2.month && d1.year == d2.year);
    }

    @Override
    public String toString()
    {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}

class Student
{
    private int rollNo;
    private String name;
    private Date birthDate;
    private int maxDegree;
    private double [] degrees;
    private double [] CGPAs;
    private static int count = 0;

    public Student (String name , byte day , byte month , int year ,
                    int maxDegree , double [] degrees, double [] CGPAs)
    {
        rollNo = ++count;
        this.name = name;
        birthDate = new Date(day,month,year);
        this.maxDegree = maxDegree;
        this.degrees = new double[degrees.length]; // تم تصحيح تهيئة الأري الأول
        setDegrees(degrees);
        this.CGPAs = CGPAs;
    }

    public void setDegrees(double [] degrees)
    {
        for(int i = 0; i< degrees.length ; i++)
        {
            if(degrees[i] < 0 || degrees[i] > maxDegree)
                this.degrees[i] = 0;
            else
                this.degrees[i] = degrees[i];
        }
    }

    public double calculateGrade ()
    {
        double totalDegrees = 0;
        for (double degree : degrees)
            totalDegrees += degree;
        double maxTotal = 3 * maxDegree;
        return (totalDegrees / maxTotal) * 100;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", maxDegree=" + maxDegree +
                ", degrees=" + Arrays.toString(degrees) +
                ", CGPAs=" + Arrays.toString(CGPAs) +
                ", Grade=" + calculateGrade() +
                '}' ;
    }

    public boolean areOnProbation ()
    {
        for(int i = 0; i < CGPAs.length - 1; i++)
            if (CGPAs[i] < 2.0 && CGPAs[i + 1] < 2.0)
                return true;
        return false;
    }
}

class StudentTest
{
    private Student [] students;

    public StudentTest (Student [] students) {this.students = students;}

    public Student findStudentHighestTotalDegree ()
    {
        if (students == null || students.length == 0) return null;

        Student studentHighestTotalDegree = students[0];
        for(int i = 1; i < students.length; i++)
        {
            if(students[i] != null)
                if(students[i].calculateGrade() > studentHighestTotalDegree.calculateGrade())
                    studentHighestTotalDegree = students[i];
        }
        return studentHighestTotalDegree;
    }

    public Student [] findTheStudentsWhoAreOnProbation ()
    {
        ArrayList<Student> studentsWhoAreOnProbation = new ArrayList<>();
        for(Student student : students)
            if(student != null && student.areOnProbation())
                studentsWhoAreOnProbation.add(student);
        return studentsWhoAreOnProbation.toArray(new Student[0]);
    }
}

public class Task1
{
    public static void main(String[] args)
    {
        Student [] students = new Student[3];

        students[0] = new Student("Sara", (byte)1, (byte)6, 2006, 150, new double[]{100, 128, 90}, new double[]{2.8, 2.5, 3.7, 3.9, 1.5});
        students[1] = new Student("Ahmed", (byte)15, (byte)3, 2005, 150, new double[]{140, 135, 145}, new double[]{1.8, 1.5, 3.0, 3.2, 3.5});
        students[2] = new Student("Mona", (byte)10, (byte)9, 2006, 150, new double[]{120, 110, 130}, new double[]{1.5, 1.4, 2.8, 3.1, 3.0});

        StudentTest studentTest = new StudentTest(students);

        System.out.println("--- Student with Highest Total Degree ---");
        System.out.println(studentTest.findStudentHighestTotalDegree());

        System.out.println("\n--- Students on Probation ---");
        Student[] probationStudents = studentTest.findTheStudentsWhoAreOnProbation();
        for(Student s : probationStudents) {
            System.out.println(s);
        }
    }
}
