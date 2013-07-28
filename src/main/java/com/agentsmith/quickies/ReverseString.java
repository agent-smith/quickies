package com.agentsmith.quickies;

public class ReverseString
{
    public String reverse(String strToReverse)
    {
        char[] chars = strToReverse.toCharArray();
        for (int i = 0; i < chars.length / 2; i++)
        {
            swap(chars, i, (chars.length - 1) - i);
        }

        return String.valueOf(chars);
    }

    private void swap(char[] chars, int a, int b)
    {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static void main(String[] args)
    {
        String strToReverse = args[0];

        System.out.println("Reversing following String: " + strToReverse);

        ReverseString revString = new ReverseString();
        String reversedStr = revString.reverse(strToReverse);

        System.out.println("Reversed String: " + reversedStr);
    }
}
