package com.epam.firstmoduletask;

public class Main {

    public static void main(String[] args) {
        System.out.println(makeOutWord("{{}}", "Hello"));
        System.out.println(stringTimes("Hi", 2));
        System.out.println(array123(new int[]{1, 1, 2, 3, 1}));
        System.out.println(array123(new int[]{1, 1, 2, 4, 1}));
        System.out.println(array123(new int[]{1, 1, 2, 1, 2, 3}));
        printIntervalNumbers(1, 5);
        printIntervalNumbers(5, 5);
        printIntervalNumbers(5, 1);
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));

    }
    public static String makeOutWord(String wrapper, String word) {
        if (wrapper == null || word == null) {
            throw new IllegalArgumentException("arguments of makeOutWord() are null");
        }
        int center = wrapper.length() / 2;
        String leftPart = wrapper.substring(0, center);
        String rightPart = wrapper.substring(center, wrapper.length());
        return leftPart + word + rightPart;
    }

    public static String stringTimes(String str, int n) {
        if (str == null) {
            throw new IllegalArgumentException("argument of stringTimes() is null");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean array123(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("argument of array123() is null");
        }
        int currentNum = 1;
        int lastNum = 3;
        for (int num : nums) {
            if (num == currentNum && currentNum == lastNum) {
                return true;
            }
            if (num == currentNum && currentNum < lastNum) {
                currentNum++;
            }
        }
        return false;
    }

    public static void printIntervalNumbers(int a, int b) {
        if (a < b) {
            printNumbers(a, b);
        } else {
            printNumbers(b, a);
        }
    }

    private static void printNumbers(int a, int b) {
        for (int i = a + 1; i < b; i++) {
            System.out.println(i);
        }
    }

    public static int[] reverse(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("argument of array123() is null");
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length / 2; i++) {
            int current = nums[i];
            result[i] = nums[nums.length - i - 1];
            result[nums.length - i - 1] = current;
        }
        return result;
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
