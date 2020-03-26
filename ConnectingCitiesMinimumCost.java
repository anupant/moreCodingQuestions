import java.util.Arrays;

public class ConnectingCitiesMinimumCost {
	
	  // Space O(n) for recursion stack, Time O(n)
    private int find(int[] parent, int v) {
        if(parent[v] == -1) return v;
        return find(parent, parent[v]);
    }
    
    // Space O(n) for recursion stack, Time O(n)
    private void union(int[] parent, int x, int y){
        int xParent = find(parent, x);
        int yParent = find(parent, y);
        parent[xParent] = yParent;
    }
    
 // Minimum spanning tree 
    // -- Order all edges in non-decreasing order
    // -- start building the spanning tree with min cost
    // -- -- for each edge:
    // -- -- -- Check if edge will cause having cycles then ignore this edge
    // -- -- -- Else: include this edge
    // Will need to helper methods
    // -- Union: uninon two subsets 
    // -- find: find the subset the given node beliong to
    // This is a greedy algo
    
    // parent[i] represent the subset id for the ith node
    // if parent[i] == 0 --> subset has only one node with id = 

public int minimumCost(int N, int[][] connections) {
    int[] parent = new int[N + 1];
    Arrays.fill(parent, -1);
    Arrays.sort(connections, (a,b) -> (a[2]-b[2]));
    int cnt = 0;
    int minCost = 0;
    
     for(int[] edge: connections){
        int src = edge[0];
        int dst = edge[1];
        int cost = edge[2];
        
        int srcSubsetId = find(parent, src);
        int dstSubsetId = find(parent, dst);
        
        if(srcSubsetId == dstSubsetId) {
            // Including this edge will cause cycles, then ignore it
            continue;
        }
        cnt += 1;
        minCost += cost;
        union(parent, src, dst);
    }
    return cnt==N-1? minCost : -1;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
