package com.wordle.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class GameLogic {
    String word;
    int guessNum;
    boolean[] isTrue = new boolean[5];
    public String getWord() {
        if (word == null) {
            setWord();
            for (int i = 0; i < 5; i++) {
                isTrue[i] = true;
            }
        }
        return word;
    }
    public String getGuess() {
        int lineNumber = (int) (Math.random() * 14855);
        String line = null;
        try {
            line = Files.readAllLines(Paths.get("src/main/resources/com/wordle/wordle/Words.txt")).get(lineNumber);
        } catch (IOException e) {
            System.out.println(e);
        }
        return line;
    }
    public void setWord() {
        int lineNumber = (int) (Math.random() * 2315);
        try{
            String line = Files.readAllLines(Paths.get("src/main/resources/com/wordle/wordle/answers.txt")).get(lineNumber);
            word = line;
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public boolean inList(String guessUpper) throws FileNotFoundException {
        String guess = guessUpper.toLowerCase();
        File file = new File("src/main/resources/com/wordle/wordle/Words.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            if (scan.nextLine().equals(guess)) {
                return true;
            }
        }
        return false;
    }
    public String[] checkWord(String guessUpper) {
        String guess = guessUpper.toLowerCase();
        guessNum++;
        String[] correct = new String[5];
        for (int j = 0; j < 5; j++) {
            correct[j] = String.valueOf(guess.charAt(j) == word.charAt(j));
        }
        for (int j = 0; j < 5; j++) {
            if (Objects.equals(correct[j], "false")) {
                for (int i = 0; i < 5; i++) {
                    if (guess.charAt(j) == word.charAt(i)) {
                        correct[j] = "contains";
                        break;
                    }
                }
            }
        }
        return correct;
    }
}
