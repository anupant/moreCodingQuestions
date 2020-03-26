/* A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]

Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts. */
import java.util.*;
public class PartitionLabels {
	
	 public List<Integer> partitionLabels(String S) {
	       // HashMap + Window: HashMap<char, rightmostIndex>
	        // 1. Remember the rightmost index of each character
	        // 2. Within the [leftmostIndex, rightmostIndex], if other char's right most exceeds the current, use the larger rightmostIndex 
	        List<Integer> res = new ArrayList<>();
	        HashMap<Character, Integer> map = new HashMap<>();
	        char[] arr = S.toCharArray();
	        for(int i = 0; i < arr.length; i++)
	            map.put(arr[i], i);
	        
	        int left = 0, right = 0;
	        while(left <= right && right < arr.length) {
	            for(int i = left; i <= right; i++) {
	                int rightMostIndexOfCurrentChar = map.get(arr[i]);
	                right = Math.max(right, rightMostIndexOfCurrentChar);
	            }
	            res.add(right - left + 1);
	            left = right + 1;
	            right += 1;
	        }
	        return res;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
