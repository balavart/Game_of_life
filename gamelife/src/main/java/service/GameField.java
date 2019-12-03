package service;

/**
 * The interface Game field.
 *
 * @see GameFieldImplementation implements
 * @author Vardan Balayan
 * @version 1.8
 * @created 12/3/2019
 */
public interface GameField {

  /** life check. */
  boolean isEmpty();

  /** counting the number of neighbors. */
  int countNeighbors(int x, int y);

  /** birth of shapes. */
  boolean[][] shapesBorn();

  /** death of shapes. */
  boolean[][] shapesDeath();

  /** random shape filling. */
  void randomFillingByShapes();

  /** cleaning shapes. */
  boolean[][] shapesCleaning();
}
