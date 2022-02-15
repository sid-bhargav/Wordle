package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        WordleGrid game = new WordleGrid();
        Scanner scanner = new Scanner(System.in);
        Word guess = null;
        System.out.println(game);
    
        while (!game.isWon(guess)){
        String guessWord = scanner.nextLine();  // Read user input
        guess = new Word(guessWord);
        System.out.println(guess);
        System.out.println(game.checkGuess(guess));
        }
    }
}