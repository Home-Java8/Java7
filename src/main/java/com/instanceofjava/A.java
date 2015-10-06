package main.java.com.instanceofjava;

/**
 * Created by Саша on 06.10.2015.
 * {@link http://tproger.ru/translations/10-tricky-core-java-interview-coding}
 * ***************************************************************************
 * 10 интересных вопросов по Java, которые вам могут задать на собеседовании
 */
public class A {
    public static void show(){
        System.out.println("Static method called");
    }

    public static void main(String[] args)  {
//        A.show();

        A obj = null;
        obj.show();
    }
}
