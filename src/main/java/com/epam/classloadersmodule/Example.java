package com.epam.classloadersmodule;

public class Example {
    private static int value;

    static {
        setValue(2);
    }

    private static void setValue(int value) {
        Example.value = value;
    }

    private static void print(){
        System.out.println("Example");
    }
}
