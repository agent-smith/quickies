package com.agentsmith.quickies;

public class ReverseString {

    public String reverse(String strToReverse) {
        char[] chars = strToReverse.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            ArraySwap.swap(chars, i, (chars.length - 1) - i);
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        String strToReverse;
        if (args.length != 1) {
            strToReverse = "123456";
        } else {
            strToReverse = args[0];
        }

        System.out.println("Reversing following String: " + strToReverse);

        ReverseString revString = new ReverseString();
        String reversedStr = revString.reverse(strToReverse);

        System.out.println("Reversed String: " + reversedStr);
    }
}
