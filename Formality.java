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
    String report = "This is what we found regarding your formality score:";

    public String getFormalScore(String text){
        capitalization(text);
        emojis(text);
        punctuation(text);
        lengthOwords(text);
        if(formality+informality > 0) {
            double denominator = formality + informality;
            double score = (formality/denominator) * 100;
            score = Math.round(score);
            String scoreReport = Double.toString(score) + "%";
            return(scoreReport);
        }
        return("Not enough information");
    }

    public String getFormalReport(String text){
        String score = getFormalScore(text);
        return(report);
    }

    private void lengthOwords(String text) {
        String[] words = text.split("\\W+");
        int totWordLen = 0;
        for(String word : words){
            totWordLen += word.length();
        }
        int avgLen = totWordLen/(words.length);
        if(avgLen > 5){
            formality += 2;
            report += "\n  - You have a high average word length, which is considered formal";
        }
        else{
            informality++;
            report += "\n  - You have a low average word length, which is considered informal";
        }
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
        if(countPuncMarks == 0){
            informality+=2;
            report += "\n  - You had no punctuation, which is considered informal";
        } else if ((countPuncMarks/words.length) > 0.5){
            informality+=2;
            report += "\n  - You possibly have excessive punctuation, which is considered informal";
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
        if(emoCount == 0){
            formality++;
            report += "\n  - You had no emojis, which is considered formal";
        } else {
            report += "\n  - You included emojis, which is considered informal";
        }
    }

    private void capitalization(String text) {
        int upperCount = 0;
        String[] words = text.split("\\W+");
        for(String word : words){
            if(word.equals(word.toUpperCase())) {
                informality++;
                upperCount++;
            }
        }
        if(upperCount > 0){
            report += "\n  - You had some words in all caps, which is considered informal";
        }
    }

}
