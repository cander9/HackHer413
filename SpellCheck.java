package com.example.textmooddetector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class SpellCheck {

    private HashSet<String> wordSet = new HashSet<>();
    String filePath = "/Users/laurenwagner/Desktop/words_alpha.txt";

    public String getMisspellings(String text) throws IOException {
        createSet();
        int misspellings = 0;
        String[] words = text.split("\\W+");
        for(String word : words){
            if(!wordSet.contains(word)){
                misspellings++;
            }
        }
        
        return(Integer.toString(misspellings));
    }

    public void createSet()  throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String st;
        while (true) {
            try {
                if (((st = br.readLine()) == null)) break;
                wordSet.add(st);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
