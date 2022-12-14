import java.util.Hashtable;
import java.util.Random;

public class HashTest {
	
	public static void main(String[] args) {
		int n = 1000;
		HashTable table = new HashTable(n);
		int max = (int)(table.tableSlots*.8);
		
		Random rand = new Random();

		while (table.size<max) {
		
			table.put(rand.nextInt(999999), "Hi"); 
		}
		double utilization = (double)table.size/(double)table.tableSlots;
		System.out.println("Percentage Utilization is " + utilization);
		System.out.println("Number of collisions was " + table.collisions);
		System.out.println("Number of nodes added was "+table.nodeCount);
		
		Hashtable<Integer, String> builtInTable = new Hashtable<Integer, String>(n);
		for (int i = 0; i<(int)(n*.75); i++) {
			
			builtInTable.put(rand.nextInt(999999), "Hi"); 
		}
		int size = builtInTable.size();
		double builtInUtil = (double)size/(double)n;
		System.out.println("Percentage of Utilization for built in hashtable is "+ builtInUtil);
		
		
	}

}
