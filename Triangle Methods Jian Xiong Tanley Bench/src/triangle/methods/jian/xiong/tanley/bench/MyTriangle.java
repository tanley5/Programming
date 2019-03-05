package triangle.methods.jian.xiong.tanley.bench;//Jian Xiong Tanley Bench

import java.util.Arrays;
import java.util.Scanner;


public class MyTriangle
{
    public static boolean isValid(double sidea, double sideb, double sidec)
    {
        boolean validation = false;
        if(sidea>0 && sideb>0 && sidec>0)
        {
            double []side = new double[3];
            side[0] = sidea;
            side[1] = sideb;
            side[2] = sidec;
            
            Arrays.sort(side);
            sidea = side[0];
            sideb = side[1];
            sidec = side[2];
            
            if((sidea+sideb)>sidec)
            {
                validation = true;
            }
        }
        return validation;
    }
    
    public static double area(double sidea, double sideb, double sidec)
    {
        double areaCalc;
        double semiPerimeter;
        
        //Calculate the semiperimeter
        semiPerimeter = (sidea+sideb+sidec)/2;
        //Calculate the area using Heron's formula
        areaCalc = Math.sqrt(semiPerimeter*(semiPerimeter-sidea)*(semiPerimeter-sideb)*(semiPerimeter-sidec));
        
        return areaCalc;
    }
    
    public static String triangleType(double a, double b, double c)
    {
        String type;
        double sidea, sideb, sidec;
        boolean validation;
        
        type = "Invalid Triangle";
        
        if(a>0 && b>0 && c>0)
        {
            double []side = new double[3];
            side[0] = a;
            side[1] = b;
            side[2] = c;
            
            Arrays.sort(side);
            sidea = side[0];
            sideb = side[1];
            sidec = side[2];
            
            //Check if the Triangle is valid
            validation = isValid(sidea,sideb,sidec);
            //Compare the results to see which type of triangle it is
            if(validation ==true)
            {
                if(sidea == sideb || sideb == sidec)
                {
                    type = "Isoceles";
                    if (sidea == sidec)
                    {
                        type = "Equilateral";
                    }
                }
                else
                {
                    type = "Scalene";
                }
            }
        }
        return type;
    }
    
    public static void main(String[] args)
    {
        Scanner input;
        boolean validation, proceed;
        double sidea,sideb,sidec;
        
        input = new Scanner(System.in);
        proceed = true;
        
        while(proceed)
        {
            System.out.println("Enter the Three sides of a triangle (press enter after every side)");
            sidea = input.nextDouble();
            sideb = input.nextDouble();
            sidec = input.nextDouble();

            validation = isValid(sidea,sideb,sidec);

            if (validation == true)
            {
                System.out.println("Triangle type: "+triangleType(sidea,sideb,sidec));
                System.out.printf("Area is: %.2f%n", area(sidea,sideb,sidec));
                proceed = false;
            }
            else
            {
                System.out.println("Triangle type: "+triangleType(sidea,sideb,sidec));
                System.out.println("Please enter valid triangle sides");
            }
        }
        input.close();
    }
}
