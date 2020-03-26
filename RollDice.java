/* A six-sided die is a small cube with a different number of pips on each face (side), ranging from 1 to 6.
On any two opposite side of the cube, the number of pips adds up to 7; that is, there are three pairs of opposite sides: 1 and 6, 2 and 5, and 3 and 4.
There are N dice lying on a table, each showing the pips on its top face. In one move, you can take one die and rotate it to an adjacent face.
For example, you can rotate a die that shows 1 s that it shows 2, 3, 4 or 5. However, it cannot show 6 in a single move, because the faces with one pip and six pips visible are opposite sides rather than adjacent.
You want to show the same number of pips on the top face of all N dice. Given that each of the dice can be moved multiple times, count the minimum number of moves needed to get equal faces.

Write a function that, given an array A consisting of N integers describing the number of pips (from 1 to 6) shown on each die's top face, returns the minimum number of moves necessary for each die show the same number of pips.*/
//https://leetcode.com/discuss/interview-question/331158


public class RollDice {
	
	public static int rollDiceSolution(int[] nums) {
	    int min = Integer.MAX_VALUE;
	    int[] cnt = new int[7];
	    for (int num : nums) cnt[num]++;
	    //iterate all six of possible final numbers
	    //Then number of rolls can be calculated directly
	    for (int i = 1; i < 7; i++) {
	    	int rollNum = 0;
	    	for(int j = 1; j < 7;j++) {
	    		if(j == i) continue; // if the current dice already show the final number, just skip it
	    		if(j + i == 7) {
	    			rollNum += 2*cnt[j];
	    		}else {
	    			rollNum += cnt[j];
	    		}
	    	}
	    	min = Math.min(rollNum, min);
	  }
	  return min;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
