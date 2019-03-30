class LRUCache {
    HashMap<Integer, Node> hash;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        hash = new HashMap<>();
        
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        
        if (hash.containsKey(key)) {
            moveToEnd(hash.get(key));
            return hash.get(key).value;
            
        }
        else 
            return -1;
        
    }
    
    public void put(int key, int value) {
        
        Node newNode = new Node(key, value);
        
       
        if (hash.containsKey(key)) { 
            removeFromList(hash.get(key));
            hash.replace(key, newNode);
            addToEnd(hash.get(key));
            
        } else if (hash.size() >= this.capacity) {
            
            Node headNext = head.next;
            hash.remove(headNext.key);
            removeFromList(headNext); 
            
            hash.put(key, newNode);
            addToEnd(newNode);
            
        } else {
            hash.put(key, newNode);
            addToEnd(newNode);
        }    
        
        
    }
    
    public void addToEnd(Node node) {
        
        Node tailPrev = tail.prev;
        
        tail.prev = node;
        tailPrev.next = node;
        
        node.prev = tailPrev;
        node.next = tail;
        
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
    
    public void moveToEnd(Node node) {
        
        removeFromList(node);
        addToEnd(node);
        
    }
       
    

}

class Node {
    int value;
    int key;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.value = value;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */