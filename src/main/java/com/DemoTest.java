package com;

import com.MoodMain.MoodException.MoodAnalyzerException;

import javax.management.monitor.MonitorSettingException;

public class DemoTest {
    public void method1(){
        try {
            method2();
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
    public  void method2() throws MoodAnalyzerException {
      try{
          System.out.println(1/0);
    }catch(ArithmeticException a){
      //System.out.println(a);
     // throw new MoodAnalyzerException("Enter proper Mood");
      }
    }
    public static void main(String[] args) {
        DemoTest demoTest=new DemoTest();
        demoTest.method1();
    }
}
