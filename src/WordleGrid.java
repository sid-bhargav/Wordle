package src;

import java.util.ArrayList;

public class WordleGrid {
    // Game parameters
    private int wordLength;
    private int guessesLength;

    // Game logic
    private int turns = 0;
    private int[] played;
    private boolean gameWon = false;
  
    private Word answerWord;
    private Word[] gameGrid;
    private Word[] guesses;

    //TEMP
    private Word blank;

    public WordleGrid(){
        this.wordLength = 5;
        this.guessesLength = 6;
        // TODO add random 5 letter word through csv
        this.answerWord = new Word("crane");
        gameGrid = new Word[guessesLength];
        guesses = new Word[guessesLength];

        //TEMP
        blank = new Word("#####");
    }

    // Custom game
    public WordleGrid(int wordLength, int guessesLength){
        this.wordLength = wordLength;
        this.guessesLength = guessesLength;
        gameGrid = new Word[guessesLength];
        guesses = new Word[guessesLength];

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

    public boolean isWon(Word w){
        return false; 
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < gameGrid.length; i++){
            if(guesses[i] == null)
                gameGrid[i] = blank;
            else{
                gameGrid[i] = guesses[i];
            }
            s += gameGrid[i].toString() + "\n";
        }
        return s; 
    }

    // Maybe I should change this from a Letter array to a word?
    public ArrayList<Letter> checkGuess(Word w){
        ArrayList<Letter> checked = w.getLetters();
        return checked;
    }
}
