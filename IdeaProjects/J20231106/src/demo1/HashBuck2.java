package demo1;

public class HashBuck2 <K,V>{
    static class Node<K,V>{
        public K key;
        public V val;

        public Node<K,V> next;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array;
    public int usedSize;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashBuck2(){
        array = (Node<K,V>[]) new Node[10];//强转
    }
    public void put(K key, V val){
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while(cur!=null){
            //引用类型不能用等号
            //if(cur.key == key){
            if(cur.key.equals(key)){
                //更新value
                cur.val = val;
            }
            cur = cur.next;
        }
        Node<K,V> node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
    }
    public V getValue(K key){
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while(cur != null){
            if(cur.key.equals(key)){
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}
