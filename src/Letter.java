package src;

import java.awt.Color;

public class Letter {

    private Color status;
    private String letter;

    private Color green = Color.GREEN; 
    private Color yellow = Color.YELLOW;
    private Color gray = Color.GRAY;

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
        return letter + status.toString();
    }

}
