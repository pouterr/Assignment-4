import java.util.Arrays;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        /**
         * Constructs a HashNode object with the given key and value.
         *
         * @param key   the key of the node
         * @param value the value of the node
         */
        public HashNode(K key, V value) {

            this.key = key;

            this.value = value;

        }

        /**
         * Returns a string representation of the HashNode.
         *
         * @return a string representation of the node
         */
        @Override
        public String toString() {
            return "" + key + " " + value + "}";

        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11; // Default number of buckets
    private int size;

    /**
     * Constructs a MyHashTable object with the default number of buckets.
     */
    public MyHashTable() {
        chainArray = new HashNode[M]; // Initialize the chain array with default size
        size = 0;
    }

    /**
     * Constructs a MyHashTable object with the specified number of buckets.
     *
     * @param M the number of buckets
     */
    public MyHashTable(int M) {
        this.M = M; // Set the number of buckets as provided by the user
        chainArray = new HashNode[M]; // Initialize the chain array with the provided size
        size = 0;
    }

    /**
     * Returns the hash code for the given key.
     *
     * @param key the key
     * @return the hash code for the key
     */
    private int hash(K key) {
        return key.hashCode(); // Use the default hashCode() method of the key
    }

    /**
     * Adds a key-value pair to the hash table.
     *
     * @param key   the key to be added
     * @param value the value to be added
     */
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (chainArray[index] == null) {
            chainArray[index] = newNode; // No collision, add the new node directly
        } else {
            HashNode<K, V> currentNode = chainArray[index];

            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {

                    currentNode.value = value; // Key already exists, update the value
                    return;
                }
                currentNode = currentNode.next;
            }

            // Reached the end of the chain, add the new node
            if (currentNode.key.equals(key)) {
                System.out.println(value);
                currentNode.value = value; // Key already exists, update the value
            } else {
                currentNode.next = newNode; // Append the new node at the end of the chain
            }
        }

        size++;
    }


    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        int index = hash(key);

        HashNode<K, V> currentNode = chainArray[index];

        while (currentNode != null) {
            if (index == this.hash(key)) {
                return currentNode.value; // Key found, return the associated value
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    /**
     * Removes the key-value pair associated with the specified key from the hash table.
     *
     * @param key the key of the pair to be removed
     * @return the value associated with the removed key, or null if the key is not found
     */
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = chainArray[index];
        HashNode<K, V> prevNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    chainArray[index] = currentNode.next; // The first node is the target
                } else {
                    prevNode.next = currentNode.next; // The target node is in the middle or end
                }
                size--;
                return currentNode.value; // Return the value of the removed node
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return null; // Key not found
    }

    /**
     * Checks if the hash table contains a specific value.
     *
     * @param value the value to be checked
     * @return true if the value is found, false otherwise
     */
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return true; // Value found
                }
                currentNode = currentNode.next;
            }
        }
        return false; // Value not found
    }

    /**
     * Retrieves the key associated with the specified value.
     *
     * @param value the value whose associated key is to be returned
     * @return the key associated with the value, or null if the value is not found
     */
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return currentNode.key; // Key found
                }
                currentNode = currentNode.next;
            }
        }
        return null; // Value not found
    }

    /**
     * Prints the sizes of individual chains in the hash table.
     */
    public void printChainSizes() {
        for (int i = 0; i < M; i++) {
            int bucketSize = 0;
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                bucketSize++;
                currentNode = currentNode.next;
            }
            System.out.println("Bucket " + i + ": " + bucketSize + " elements");
        }
    }



    public void replace(K key, V oldValue, V newValue) {
        int index = hash(key);
        HashNode<K, V> currentNode = chainArray[index];

        while (currentNode != null) {
            if (currentNode.value.equals(oldValue)) {
                currentNode.value = newValue; // Replace the value if key and oldValue match
                return;
            }
            currentNode = currentNode.next;
        }
    }


}
