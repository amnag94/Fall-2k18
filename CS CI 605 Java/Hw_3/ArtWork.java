

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.File;

class ArtWork {
    private int allowedAttempts;
    private String fileName ;
    private List<String> wordList ;
    private Vector<String> artWorkPicture;
    private int [] displayedArtWorkIndexes;

    public ArtWork(int attemptsCount, String fileName){
        allowedAttempts = attemptsCount;
        this.fileName = fileName;
        artWorkPicture = readArtWorkFile();

    }

    private boolean initialiseGame() {
        Scanner scanner = null;
        try {
            wordList = new ArrayList<>();
            scanner = new Scanner(new FileReader(new File("").getCanonicalPath() + "/"+fileName));
            while (scanner.hasNext()){
                wordList.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("please enter a correct file name");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
        if(scanner != null){
            scanner.close();
            return  true;
        }
        else {
            return false;
        }
        }
    }

    private void play() {
        String continueGame;
        do {
            String wordToBeDisplayed = chooseRandomWordFromWordList();
            System.out.println();
            initialiseArtWorkToBeDisplayed();
            continueGame = playGame(wordToBeDisplayed);
        }while(continueGame.equalsIgnoreCase("yes"));
    }

    private void initialiseArtWorkToBeDisplayed() {
        displayedArtWorkIndexes = new int[artWorkPicture.size()];
    }

    private String chooseRandomWordFromWordList() {
        return wordList.get(new Random().nextInt(wordList.size()));
    }


    private Vector<String> readArtWorkFile() {
        Scanner scanner = null;
        Vector<String> artWork = new Vector<>();
        try {

            scanner = new Scanner(new FileReader(new File("").getCanonicalPath() + "/pic.txt"));
            while (scanner.hasNext()){
                artWork.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(scanner != null){
                scanner.close();
            }
            return artWork;
        }
    }

    private String playGame(String wordToGuess) {
        Scanner scanner = new Scanner(System.in);
        int remainingGameAttempts = allowedAttempts;
        int [] guessedWordIndexes = new int[wordToGuess.length()];
        do {
            printGuessedString(wordToGuess, guessedWordIndexes);
            System.out.print("Guess a letter : ");
            char guessedChar = scanner.next().charAt(0);
            if(playerGuessedCorrectChar(guessedChar,wordToGuess,guessedWordIndexes)){
                if( playerGuessedEntireWord(guessedWordIndexes)){
                    break;
                }
            }
            else {
                remainingGameAttempts--;
            }
            displayArtWork(false);
        }while (remainingGameAttempts > 0);
        displayArtWork(true);
        System.out.println("The word was : " + wordToGuess);
        System.out.println("Do you want to continue? ");
        return scanner.next();
    }

    private boolean playerGuessedCorrectChar(char guessedChar,String wordToGuess,int [] guessedWordIndexes) {
        int index = wordToGuess.indexOf(guessedChar);
        boolean charGuessed = false;
        while (index != -1){
            charGuessed = true;
            guessedWordIndexes[index]=1;
            index = wordToGuess.indexOf(guessedChar,index+1);
        }
        return charGuessed;
    }

    private boolean playerGuessedEntireWord(int[] guessedWord) {
        int guessedCounter = 0;
        for(int guessedIndex = 0; guessedIndex < guessedWord.length; guessedIndex++) {
            if(guessedWord[guessedIndex] == 1)
                guessedCounter++;
        }
        return (guessedCounter == guessedWord.length);
    }

    public static void printGuessedString(String wordToBeDisplayed, int [] guessedCharIndexes)
    {
        StringBuilder stringBuilder = new StringBuilder();
        int charIndex = 0;
        while(charIndex < wordToBeDisplayed.length()) {
            if(guessedCharIndexes[charIndex] == 1) {
                stringBuilder.append(wordToBeDisplayed.charAt(charIndex) + " ");
            }
            else {
                stringBuilder.append("_ ");
            }
            charIndex++;
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main( String args[] ) {
        try {
            String fileName ;
            if (args.length > 0){
                fileName = args[0];
            }
            else{
                fileName = "wordList.txt";
            }
            ArtWork artWork = new ArtWork(3,fileName);
            if(artWork.initialiseGame()){
                artWork.play();
            }

        }
        catch (Exception exc) {
            System.out.println(exc.toString());
        }
    }

    private void displayArtWork(boolean showEntirePicture) {

        Random random = new Random();
        int rowsOfArtWorkToShowOnEachAttempt = artWorkPicture.size() / allowedAttempts;
        while (rowsOfArtWorkToShowOnEachAttempt >= 0){
            int randomNumber = random.nextInt(artWorkPicture.size());
            displayedArtWorkIndexes[randomNumber] = 1;
            rowsOfArtWorkToShowOnEachAttempt --;
        }
        for (int index = 0; index < artWorkPicture.size(); index++) {
            if(displayedArtWorkIndexes[index]==1 || showEntirePicture){
                System.out.println(artWorkPicture.get(index));
            }
            else {
                System.out.println();
            }
        }
    }


}
