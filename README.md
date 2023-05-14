# Assignment-4
# MyHashTable

The MyHashTable class is a custom implementation of a hash table that stores key-value pairs. It utilizes separate chaining to handle collisions. The hash table supports operations such as adding, retrieving, removing, and checking the existence of elements.

**Inner Class**: HashNode

The HashNode class represents a node in the hash table. Each node contains a key-value pair and a reference to the next node in case of collision.

**Constructors**

`HashNode(K key, V value)`: Constructs a HashNode object with the given key and value.

**Methods**

`String toString()`: Returns a string representation of the HashNode.

**Fields**

`private HashNode<K, V>[] chainArray`: An array of linked lists to store the elements in separate chains.

`private int M`: The number of buckets in the hash table (default is 11).

`private int size`: The number of elements stored in the hash table.

**Constructors**

`MyHashTable()`: Constructs a MyHashTable object with the default number of buckets.

`MyHashTable(int M)`: Constructs a MyHashTable object with the specified number of buckets.

**Methods**

`private int hash(K key)`: Returns the hash code for the given key.

`public void put(K key, V value)`: Adds a key-value pair to the hash table.

`public V get(K key)`: Retrieves the value associated with the specified key.

`public V remove(K key)`: Removes the key-value pair associated with the specified key from the hash table.

`public boolean contains(V value)`: Checks if the hash table contains a specific value.

`public K getKey(V value)`: Retrieves the key associated with the specified value.

`public void printChainSizes()`: Prints the sizes of individual chains in the hash table.

# MyTestingClass

The MyTestingClass represents a class used as keys in the MyHashTable class. Each instance of MyTestingClass is initialized with an id, which is used to calculate the hash code for the object.

**Constructors**

`MyTestingClass(int id)`: Constructs a MyTestingClass object with the given id.

**Methods**

`int hashCode()`: Returns the hash code for the MyTestingClass object based on the id.
