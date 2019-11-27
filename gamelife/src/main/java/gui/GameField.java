package gui;

import static config.Specification.SHAPE_FULLNESS;
import static config.Specification.lifeSize;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/26/2019
 */
public class GameField {

  private boolean[][] lifeGeneration = new boolean[lifeSize][lifeSize];
  private boolean[][] nextGeneration = new boolean[lifeSize][lifeSize];


  public boolean[][] getLifeGeneration() {
    return lifeGeneration;
  }

  public void setLifeGeneration(boolean[][] lifeGeneration) {
    this.lifeGeneration = lifeGeneration;
  }

  public void setNullLifeGeneration(int x, int y, boolean[][] lifeGeneration) {
    this.lifeGeneration[x][y] = !lifeGeneration[x][y];
  }

  public void setNextGeneration(int x, int y, boolean[][] generation) {
    this.nextGeneration[x][y] = generation[x][y];
  }

  public void setNextGeneration(boolean[][] nextGeneration) {
    this.nextGeneration = nextGeneration;
  }

  public void setLifeGeneration(int x, int y, boolean state) {
    this.lifeGeneration[x][y] = state;
  }

  public void setNextGeneration(int x, int y, boolean state) {
    this.nextGeneration[x][y] = state;
  }

  // проверка на жизнь
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

  // посчитать количество соседей
  public int countNeighbors(int x, int y) {
    int count = 0;
    for (int dx = -1; dx < 2; dx++) {
      for (int dy = -1; dy < 2; dy++) {
        int nX = x + dx;
        int nY = y + dy;
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

  // основной процесс жизни
  public void lifeProcess() {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        int count = countNeighbors(x, y);
        // nextGeneration[x][y] = lifeGeneration[x][y];
        // если 3 пустых соседа вокруг пустых клеток - клетка становится живой
        nextGeneration[x][y] = (count == 3) || nextGeneration[x][y];
        // если ячейка имеет менее 2 или более 3 соседей - она умрет
        nextGeneration[x][y] = ((count >= 2) && (count <= 4)) && nextGeneration[x][y];
      }
    }
    for (int x = 0; x < lifeSize; x++) {
      System.arraycopy(nextGeneration[x], 0, lifeGeneration[x], 0, lifeSize);
    }
  }

  // рождение фигур
  public void shapesBorn() {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        int count = countNeighbors(x, y);
        // если 3 пустых соседа вокруг пустых клеток - клетка становится живой
        nextGeneration[x][y] = (count == 3) || nextGeneration[x][y];
      }
    }
    for (int x = 0; x < lifeSize; x++) {
      System.arraycopy(nextGeneration[x], 0, lifeGeneration[x], 0, lifeSize);
    }
  }

  // смерть фигур
  public void shapesDeath() {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        int count = countNeighbors(x, y);
        // если 3 пустых соседа вокруг пустых клеток - клетка становится живой
        nextGeneration[x][y] = ((count >= 2) && (count <= 4)) && nextGeneration[x][y];
      }
    }
    for (int x = 0; x < lifeSize; x++) {
      System.arraycopy(nextGeneration[x], 0, lifeGeneration[x], 0, lifeSize);
    }
  }

  // для выбора методов жизни или смерти
  public synchronized void shapeStateChoice(String stateName) {
    if (stateName.equals("Life")) {
      shapesBorn();
    }
    if(stateName.equals("Death")) {
      shapesDeath();
    }
  }

  // рандомное заполнение фигурами
  public void fillingByShapes() {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        lifeGeneration[x][y] = (Math.random()) * 100 < SHAPE_FULLNESS;
      }
    }
  }

  // очистка фигур
  public void shapesCleaning() {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        lifeGeneration[x][y] = nextGeneration[x][y];
      }
    }
  }
}
