import java.util.*;
class PointItem {
    int x;
    int y;
    int dist;
    public PointItem(int x, int y){
        this.x =x;
        this.y =y;
        this.dist =x*x +y*y;
    }
}

public class KClosestPointsOrigin {
	
	public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<PointItem> pq =new PriorityQueue<>((a,b)->a.dist-b.dist);
        for(int i=0;i<points.length;i++){
            pq.add(new PointItem(points[i][0],points[i][1]));
        }
        int arr[][] =new int[K][2];
        int i=0;
        while(K-- >0){
            arr[i][0] =pq.peek().x;
            arr[i][1] =pq.poll().y;
            i++;
        }
        return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
