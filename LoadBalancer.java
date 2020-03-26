
public class LoadBalancer {
	
	public boolean LoadBalancer(int[] array) {
		double[] presum = new double[array.length + 1];
		for(int i = 1; i < array.length + 1; i++){
		presum[i] = presum[i-1] + (double)array[i - 1];
		}

	    int left = 1;
	    int right = presum.length - 2;
	    while(left < right - 1){
	        double sumLeft = presum[left] - presum[0];
	        double sumRight = presum[presum.length - 1] - presum[right];
	        if(sumLeft == sumRight){
	            double midSum = presum[right - 1] - presum[left + 1];
	            if(midSum == sumLeft){
	                return true;
	            }else{
	                left++;
	                right--;
	            }
	        }else if(sumLeft < sumRight){
	            left++;
	        }else{
	            right--;
	        }
	    }
	    return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
