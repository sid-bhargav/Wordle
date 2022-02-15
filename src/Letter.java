package src;

import java.awt.Color;

public class Letter {

    private Color status;
    private String letter;

    private Color green = new Color(75, 176, 62); 
    private Color yellow = new Color(235, 200, 47);
    private Color gray = new Color(128, 128, 128);

    public Letter(String s){
        this.letter = s; 
        status = gray; 
    }

    public String getLetter() {
        return letter;
    }

    public void setColor(Color c) {
        this.status = c;
    }

    @Override
    public String toString() {
        String s = letter;
        // s += status.toString();
        return s;
    }

}
