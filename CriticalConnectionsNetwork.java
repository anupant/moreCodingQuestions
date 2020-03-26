import java.util.*;
public class CriticalConnectionsNetwork {
	
	static int time = 0;
    static List<Integer>[] network;
    static int[] lowestVertex; //lowest vertext from current vertex
    static int[] discoveredTime; //discovered time of vertext
    static boolean[] visited;
    static List<List<Integer>> critialConnections;
    
     public static void initialization(int n) {
        lowestVertex = new int[n];
        discoveredTime = new int[n];
        visited = new boolean[n];
        critialConnections = new ArrayList<>();

        network = new ArrayList[n];
        for(int i=0; i<n; i++) network[i] = new ArrayList<>();
    }

    public static void buildNetwork(List<List<Integer>> connections) {
        for(List<Integer> connection :connections) {
            network[connection.get(0)].add(connection.get(1));
            network[connection.get(1)].add(connection.get(0));
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        initialization(n);
        buildNetwork(connections);
        getCritialConnections(0, -1);

        return critialConnections;
    }

   //dfs search
    public static void getCritialConnections(int current, int parent) {

        time++;
        lowestVertex[current] = time;
        discoveredTime[current] = time;
        visited[current] = true;

        for(int neighbor : network[current]) {
            if(neighbor == parent) continue;

            if(visited[neighbor] == false) { //if it does not discovered

                getCritialConnections(neighbor, current);

                lowestVertex[current] = Math.min(lowestVertex[current], lowestVertex[neighbor]);

                /**
                 * lowestVertex of neighbor > current's discoveredTime => critical connection!!
                 * lowestVertex of neighbor <= current's discoveredTime
                 * => not critical connection. there is a circular network.
                 */
                if(lowestVertex[neighbor] > discoveredTime[current]) {
                    critialConnections.add(Arrays.asList(current, neighbor));
                }
            } else { //if this neighbor is already visited, lowerVertext of current will be updated!!
                lowestVertex[current] = Math.min(lowestVertex[current], discoveredTime[neighbor]);
            }
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
