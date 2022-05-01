import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    public void addFirst(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }

    public void removeLast(){
        Node prev = tail.prev;
        Node prepre = prev.prev;

        prepre.next = tail;
        tail.prev = prepre;

        map.remove(prev.key);
    }

    public void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;

        prev.next=next;
        next.prev=prev;
    }


    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=tail;
        this.tail.prev=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addFirst(node);
        }
        else{
            Node node=new Node(key,value);
            map.put(key,node);
            addFirst(node);

            if(map.size()>capacity)
                removeLast();
        }
    }
}