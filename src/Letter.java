package src;

import java.awt.Color;

public class Letter {

    private Color status;
    private String letter;

    private Color green = new Color(75, 176, 62); 
    private Color yellow = new Color(235, 200, 47);
    private Color gray = new Color(128, 128, 128);
    private Color white = new Color(0, 0, 0);

    public Letter(String s){
        this.letter = s; 
        status = gray; 
    }

    public String getLetter() {
        return letter;
    }

    public Color getStatus() {
        return status;
    }

    public void setColor(Color c) {
        this.status = c;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
			return false;
		}
		
		try {
			Letter l = (Letter) obj;
			return this.letter.equals(l.letter);
		}
		catch (Exception e){
		}

		return false;
    }

    @Override
    public String toString() {
        String s = letter;
        if(this.status.equals(green)){
            s += "(G)";
        }
        if(this.status.equals(yellow)){
            s += "(Y)";
        }
        if(this.status.equals(gray)){
            s += "(*)";
        }
        if(this.status.equals(white))
            s += "";
        // s += status.toString();
        return s;
    }

}
