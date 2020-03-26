
public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
        if(grid == null)
        return 0;
        
        
        int m = grid.length;
        int n = grid[0].length;
        int newSum[][] = new int[m][n];
        newSum[0][0] = grid[0][0];
        
        for(int i = 1 ; i < n ; i++){
            newSum[0][i] = newSum[0][i-1]+ grid[0][i];
        }
        for(int j = 1 ; j < m; j++){
            newSum[j][0] = newSum[j-1][0]+ grid[j][0];
        }
    
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n ; j++){
                newSum[i][j] = Math.min((newSum[i][j-1] + grid[i][j]),(newSum[i-1][j] + grid[i][j]));
            }
        }
        int result = newSum[m-1][n-1]; 
      return  result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
