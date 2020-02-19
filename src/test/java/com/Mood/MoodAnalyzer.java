package com.Mood;

import com.MoodMain.MoodAnalyzerMain;
import com.MoodMain.MoodException.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzer {

    @Test
    public void givenNullMoodShould_ReturnHappy() {
        try {
            MoodAnalyzerMain moodAnalyzer = new MoodAnalyzerMain("I'm Happy");
            Assert.assertEquals("Happy",moodAnalyzer.analyzeMood());
            }catch(MoodAnalyzerException e){
                e.printStackTrace();
        }

    }
    @Test
    public void givenNullMoodShould_ReturnSad() {
        try {
            MoodAnalyzerMain moodAnalyzer = new MoodAnalyzerMain("I'm in Sad");
            Assert.assertEquals("SAD",moodAnalyzer.analyzeMood());
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenNullMoodShould_ReturnNull() {
        try {
            MoodAnalyzerMain moodAnalyzer = new MoodAnalyzerMain();
            }catch(MoodAnalyzerException e){
                Assert.assertEquals("enter properly", e.getMessage());
            }
    }
    @Test
    public void givenNullMoodShould_ReturnEmpty() {
        try {
            MoodAnalyzerMain moodAnalyzer = new MoodAnalyzerMain("");
        }catch(MoodAnalyzerException e){
            Assert.assertEquals("enter properly", e.getMessage());
        }
    }
}


