package src;

import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class Main {
    public static void main(String[] args){

        WordleGrid game = new WordleGrid();
        Scanner scanner = new Scanner(System.in);
        Word guess = null;
        System.out.println(game);
        boolean gameOver = false; 

        while (!gameOver){
        String guessWord = scanner.nextLine();  // Read user input
        guess = new Word(guessWord);
    
        if(game.handleCheck(guess)){
            game.addGuess(guess);
        }
        System.out.println(game);
        gameOver = game.isWon(guess);
        if(game.checkGameOver())
            break;
        }
    }
}