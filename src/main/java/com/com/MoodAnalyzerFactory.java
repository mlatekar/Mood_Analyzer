package com.com;

import com.MoodMain.MoodAnalyzerMain;
import com.MoodMain.MoodException.MoodAnalyzerException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    public static MoodAnalyzerMain createMoodAnalyzer(String message) {
        Object moodObj = null;
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.MoodMain.MoodAnalyzerMain");
            Constructor<?> constructor = moodAnalyzerClass.getConstructor(String.class);
            moodObj = constructor.newInstance(message);
            return (MoodAnalyzerMain) moodObj;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyzerMain createMoodAnalyzer() {
        Object ob = null;
        try {
            Class<?> defaultConstructor = Class.forName("com.MoodMain.MoodAnalyzerMain");
            Constructor<?> constructor = defaultConstructor.getConstructor();
            ob = constructor.newInstance();
            return (MoodAnalyzerMain) ob;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(String className,Class param) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(e.getMessage(),MoodAnalyzerException.Exception.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(e.getMessage(),MoodAnalyzerException.Exception.NO_SUCH_METHOD);
        }

    }
}
