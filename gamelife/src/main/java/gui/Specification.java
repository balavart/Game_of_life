package gui;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
public class Specification {

  public static final int lifeSize = 50;
  public static final int shapeRadius = 10;
  public static final int fieldSize = lifeSize * shapeRadius;
  public static final int timeDelay = 300;
  public static final int shapeFullness = 10;
  public static volatile boolean goNextGeneration = false;
  public static boolean[][] lifeGeneration = new boolean[lifeSize][lifeSize];
  public static boolean[][] nextGeneration = new boolean[lifeSize][lifeSize];
}
