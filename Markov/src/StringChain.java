
/*
 * @author Pablo Edgar
 * 11/6/2017
 * Lab #7 - Markov Chain Text Generator
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

    public class Suffix {

        private List<String> suf1;

        /**
         * Suffix Constructor
         * 
         * @param str
         */
        public Suffix(String str) {
            suf1 = new LinkedList<>();
            suf1.add(str);
        }

        /**
         * Default constructor
         */
        public Suffix() {
            suf1 = new LinkedList<>();
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
         * Get method to get random string
         * 
         * @param randr
         * @return item at 'i' in LinkedList
         */
        public String getRand(Random randr) {
            int i = randr.nextInt(suf1.size());
            return suf1.get(i);
        }

        @Override
        public int hashCode() {
            return suf1.hashCode() * 31;
        }

    }

    /**
     * Prefix Class of Markov Chain
     */
    public class Prefix {

        private List<String> pre1;

        // Constructor that takes in a List of Strings (LinkedList)
        Prefix(List<String> list) {

            // Used a LinkedList to increase performance vs. a ArrayList
            pre1 = new LinkedList<String>(list);
        }

        @Override
        public boolean equals(Object prefix) {
            return pre1.equals(((Prefix) prefix).getPrefix());
        }

        /**
         * Get method for current prefix
         * 
         * @return pre1
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
     * String Chain Constructor
     * 
     * @param order
     */
    public StringChain(int order) {
        this.order = order;
    }

    /**
     * Add a sequence of items to the chain, as given by a string iterator.
     * 
     * @param itemIter
     */
    
    public void addItems(Iterator<String> itemIter) {
        List<String> intL = new LinkedList<>();

        for (int i = 0; i < order; i++) {
            intL.add(NONWORD);
        }

        // Create a new prefix object
        Prefix p1 = new Prefix(intL);

        // Manipulate Chain by putting items to map
        while (itemIter.hasNext()) {
            String s = itemIter.next();
            if (chain.containsKey(p1)) {
                chain.get(p1).Add(s);
            } else {
                chain.put(p1, new Suffix(s));

            }

            intL.add(s);
            intL.remove(0);
            p1 = new Prefix(intL);

        }
        // Repeat
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

        List<String> generated = new LinkedList<>();
        List<String> temp = new LinkedList<>();

        // Add nonwords depending on order of chain
        for (int i = 0; i < order; i++) {
            temp.add(NONWORD);
        }
        // Add new strings to LinkedLists
        for (int j = 0; j < n; j++) {
            Prefix p = new Prefix(temp);
            Suffix s1 = chain.get(p);
            String v1 = s1.getRand(rand);
            generated.add(v1);
            temp.add(v1);
            temp.remove(0);
        }

        return generated;

    }

}