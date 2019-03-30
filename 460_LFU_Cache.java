class LFUCache {
    HashMap<Integer, Node> hash;
    int capacity;
    Node head;
    Node tail;

    public LFUCache(int capacity) {
        
        this.capacity = capacity;
        hash = new HashMap<>();
        
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        
        if (hash.containsKey(key)) {
            
            hash.get(key).count++;
            reorder(hash.get(key));
            return hash.get(key).value;
            
        }
        else 
            return -1;
        
    }
    
    public void put(int key, int value) {
        
        Node newNode = new Node(key, value);     
        
        if( capacity > 0 ) {
       
            if (hash.containsKey(key)) { 

                removeFromList(hash.get(key));

                newNode.count = hash.get(key).count + 1;

                hash.replace(key, newNode);
                addToList(hash.get(key));

            } else if (hash.size() >= this.capacity) {

                Node headNext = head.next;
                hash.remove(headNext.key);
                removeFromList(headNext); 

                hash.put(key, newNode);
                addToList(newNode);

            } else {
                hash.put(key, newNode);
                addToList(newNode);
            }    
        }
        
    }
    
    public void addToList(Node node) {
        int count = node.count;
        Node i = head.next;
        
        while (i.count <= node.count && i.value != -1) {
            i = i.next;
        }
        
        Node iPrev = i.prev;
        
        i.prev = node;
        iPrev.next = node;
        
        node.prev = iPrev;
        node.next = i;
        
       
    }
    
    public void removeFromList(Node node) {
                   
        if (node.prev != null) {           
            Node prevNode = node.prev;
            prevNode.next = node.next;
        }

        if (node.next != null) {
            Node nextNode = node.next;
            nextNode.prev = node.prev;
        }
        
               
    }
    
    public void reorder(Node node) {
        
        removeFromList(node);
        addToList(node);
        
    }
    
    

}

class Node {
    int value;
    int key;
    int count;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.value = value;
        this.key = key;
        this.count = 0;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */