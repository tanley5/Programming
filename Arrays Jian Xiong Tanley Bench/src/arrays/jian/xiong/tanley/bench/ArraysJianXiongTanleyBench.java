package arrays.jian.xiong.tanley.bench;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArraysJianXiongTanleyBench
{

    public static String symbol(int number)
    {
        //int counter;
        String symbol;

        symbol = "";

        while (number >= 10)
        {
            number -= 10;
            symbol += "X";
        }
        if (number >= 5)
        {
            symbol += "X";
        }

        return symbol;
    }

    public static void main(String[] args)
    {
        //Read the File and store into arrays
        int i;
        String studentNum[] = new String[1000];
        double gpa[] = new double[1000];
        i = 0;
        try
        {
            Scanner inputFile = new Scanner(new File("studentdata.txt"));
            while (inputFile.hasNext())
            {
                studentNum[i] = inputFile.next();
                gpa[i] = inputFile.nextDouble();
                i++;
            }
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("The file is not there");
        }
        //You must create a simple diagram to show how many students fall into each of 
        //8 different categories.

        //Count the number of students in each of the categories
        int counts[] = new int[8];
        for (int j = 0; j < counts.length; j++)
        {
            counts[j] = 0;
        }

        for (int j = 0; j < gpa.length; j++)
        {
            if (0.0 <= (gpa[j]) && (gpa[j]) < 0.5)
            {
                counts[0]++;
            }
            else if (0.5 <= gpa[j] && gpa[j] < 1)
            {
                counts[1]++;
            }
            else if (1 <= gpa[j] && gpa[j] < 1.5)
            {
                counts[2]++;
            }
            else if (1.5 <= gpa[j] && gpa[j] < 2)
            {
                counts[3]++;
            }
            else if (2 <= gpa[j] && gpa[j] < 2.5)
            {
                counts[4]++;
            }
            else if (2.5 <= gpa[j] && gpa[j] < 3)
            {
                counts[5]++;
            }
            else if (3 <= gpa[j] && gpa[j] < 3.5)
            {
                counts[6]++;
            }
            else if (3.5 <= gpa[j] && gpa[j] <= 4)
            {
                counts[7]++;
            }
        }

        //create an Array special symbol (X)
        String[] diagram = new String[8];
        for (int j = 0; j < counts.length; j++)
        {
            diagram[j] = symbol(counts[j]);
            //System.out.println(diagram[j]);
        }

        //output diagram
        System.out.println("Each X represents 10 students rounded to the nearest 10.");
        System.out.printf("0.0 to 0.49\t(%d)\t%s\n", counts[0], diagram[0]);
        System.out.printf("0.5 to 0.99\t(%d)\t%s\n", counts[1], diagram[1]);
        System.out.printf("1.0 to 1.49\t(%d)\t%s\n", counts[2], diagram[2]);
        System.out.printf("1.5 to 1.99\t(%d)\t%s\n", counts[3], diagram[3]);
        System.out.printf("2.0 to 2.49\t(%d)\t%s\n", counts[4], diagram[4]);
        System.out.printf("2.5 to 2.99\t(%d)\t%s\n", counts[5], diagram[5]);
        System.out.printf("3.0 to 3.49\t(%d)\t%s\n", counts[6], diagram[6]);
        System.out.printf("3.5 to 4.00\t(%d)\t%s\n", counts[7], diagram[7]);

        //For each student in the input file, 
        //you must display their S-number, gpa, and class rank.  
        //The S-number and gpa will already be in your arrays; 
        //however, you must calculate their class rank.
        System.out.println("\n\nStudent Number |GPA  \t|Class Rank |Same Rank");
        System.out.println("-------------------------------------------------");
        for (int j = 0; j < gpa.length; j++)
        {
            double rankAbove = rankCounterAbove(gpa, gpa[j]);
            double rankSame = rankCounterSame(gpa, gpa[j]);
            if (studentNum[j] != null)
            {
                if (rankSame == 0)
                {
                    System.out.printf("%s        %.2f        %.0f\n",
                            studentNum[j], gpa[j], rankAbove);
                }
                else
                {
                    System.out.printf("%s        %.2f        T%.0f with %.0f others\n",
                            studentNum[j], gpa[j], rankAbove, rankSame);
                }
            }

        }
    }

    public static double rankCounterAbove(double[] number, double num)
    {
        double rankAbove;
        rankAbove = 0;

        for (int j = 0; j < number.length; j++)
        {
            if (number[j] > num)
            {
                rankAbove++;
            }
        }
        return rankAbove;
    }

    public static double rankCounterSame(double[] number, double num)
    {
        double rankSame;
        rankSame = 0;

        for (int j = 0; j < number.length; j++)
        {
            if (number[j] == num)
            {
                rankSame++;
            }
        }
        return rankSame-1;
    }

}
