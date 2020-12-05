package com.leetcode.december_2020.week_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring palindromic;

    @BeforeEach
    void setUp() {
        palindromic = new LongestPalindromicSubstring();
    }


    @Test
    @DisplayName("역순으로 읽어도 같은 (가장 긴)단어를 출력")
    void getLongestPalindromic() {
        assertAll(
                () -> assertEquals(palindromic.longestPalindrome("babad"), "bab")
/*                () -> assertEquals(palindromic.longestPalindrome("babad"), "bab"),
                () -> assertEquals(palindromic.longestPalindrome("babad"), "bab"),
                () -> assertEquals(palindromic.longestPalindrome("babad"), "bab")*/
        );
    }
}