package src;

import java.util.ArrayList;
import java.awt.Color;

public class Word {
    private String word;
    private int length;
    private ArrayList<Letter> letters = new ArrayList<Letter>(); 

    private Color green = new Color(75, 176, 62); 
    private Color yellow = new Color(235, 200, 47);
    private Color gray = new Color(128, 128, 128);
    private Color white = new Color(0, 0, 0);

    public Word(String guess){
        this.word = guess;
        this.length = guess.length();
        for (int i = 0; i < guess.length(); i++){
            letters.add(new Letter(guess.substring(i, i+1)));
        }
    }

    public String getWord() {
        return word;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<Letter> getLetters() {
        return letters;
    }

    public ArrayList<Letter> setLetterColor(int i, Color c) {
        letters.get(i).setColor(c);
        return letters;
    }

    @Override
    public String toString(){
        return letters.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
			return false;
		}
		
		try {
			Word w = (Word) obj;
            return this.word.equals(w.word);
		}
		catch (Exception e){
		}

		return false;
    }

    public Word compareTo(Word w){

        for(int i = 0; i < length; i++){

            for(int j = 0; j < length; j++){
                if(this.letters.get(i).equals(w.letters.get(j))){
                    (this.letters.get(i)).setColor(yellow);
                }
            }

            // Check exact matches
            if(this.letters.get(i).equals(w.letters.get(i))){
                (this.letters.get(i)).setColor(green);
            }

        }
        return this;
    }
}
