package src;

import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class Main {
    public static void main(String[] args){

        WordleGrid game = new WordleGrid();
        Scanner scanner = new Scanner(System.in);
        Word guess;
        System.out.println(game);
        boolean gameOver = false; 

        while (!gameOver){
        String guessWord = scanner.nextLine();  // Read user input
        guess = new Word(guessWord);
            
        // Checks if the guess is valid, and then adds the guess to the board
        if(game.handleCheck(guess)){
            game.addGuess(guess);
        }
        // TEMP Print the game board 
        System.out.println(game);
        // Checks if the game has been won by player to break the loop
        gameOver = game.isWon(guess);
        // Checks if the game went too long and breaks the loop if it hasn't 
        if(game.checkGameOver())
            break;
        }

        scanner.close();
    }
}