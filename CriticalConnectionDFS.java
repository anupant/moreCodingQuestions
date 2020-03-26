import java.util.*;

public class CriticalConnectionDFS {
	 List<List<Integer>> list;
	 Map<Integer, Boolean> visited;
	    
	    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
	        for(List<Integer> connection : connections){
	            int u = connection.get(0);
	            int v = connection.get(1);
	            if(adj.get(u) == null){
	                adj.put(u,new HashSet<Integer>());
	            }
	            adj.get(u).add(v);
	            if(adj.get(v) == null){
	                adj.put(v,new HashSet<Integer>());
	            }
	            adj.get(v).add(u);
	        }
	       
	        list = new ArrayList<>();
	        for(int i =0;i<connections.size();i++){
	            visited = new HashMap<>();
	            List<Integer> p = connections.get(i);
	            int x = p.get(0);
	            int y = p.get(1);
	            adj.get(x).remove(y);
	            adj.get(y).remove(x);
	            DFS(adj,1);
	            if(visited.size()!=n){
	                    List<Integer> l1 = new ArrayList<Integer>();
	                    if(p.get(0) > p.get(1))
	                    {
	                    // List<Integer> l1 = new ArrayList<Integer>();
	                     l1.add(p.get(1));
	                     l1.add(p.get(0));
	                     }
	                    else
	                    {l1.add(p.get(0));
	                    l1.add(p.get(1));
	                    }
	                  list.add(l1);
	            }
	            adj.get(x).add(y);
	            adj.get(y).add(x);
	        }
	        return list;
	    }
	   
	    public void DFS(Map<Integer, HashSet<Integer>> adj, int u){
	        visited.put(u, true);
	        if(adj.get(u).size()!=0){
	            for(int v : adj.get(u)){
	                if(visited.getOrDefault(v, false)== false){
	                    DFS(adj,v);
	                }
	            }
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
