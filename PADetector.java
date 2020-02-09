package com.example.textmooddetector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PADetector {

    String filePath = "pawords.txt";

    public String keyWordDetector(String text) throws IOException {

        text = text.toLowerCase();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String st;
        ArrayList<String> paWords = new ArrayList<>();
        while (true) {
            try {
                if (((st = br.readLine()) == null)) break;
                    if(text.contains(st)){
                        paWords.add(st);
                    }
                }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (paWords != null){
            String paMessage = "Uh oh! It looks like your text might be passive aggressive. Here are the phrases we flagged:" + "\n";
            for(String word : paWords){
                paMessage = paMessage + "     " + word + "\n";
            }
            return(paMessage);
        }

        return("Your text sounds great! Go ahead and send it.");

    }

}
