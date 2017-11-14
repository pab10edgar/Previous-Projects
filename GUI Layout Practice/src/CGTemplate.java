
//////import java.awt.BorderLayout;
//////import java.awt.Color;
//////import java.awt.Dimension;
//////import java.awt.Font;
//////
//////import javax.swing.ImageIcon;
//////import javax.swing.JFrame;
//////import javax.swing.JPanel;
//////import javax.swing.JSplitPane;
//////import javax.swing.WindowConstants;
//////
////////import java.awt.*; // Using AWT's Graphics and Color
////////import java.awt.event.*; // Using AWT event classes and listener interfaces
////////import javax.swing.*; // Using Swing's components and containers
////////
/////////** Custom Drawing Code Template */
////////// A Swing application extends javax.swing.JFrame
////////public class CGTemplate extends JFrame {
////////    // Define constants
////////    public static final int CANVAS_WIDTH = 640;
////////    public static final int CANVAS_HEIGHT = 480;
////////
////////    // Declare an instance of the drawing canvas,
////////    // which is an inner class called DrawCanvas extending javax.swing.JPanel.
////////    private DrawCanvas canvas;
////////
////////    // Constructor to set up the GUI components and event handlers
////////    public CGTemplate() {
////////        canvas = new DrawCanvas(); // Construct the drawing canvas
////////        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
////////        
////////
////////        // Set the Drawing JPanel as the JFrame's content-pane
////////        Container cp = getContentPane();
////////        cp.add(canvas);
////////        
////////        // or "setContentPane(canvas);"
////////
////////        setDefaultCloseOperation(EXIT_ON_CLOSE); // Handle the CLOSE button
////////        pack(); // Either pack() the components; or setSize()
////////        setTitle("......"); // "super" JFrame sets the title
////////        setVisible(true); // "super" JFrame show
////////    }
////////
////////    /**
////////     * Define inner class DrawCanvas, which is a JPanel used for custom
////////     * drawing.
////////     */
////////    private class DrawCanvas extends JPanel {
////////        // Override paintComponent to perform your own painting
////////        @Override
////////        public void paintComponent(Graphics g) {
////////            super.paintComponent(g); // paint parent's background
////////            setBackground(Color.BLACK); // set background color for this JPanel
////////
////////            // Your custom painting codes. For example,
////////            // Drawing primitive shape
////////            
////////            g.setColor(Color.WHITE); // set the drawing color
////////
////////            g.drawOval(60, 60, 200, 200);
////////            g.fillOval(90, 120, 50, 20);
////////            g.fillOval(190, 120, 50, 20);
////////            g.drawLine(165, 125, 165, 175);
////////
////////            g.drawArc(110, 130, 95, 95, 0, -180);
////////            g.setColor(Color.BLUE); // change the drawing color
////////            g.fillRect(400, 350, 60, 50);
////////            // Printing texts
////////            g.setColor(Color.WHITE);
////////            g.setFont(new Font("Monospaced", Font.PLAIN, 12));
////////            g.drawString("Testing custom drawing ...", 10, 20);
////////
////////        }
////////    }
////////
////////    // The entry main method
////////    public static void main(String[] args) {
////////        // Run the GUI codes on the Event-Dispatching thread for thread safety
////////        SwingUtilities.invokeLater(new Runnable() {
////////            @Override
////////            public void run() {
////////                new CGTemplate(); // Let the constructor do the job
////////            }
////////        });
////////    }
////////}
////////
//////////// Face.java
////////// import java.awt.*;
////////// import javax.swing.*;
////////// import java.awt.event.*;
////////// import javax.swing.event.*;
//////////
/////////// *
////////// Demonstrates a component that draws a face and uses the setter/repaint
//////////// style.
////////// */
////////// public class CGTemplate extends JPanel {
//////////
////////// // The "model" data for the face:
////////// // booleans and ints that control how it looks
////////// private boolean angry;
////////// private boolean hat;
////////// // Deltas added/subtracted from default eye/mouth size
////////// private int eyeDelta;
////////// private int mouthDelta;
//////////
////////// private int mouthWidthDelta;
//////////
////////// CGTemplate(int width, int height) {
//////////
////////// setPreferredSize(new Dimension(width, height));
////////// angry = false;
////////// hat = false;
////////// eyeDelta = 0;
////////// mouthDelta = 0;
////////// mouthWidthDelta = 0;
////////// }
//////////
////////// public void paintComponent(Graphics g) {
////////// super.paintComponent(g);
////////// // see how big we are
////////// int width = getWidth();
////////// int height = getHeight();
////////// // Angry -> draw red oval, otherwise plain outline
////////// if (angry) {
////////// g.setColor(Color.RED);
////////// g.fillOval(0, 0, width, height);
////////// } else {
////////// g.drawOval(0, 0, width - 1, height - 1);
////////// }
////////// int eyeY = height / 4; // place eyes 1/4 from top
////////// int mouthY = 2 * height / 3; // place mouth 2/3 from top
////////// // base eye size on width
////////// int eyeRadius = width / 10 + eyeDelta;
////////// // place the eyes at 1/3 and 2/3 from left
////////// int left = width / 3;
////////// int right = 2 * width / 3;
////////// // draw the eyes in green
////////// g.setColor(Color.GREEN);
////////// g.fillOval(left - eyeRadius, eyeY - eyeRadius, eyeRadius * 2,
////////// eyeRadius * 2);
////////// g.fillOval(right - eyeRadius, eyeY - eyeRadius, eyeRadius * 2,
////////// eyeRadius * 2);
////////// // draw the mouth
////////// int mouthRadius = width / 10 + mouthDelta;
////////// g.setColor(Color.BLACK);
////////// g.fillOval(width / 2 - mouthRadius - mouthWidthDelta, // x
////////// mouthY - mouthRadius, // y
////////// (mouthRadius + mouthWidthDelta) * 2, mouthRadius * 2); // height
////////// // draw the hat last (on top)
////////// if (hat) {
////////// g.setColor(Color.BLACK);
////////// int midX = width / 2;
////////// int wide = 3 * width / 4;
////////// g.fillOval(midX - wide / 2, 0, wide, height / 15);
////////// }
////////// }
//////////
////////// public static void main(String[] args) {
////////// // Run the GUI codes on the Event-Dispatching thread for thread safety
////////// SwingUtilities.invokeLater(new Runnable() {
////////// @Override
////////// public void run() {
////////// new CGTemplate(40, 100); // Let the constructor do the job
////////// }
////////// });
////////// }
////////// }
////////// import java.applet.*;
////////// import java.awt.*;
//////////
////////// /* <applet code = "face" width = 300 height = 300> </applet> */
//////////
////////// public class CGTemplate extends Applet
////////// {
////////// public void paint(Graphics g)
////////// {
////////// g.setColor (Color.yellow);
////////// g.fillOval (100,100,100,100);
////////// g.setColor (Color.black);
////////// g.fillOval (120,125,20,20);
////////// g.fillOval (160,125,20,20);
////////// g.setColor (Color.blue);
////////// g.drawLine (150,165,150,150);
////////// g.drawLine (130,170,170,170);
////////// g.drawArc(110, 130, 95, 95, 0, -180);
////////// }
////////// }
///////**
////// * @param args the command line arguments
////// */
//////
//////public class CGTemplate extends JFrame {
//////
//////    private int width = 600;
//////    private int height = 750;
//////
//////    public CGTemplate() {
//////        this.setSize(width, height);
//////        this.setVisible(true);
//////        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//////
//////        JPanel glass = new JPanel();
//////        glass.setSize(450, 750);
//////        glass.setBackground(Color.BLUE);
//////        glass.setVisible(true);
//////
//////        JPanel controls = new JPanel();
//////        controls.setSize(150, 750);
//////        controls.setBackground(Color.RED);
//////        controls.setVisible(true);
//////
//////        JSplitPane splitPane = new JSplitPane();
//////        splitPane.setSize(width, height);
//////        splitPane.setDividerSize(0);
//////        splitPane.setDividerLocation(150);
//////        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
//////        splitPane.setLeftComponent(controls);
//////        splitPane.setRightComponent(glass);
//////
//////        this.add(splitPane);
//////        
//////
//////    }
//////    public static void main(String[] args) {
//////        CGTemplate view = new CGTemplate();
//////    }
//////
//////}
////
////import javafx.*;
////import javafx.animation.AnimationTimer;
////import javafx.application.Application;
////import javafx.scene.Scene;
////import javafx.scene.canvas.Canvas;
////import javafx.scene.canvas.GraphicsContext;
////import javafx.scene.layout.VBox;
////import javafx.scene.paint.Color;
////import javafx.stage.Stage;
//////===============================================================================================
////// This is the program we (CS-152) started to develop in class on Monday (Sept. 18).
////// It extends javafx.application.Application and when run, it creates a window into
////// which it draws an endless stream of random rectangles.
//////
////// NOTE: this program requires Java 1.8 or newer.
//////===============================================================================================
////
////
//////==========================================================================================
//////A class that uses JavaFX must extend javafx.application.Application
//////==========================================================================================
////public class CGTemplate extends Application
////{
////  private static final int DRAW_WIDTH  = 1000;
////  private static final int DRAW_HEIGHT = 700;
////
////  private Animation myAnimation;  //Reference to an inner class that gets called at 60Hz
////  private Canvas canvas;          //Area on which to draw graphics items.
////  private GraphicsContext gtx;    //Drawing methods for the Canvas.
////
////  private static final int BALL_COUNT = 100;
////  private int[] ballX = new int[BALL_COUNT];
////  private int[] ballY = new int[BALL_COUNT];
////  private int[] friend = new int[BALL_COUNT];
////
////  private int ballSize;
////
////  @Override
////  //=========================================================================
////  //start(Stage stage)
////  //This is a JavaFX callback method. It is called by JavaFX after JavaFX
////  //   has created a window. The parameter, Stage stage, is a pointer to
////  //   the part of the window where the programmer can add widgets, such as
////  //   buttons, menus and canvases.
////  //=========================================================================
////  public void start(Stage stage) throws Exception
////  {
////    //Set the window's title in its title bar.
////    stage.setTitle("Walk and Turn (100 large blocks)");
////
////
////    //A Canvas is an area that supports graphics drawing
////    //To get this to work, there is a hierarchy of objects that is needed:
////    //   1) The canvas is placed in a new instance of VBox.
////    //   2) The instance of VBox is placed in a new instance of Scene.
////    //   3) The instance of Scene is placed in the given instance of Stage.
////    canvas = new Canvas(DRAW_WIDTH, DRAW_HEIGHT);
////
////    //A GraphicsContext, gtx, is a pointer to a set of drawing tools
////    //   that can be performed on an instance of a Canvas, canvas.
////    gtx = canvas.getGraphicsContext2D();
////
////
////
////    VBox vBox = new VBox();
////    vBox.getChildren().addAll(canvas);
////
////    Scene scene = new Scene(vBox, DRAW_WIDTH, DRAW_HEIGHT);
////
////    stage.setScene(scene);
////    stage.show();
////
////    //At this point, the an empty, white window is created.
////
////    ballSize = 20;
////    for (int i=0; i<BALL_COUNT; i++)
////    {
////      ballX[i]  = (int)(Math.random()*(DRAW_WIDTH-ballSize));
////      ballY[i]  = (int)(Math.random()*(DRAW_HEIGHT-ballSize));
////
////      friend[i] = i;
////      while (friend[i] == i)
////      { friend[i] = (int)(Math.random()*BALL_COUNT);
////      }
////    }
////
////
////
////    //Now, we create an new AnimationTimer and start it running.
////    //  this will tell JavaFX to call the AnimationTimer's handle method
////    //  at a rate of 60 times per second.
////    //Each time the handle method is called, a new image can be drawn.
////    //Each new image is called a "frame". Thus, this will **attempt** to
////    //  draw at 60 frames per second (fps).
////    myAnimation = new Animation();
////    myAnimation.start();
////  }
////
////
////  //===========================================================================================
////  // Animation is an inner class of our JavafxRandomBox class.
////  // Animation is an "inner class" because it is inside the JavafxRandomBox class.
////  // Since Animation extends AnimationTimer, the Animation class MUST implement
////  //   public void handle(long now), a callback method that is called by JavaFX at 60Hz.
////  //===========================================================================================
////  class Animation extends AnimationTimer
////  {
////    @Override
////    //=========================================================================================
////    //handel is a callback method called by JavaFX at 60Hz.
////    //  Try printing the value of the parameter now. Can you guess what it is?
////    //  Why is it a long?
////    //  Note: printing to the console (System.out.println()) is a relatively slow task.
////    //        Thus, while it can be instructive to call
////    //          System.out.println("JavafxRandomBox.Animaton.handle() now="+now);
////    //        in this callback, remember that JavaFX is calling it at 60Hz.
////    //        Therefore, if you leave that print statement in handle, it will slow down the
////    //        program.
////    //=========================================================================================
////    public void handle(long now)
////    {
////      //JavaFX defines colors using RGB color space.
////      //  The red, green and blue values each must be in the range [0,1] where
////      //  0 is totally off, 1 is full brightness, 0.5 is half brightness, ...
////
////      gtx.setFill(Color.DEEPSKYBLUE);
////      //gtx.fillRect(left, top, width, height) will fill an axis-aligned rectangular
////      //    area with the current fill color. The rectangle is defined by the 4
////      //   parameters:
////      //         left  (x-coordinate in pixels of the left corner of the rectangle).
////      //         top   (y-coordinate in pixels of the top corner of the rectangle).
////      //         width (width in pixels of the rectangle).
////      //         height (height in pixels of the rectangle).
////      gtx.fillRect(0, 0, DRAW_WIDTH, DRAW_HEIGHT);
////
////
////      //Follow the leader
////      for (int i=0; i<BALL_COUNT; i++)
////      {
////        gtx.setFill(Color.DARKOLIVEGREEN);
////        gtx.fillRect(ballX[i], ballY[i], ballSize, ballSize);
////
////        int friendIdx = friend[i];
////        int centerX0 = ballX[friendIdx]+ballSize/2;
////        int centerY0 = ballY[friendIdx]+ballSize/2;
////
////        int centerXi = ballX[i]+ballSize/2;
////        int centerYi = ballY[i]+ballSize/2;
////
////        if (centerX0 < centerXi)
////        {
////          ballX[i] = ballX[i]-1;
////        }
////        else if (centerX0 > centerXi)
////        { ballX[i] = ballX[i]+1;
////        }
////
////
////        if (centerY0 < centerYi)
////        {
////          ballY[i] = ballY[i]-1;
////        }
////        else if (centerY0 > centerYi)
////        { ballY[i] = ballY[i]+1;
////        }
////      }
////    }
////  } //This bracket ends Animation, the inner class.
////
////
////
////  //===========================================================================================
////  // Every Java program must have public static void main(String[] args).
////  // In a JavaFX program, main starts JavaFX by calling:
////  //     javafx.application.Application.launch(String[] args)
////  //===========================================================================================
////  public static void main(String[] args)
////  {
////    launch(args);
////  }
////}
////
////
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
////===============================================================================================
//// This is the program we (CS-152) started to develop in class on Monday (Sept. 18).
//// It extends javafx.application.Application and when run, it creates a window into
//// which it draws an endless stream of random rectangles.
////
//// NOTE: this program requires Java 1.8 or newer.
////===============================================================================================
//
//
////==========================================================================================
////A class that uses JavaFX must extend javafx.application.Application
////==========================================================================================
//public class CGTemplate extends Application
//{
//  private static final int DRAW_WIDTH  = 1000;
//  private static final int DRAW_HEIGHT = 700;
//
//  private Animation myAnimation;  //Reference to an inner class that gets called at 60Hz
//  private Canvas canvas;          //Area on which to draw graphics items.
//  private GraphicsContext gtx;    //Drawing methods for the Canvas.
//
//  private static final int BALL_COUNT = 100;
//  private int[] ballX = new int[BALL_COUNT];
//  private int[] ballY = new int[BALL_COUNT];
//  private int[] speedX = new int[BALL_COUNT];
//  private int[] speedY = new int[BALL_COUNT];
//
//  private int ballSize;
//
//  @Override
//  //=========================================================================
//  //start(Stage stage)
//  //This is a JavaFX callback method. It is called by JavaFX after JavaFX
//  //   has created a window. The parameter, Stage stage, is a pointer to
//  //   the part of the window where the programmer can add widgets, such as
//  //   buttons, menus and canvases.
//  //=========================================================================
//  public void start(Stage stage) throws Exception
//  {
//    //Set the window's title in its title bar.
//    stage.setTitle("A lot of Random Boxes");
//
//
//    //A Canvas is an area that supports graphics drawing
//    //To get this to work, there is a hierarchy of objects that is needed:
//    //   1) The canvas is placed in a new instance of VBox.
//    //   2) The instance of VBox is placed in a new instance of Scene.
//    //   3) The instance of Scene is placed in the given instance of Stage.
//    canvas = new Canvas(DRAW_WIDTH/2, DRAW_HEIGHT);
//
//    //A GraphicsContext, gtx, is a pointer to a set of drawing tools
//    //   that can be performed on an instance of a Canvas, canvas.
//    gtx = canvas.getGraphicsContext2D();
//
//
//
//    VBox vBox = new VBox();
//    vBox.getChildren().addAll(canvas);
//
//    Scene scene = new Scene(vBox, DRAW_WIDTH, DRAW_HEIGHT);
//
//    stage.setScene(scene);
//    stage.show();
//
//    //At this point, the an empty, white window is created.
//
//    ballSize = 20;
//    for (int i=0; i<BALL_COUNT; i++)
//    {
//      ballX[i]  = (int)(Math.random()*(DRAW_WIDTH-ballSize));
//      ballY[i]  = (int)(Math.random()*(DRAW_HEIGHT-ballSize));
//      speedX[i] = (int)(Math.random()*10 - 5);
//      speedY[i] = (int)(Math.random()*10 - 5);
//    }
//
//
//
//    //Now, we create an new AnimationTimer and start it running.
//    //  this will tell JavaFX to call the AnimationTimer's handle method
//    //  at a rate of 60 times per second.
//    //Each time the handle method is called, a new image can be drawn.
//    //Each new image is called a "frame". Thus, this will **attempt** to
//    //  draw at 60 frames per second (fps).
//    myAnimation = new Animation();
//    myAnimation.start();
//  }
//
//
//  //===========================================================================================
//  // Animation is an inner class of our JavafxRandomBox class.
//  // Animation is an "inner class" because it is inside the JavafxRandomBox class.
//  // Since Animation extends AnimationTimer, the Animation class MUST implement
//  //   public void handle(long now), a callback method that is called by JavaFX at 60Hz.
//  //===========================================================================================
//  class Animation extends AnimationTimer
//  {
//    @Override
//    //=========================================================================================
//    //handel is a callback method called by JavaFX at 60Hz.
//    //  Try printing the value of the parameter now. Can you guess what it is?
//    //  Why is it a long?
//    //  Note: printing to the console (System.out.println()) is a relatively slow task.
//    //        Thus, while it can be instructive to call
//    //          System.out.println("JavafxRandomBox.Animaton.handle() now="+now);
//    //        in this callback, remember that JavaFX is calling it at 60Hz.
//    //        Therefore, if you leave that print statement in handle, it will slow down the
//    //        program.
//    //=========================================================================================
//    public void handle(long now)
//    {
//      //JavaFX defines colors using RGB color space.
//      //  The red, green and blue values each must be in the range [0,1] where
//      //  0 is totally off, 1 is full brightness, 0.5 is half brightness, ...
//
//      gtx.setFill(Color.DEEPSKYBLUE);
//      //gtx.fillRect(left, top, width, height) will fill an axis-aligned rectangular
//      //    area with the current fill color. The rectangle is defined by the 4
//      //   parameters:
//      //         left  (x-coordinate in pixels of the left corner of the rectangle).
//      //         top   (y-coordinate in pixels of the top corner of the rectangle).
//      //         width (width in pixels of the rectangle).
//      //         height (height in pixels of the rectangle).
//      gtx.fillRect(0, 0, DRAW_WIDTH, DRAW_HEIGHT);
//
//
//      //ball collide with walls
//      for (int i=0; i<BALL_COUNT; i++)
//      {
//        if (i==0) gtx.setFill(Color.DEEPPINK);
//        else gtx.setFill(Color.DARKOLIVEGREEN);
//
//        gtx.fillRect(ballX[i], ballY[i], ballSize, ballSize);
//        ballX[i] = ballX[i] + speedX[i];
//        ballY[i] = ballY[i] + speedY[i];
//
//        if (ballX[i] < 0) speedX[i] = (int)(Math.random()*5 +1);
//        if (ballY[i] < 0) speedY[i] = (int)(Math.random()*5 +1);
//
//
//        if (ballX[i] > DRAW_WIDTH-ballSize)  speedX[i] = -(int)(Math.random()*5 +1);
//        if (ballY[i] > DRAW_HEIGHT-ballSize) speedY[i] = -(int)(Math.random()*5 +1);
//      }
//
//
//
//      //Balls collide with each other
//      for (int k=0; k<BALL_COUNT; k++)
//      {
//        for (int i=k+1; i<BALL_COUNT; i++)
//        {
//
//          //***********
//          //*         *      ****
//          //***********      *  *
//          //                 ****
//          if (isCollision(k,i))
//          {
//            int centerX0 = ballX[k]+ballSize/2;
//            int centerY0 = ballY[k]+ballSize/2;
//
//            int centerXi = ballX[i]+ballSize/2;
//            int centerYi = ballY[i]+ballSize/2;
//
//            if (centerX0 < centerXi)
//            {
//              speedX[k] = -((int)(Math.random()*5)+1);
//              speedX[i] = (int)(Math.random()*5)+1;
//            }
//            else
//            { speedX[k] = (int)(Math.random()*5)+1;
//              speedX[i] = -((int)(Math.random()*5)+1);
//            }
//
//            if (centerY0 < centerYi)
//            {
//              speedY[k] = -((int)(Math.random()*5)+1);
//              speedY[i] = (int)(Math.random()*5)+1;
//            }
//            else
//            { speedY[k] = (int)(Math.random()*5)+1;
//              speedY[i] = -((int)(Math.random()*5)+1);
//            }
//          }
//        }
//      }
//    }
//  } //This bracket ends Animation, the inner class.
//
//
//  public boolean isCollision(int k, int i)
//  {
//    //is ball i totally above ball k?
//    if (ballY[k] > ballY[i] + ballSize) return false;
//    if (ballY[k]+ballSize < ballY[i]) return false;
//    if (ballX[k] > ballX[i] + ballSize) return false;
//    if (ballX[k]+ballSize < ballX[i]) return false;
//    return true;
//  }
//
//
//  //===========================================================================================
//  // Every Java program must have public static void main(String[] args).
//  // In a JavaFX program, main starts JavaFX by calling:
//  //     javafx.application.Application.launch(String[] args)
//  //===========================================================================================
//  public static void main(String[] args)
//  {
//    launch(args);
//  }
//}
//
//
//
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CGTemplate extends JPanel {

    private static final int FRAME_WIDTH = 0;
    private static final int RECT_WIDTH = 0;
    private static final int FRAME_HEIGHT = 0;

    /*
     * JFrame is a top level container (window) where we would be adding our
     * button
     */
    

    /*
     * This method specifies the location and size of button. In method
     * setBounds(x, y, width, height) x,y) are cordinates from the top left
     * corner and remaining two arguments are the width and height of the
     * button.
     */
    public static void draw() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        // Creating Button
        JButton b = new JButton("Click Me..");
        JButton b1 = new JButton("Test");
        b.setBounds(50, 50, 90, 50);

        // Adding button onto the frame
        frame.add(b);

        // Setting Frame size. This is the window size
        frame.setSize(300, 200);
        // Grid Layout side by side
        frame.setLayout(new GridLayout(1, 2));
        // make the frame visible
        frame.setVisible(true);
        // add panels on top of frame
        frame.add(panel);
        frame.add(panel1);
        // add buttons to left and right frame
        panel.add(b1);
        panel.setBackground(Color.BLUE);
        panel1.add(b);
        

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paintComponent(Graphics g) {
        
        JPanel panel = new JPanel();
        super.paintComponent(g);
        
        g.drawOval(60, 60, 200, 200);
        g.fillOval(90, 120, 50, 20);
        g.fillOval(190, 120, 50, 20);
        g.drawLine(165, 125, 165, 175);
        g.drawArc(110, 130, 95, 95, 0, -180);
        
        

    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Title");
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CGTemplate d = new CGTemplate();

        f.add(d);
        f.setVisible(true);
        draw();
    }
}