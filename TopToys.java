import java.util.*;
//Top n buzzwords
public class TopToys {
	// https://leetcode.com/discuss/interview-question/460127/
	//*Predefined Character Classes	Description
  /* Any character
	\d	A digit: [0-9]
	\D	A non-digit: [\^0-9]
	\s	A whitespace character: [ \t\n\x0B\f\r]
	\S	A non-whitespace character: [\^\s]
	\w	A word character: [a-zA-Z_0-9]
	\W	A non-word character: [\^\w] */
	
	//Try handling non words
	public static List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes)
	{
		Map<String, int[]> freq = new HashMap<>();
		for(String toy: toys) {
			freq.put(toy, new int[] {0,0});
		}
		
		for (String quote : quotes) {
		      Set<String> used = new HashSet<>();
		      // quote = quote.replaceAll("'","");
		      //String[] words = quote.toLowerCase().split("^[a-zA-Z]+('[a-zA-Z]+)?$");
		      // String[] words = quote.toLowerCase().split("\\W+");
		      String[] words = quote.toLowerCase().split("[^\\w']+");
		      for (String word : words) {
		    	     System.out.println(word);
		        if (!freq.containsKey(word)) {
		          continue;
		        }

		        int[] nums = freq.get(word);

		        nums[0]++;
		        if (!used.contains(word)) {
		          nums[1]++;
		        }

		        used.add(word);
		      }
		    }
            // Min Priority 
		    PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
		      if (freq.get(t1)[0] != freq.get(t2)[0]) {
		        return freq.get(t1)[0] - freq.get(t2)[0];
		      }

		      if (freq.get(t1)[1] != freq.get(t2)[1]) {
		        return freq.get(t1)[1] - freq.get(t2)[1];
		      }

		      return t2.compareTo(t1);
		    });

		    if (topToys > numToys) {
		      for (String toy : freq.keySet()) {
		        if (freq.get(toy)[0] > 0) 
		          pq.add(toy);
		       }
		    } else {
		      for (String toy : toys) {
		    	   /// toy = toy.replaceAll("'","");
		        pq.add(toy);
		        if (pq.size() > topToys) 
		          pq.poll();
		      }
		    }

		    List<String> output = new ArrayList<>();
		    while (!pq.isEmpty()) {
		      output.add(pq.poll());
		    }

		    Collections.reverse(output);
		    return output;
		  }
	
	public static void main(String[] args) {
	    System.out.println(
	      topToys(6, 2, new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft", "popeye's"}, 7,
	        new String[]{
	          "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
	          "The new Elmo dolls are super high quality popeye's",
	          "Expect the Elsa dolls to be very popular this year, Elsa!",
	          "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
	          "For parents of older kids, look into buying them a drone",
	          "Warcraft is slowly rising in popularity ahead of the holiday season"
	        }));
	  }
}
