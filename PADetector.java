package com.example.textmooddetector;

import java.util.*;


public class PADetector {

    String filePath = "i just feel like\n" +
            "okay.\n" +
            "okay?\n" +
            "ok.\n" +
            "ok?\n" +
            "k.\n" +
            "whatever\n" +
            "joking\n" +
            "take a joke\n" +
            "thanks in advance\n" +
            "fine\n" +
            "consider\n" +
            "just saying\n" +
            "i'm not mad\n" +
            "whatever you want\n" +
            "i'm curious\n" +
            "surprised\n" +
            "confused\n" +
            "why are you\n" +
            "i hope\n" +
            "i wish i was as\n" +
            "no need to thank me\n" +
            "i thought you knew\n" +
            "no offense\n" +
            "no offence\n" +
            "for someone like\n" +
            "for someone of\n" +
            "sensitive\n" +
            "be so\n" +
            "being so";
    ArrayList<String> paWords = new ArrayList<>();


    public String paScore(String text){

        text = text.toLowerCase();
        String[] phrases = filePath.split("\n");
        int paCount = 0;
        for(String phrase : phrases){
            if(text.contains(phrase)){
                paWords.add(phrase);
                paCount++;
            }
        }

        return(Integer.toString(paCount));

    }
    
    public String paReport(String text){
        
        String score = paScore(text);
        if(paWords.size()>0) {
            String report = "These are the phrases that you used that may be considered passive aggressive:";
            for (String word : paWords) {
                report += "\n  - " + word;
            }
            return(report);
        } else {
            String report = "You didn't use any common passive aggressive phrases!";
            return(report);
        }
    }

}
