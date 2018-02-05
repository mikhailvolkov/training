package com.epam.troubleshooting;

/**
 * Created by Ilya Lagoshny (ilya@lagoshny.ru)
 * <p>
 * Date: 10.12.2017
 */
public class Main {

    public static void main(String[] args) {
        TestObject firstObj = new TestObject();
        TestObject secondObj = new TestObject();
        Test first = new Test(firstObj, secondObj);
        Test second = new Test(secondObj, firstObj);
        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);
        firstThread.start();
        secondThread.start();

    }


}
