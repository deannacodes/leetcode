import java.util.*;

public class Main {
	
	public static void main(String[] args) {
	    long l = Long.parseLong("1");
	    long r = Long.parseLong("1000000000000000000");
	    long total = r - l; //-1?
	    int m = Integer.parseInt("10");
	    long[] n = {485278786,917367266,477606006,635986203,914812984,107918120,112248576,302815519,398749321,402524265};


	    for (int i = 0; i < n.length; i++) {
	      for (int j = i + 1; j < n.length; j++) {
	        if (n[i] % n[j] == 0) {
	          n[i] = 0;
	          break;
	        }
	      }
	    }

	     HashSet<Long> killed = new HashSet<>();

			    for (int i = 0; i < n.length; i++) {

	          if (n[i] != 0) {

	            long lowerBound = (l / n[i]) + 1;
	            long upperBound = r / n[i]; 

	            for (long j = lowerBound; j <= upperBound; j++) {
	              
	              long val = n[i] * j;
	              if (val > l && val < r)
	                killed.add(val);
	              //System.out.println(lowerBound + " " + upperBound + ": adding " + val);

	            }

	          }

			    }

			    long result = total - killed.size() + 1;

			    System.out.println(result);
	  }
	

}
