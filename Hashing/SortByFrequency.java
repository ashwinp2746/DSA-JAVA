/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The
frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them

Approach :- Make HashMap put the key value and then make PriorityQueue for entrySet and store key value pair in pq 
            and sort decending order and then make stringbuilder and store charcter


TC:-O(n+logk)

*/

package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequency {

    public static String sortByFrequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        StringBuilder ans = new StringBuilder();

        while (pq.size() != 0) {
            char ch = pq.poll().getKey();
            int val = map.get(ch);

            while (val != 0) {
                ans.append(ch);
                val--;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(sortByFrequency(s));
    }
}
