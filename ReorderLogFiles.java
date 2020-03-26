import java.util.*; 	
public class ReorderLogFiles {

	public String[] reorderLogFiles(String[] logs) {
	        List<String> letterLogs = new ArrayList<>();
	        List<String> digitLogs = new ArrayList<>();

	        for (String log : logs) {
	            /*split("\\s+") will split the string into string of array with separator as space or multiple spaces. \s+ is a regular expression for               one or more spaces. */
	            //In a digit every character will add up
	            if(Character.isDigit(log.split("\\s+")[1].charAt(0))) {
	                digitLogs.add(log);
	            }
	            else {
	                letterLogs.add(log);
	            }
	        }

	        Collections.sort(letterLogs, new Comparator<String>() {
	            @Override
	            public int compare(String o1, String o2) {
	                String[] s1 = o1.split("\\s+");
	                String[] s2 = o2.split("\\s+");
	                StringBuilder sb1 = new StringBuilder();
	                StringBuilder sb2 = new StringBuilder();
	                
	                //Starts from 1 ignoring lexicographical thing
	                for (int i=1; i<s1.length; i++) {
	                    sb1.append(s1[i]).append(" ");
	                }
	                //Starts from 1 ignoring lexicographical thing
	                for (int i=1; i<s2.length; i++) {
	                    sb2.append(s2[i]).append(" ");
	                }
	                 // In case the remaining strings consist of tie, then use first    string
	                if (sb1.toString().compareTo(sb2.toString()) == 0) {
	                    return s1[0].compareTo(s2[0]);
	                }

	                return sb1.toString().compareTo(sb2.toString());
	            }
	        });

	        String[] ans = new String[logs.length];

	        int i = 0;
	        for (String log : letterLogs) {
	            ans[i++] = log;
	        }
	        
	        /*PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
			       String[] s1 = t1.split("\\s+");
	                String[] s2 = t2.split("\\s+");

	                StringBuilder sb1 = new StringBuilder();
	                StringBuilder sb2 = new StringBuilder();
	                
	                //Starts from 1 ignoring lexicographical thing
	                for (int i=1; i<s1.length; i++) {
	                    sb1.append(s1[i]).append(" ");
	                }
	                //Starts from 1 ignoring lexicographical thing
	                for (int i=1; i<s2.length; i++) {
	                    sb2.append(s2[i]).append(" ");
	                }
	                 // In case the remaining strings consist of tie, then use first    string
	                if (sb1.toString().compareTo(sb2.toString()) == 0) {
	                    return s1[0].compareTo(s2[0]);
	                }

	                return sb1.toString().compareTo(sb2.toString());
			    });
			    
			    for(String s : letterLogs){
            pq.add(s);
        }

        String[] ans = new String[logs.length];

        int i = 0;
        while(pq.size() != 0) {
            ans[i++] = pq.poll();
        }
        */


	        for (String log : digitLogs) {
	            ans[i++] = log;
	        }

	        return ans;
	        
	    } 
}
