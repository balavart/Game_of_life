package config;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
public class Specification {
  public static int lifeSize = 50;
  public static int shapeRadius = 10;
  public static final int FIELD_SIZE = lifeSize * shapeRadius;
  public static volatile boolean goNextGeneration = false;
  public static final int SHAPE_FULLNESS = 10;

}
