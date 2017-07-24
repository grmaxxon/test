package com.test;

public class Palindrome {

    public Palindrome() {

    }

    public boolean isPalindrome(String str) {
        if (str == null || str.length() < 2) return true;
        String rpl = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int first = 0;
        int last = rpl.length() - 1;

        while (first < last) {
            if (rpl.charAt(first) != rpl.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }

        return true;
    }

}
