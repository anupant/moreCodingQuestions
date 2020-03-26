
public class DiceSumTarget {
	
	public int numRollsToTarget(int d, int f, int target) {
		int[][] memo = new int[d+1][target+1];
		return dp(d,f,target,memo);
		}
	
	public int dp(int d,int f, int target, int[][] memo){
	    if(d==0 && target==0)
	        return 1;
	    if(d==0 || target==0)
	        return 0;
	    int count=0;
	    if(memo[d][target]!=0){
	        return memo[d][target]==Integer.MAX_VALUE ? 0 : memo[d][target];
	    }
	    for(int i=1;i<=f;i++){
	        if(target-i>=0){
	            count = (count + (dp(d-1,f,target-i,memo))%1000000007)%1000000007;
	        }
	    }
	    
	    memo[d][target] = count>0 ? count : Integer.MAX_VALUE;
	    return count;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
