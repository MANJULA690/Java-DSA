import java.util.LinkedList;
import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[2 * N];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                return true;
            }
            return false;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Apple", 100);
        hm.put("Banana", 60);
        hm.put("Grapes", 50);
        hm.put("pineApple", 70);
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(hm.get("Apple"));
        System.out.println(hm.containsKey("Apple"));
        System.out.println(hm.remove("Apple"));
        System.out.println(hm.get("Apple"));
        System.out.println(hm.containsKey("Apple"));
        // LinkedHashMap<String, Integer> map=new LinkedHashMap<>();
        // TreeMap<String, Integer> map = new TreeMap<>();
        // map.put("Apple", 100);
        // map.put("Banana", 50);
        // map.put("Cucumber", 80);
        // System.out.println(map);
    }
}
