import java.util.Random;

public class MyTestingClass {
    private int id;

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
        return id % 11; // Calculate the hash code by taking the remainder of id divided by 11
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(); // Create an instance of MyHashTable
        Random random = new Random(); // Create a Random object for generating random values

        // Add 10000 random elements to the hash table
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(100)); // Create a new MyTestingClass object with a random id
            String value = "Value" + i; // Create a value string with the format "ValueX"
            table.put(key, value); // Add the key-value pair to the hash table
        }

        table.printChainSizes(); // Print the sizes of the individual chains in the hash table
    }
}


