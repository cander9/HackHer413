package com.example.textmooddetector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formality {
    //capital letters = more formal
    //all caps = less formal
    //emojis = less formal
    //excessive punctuation is less formal
    //no punctuation is less formal
    //length of words (shorter & less formal)

    int formality;
    int informality;
    private final String emo_regex = "([\\u20a0-\\u32ff\\ud83c\\udc00-\\ud83d\\udeff\\udbb9\\udce5-\\udbb9\\udcee])";


    public String getFormalScore(String text){
        capitalization(text);
        emojis(text);
        punctuation(text);
        lengthOwords(text);
        if(formality+informality > 0) {
            int score = formality / (formality + informality) * 100;
            String scoreReport = Integer.toString(score) + "%";
            return(scoreReport);
        }
        return("Not enough information");
    }

    private void lengthOwords(String text) {
        String[] words = text.split("\\W+");
        int totWordLen = 0;
        for(String word : words){
            totWordLen += word.length();
        }
        int avgLen = totWordLen/(words.length);
        if(avgLen > 6) formality += 2;
        else informality++;
    }

    private void punctuation(String text) {
        int countPuncMarks = 0;
        String[] words = text.split("\\W+");
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '!' || text.charAt(i) == ',' || text.charAt(i) == ';' || text.charAt(i) == '.' ||        text.charAt(i) == '?' || text.charAt(i) == '-' ||
                    text.charAt(i) == '\'' || text.charAt(i) == '\"' || text.charAt(i) == ':') {
                countPuncMarks++;
            }
        }
        if(countPuncMarks == 0 || (countPuncMarks/words.length) > 0.5){
            informality+=2;
        } else {
            formality++;
        }
    }

    private void emojis(String text) {
        int emoCount = 0;
        Matcher matcher = Pattern.compile(emo_regex).matcher(text);
        while (matcher.find()) {
            informality++;
            emoCount++;
        }
        if(emoCount == 0) formality++;
    }

    private void capitalization(String text) {
        String[] words = text.split("\\W+");
        for(String word : words){
            String capWord = word.substring(0, 1).toUpperCase() + word.substring(1);
            if(word.equals(capWord)) formality++;
            if(word.equals(word.toUpperCase())) informality++;
        }
    }

}
