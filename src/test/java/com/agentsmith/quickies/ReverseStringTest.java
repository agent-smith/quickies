package com.agentsmith.quickies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for ReverseString.
 * <p/>
 * User: rmarquez
 * Date: 7/27/13
 * Time: 11:37 PM
 */
public class ReverseStringTest
{
    @Test
    public void reverseEmtpyString()
    {
        ReverseString rs = new ReverseString();
        String actual = rs.reverse("");
        assertEquals("", actual);
    }

    @Test
    public void reverseNonEmtpyStringWithOddNumChars()
    {
        ReverseString rs = new ReverseString();
        String actual = rs.reverse("12345");
        assertEquals("54321", actual);
    }

    @Test
    public void reverseNonEmtpyStringWithEvenNumChars()
    {
        ReverseString rs = new ReverseString();
        String actual = rs.reverse("123456");
        assertEquals("654321", actual);
    }
}
