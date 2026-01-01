import java.util.LinkedList;
import java.util.List;

// Happy New Year
public class FirstJanuary {
    static class Bucket {
        public List<Integer> container;

        public Bucket() {
            this.container = new LinkedList<Integer>();
        }

        public void insert(Integer val) {
            int idx = this.container.indexOf(val);

            if (idx == -1) {
                this.container.addFirst(val);
            }
        }

        public void remove(Integer val) {
            this.container.remove(val);
        }

        public boolean contains(Integer val) {
            int idx = this.container.indexOf(val);
            return idx != -1;
        }
    }

    static class MyHashSet {
        int numBucket = 13;
        Bucket[] buckets;

        public MyHashSet() {
            this.buckets = new Bucket[this.numBucket];

            for (int i = 0; i < numBucket; i++) {
                this.buckets[i] = new Bucket();
            }
        }

        public int getIndex(Integer key) {
            return key % numBucket;
        }

        public void put(int key) {
            int bucketIndex = this.getIndex(key);
            this.buckets[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = this.getIndex(key);
            this.buckets[bucketIndex].remove(key);
        }

        public boolean containsKey(int key) {
            int bucketIndex = this.getIndex(key);
            return this.buckets[bucketIndex].contains(key);
        }

        public void printSet() {
            System.out.println("\n--- HashSet Buckets ---");
            for (int i = 0; i < numBucket; i++) {
                System.out.println("Bucket " + i + " -> " + buckets[i].container);
            }
        }
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.put(10);
        set.put(20);
        set.put(30);
        set.put(10);
        set.put(40);
        set.put(28);

        set.printSet();

        System.out.println("\nCheck contains:");
        System.out.println("Contains 15? " + set.containsKey(15));   // true
        System.out.println("Contains 50? " + set.containsKey(50));   // false

        System.out.println("\nRemoving 28...");
        set.remove(28);
        set.printSet();

        System.out.println("\nContains 28? " + set.containsKey(28)); // false
    }
}
