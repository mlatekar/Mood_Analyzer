package com.MoodMain;

import com.MoodMain.MoodException.MoodAnalyzerException;

public class MoodAnalyzerMain {
    private String mood;


    public MoodAnalyzerMain() {
        mood="default";
    }

    public MoodAnalyzerMain(String mood) {

        this.mood = mood;
    }

//    public String analyzeMood(String message) throws MoodAnalyzerException {
  //      this.message = message;
    //    return analyzeMood();
    //}

    public String analyzeMood() throws MoodAnalyzerException {
        try {
            if (mood.isEmpty()) {
                throw new MoodAnalyzerException("can not be empty",MoodAnalyzerException.Exception.NOT_EMPTY);
            }
            if (mood.contains("Sad")) {
                return "SAD";
            }
            return "Happy";

        } catch (NullPointerException e) {
            throw new MoodAnalyzerException("enter properly",MoodAnalyzerException.Exception.EMPTY_NULL);
        }
    }

    public boolean equals(Object another) {
        if (this.mood.equals(((MoodAnalyzerMain) another).mood)){
            return true;}
        return false;
    }

}
