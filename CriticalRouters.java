import java.util.*;
/*
How to find all articulation points in a given graph?
A simple approach is to one by one remove all vertices and see if removal of a vertex causes disconnected graph. Following are steps of simple approach for connected graph.

1) For every vertex v, do following
…..a) Remove v from graph
..…b) See if the graph remains connected (We can either use BFS or DFS)
…..c) Add v back to the graph



Time complexity of above method is O(V*(V+E)) for a graph represented using adjacency list. Can we do better? */

public class CriticalRouters {
	
	public List<Integer> getCriticalRouters(int numNodes, int numEdges, int[][] edges) {
	//construct graph
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    //initialize graph
    for(int i=0;i<numNodes;i++) 
    		graph.put(i, new HashSet<>());

    //add edges to graph
    for(int[] edge: edges) {
        int u = edge[0];
        int v = edge[1];

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    List<Integer> result = new ArrayList<>();

    //calculate critical routers
    for(int nodeToRemove=0;nodeToRemove<numNodes;nodeToRemove++) {

        //remove each node and its edges and check if entire graph is connected
        Set<Integer> nodeEdges = graph.get(nodeToRemove);
        int source = 0;
        for(int edge: nodeEdges) {
            graph.get(edge).remove(nodeToRemove);
            source = edge;
        }

        HashSet<Integer> visited = new HashSet<>();
        dfs(graph, source, visited);

        if(visited.size()!=numNodes-1) {
            //this node was a critical router
            result.add(nodeToRemove);
        }

        //add the edges back
        for(int edge: nodeEdges) graph.get(edge).add(nodeToRemove);
    }
    return result;
}

public void dfs (Map<Integer, Set<Integer>> graph, int source, Set<Integer> visited) {
    if(visited.contains(source)) return;

    visited.add(source);

    for(int child: graph.get(source))
    	 	dfs(graph, child, visited);
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
