package com.MoodMain;

import com.MoodMain.MoodException.MoodAnalyzerException;

public class MoodAnalyzerMain {
    private String mood;
    public MoodAnalyzerMain(){

    }
    public MoodAnalyzerMain(String mood) {
        this.mood = mood;
    }

    public String analyzeMood() throws MoodAnalyzerException {

        try {
            if (mood.contains("")) {
                throw new MoodAnalyzerException("can not be empty");
            }
            if (mood.contains("Sad")) {
                return "SAD";
            }
                return "Happy";

        }catch(NullPointerException e){
          throw new MoodAnalyzerException("enter properly");
        }
    }
}
