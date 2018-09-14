import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.math.*;

class ArtWork {
    public static void main( String args[] ) {
        try {
            Scanner scanner = new Scanner(System.in);
            String filename = "patternWords.txt";//scanner.next();
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            int roundCounter = 3;
            while(roundCounter > 0) {

                String fileLine = getRandomWord(fileScanner);

                System.out.println();
                //System.out.println(fileLine);

                String continueGame = playGame(fileLine);

                if(continueGame.equalsIgnoreCase("yes")) {
                    roundCounter--;
                }
                else {
                    System.out.println("Game Over");
                    break;
                }
            }

        }
        catch (Exception exc)
        {
            System.out.println(exc.toString());
        }
    }
    public static String getRandomWord(Scanner fileScanner)
    {
        int randomVal = ((int) ((Math.random()) * 100) % 20) + 1;
        int wordCtr = 0;
        String fileLine = "";
        while (fileScanner.hasNext()) {
            fileLine = fileScanner.next();

            wordCtr++;
            if (wordCtr == randomVal)
                break;
            //System.out.println(fileLine);
        }
        return fileLine;

    }
    public static String playGame(String fileLine)
    {
        int guessCounter = 3;
        int [] guessedStatus = new int[fileLine.length()];
        printString(fileLine, guessedStatus, (3 - guessCounter));
        while (guessCounter > 0) {
            System.out.print("Guess a letter : ");
            Scanner guessScanner = new Scanner(System.in);
            if (guessScanner.hasNext()) {
                char guessChar = guessScanner.next().charAt(0);
                int indexOfChar = fileLine.indexOf(guessChar);
                if(indexOfChar >= 0) {
                    guessedStatus[indexOfChar] = 1;
                }
                else {
                    guessCounter--;
                }
                int guessedCounter = 0;
                for(int guessedIndex = 0; guessedIndex < guessedStatus.length; guessedIndex++) {
                    if(guessedStatus[guessedIndex] == 1)
                        guessedCounter++;
                }
                if(guessedCounter == guessedStatus.length)
                    break;
                printString(fileLine, guessedStatus, (3 - guessCounter));
            }
        }

        System.out.println("The word was : " + fileLine);
        System.out.println("Do you want to continue? ");
        Scanner gameCountScanner = new Scanner(System.in);

        if(gameCountScanner.hasNext()) {
            return gameCountScanner.next().toString();
        }
        return "no input";
    }
    public static void printString(String fileLine, int guessedStatus[], int counter)
    {
        System.out.println(counter + ": ");
        int stringIndex = 0;
        while(stringIndex < fileLine.length()) {
            if(guessedStatus[stringIndex] == 1) {
                System.out.print(fileLine.charAt(stringIndex) + " ");
            }
            else {
                System.out.print("_ ");
            }
            stringIndex++;
        }
        System.out.println();
    }
}
