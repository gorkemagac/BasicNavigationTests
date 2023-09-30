package com.cbt.utilities;

public class StringUtility {
    public static void VerifyEquals(String expected, String actual, String nameOfWebsite)
    {
        System.out.println("www." + nameOfWebsite + ".com");
        if(expected.equals(actual))
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
        }
    }

}
