class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class SumCountAvg {
        Double sum;
        Double avg;
        Double count;
        SumCountAvg(Double sum, Double count, Double avg) {
            this.sum = sum;
            this.avg = avg;
            this.count = count;
        }
  }
   
public class MaximumAverageSubtree {

	public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return avg;
    }
   Double avg = new Double(0.0);
   public SumCountAvg helper(TreeNode node) {
       if(node == null) {
           return new SumCountAvg(0.0,0.0,0.0); //sum , count, avg of nodes
       }
       SumCountAvg left = helper(node.left);
       SumCountAvg right = helper(node.right);
       Double sum = node.val + left.sum + right.sum;
       Double count = 1 + left.count + right.count;
       Double currentAvg = sum / count;
       avg = Math.max(avg, currentAvg);
       return new SumCountAvg(sum, count, currentAvg);
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
