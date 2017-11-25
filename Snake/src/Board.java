import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pablo Edgar Nov 25, 2017
 * 
 */
public class Board {

    /**
     * 
     */
    Path p;

    public Board() {

    }

    public Board(Path p) {
        this.p = p;

    }

    public void makeBoard() {

        int numberLocation = 0;
        int boardWidth = 0;
        int boardHeight = 0;

        try {

            Scanner s1 = new Scanner(p);
            String configLine = s1.nextLine();
            
            Matcher matcher = Pattern.compile("\\d+").matcher(configLine);
            matcher.find();
            boardWidth = Integer.valueOf(matcher.group());

            int i = 0;
            while (i < configLine.length()
                    && !Character.isDigit(configLine.charAt(i))) {
                i++;
            }

            int j = i;
            while (j < configLine.length()
                    && Character.isDigit(configLine.charAt(j))) {
                j++;
            }

            boardWidth = Integer.parseInt(configLine.substring(i, j));

            // for (int i = 1; i < configLine.length(); i++) {
            // if (Character.isWhitespace(configLine.charAt(i)) != true) {
            // numberLocation++;
            // }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Board [p=" + p + "]";
    }

    public void makeBoard(Iterator<String> itemIter) {

    }

    public static int getWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    public static int getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

}
