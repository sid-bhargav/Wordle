package src;

import java.awt.Color;

public class Letter {

    private Color status;
    private String letter;

    private Color green;
    private Color yellow;
    private Color gray;

    public Letter(String s){
        this.letter = s; 
        status = gray; 
    }

    public String getLetter() {
        return letter;
    }

    public void setGreen() {
        this.status = green;
    }

    public void setYellow() {
        this.status = yellow;
    }

    @Override
    public String toString() {
        return letter;
    }

}
