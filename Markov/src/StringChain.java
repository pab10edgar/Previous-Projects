/*
 * @author Pablo Edgar
 * 11/6/2017
 *
 * Lab #7 - Markov Chain Text Generator
 *
 * A program that creates a Markov chain from a text file (or files) 
 * and generates some gibberish in a similar style
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StringChain {

    // Create a new hashmap that will store prefix and suffix
    private Map<Prefix, Suffix> chain = new HashMap<Prefix, Suffix>();

    // "Padding"
    private static final String NONWORD = " ";
    private final int order;

     /**
     * String Chain Constructor
     * 
     * @param order of markov chain
     */
    public StringChain(int order) {
        this.order = order;
    }
    
     /**
     * Nested Suffix Class of Markov Chain
     */
    public class Suffix {

        // Initialize LinkedList
        private List<String> suf1;
        
        /**
         * Default constructor
         */
        public Suffix() {
            suf1 = new LinkedList<>();
        }

        /**
         * Suffix Constructor
         * 
         * @param str
         */
        public Suffix(String str) {
            // Create a new LinkedList to store values
            suf1 = new LinkedList<>();
            suf1.add(str);
        }
        
        /**
         * Add method to add string to LinkedList
         * 
         * @param str
         */
        public void Add(String str) {
            suf1.add(str);
        }

        /**
         * Get method to return random string based on LinkedList
         * 
         * @param randr
         * @return item at 'i' in LinkedList
         */
        public String getRand(Random randr) {
            int i = randr.nextInt(suf1.size());
            return suf1.get(i);
        }

        // Return generic hashCode of LinkedList multiplied by 31 (prime odd number)
        // for consistency
        @Override
        public int hashCode() {
            return suf1.hashCode() * 31;
        }
    }

    /**
     * Nested Prefix Class of Markov Chain
     */
    public class Prefix {

        // Initialize the list
        private List<String> pre1;

        // Constructor that takes in a List of Strings (LinkedList)
        Prefix(List<String> list) {

            // Used a LinkedList to increase performance vs. a ArrayList
            pre1 = new LinkedList<String>(list);
        }

        // Equals method to see if object in parameter matches prefix
        @Override
        public boolean equals(Object prefix) {
            return pre1.equals(((Prefix) prefix).getPrefix());
        }

        /**
         * Get method for current prefix
         * 
         * @return pre1 List of Prefix
         */
        public List<String> getPrefix() {
            return pre1;
        }

        /**
         * Override of hashCode method as required in instructions
         * 
         * @return hashcode of pre1
         */
        @Override
        public int hashCode() {
            return pre1.hashCode();
        }
    }

    /**
     * Add a sequence of items to the chain, as given by a string iterator.
     * 
     * @param itemIter
     */
    public void addItems(Iterator<String> itemIter) {
        
        List<String> intL = new LinkedList<>();

        // Add non-word padding to chain depending on order 
        for (int i = 0; i < order; i++) {
            intL.add(NONWORD);
        }

        // Create a new prefix object
        Prefix p1 = new Prefix(intL);

        // Manipulate Chain by putting items to map
        while (itemIter.hasNext()) {
            
            String s = itemIter.next();
            
            // If chain contains prefix key, add next string to chain
            if (chain.containsKey(p1)) {
                chain.get(p1).Add(s);
            } else {
                chain.put(p1, new Suffix(s));
            }

            // Add string s to top of chain
            intL.add(s);
            // Remove string at beginning of chain
            intL.remove(0);
            
            p1 = new Prefix(intL);

        }
        
        // Repeat with NONWORDS
        for (int i = 0; i < order; i++) {
            
            String s = NONWORD;

            if (chain.containsKey(p1)) {
                chain.get(p1).Add(s);
            } else {
                chain.put(p1, new Suffix(s));
            }
            
            intL.add(s);
            intL.remove(0);
            p1 = new Prefix(intL);
        }
    }

    /**
     * Generate a list of Strings of length n, using the provided random number
     * generator.
     * 
     * @param n
     * @param rand
     * @return newly created LinkedList
     */
    public List<String> generate(int n, Random rand) {

        // Make LinkedList to store values
        List<String> generated = new LinkedList<>();
        List<String> temp = new LinkedList<>();

        // Add nonwords depending on order of chain
        for (int i = 0; i < order; i++) {
            temp.add(NONWORD);
        }
        
        // Add new strings to LinkedLists
        for (int j = 0; j < n; j++) {
            
            // Create a new Prefix, Suffix and String
            Prefix p = new Prefix(temp);
            Suffix s1 = chain.get(p);
            String v1 = s1.getRand(rand);
            
            // Add random string to LinkedList
            generated.add(v1);
            // Add random string to other LinkedList (temporary)
            temp.add(v1);
            // Remove first item from LinkedList
            temp.remove(0);
        }

        // Return generated list with random strings
        return generated;
    }
}
