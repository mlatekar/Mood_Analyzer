package com.Mood;

import com.MoodMain.MoodAnalyzerMain;
import com.MoodMain.MoodException.MoodAnalyzerException;
import com.com.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzer {

    @Test
    public void givenNullMoodShould_ReturnHappy() {
        try {
            MoodAnalyzerMain moodAnalyzer = new MoodAnalyzerMain("I'm Happy");
            Assert.assertEquals("Happy", moodAnalyzer.analyzeMood());
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenNullMoodShould_ReturnSad() {
        try {
            MoodAnalyzerMain moodAnalyzer = new MoodAnalyzerMain("I'm in Sad");
            Assert.assertEquals("SAD", moodAnalyzer.analyzeMood());
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodShould_ReturnNull() {
        try {
            MoodAnalyzerMain moodAnalyzer = new MoodAnalyzerMain(null);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.Exception.EMPTY_NULL, e.type);
        }
    }

    @Test
    public void givenNullMoodShould_ReturnEmpty() {
        try {
            MoodAnalyzerMain moodAnalyzer = new MoodAnalyzerMain("");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.Exception.NOT_EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerObject_ReturnObject() {
        try {
            Constructor<?> constructor = Class.forName("com.MoodMain.MoodAnalyzerMain").getConstructor(String.class);
            try {
                Object obj1 = constructor.newInstance("I'm in Happy Mood");
                MoodAnalyzerMain moodAnalyzerMain = (MoodAnalyzerMain) obj1;
                String newMood = moodAnalyzerMain.analyzeMood();
                Assert.assertEquals("Happy", newMood);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyzerMain moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("Happy");
            Assert.assertEquals(new MoodAnalyzerMain("Happy"), moodAnalyzer);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createMoodAnalyzer_WithDefault_Constructor_ReturnObject() {
        try {
            MoodAnalyzerMain moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
            Assert.assertEquals(new MoodAnalyzerMain(), moodAnalyzer);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassname_WhenImproper_ShouldReturnNoSuchClassError() {
        try {
            Constructor<?> moodAnalyzerMain= MoodAnalyzerFactory.getConstructor("com.MoodMain.MoodAnalzerMain", String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.Exception.NO_SUCH_CLASS, e.type);
        }
    }
   @Test
    public void givenMethodName_WhenImproper_ShouldReturnNoSuchMethod(){
        try {
          Constructor<?> moodAnalyzerMain = MoodAnalyzerFactory.getConstructor("com.MoodMain.MoodAnalyzerMain", Integer.class);
       }catch (MoodAnalyzerException e){
           Assert.assertEquals(MoodAnalyzerException.Exception.NO_SUCH_METHOD,e.type);
       }
   }

    @Test
    public void givenHappyMessageUsingReflection_WhenProper_ShouldReturnHappyMood(){
        String mood = null;
        try {
            mood = MoodAnalyzerFactory.invokeMethod("com.MoodMain.MoodAnalyzerMain", "I'm in a Happy mood","analyzeMood");
            Assert.assertEquals("Happy",mood);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMethodName_WhenImproper_ShouldReturnNoSuchMethodException() {
        try {
            String mood = MoodAnalyzerFactory.invokeMethod("com.MoodMain.MoodAnalyzerMain", "I'm in a Happy mood","analyzeMood");

        }catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.Exception.NO_SUCH_METHOD,e.type);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenField_WhenProper_ShouldReturnMessage() {
        try {
            String mood = MoodAnalyzerFactory.setFieldValues("I'm in a Sad mood","mood");
            Assert.assertEquals("Sad",mood);
        }catch (MoodAnalyzerException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenField_WhenImProper_ShouldThrowException() {
        try {
            String mood = MoodAnalyzerFactory.setFieldValues("I'm in a Sad mood","mod");
        }catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.Exception.NO_SUCH_FIELD,e.type);

        }
    }
    @Test
    public void givenField_isNullMessage_ShouldThrowException() {
        try {
            String mood = MoodAnalyzerFactory.setFieldValues(null,"mood");
        }catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.Exception.FIELD_INVOCATION_ISSUE,e.type);
        }
    }
}



