import java.util.Random;

public class MyTestingClass {
    public int id;

    /**
     * Constructs a MyTestingClass object with the given id.
     *
     * @param id the id for the MyTestingClass object
     */
    public MyTestingClass(int id) {
        this.id = id;
    }

    /**
     * Returns the hash code for the MyTestingClass object.
     *
     * @return the hash code based on the id
     */
    @Override
    public int hashCode() {
        return this.id % 2; // Calculate the hash code by taking the remainder of id divided by 11
    }

    public static void main(String[] args) {
//        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(5); // Create an instance of MyHashTable
//        Random random = new Random(); // Create a Random object for generating random values
//
//        // Add 10000 random elements to the hash table
//        for (int i = 0; i < 2; i++) {
//            MyTestingClass key = new MyTestingClass(i); // Create a new MyTestingClass object with a random id
//            String value = "Value"; // Create a value string with the format "ValueX"
//            table.put(key, value); // Add the key-value pair to the hash table
//        }
//        MyTestingClass key = new MyTestingClass(0);
//        System.out.println(table.contains("Value"));
//        System.out.println(table.get(key));
        MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
        hashTable.put(new MyTestingClass(1), "one");
        hashTable.put(new MyTestingClass(2), "two");


        System.out.println("Before replace:");
        System.out.println(hashTable.get(new MyTestingClass(1))); // Output: one
        System.out.println(hashTable.get(new MyTestingClass(2))); // Output: two
         // Output: three

        hashTable.replace(new MyTestingClass(1), "one", "new value");

        System.out.println("After replace:");
        System.out.println(hashTable.get(new MyTestingClass(1))); // Output: one
        System.out.println(hashTable.get(new MyTestingClass(2))); // Output: new value
         // Output: three


    }

}


