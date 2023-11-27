package com.wordle.wordle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameLogic {
    String word;
    public String getWord() {
        if (word == null) {
            System.out.println("TESTING");
            setWord();
            return word;
        } else {
            return word;
        }
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
        int lineNumber = (int) (Math.random()*14855);
        try{
            String line = Files.readAllLines(Paths.get("src/main/resources/com/wordle/wordle/Words.txt")).get(lineNumber);
            word = line;
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public boolean[] checkWord(String guess) {
        boolean[] correct = new boolean[5];
        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                correct[i] = true;
            } else {
                correct[i] = false;
            }
        }
        return correct;
    }
}
