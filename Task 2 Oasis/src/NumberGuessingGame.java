import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> Score_Board_of_game = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessingGame Method_Changes = new NumberGuessingGame();
        Method_Changes.menu(Score_Board_of_game);
    }

    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        Scanner Input_of_player = new Scanner(System.in);


        System.out.println("--------------------");
        System.out.println("1) Play Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit");
        System.out.println("--------------------");

        try {
            System.out.print("What would you like to do? ");
            int Menu_Options_of_game = Input_of_player.nextInt();

            switch (Menu_Options_of_game) {
                case 1:
                    System.out.print("\n"+"What would you like the range of the game to be? ");
                    int numberRng = Input_of_player.nextInt();

                    int rand_Number = methodChange.Rand_Number_genrator(numberRng);
                    methodChange.Game(rand_Number);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid entry. Please Try again");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }

    public int Rand_Number_genrator(int numberRange) {
        Random random = new Random();
        int a = random.nextInt(numberRange) + 1;

        return a;
    }

    public void Game(int randomNumber) {
        Scanner input = new Scanner(System.in);

        int user_guess;
        int bb = 0;

        do {
            System.out.print("Enter your guess: ");
            user_guess = input.nextInt();
            bb++;

            if (user_guess > randomNumber) {
                System.out.println("Lower");
            } else if (user_guess < randomNumber) {
                System.out.println("Higher");
            }

        } while (randomNumber != user_guess);

        System.out.println(" ");

        if (bb == 1) {
            System.out.println("You answered right in " + bb + " try!");
        } else {
            System.out.println("You answered right in " + bb + " tries!");
        }

        Score_Board_of_game.add(bb);
        System.out.println(" ");

        menu(Score_Board_of_game);
    }

    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");

        System.out.println("Your fastest games today: " +"\n");
        Collections.sort(Score_Board_of_game);

        for (Integer scores : Score_Board_of_game) {
            System.out.println("Finished the game in " + scores + " tries");
            System.out.println("Your score is "+((11-scores)*10)+" out of 100");

        }

        System.out.println(" ");
        menu(Score_Board_of_game);
    }
}
