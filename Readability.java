package com.example.textmooddetector;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Readability {

    public String getReadabilityScore(String text){
        double asl = getASL(text);
        double asw = getASW(text);
        double readability = 206.835 - (1.015*asl) - (84.6*asw);
        readability = Math.round(readability);
        String readReport = Double.toString(readability);
        return(readReport);
    }

    public String getReadabilityReport(String text){
        String score = getReadabilityScore(text);
        String report = "This is your readability score based on Flesch's Readability index: " + score;
        report += "\nScores of 90 and above are readable at a 3rd grade level, while scores " +
                "below 40 are at a college reading level.";
        return(report);
    }

    private double getASW(String text) {
        String[] words = text.split("\\W+");
        int totWordSyll = 0;
        for(String word : words){
            totWordSyll += countWithRegex(word);
        }
        int avgSyll = totWordSyll/(words.length);
        return(avgSyll);
    }

    private double getASL(String text) {
        String[] sentences = text.split("(?<=[a-z])\\.\\s+");
        int sentCount = 0;
        int wordCount = 0;
        for(String sentence : sentences){
            sentCount++;
            String[] words = text.split("\\W+");
            for(String word : words){
                wordCount++;
            }
        }
        double asl = wordCount/sentCount;
        return(asl);
    }


    private static int countWithRegex(String word) {
        String i = "(?i)[aiou][aeiou]*|e[aeiou]*(?!d?\\b)";
        Matcher m = Pattern.compile(i).matcher(word);
        int count = 0;

        while (m.find()) {
            count++;
        }

        // return at least 1
        return Math.max(count, 1);
    }
}
