package letter.grade.calculator;//Jian Xiong Tanley Bench

import java.util.Scanner;

public class LetterGradeCalculator
{
    public static double gradeAdjustor(double grade)
    {
        double adjustedGrade;
        
        //Adjust grades according to type
        if(grade<0)
        {
            adjustedGrade = grade*100;
        }
        else
        {
            adjustedGrade = grade;
        }
        
        return adjustedGrade;
    }
    public static double gradeDropper(double grade1, double grade2)
    {
        double returnedGrade;
        
        //Adjust the grades
        grade1 = gradeAdjustor(grade1);
        grade2 = gradeAdjustor(grade2);
        
        if(grade1>=grade2)
        {
            returnedGrade = grade1;
            //System.out.println("Grade dropped"+grade2);
        }
        else
        {
            returnedGrade = grade2;
            //System.out.println("Grade dropped"+grade1);
        }
        
        return returnedGrade;
    }
    
    public static String finalGradeCalc(double quiz1,double quiz2, double exam1, double exam2)
    {
        String finalGrade;
        String letterGrade;
        double grade;
        double quizGrade, examGrade;
        
        
        //Drop the lowest grade
        
        quizGrade = gradeDropper(quiz1,quiz2);
        examGrade = gradeDropper(exam1,exam2);
        
        //Quiz count for 40% of the grade
        quizGrade = (40*quizGrade)/100;
        //Exam counts for 60% of the grade
        examGrade = (60*examGrade)/100;
        
        //Total Grade
        grade = quizGrade+examGrade;
        
        if (grade >=90)
        {
            letterGrade = "A";
        }
        else if (grade>=80)
        {
            letterGrade = "B";
        }
        else if (grade>=70)
        {
            letterGrade = "C";
        }
        else if (grade >=60)
        {
            letterGrade = "D";
        }
        else if (grade>=50)
        {
            letterGrade = "E";
        }
        else
        {
            letterGrade = "F";
        }
        
        finalGrade = String.format("Grade is: %.2f%nLetter Grade is:%s",grade,letterGrade);
        return finalGrade;
    }
    public static void main(String[] args)
    {
        double quiz,quiz1,quiz2,exam,exam1,exam2;
        String name, studentId;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the student's name");
        name = input.nextLine();
        System.out.println("Please enter the student's ID number");
        studentId = input.nextLine();
        System.out.println("Please enter the two quiz grades (press enter after every input)");
        quiz1 = input.nextDouble();
        quiz2 = input.nextDouble();
        System.out.println("Please enter the two exam grades (press enter after every input)");
        exam1 = input.nextDouble();
        exam2 = input.nextDouble();
        
        
        System.out.println(String.format("Name : %s%nID Number: %s%n",name,studentId)+
                finalGradeCalc(quiz1,quiz2,exam1,exam2));
        input.close();
    }

}
