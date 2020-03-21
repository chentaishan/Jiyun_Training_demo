package com.example.jiyun_training_demo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        String content = "abcabcbb";
        String[] arr ={"flower","flow","flight"};

        lengthOfLongestSubstring(content);

//        longestCommonPrefix(arr);
    }



        public int lengthOfLongestSubstring(String s) {



            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }

//    public String longestCommonPrefix(String[] strs) {
//
//        int minLength=strs[0].length();
//        for (int i = 1; i < strs.length; i++) {
//            if (minLength<strs[i].length()){
//                minLength= strs[i].length();
//            }
//        }
//        for (int i = 0; i < minLength; i++) {
//            String s1 =  strs[]
//        }
//
//        return "";
//    }

}