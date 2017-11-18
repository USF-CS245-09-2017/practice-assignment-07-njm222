
public class Hashtable {
	
	class HashNode {
		
		String key;
		String value;
		HashNode next;
		
		public HashNode(String K, String V) {
			key = K;
			value = V;
		}
	}
	
	private HashNode[] table;
	private int size;
	
	public Hashtable() {
		table = new HashNode[314526];
		size = 0;
	}

	public void put(String K, String V) {
		// TODO Auto-generated method stub
		int i = Math.abs(K.hashCode() % table.length);
		if(containsKey(K)){
			HashNode Node = table[i];
			while(Node != null){
				if(Node.key.equals(K)){
					Node.value = V;
					return;
				}
				Node = Node.next;
			}
		}else{
			HashNode Node = new HashNode(K, V);
			Node.next = table[i];
			table[i] = Node;
			size++;	
		}
	}

	public Object get(String K) {
		// TODO Auto-generated method stub
		if(!containsKey(K))
			return null;
		
		int i = Math.abs(K.hashCode() % table.length);
		HashNode start = table[i];
		
		while(start != null){
			if(start.key.equals(K))
				return start.value;
			start = start.next;
		}
		
		return null;
	}

	public String remove(String K) throws Exception {
		// TODO Auto-generated method stub
		if(!containsKey(K))
			throw new Exception();
		
		int i = Math.abs(K.hashCode() % table.length);
		HashNode start = table[i];
		String temp = null;
		if(start == null)
			return null;
		else if(start.key.equals(K)){
			temp = start.value;
			table[i] = start.next;
		}
		else{
			while(start.next != null){
				if(start.next.key.equals(K))
					break;
				start = start.next;
			}
			temp = start.next.value;
			start.next = start.next.next;
		}
		size--;
		return temp;
	}

	public boolean containsKey(String K) {
		// TODO Auto-generated method stub
		int i = Math.abs(K.hashCode() % table.length);
		HashNode start = table[i];
		
		while(start != null){
			if(start.key.equals(K))
				return true;
			start = start.next;
		}
		return false;
	}

}
