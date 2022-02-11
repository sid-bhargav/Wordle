package src;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Letter> letters = new ArrayList<Letter>(); 

    public Word(String guess){
        this.word = guess;
        for (int i = 0; i < guess.length(); i++){
            letters.add(new Letter(guess.substring(i, i+1)));
        }
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Letter> getLetters() {
        return letters;
    }

    @Override
    public String toString(){
        return letters.toString();
    }

    public int compareTo(Word w){
        return 0;
    }
}
