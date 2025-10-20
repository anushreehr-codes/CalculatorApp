import java.util.*;

class Calculator{
    public double addition(double a,double b)
    {
        return a+b;
    }
    public double substraction(double a,double b)
    {
        return a-b;
    }
    public double multiplication(double a,double b)
    {
        return a*b;
    }
    public double division(double a,double b)
    {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
        // if(b==0)
        // {
        //     System.out.println("division by zero error!");
        // }
        // else{
        //     return a/b;
        // }
    }
}

public class Calculator_App {
    public static void main(String args[]){

    int choice=1;//initialize to enter the loop 
    Scanner sc= new Scanner(System.in);//using the scanner class for user input.
    Calculator calc=new Calculator();//creating the object of Calculator class.
    do{
        System.out.println("enter the first number");
        while (!sc.hasNextDouble()) {
        System.out.println("Invalid input! Please enter a number:");
         sc.next(); // discard invalid input(if user entered string/ any other character instead of number)
        }
    Double num1 = sc.nextDouble();

        System.out.println("enter the second number");
        while (!sc.hasNextDouble()) 
        {
        System.out.println("Invalid input! Please enter a number:");
        sc.next();
        }
    Double num2 = sc.nextDouble();
        System.out.println("enter the operator");
        char op=sc.next().charAt(0);
        double result=0;
        boolean flag=true;
        switch (op) {
            case '+':
                result=calc.addition(num1,num2);
                break;
            case '-':
                result=calc.substraction(num1,num2);
                break;
            case '*':
                result=calc.multiplication(num1,num2);
                break;
            case '/':
                try {
                    result = calc.division(num1, num2);
                // throw keyword will throw the exception at run time.hence the caller need to responsible to handle using the try and catch.
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    flag = false;
                }
                break;
            default:
                System.out.println("Invalid operator!");
                flag=false;
                break;
        }
        if(flag)
        {
            System.out.println("the result is "+ result);
        }
        
        System.out.println("enter the choice 1 for continue and 0 for exit");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Enter 1 to continue or 0 to exit:");
            sc.next();
        }
        choice = sc.nextInt();
    }while(choice==1);
    sc.close();
    }
}
