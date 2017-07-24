package com.test;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void testPalindrom() {
        Palindrome p = new Palindrome();
        Assert.assertTrue(p.isPalindrome("")); //empty string is also palindrome
        Assert.assertTrue(p.isPalindrome("a")); //single-char string is also palindrome
        Assert.assertTrue(p.isPalindrome("_!E#@y#e"));
        Assert.assertTrue(p.isPalindrome("MaDaM!!"));
        Assert.assertTrue(p.isPalindrome("RaCEC@A@R"));
        Assert.assertFalse(p.isPalindrome("RaCEC@A@R5"));
        Assert.assertFalse(p.isPalindrome("test"));
        Assert.assertFalse(p.isPalindrome("abc"));
        Assert.assertFalse(p.isPalindrome("anything"));
        Assert.assertTrue(p.isPalindrome("A roza UpaLa Na lApU AzORA"));
    }


}
