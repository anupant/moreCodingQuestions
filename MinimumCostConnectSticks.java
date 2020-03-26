/*You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

 

Example 1:

Input: sticks = [2,4,3]
Output: 14
Example 2:

Input: sticks = [1,8,3,5]
Output: 30

/* Constraints:

1 <= sticks.length <= 10^4
1 <= sticks[i] <= 10^4 */

import java.util.*;
public class MinimumCostConnectSticks {
	
	 public int connectSticks(int[] sticks) {
	        if(sticks == null || sticks.length == 0)
	            return 0;
	        
	        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	        for(int i: sticks){
	            queue.add(i);
	        }
	        int cost = 0;
	        while(queue.size() > 1){
	            int first = queue.poll();
	            int second = queue.poll();
	            int sum = first + second;
	            queue.add(sum);
	            cost = cost + sum;
	            
	        }
	        return cost;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
