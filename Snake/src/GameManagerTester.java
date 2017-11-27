
/**
 * @author Pablo Edgar
 * Nov 20, 2017
 * 
 * Final Project - Snake Game
 * 
 */
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

public class GameManagerTester {

    public static void main(String[] args) {
        
        GameManager game1 = new GameManager("maze-simple.txt");
//        GameManager game2 = new GameManager("maze-cross.txt");
    
        while (!game1.gameEnded()) {
            System.out.print("> ");
            game1.controlSnake();
            game1.updateFrame();
            System.out.println(game1);
    
        }
        

    }
}
