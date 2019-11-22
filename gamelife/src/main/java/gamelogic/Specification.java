package gamelogic;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
public class Specification {
  public static final String NAME_OF_GAME = "Game of Life";
  public static final int LIFE_SIZE = 50;
  public static final int SHAPE_RADIUS = 10;
  public static final int FIELD_SIZE = LIFE_SIZE * SHAPE_RADIUS;
  public static final int BUTTON_PANEL_HEIGHT = 50;
  public static boolean[][] lifeGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
  public static boolean[][] nextGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
  public static int timeDelay = 300;
}
