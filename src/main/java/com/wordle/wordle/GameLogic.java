package com.wordle.wordle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class GameLogic {
    String word;
    boolean[] isTrue = new boolean[5];
    public String getWord() {
        if (word == null) {
            System.out.println("TESTING");
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
        int lineNumber = (int) (Math.random()*2315);
        try{
            String line = Files.readAllLines(Paths.get("src/main/resources/com/wordle/wordle/answers.txt")).get(lineNumber);
            word = line;
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public boolean[] checkWord(String guess) {
        boolean[] correct = new boolean[5];
        File file = new File("src/main/resources/com/wordle/wordle/Words.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (guess.equals(line)) {
                    for (int j = 0; j < 5; j++) {
                        correct[j] = guess.charAt(j) == word.charAt(j);
                    }
                    break;
                } else {
                    correct = new boolean[]{true, false, true, false, true};
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return correct;
    }
}
