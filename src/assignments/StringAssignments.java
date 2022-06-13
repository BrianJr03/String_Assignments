package assignments;

import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("all")
public class StringAssignments {

    @Test
    void palindromeTest() { // 1.
        assertTrue(Palindrome.isPalindrome("racecar"));
    }

    @Test
    void charCountTest() { // 2.
        assertEquals(Char.getEachCharCount("Hello, nice to meet you.").toString(),
                "{ =4, c=1, e=4, H=1, i=1, l=2, ,=1, m=1, n=1, .=1, o=3, t=2, u=1, y=1}");
    }

    @Test
    void mostFrequentCharTest() { // 3.
        assertEquals(Char.getMostFrequentChar("Cheese"), 'e');
    }

    @Test
    void removeDuplicateCharTest() { // 4.
        assertEquals(Char.removeDuplicateChars("super computer"), "super comt");
    }

    @Test
    void printAllDuplicateCharTest() { // 5.
        Char.printAllDuplicateChars("duplication is fun");
    }

    @Test
    void getFirstNonRepeatingCharTest() { // 6.
        assertEquals(Char.getFirstNonRepeatingChar("eeeerrrrfgggg"), 'f');
    }

    @Test
    void removeCharsFirstStrTest() { // 7.
        assertEquals(String.removeCharsFirstStr("", ""), "");
    }

    @Test
    void isRotatedTest() { // 8.
        assertTrue(String.isRotated("AndroidDev", "DevAndroid"));
    }

    @Test
    void reverseEachWordTest() { // 10.
        assertEquals(String.reverseEachWord("Android is best ! si diordnA tseb ?"),
                "diordnA si tseb ! is Android best ?");
    }

    @Test
    void findLongestWordTest() { // 11.
        assertEquals(String.findLongestWord(" Hello how are you."),
                "Hello");
    }

    @Test
    void removeConsecutiveCharsTest() { // 12.
        assertEquals( Char.removeConsecutiveChars("hiii worlllddd,,,, mmmmy nammme isss bbbbrriann"),
                "hi world, my name is brian");
    }
}


@SuppressWarnings("all")
class Palindrome {
    // 1. Check if a given string is a palindrome
    // without finding the reverse of the string
    static boolean isPalindrome(java.lang.String str) {
        java.lang.String lower = str.toLowerCase();
        int i = 0; // Pointer that starts at beginning of str
        int j = lower.length() - 1; // Pointer that starts at end of str
        while (j > i) {
            // As j is decremented & i is incremented, each corresponding char
            // must be equal in order for the str to be a palindrome
            if (lower.charAt(j) != lower.charAt(i))
                return false;
            j--;
            i++;
        }
        return true;
    }
}

@SuppressWarnings("all")
class Char {
    // 2. Count the number of occurrences of each char in the input string
    static HashMap<Character, Integer> getEachCharCount(java.lang.String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Loop through string
        for(int i = 0; i < str.length(); i++) {
            // Extract each char from the string
            Character ch = str.charAt(i);
            if(map.containsKey(ch)) {
                // Get char count
                int currentCount = map.get(ch);
                // Increment char count
                int newCount = currentCount + 1;
                // Store new char count with assocaited char in map
                map.put(ch, newCount);
            } else {
                // Store char and initial count of 1 in map
                map.put(ch, 1);
            }
        }

        // KeySet comrpising of each char found in string
        Set<Character> keys = map.keySet();

        System.out.println("---------\nChar count\n---------");

        for(Character ch: keys) {
            // Get char count of each char in keys
            int count = map.get(ch);
            System.out.println(ch+ " = "+ count);
        }
        return map;
    }

    // 3. Find the most recurring char in the input string
    static char getMostFrequentChar(java.lang.String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> keys = map.keySet();

        for(int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(map.containsKey(ch)) {
                int currentCount = map.get(ch);
                int newCount = currentCount + 1;
                map.put(ch, newCount);
            } else {
                map.put(ch, 1);
            }
        }

        int most = 0;
        char mostChar  = '.';

        for(Character ch: keys) {
            if (map.get(ch) > most) {
                most = map.get(ch);
                mostChar = ch;
            }
        }

        System.out.println("--------");
        System.out.println("Analysing: " + "'" + str + "'");
        System.out.println( "'" + mostChar + "'" + " has appeared the most: " + most + " times");
        System.out.println("--------");

        return mostChar;
    }

