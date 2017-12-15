
/**
 * @author Pablo Edgar
 * 11/6/2017
 * Lab #7 - Markov Chain Text Generator
 * 
 * A program that creates a Markov chain from a text file (or files) 
 * and generates some gibberish in a similar style
 * 
 * Takes at least 4 command-line arguments:
 * 
 * 1. The order of the Markov chain.
 * 2. The number of items that should be in the generated output.
 * 3. Either “word” or “char” to indicate if the source text will be broken into words or characters.
 * 4. The name of the first text file that will be used to generate the random text.
 * 5. Any additional arguments are the names of additional text files to add to the chain.
 */

import java.util.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.*;

public class Markov {
    
    /** Regular expression for breaking up words. */
    private static final String WORD_REGEX = "(?<=\\b\\s)";
    /** Regular expression for getting individual characters. */
    private static final String CHAR_REGEX = "(?<=.)";

    public static void main(String[] args) {

        String regex1 = WORD_REGEX;
        String regex = CHAR_REGEX;

        // New random number
        Random r1 = new Random();

        // Take in args from command line for chain order and length
        int order = Integer.parseInt(args[0]);
        int length = Integer.parseInt(args[1]);

        // Create a new String Chain
        StringChain chain = new StringChain(order);
        
        // Check args[2] for either char or word, to specify type of chain
        if (args[2].equalsIgnoreCase("word")) {
            regex = WORD_REGEX;
        }
        // Add multiple files to chain depending on args
        for (int a = 3; a < args.length; a++) {
            String f1 = args[a];
            addFile(chain, regex, Paths.get(f1));
        }

        Scanner in = null;
        
        // Generate chain and print out result
        for (String s : chain.generate(length, r1)) {
            System.out.print(s);
        }
        // Spacing at end
        System.out.println("");
    }

    /**
     * Method that allows multiple files to be added to the chain.
     * 
     * @param chain
     * @param regex
     * @param file
     */
    private static void addFile(StringChain chain, String r, Path f) {

        try (Scanner s1 = new Scanner(f)) {

            // Create a new scanner with file path
            // Set scanner delimiting pattern to pattern constructed from
            // string.
            s1.useDelimiter(r);

            // Add a sequence of items to the chain
            chain.addItems(s1);
          
        } catch (IOException exception1) {
            exception1.printStackTrace();
        }
    }
}
