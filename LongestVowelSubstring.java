import java.util.*;
/*You are given with a string . Your task is to remove atmost two substrings of any length from the given string such that the remaining string contains vowels('a','e','i','o','u') only. Your aim is the maximise the length of the remaining string. Output the length of remaining string after removal of atmost two substrings.
NOTE: The answer may be 0, i.e. removing the entire string.*/
public class LongestVowelSubstring {
	
	/*static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    static int solution(String S) {
        int left = 0, right = S.length() - 1, res = 0;
        while (left < right) {
            if (vowels.contains(S.charAt(left))) {
                left++;
                res++;
            } else if (vowels.contains(S.charAt(right))) {
                right--;
                res++;
            } else break;
        }

        res += longestVowelSubstring(S, left, right);

        return res;
    }
    // The answer is correct
    private static int longestVowelSubstring(String S, int left, int right) {
        int res = 0, max = 0; int count = 0;
        for (int k = left ; k < right; k++) {
        	    if(count > 2)
        	    		return 0;
            if (vowels.contains(S.charAt(k))) {
                // if (res == 0) res = 1;
                if (vowels.contains(S.charAt(k))) {
                    res++;
                }
                max = Integer.max(max, res);
            } else {
            	    count = count +1;
                res = 0;
            }
        }
        return max;
    } */
	
	private boolean isVowel(char c){
	    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	public int longestString(String s){
	    int len = s.length();
	    int start = 0, end = len - 1;
	    while(start < len && isVowel(s.charAt(start))) ++start;
	    while(end >= 0 && isVowel(s.charAt(end))) --end;
	    // checking area come to [start, end]
	    if(start >= len) return len;
	    int res = start + len - 1 - end;
	    int longest = 0, sum = 0;
	    for(int i = start + 1; i <= end; ++i){
	        if(isVowel(s.charAt(i)))
	            ++sum;
	        else
	            sum = 0;
	        longest = Math.max(sum, longest);
	    }
	    return longest + res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String vs = "earthproblem";// 3
		String vse = "eaxygha";// 3
		String ve = "letsgosomewhere"; //2
		String cse = "cearthproblem";// 2
		LongestVowelSubstring obj = new LongestVowelSubstring();
		int solVal = obj.longestString(cse);
		System.out.println(solVal);

	}

}