    // 4. Remove duplicate chars from the input string
    static java.lang.String removeDuplicateChars(java.lang.String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();
        for(char c : str.toCharArray()) {
            set.add(c);
        }
        for (char ele : set) {
            sb.append(ele);
        }
        return new java.lang.String(sb);
    }

    // 5. Print all the duplicate chars in the input string
    static void printAllDuplicateChars(java.lang.String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> keys = map.keySet();

        for(int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(map.containsKey(ch)) {
                int currentCount = map.get(ch);
                int newCount = currentCount + 1;
                map.put(ch, newCount);
            } else {
                map.put(ch, 1);
            }
        }

        int duplicates = 0;
        System.out.println("Str: " + str);
        System.out.println("Printing duplicate characters...");
        for(Character ch: keys) {
            int count = map.get(ch);
            if (count > 1) {
                duplicates++;
                System.out.println("  --> " + "'" +ch + "'" + " used "+ count + " times");
            }
        }
        if (duplicates == 0) {
            System.out.println("No duplicate characters found");
        }
    }

    // 6. Find first mon-repeating character in the string
    static char getFirstNonRepeatingChar(java.lang.String str) {
        char ch = '.';
        for (char c : str.toCharArray()) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                ch = c;
            }
        }
        return ch;
    }

    // 12. Remove the same consecutive char from the input string
    static java.lang.String removeConsecutiveChars(java.lang.String str) {
        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i != str.length() - 1) {
                if (str.charAt(i) != str.charAt(i+1)) {
                    sb.append(str.charAt(i));
                }
            }
        }
        sb.append(str.toCharArray()[str.length() - 1]);
        return new java.lang.String(sb);
    }
}

@SuppressWarnings("all")
class String {
    static java.lang.String reverseString(java.lang.String str) {
        StringBuilder sb = new StringBuilder();
        char[] strCharArray = str.toCharArray();
        for (int i = strCharArray.length - 1; i >= 0; i--) {
            sb.append(strCharArray[i]);
        }
        return new java.lang.String(sb);
    }

    // 7. Remove characters from the first string which are present in the scecond string
    static java.lang.String removeCharsFirstStr(java.lang.String str1, java.lang.String str2) {
        StringBuilder sb = new StringBuilder();
        return new java.lang.String(sb);
    }

    // 8. Check if strings are rotations of each other
    public static boolean isRotated(java.lang.String str1, java.lang.String str2) {
        // The two lengths must be equal
        if (str1.length() != str2.length()) {
            return false;
        }
        // Takes str1's first char and finds its
        // corresponding first-occurring index in str2
        int index = str2.indexOf(str1.charAt(0));
        // If index is found
        if (index > -1) {
            // If equal, str2 is a rotation of str1
            if (str1.equalsIgnoreCase(str2)) {
                return true;
            }

            int finalPos = str2.length() - index;

            // Checks if the first char of str2 is the same as the char at the final position of str1
            // and the substring of str1 (starting at the index of the final position of str1) is equal
            // to str2.substring(0, index)
            return str2.charAt(0) == str1.charAt(finalPos)
                    && str1.substring(finalPos).equals(str2.substring(0, index));
        }
        return false;
    }

    // 10. Reverse each word in a given string
    static java.lang.String reverseEachWord(java.lang.String str) {
        StringBuilder reversedSentence = new StringBuilder();
        java.lang.String[] words = str.split(" ");
        for (java.lang.String word : words) {
            word = reverseString(word);
            reversedSentence.append(word).append(" ");
        }
        return new java.lang.String(reversedSentence).trim();
    }

    // 11. Find the word with the longest length in the given sentence
    static java.lang.String findLongestWord(java.lang.String str) {
        int longest = 0;
        java.lang.String longestWord = "";
        java.lang.String[] words = str.split(" ");
        for (java.lang.String word : words) {
            if (word.length() > longest) {
                longest = word.length();
                longestWord = word;
            }
        }
        return longestWord;
    }
}


