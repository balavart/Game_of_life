package service;

/**
 * Core logic service.
 *
 * @see GameField implemented
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/26/2019
 */
public class GameFieldImplementation implements GameField {

  private static final int LIFE_SIZE = 50;
  private volatile boolean[][] lifeGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
  private volatile boolean[][] nextGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
  private int shapeFullness;
  private int shapeScale;

  public int getLifeSize() {
    return LIFE_SIZE;
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

  @Override
  public boolean isEmpty() {
    for (int x = 0; x < LIFE_SIZE; x++) {
      for (int y = 0; y < LIFE_SIZE; y++) {
        if (lifeGeneration[x][y]) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  @SuppressWarnings("CheckStyle")
  public int countNeighbors(int x, int y) {
    int count = 0;
    for (int dX = -1; dX < 2; dX++) {
      for (int dY = -1; dY < 2; dY++) {
        int nX = x + dX;
        int nY = y + dY;
        nX = (nX < 0) ? LIFE_SIZE - 1 : nX;
        nY = (nY < 0) ? LIFE_SIZE - 1 : nY;
        nX = (nX > LIFE_SIZE - 1) ? 0 : nX;
        nY = (nY > LIFE_SIZE - 1) ? 0 : nY;
        count += (lifeGeneration[nX][nY]) ? 1 : 0;
      }
    }
    if (lifeGeneration[x][y]) {
      count--;
    }
    return count;
  }

  @Override
  public boolean[][] shapesBorn() {
    for (int x = 0; x < LIFE_SIZE; x++) {
      for (int y = 0; y < LIFE_SIZE; y++) {
        int count = countNeighbors(x, y);
        getNextGeneration()[x][y] = (count == 3) || getNextGeneration()[x][y];
      }
    }
    return getNextGeneration();
  }

  @Override
  public boolean[][] shapesDeath() {
    for (int x = 0; x < LIFE_SIZE; x++) {
      for (int y = 0; y < LIFE_SIZE; y++) {
        int count = countNeighbors(x, y);
        getNextGeneration()[x][y] = ((count >= 2) && (count <= 4)) && getNextGeneration()[x][y];
      }
    }
    return getNextGeneration();
  }

  @Override
  public void randomFillingByShapes() {
    for (int x = 0; x < LIFE_SIZE; x++) {
      for (int y = 0; y < LIFE_SIZE; y++) {
        lifeGeneration[x][y] = (Math.random()) * 100 < shapeFullness;
      }
    }
  }

  @Override
  public boolean[][] shapesCleaning() {
    for (int x = 0; x < LIFE_SIZE; x++) {
      System.arraycopy(nextGeneration[x], 0, lifeGeneration[x], 0, LIFE_SIZE);
    }
    return nextGeneration;
  }
}
