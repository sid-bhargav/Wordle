package src;

import com.opencsv.CSVReader;
import com.opencsv.*;

import java.io.FileReader;
import java.util.ArrayList;

public class WordleGrid {
    // Game parameters
    private int wordLength;
    private int guessesLength;

    // Game logic
    int turns = 0;
    private boolean gameWon = false;
  
    private Word answerWord;
    private Word[] gameGrid;
    private Word[] guessesChecked;

    private ArrayList<String> legalWords = new ArrayList<>();

    private ArrayList<Letter> bank = new ArrayList<>();

    // Read CSV file and find a random word to use:

    //TEMP creates a row for the terminal
    private Word blank;

    public void loadWords(){
        try {
            //csv file containing data
            String strFile = "FiveLetterWords.csv";
            CSVReader reader = new CSVReader(new FileReader(strFile));
            String[] nextLine;
            int lineNumber = 0;
            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;
                // System.out.println("Line # " + lineNumber);
                legalWords.add(nextLine[0]);
            
                // // nextLine[] is an array of values from the line
                // System.out.println(nextLine[0] + " etc...");
            }
        } catch (Exception e) {
            System.out.println("Error loading in word list file");
        }
    }

    public String pickWord(){
        int n = (int)(legalWords.size()*java.lang.Math.random());
        System.out.println(legalWords.get(n));
        return legalWords.get(n);
    }

    public WordleGrid(){
        this.loadWords();
        this.wordLength = 5;
        this.guessesLength = 6;
        // TODO add random 5 letter word through csv
        this.answerWord = new Word(this.pickWord());
        gameGrid = new Word[guessesLength];
        guessesChecked = new Word[guessesLength];

        //TEMP
        blank = new Word("#####");
    }

    // Custom game
    public WordleGrid(int wordLength, int guessesLength){
        this.wordLength = wordLength;
        this.guessesLength = guessesLength;
        gameGrid = new Word[guessesLength];
        guessesChecked = new Word[guessesLength];

        //TEMP
        String s = "";
        for(int i = 0; i < wordLength; i++){
            s += "#";
        }
        blank = new Word(s); 
    }

    public int getWordLength() {
        return wordLength;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < gameGrid.length; i++){
            if(guessesChecked[i] == null)
                gameGrid[i] = blank;
            else{
                gameGrid[i] = guessesChecked[i];
            }
            s += gameGrid[i].toString() + "\n";
        }
        return s; 
    }

    // Maybe I should change this from a Letter array to a word?

    /* Checks */

    public boolean isWon(Word w){
        if (w.equals(answerWord)){
            gameWon = true;
            return true;
        }
        return false;
    }

    //Checks if the length is right
    public boolean checkLength(Word w) {
        if(w.getLength() == wordLength)
            return true; 
        return false;
    }

    // Checks if the word is a valid english word 
    public boolean checkValid(Word w) {
        for (int i = 0; i < legalWords.size(); i++){
            if (w.equals(new Word(legalWords.get(i)))){
                return true;
            }
        }
        return false;
    }

    public boolean checkGameOver() {
        // Checks if game has been won yet
        if (gameWon){
            if (turns == 1){
                System.out.println("You're cracked! it took you just one turn to get the answer: " + answerWord.getWord());
                return false;
            }
            if (turns == 2){
                System.out.println("That's insane! it took you just two turns to get the answer: " + answerWord.getWord());
                return false;
            }
            if (turns < 5){
                System.out.println("You won! it took you " + turns + " turns to get the answer: " + answerWord.getWord());
                return false;
            } else {
                System.out.println("Wow, that was hard! it took you " + turns + " turns to get the answer: " + answerWord.getWord());
                return false;
            }
        }

        // Checks to see if there are any guesses left, if all guesses have been used: game over
        int nulls = 0;
        for(int i = 0; i < guessesChecked.length; i++){
            if(guessesChecked[i] == null){
                nulls++;
            }
        }
        if(nulls > 0){
            return false;
        }
        System.out.println("Gameover, the word was: " + answerWord.getWord());
        return true; 
    }

    public Word colorWords(Word w) {
        return w.compareTo(answerWord); 
    }

    public boolean handleCheck(Word w){

        if(checkLength(w) && checkValid(w)){
            colorWords(w);
        } else {
            System.out.println("Sorry, this word is invalid.");
            return false;
        }
        return true; 
    }

    public Word addGuess(Word w) {
        Word checked = w;

        for(int i = 0; i < guessesChecked.length; i++){
            if (guessesChecked[i] == null){
                guessesChecked[i] = w;
                turns++;
                break;
            }
        }
        return checked;
    }
}
