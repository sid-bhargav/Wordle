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

    public WordleGrid(){
        this.wordLength = 5;
        this.guessesLength = 6;
        // TODO add random 5 letter word through csv
        this.answerWord = new Word("crane");
    }

    // Custom game
    public WordleGrid(int wordLength, int guessesLength){
        this.wordLength = wordLength;
        this.guessesLength = guessesLength;
    }

    public int getWordLength() {
        return wordLength;
    }

    public boolean isWon(Word w){
        return false; 
    }

    public ArrayList<Letter> checkGuess(Word w){
        ArrayList<Letter> checked = w.getLetters();
        return checked;
    }
}
