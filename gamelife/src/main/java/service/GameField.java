package service;

/**
 * Core logic service.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/26/2019
 */
public class GameField {

  private final int lifeSize = 50;
  private volatile boolean[][] lifeGeneration = new boolean[lifeSize][lifeSize];
  private volatile boolean[][] nextGeneration = new boolean[lifeSize][lifeSize];
  private int shapeFullness;
  private int shapeScale;

  public int getLifeSize() {
    return lifeSize;
  }

  public synchronized boolean[][] getLifeGeneration() {
    return lifeGeneration;
  }

  public synchronized boolean[][] getNextGeneration() {
    return nextGeneration;
  }

  public boolean getShapeState(int x, int y) {
    return lifeGeneration[x][y];
  }

  public void setLifeGeneration(boolean[][] lifeGeneration) {
    this.lifeGeneration = lifeGeneration;
  }

  public void toggleLifeGeneration(int x, int y) {
    this.lifeGeneration[x][y] = !this.lifeGeneration[x][y];
  }

  public void setNextGeneration(boolean[][] nextGeneration) {
    this.nextGeneration = nextGeneration;
  }

  public void setNextGeneration(int x, int y, boolean state) {
    this.nextGeneration[x][y] = state;
  }

  public void setShapeFullness(int shapeFullness) {
    this.shapeFullness = shapeFullness;
  }

  public int getShapeScale() {
    return shapeScale;
  }

  public void setShapeScale(int shapeScale) {
    this.shapeScale = shapeScale;
  }

  /** life check. */
  public boolean isEmpty() {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        if (lifeGeneration[x][y]) {
          return false;
        }
      }
    }
    return true;
  }

  /** counting the number of neighbors. */
  public int countNeighbors(int x, int y) {
    int count = 0;
    for (int dX = -1; dX < 2; dX++) {
      for (int dY = -1; dY < 2; dY++) {
        int nX = x + dX;
        int nY = y + dY;
        nX = (nX < 0) ? lifeSize - 1 : nX;
        nY = (nY < 0) ? lifeSize - 1 : nY;
        nX = (nX > lifeSize - 1) ? 0 : nX;
        nY = (nY > lifeSize - 1) ? 0 : nY;
        count += (lifeGeneration[nX][nY]) ? 1 : 0;
      }
    }
    if (lifeGeneration[x][y]) {
      count--;
    }
    return count;
  }

  /** birth of figures. */
  public void shapesBorn() {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        int count = countNeighbors(x, y);
        getNextGeneration()[x][y] = (count == 3) || getNextGeneration()[x][y];
      }
    }
  }

  /** death of figures. */
  public void shapesDeath() {
    for (int x = 0; x < lifeSize; x++) {
      //      for (int y = 0; y < lifeSizeWidth; y++) {
      for (int y = 0; y < lifeSize; y++) {
        int count = countNeighbors(x, y);
        getNextGeneration()[x][y] = ((count >= 2) && (count <= 4)) && getNextGeneration()[x][y];
      }
    }
  }

  public void arrCopy() {
    for (int x = 0; x < lifeSize; x++) {
      System.arraycopy(getNextGeneration()[x], 0, getLifeGeneration()[x], 0, lifeSize);
    }
  }

  /** random shape filling. */
  public void fillingByShapes() {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        lifeGeneration[x][y] = (Math.random()) * 100 < shapeFullness;
      }
    }
  }

  /** cleaning figures. */
  public void shapesCleaning() {
    for (int x = 0; x < lifeSize; x++) {
      System.arraycopy(nextGeneration[x], 0, lifeGeneration[x], 0, lifeSize);
    }
  }
}
