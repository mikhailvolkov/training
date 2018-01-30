package com.epam.memorymodule;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        heapSizeErrorExample();
    }

    private static void heapSizeErrorExample(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object[] obj = new Object[1];
        while(true){
            obj = new Object[]{obj};
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void stackOverFlowExample(){
        long a1 = 0;
        long a2 = 0;
        long a3 = 0;
        long a4 = 0;
        long a5 = 0;
        long a6 = 0;
        long a7 = 0;
        long a8 = 0;
        long a9 = 0;
        long a10 = 0;
        long a11 = 0;
        stackOverFlowExample();
    }

    private static void stackOverFlowWithCyclicDependency(){
        FirstObject object = new FirstObject();
    }
}
