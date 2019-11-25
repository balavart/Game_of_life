package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 25.11.2019
 */
public class GameWindow extends JFrame {
  private GameFrame frame;
  private ButtonsMenuBar buttonsPanel;
  private Canvas canvas;

  public GameWindow(GameFrame gameFrame, ButtonsMenuBar buttonsPanel, Canvas canvas) {
    this.frame = gameFrame;
    this.buttonsPanel = buttonsPanel;
    this.canvas = canvas;

    frame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
    frame.getContentPane().add(BorderLayout.CENTER, canvas);

    startEndlessLifeSpan();
  }

  // бесконечная петля жизни
  public void startEndlessLifeSpan() {
    while (true) {
      if (Specification.goNextGeneration) {
        lifeProcess();
        canvas.repaint();
        try {
          Thread.sleep(300);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  // посчитать количество соседей
  public int countNeighbors(int x, int y) {
    int count = 0;
    for (int dx = -1; dx < 2; dx++) {
      for (int dy = -1; dy < 2; dy++) {
        int nX = x + dx;
        int nY = y + dy;
        nX = (nX < 0) ? Specification.lifeSize - 1 : nX;
        nY = (nY < 0) ? Specification.lifeSize - 1 : nY;
        nX = (nX > Specification.lifeSize - 1) ? 0 : nX;
        nY = (nY > Specification.lifeSize - 1) ? 0 : nY;
        count += (Specification.lifeGeneration[nX][nY]) ? 1 : 0;
      }
    }
    if (Specification.lifeGeneration[x][y]) {
      count--;
    }
    return count;
  }

  // основной процесс жизни
  public void lifeProcess() {
    for (int x = 0; x < Specification.lifeSize; x++) {
      for (int y = 0; y < Specification.lifeSize; y++) {
        int count = countNeighbors(x, y);
        Specification.nextGeneration[x][y] = Specification.lifeGeneration[x][y];
        // если 3 пустых соседа вокруг пустых клеток - клетка становится живой
        Specification.nextGeneration[x][y] = (count == 3) ? true : Specification.nextGeneration[x][y];
        // если ячейка имеет менее 2 или более 3 соседей - она умрет
        Specification.nextGeneration[x][y] = ((count < 2) || (count > 4)) ? false : Specification.nextGeneration[x][y];
      }
    }
    for (int x = 0; x < Specification.lifeSize; x++) {
      System.arraycopy(Specification.nextGeneration[x], 0, Specification.lifeGeneration[x], 0, Specification.lifeSize);
    }
  }
}
