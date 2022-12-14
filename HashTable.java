
public class HashTable {
	Node [] table;
	int size = 0;
	int tableSlots;
	int collisions;
	int nodeCount;
	
	public HashTable(int capacity) {
		collisions = 0;
		size = 0;
		nodeCount = 0;
		int number = capacity;
		boolean prime = false;
		while(!prime) {
			if (!isPrime(number)) {
				number ++;
			}else prime = true;
		}
		
		tableSlots = number;
		table = new Node[number];
		for (int i = 0; i<number; i++) {
			table[i] = null;
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isPrime(int number) {
		int i;
		for (i=3; i<Math.sqrt(number); i+=2)
			if(number%i==0)
				return false;
		return true;
	}
	public void put(int key, String value) {
		int index;
		Node p = new Node();
		nodeCount++;
		p.key = key;
		p.data = value;
		index = foldedsquarehash(key);
		if(size == table.length)System.exit(1);
		while(table[index]!=null) {
			collisions++;
			index = (index +1)%table.length; //This is the linear probing needed to handle collisions
		
		}
		table[index] = p;
		size++;
	}
	
	public int hash(int key) {
		return (int)(key%table.length);
	}
	public int foldedsquarehash(long key) {
		long index = ((long)key*(long)key)/100;
		index%=table.length;
		return (int)index;
	}
	
	public Node find (int key) {
		int index, start;
		index = hash(key);
		start = index;
		while(table[index]!=null && table[index].key!=key) {
			index = (index+1)%table.length;
			if(index ==start)return null;
		}
		if (table[index]==null)return null;
		return table[index];
	}
	public Node findChain(int key) {
		int index, start;
		index = hash(key);
		Node t = table[index];
		while(t!=null) {
			if(t.key ==key)return table[index];
			t = t.next;
		}
		return null;
	}
	
	public boolean contains (int key) {
		int index, start;
		index = hash(key);
		start = index;
		while(table[index]!=null && table[index].key!=key) {
			index = (index+1)%table.length;
			if(index ==start)return false;
		}
		if (table[index]==null)return false;
		return true;
	}
	
	
	
	public class Node{
		int key;
		String data;
		Node next;
	}

}
