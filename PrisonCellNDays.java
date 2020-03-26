import java.util.*;
public class PrisonCellNDays {
	
	 public int[] prisonAfterNDays(int[] cells, int N) {
	        Map<Integer, int[]> map = new HashMap<>();
	        List<Integer> arr = new ArrayList<>();
	        for(int i=0; i<=N; i++){
	            int[] newCells = nextDay(cells);
	            if(i==N) return cells;
	            int key = listToInt(newCells);
	            if(map.containsKey(key)) break;
	            map.put(key, newCells);
	            arr.add(key);
	            cells = newCells;
	        }
	        N = (N-1) % arr.size();
	        return map.get(arr.get(N));
	    }
	    
	    private int[] nextDay(int[] cells){
	        int[] newCells = new int[8];
	        for(int i=1; i<7; i++){
	            if(cells[i-1]==cells[i+1]){
	                newCells[i]=1;
	            }
	        }
	        return newCells;
	    }
	    
	    private int listToInt(int[] list){
	        int ret = 0;
	        for(int i=0; i<8; i++){
	            ret += list[i]<<i;
	        }
	        return ret;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
