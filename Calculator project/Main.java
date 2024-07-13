import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);


        double number1, number2;

        boolean quit = false;

        ArrayList<Double> resultList = new ArrayList<>();


        do{



            System.out.println("Please enter the first number: (enter 0 for both numbers to quit) ");
            number1 = scan.nextDouble();


            System.out.println("Please enter the second number: (enter 0 for both numbers to quit) ");

            number2 = scan.nextDouble();


            if(number1 == 0 || number2 == 0){
                quit = true;
                break;
            }

           switch (getChoice()){

               case 1:
                   System.out.println("The Sum of the two numbers is: " + sum(number1,number2,resultList));
                   break;

               case 2:
                   System.out.println("The Subtraction of the two numbers is: " + subtract(number1,number2,resultList));
                   break;

               case 3:
                   System.out.println("The multiplication of the two numbers is: " + multiplication(number1,number2,resultList));
                   break;

               case 4:
                   System.out.println("The divison of the two numbers is: " + divison(number1,number2,resultList));
                   break;

               case 5:
                   System.out.println("The modulus of the two numbers is: " + modulus(number1,number2,resultList));
                   break;

               case 6:
                   System.out.println("The minimum of the two numbers is: " + minimumNumber(number1,number2,resultList));
                   break;

               case 7:
                   System.out.println("The maximum of the two numbers is: " + maximumNumber(number1,number2,resultList));
                   break;

               case 8:
                   System.out.println("The average of the two numbers is: " + average(number1,number2,resultList));
                   break;


               case 9:
                   System.out.println("The last result is : ");
                   showLastResult(resultList);
                   break;

               case 10:
                   System.out.println("All the previous results ");
                   showAllResult(resultList);
                   break;
           }

        }while(quit == false);






    }


    public static void displayMenu(){
        System.out.println("Enter 1 to addition the numbers ");
        System.out.println("Enter 2 to subtraction the numbers");
        System.out.println("Enter 3 to multiplication the numbers ");
        System.out.println("Enter 4 to divison the numbers ");
        System.out.println("Enter 5 to modulus the numbers ");
        System.out.println("Enter 6 to find the minimum number ");
        System.out.println("Enter 7 to find the Maximum number ");
        System.out.println("Enter 8 to find the average of numbers ");
        System.out.println("Enter 9 to print the last result in calculator ");
        System.out.println("Enter 10 to print the list of all results in calculator ");
    }



    private static int getChoice() {
        Scanner scan = new Scanner(System.in); // Use a separate scanner for user input here
        System.out.println("\nEnter your choice: ");
        displayMenu();

        int choice;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scan.next();
            choice = -1;
        }
        return choice;
    }



    public static double sum(double number1, double number2, ArrayList<Double> resultList){

        double result = number1 + number2;

        resultList.add(result);

        return result;
    }

    public static double subtract(double number1, double number2, ArrayList<Double> resultList){

        double result = number1 - number2;

        resultList.add(result);

        return result;
    }

    public static double multiplication(double number1, double number2, ArrayList<Double> resultList){

        double result = number1 * number2;

        resultList.add(result);

        return result;
    }

    public static double divison(double number1, double number2, ArrayList<Double> resultList){

        double result = number1 / number2;

        resultList.add(result);

        return result;
    }

    public static double modulus(double number1, double number2, ArrayList<Double> resultList){

        double result = number1 % number2;

        resultList.add(result);

        return result;
    }

    public static double maximumNumber(double number1, double number2, ArrayList<Double> resultList){

        double result = Math.max(number1,number2);

        resultList.add(result);

        return result;
    }

    public static double minimumNumber(double number1, double number2, ArrayList<Double> resultList){

        double result = Math.min(number1,number2);

        resultList.add(result);

        return result;
    }

    public static double average(double number1, double number2, ArrayList<Double> resultList){

        double result = (number1 + number2) / 2;

        resultList.add(result);

        return result;
    }


    public static void showLastResult(ArrayList<Double> resultList){

        if(resultList.isEmpty()){
            System.out.println("There is not results yet: ");
        } else {
            System.out.println("The last result is: \n" + resultList.get(resultList.size() - 1));
        }

    }

    public static void showAllResult(ArrayList<Double> resultList){

        if(resultList.isEmpty()){
            System.out.println("There is not results yet: ");
        } else {
            System.out.println("The result of an array list: \n " + resultList);
        }
    }

}