import java.util.*;
class FreqClass {
	Integer freq;
	Character ch;
	
	public FreqClass(Integer i, Character ch1) {
		this.freq = i;
		this.ch = ch1;
	}
	
	public void setFreq(Integer k) {
		this.freq = k;
	}
	
	public Integer getFreq() {
		return this.freq;
	}
	
	public void setChar(Character k) {
		this.ch = k;
	}
	
	public Character getChar() {
		return this.ch;
	}
}
	
	class FrequencyComparator implements Comparator<FreqClass> {
		
		// Overriding compare()method of Comparator for descending order of freq
		public int compare(FreqClass s1, FreqClass s2) {
			if(s1.freq == s2.freq)
				return s1.ch.compareTo(s2.ch);
			else return Integer.compare(s2.freq, s1.freq);
			
		}
	}
	




public class RearrangeStringsKDistanceApart {
	
	public String returnKDistanceApart(String s, int k) {
		if(s == null || s.length() == 0 || k > s.length()) return s;
		// Create a frequency map of characters in the string
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char c : s.toCharArray())
	    { if (!frequencyMap.containsKey(c)) 
	                frequencyMap.put(c, 1);
	       else 
	                frequencyMap.put(c, frequencyMap.get(c) + 1);
	    }
		
		// We need to get the max frequent ones at first, to ensure that characters can be placed k distance apart
		// Hence, heap is used
	    PriorityQueue<FreqClass> maxHeap = new PriorityQueue<FreqClass>(new FrequencyComparator());
	        
		// Add all map entries into the heap
	    for( Character ch: frequencyMap.keySet()){
	        maxHeap.add(new FreqClass(frequencyMap.get(ch),ch));
	    }

		// Since each character must be apart k distance, keep a queue for storing all previously seen characters
		Queue<FreqClass> previousEntries = new LinkedList<>();
		StringBuilder sb = new StringBuilder(s.length());

		while (!maxHeap.isEmpty()) {
			// Insert the character
			FreqClass current = maxHeap.poll();
			sb.append(current.ch);
	        // current.setFrq()
			current.setFreq(current.getFreq() - 1);
			// Current becomes previous into the queue
			previousEntries.add(current);
			// As long as the number of characters in the previous entries is less than k, do nothing
			if (previousEntries.size() < k)
				continue;
			// Once the previous entries queue is of size k, then evict the first element and enqueue it
			// only when its frequency is positive
			FreqClass firstPrevious = previousEntries.poll();
			if (firstPrevious.getFreq() > 0)
				maxHeap.offer(firstPrevious);
		} 
		
		// Only when the result string is of same length as input string, that's success, else return empty result
		return sb.length() == s.length() ? sb.toString() : "";
	        
	    }
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
