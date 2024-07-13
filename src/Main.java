import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int rows = 3, coul = 3, counter = 1, position;

        List<Integer> positions = List.of(1,2,3,4,5,6,7,8,9);

        ArrayList<Integer> positionsLeft;

        String choice;

        String[][] boardGame =  new String[rows][coul];


        initialize(boardGame,rows,coul,counter);


        displayBoard(boardGame,rows,coul);


        int round = 0, playerScore = 0, computerScore = 0;

        do{
            System.out.println("How many round do you to play 1 or 3: ");
            round = scan.nextInt();



        }while(round != 1 && round != 3);



        for (int i = 0; i < round ; i++) {

            initialize(boardGame,rows,coul,counter);

            positionsLeft = new ArrayList<>(positions);

            System.out.println("Round number: " + (i + 1));

            do{

                scan.nextLine();

                System.out.println("You want to play with X or O ?");

                choice = scan.nextLine();


                displayBoard(boardGame,rows,coul);


            } while (!checkChoice(choice));

            boolean win = false;


            do {

                playerChoice(boardGame, rows, coul, scan, choice, positionsLeft );

                if(determineWin(boardGame, rows, coul)){

                    System.out.println("player you won the round");

                    playerScore++;

                    win = true;

                    break;
                } else if(positionsLeft.isEmpty()){
                    System.out.println("It's a draw");
                    break;
                }


                computerChoice(boardGame, rows, coul, choice, positionsLeft);

                if(determineWin(boardGame, rows, coul)){

                    System.out.println("the computer won the round");
                    computerScore++;
                    break;

                } else if(positionsLeft.isEmpty()){
                    System.out.println("It's a draw");
                    break;
                }



            }while(true);

            System.out.println();
        }

        if(playerScore > computerScore){
            System.out.println("player won the game ");
        } else if (computerScore > playerScore) {
            System.out.println("computer won the game");
        } else {
            System.out.println("It's a draw ");
        }


    } // The end of the main method


    public static void initialize(String[][] boardGame, int rows, int coul, int counter){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < coul; j++) {

                boardGame[i][j] = String.valueOf(counter);
                counter++;

            }
        }
    }



    public  static void displayBoard(String[][] boardGame, int rows, int coul){

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < coul; j++) {
                System.out.print(boardGame[i][j] + " ");
            }

            System.out.println();
        }


    }

    public static void playerChoice(String[][] boardGame, int rows, int coul, Scanner scan, String choice, ArrayList<Integer> positionsLeft){
        int position = 0;


        do{
            System.out.println("Please enter the position from ( 1 - 9): write 0 to exit");

            try{
                position = scan.nextInt();

            }catch (InputMismatchException e){
                System.out.println("There is an input mismatch: " + e.getMessage());
            } catch (Exception e){
                System.out.println("A general exception happened: " + e.getMessage());
            }



        }while(isUnvalid(positionsLeft, position));



            for (int i = 0; i < rows ; i++) {
                for (int j = 0; j < coul ; j++) {
                    if(boardGame[i][j].equalsIgnoreCase(Integer.toString(position))){
                        boardGame[i][j] = choice;

                        positionsLeft.remove(Integer.valueOf(position));

                    }
                }
            }
            displayBoard(boardGame,rows,coul);
    }


    public static void computerChoice(String[][] boardGame, int rows, int coul, String choice, ArrayList<Integer> positionsLeft){

        Random random = new Random();

      int randomIndex =  random.nextInt(0, positionsLeft.size());


      int position = positionsLeft.get(randomIndex);


        System.out.println("-----------------------------");
        System.out.println("The computer play");

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < coul ; j++) {
                if(boardGame[i][j].equalsIgnoreCase(Integer.toString(position))){

                    if(choice.equalsIgnoreCase("o")){
                        boardGame[i][j] = "X";
                        positionsLeft.remove(Integer.valueOf(position));
                    }else {
                        boardGame[i][j] = "O";
                        positionsLeft.remove(Integer.valueOf(position));
                    }
                }
            }
        }

        displayBoard(boardGame,rows,coul);


    }


    public static boolean determineWin(String[][] boardGame, int rows, int coul) {
        if ((boardGame[0][0].equalsIgnoreCase(boardGame[0][1]) && boardGame[0][0].equalsIgnoreCase(boardGame[0][2]))
                || (boardGame[1][0].equalsIgnoreCase(boardGame[1][1]) && boardGame[1][0].equalsIgnoreCase(boardGame[1][2]))
                || (boardGame[2][0].equalsIgnoreCase(boardGame[2][1]) && boardGame[2][0].equalsIgnoreCase(boardGame[2][2]))
                || (boardGame[0][0].equalsIgnoreCase(boardGame[1][0]) && boardGame[0][0].equalsIgnoreCase(boardGame[2][0]))
                || (boardGame[0][1].equalsIgnoreCase(boardGame[1][1]) && boardGame[0][1].equalsIgnoreCase(boardGame[2][1]))
                || (boardGame[0][2].equalsIgnoreCase(boardGame[1][2]) && boardGame[0][2].equalsIgnoreCase(boardGame[2][2]))
                || (boardGame[0][0].equalsIgnoreCase(boardGame[1][1]) && boardGame[0][0].equalsIgnoreCase(boardGame[2][2]))
                || (boardGame[0][2].equalsIgnoreCase(boardGame[1][1]) && boardGame[0][2].equalsIgnoreCase(boardGame[2][0]))
        )
        {
            return true;
        }
        return false;
    }


    private static boolean isUnvalid(ArrayList<Integer> positionsLeft, int position){


        if(positionsLeft.contains(position)){
            return false;
        } else {
            System.out.println("The position is Unvalid");
            return true;
        }
    }

    private static boolean checkChoice(String choice){

        if(choice.equalsIgnoreCase("x") || choice.equalsIgnoreCase("o")){
            return true;
        }else {
            System.out.println("The only choices accepted is X or O : ");
            return false;
        }


    }

} // The end of the main class



