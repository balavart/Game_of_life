package gamelogic;

import static gamelogic.Specification.BUTTON_PANEL_HEIGHT;
import static gamelogic.Specification.FIELD_SIZE;
import static gamelogic.Specification.LIFE_SIZE;
import static gamelogic.Specification.NAME_OF_GAME;
import static gamelogic.Specification.lifeGeneration;
import static gamelogic.Specification.nextGeneration;
import static gamelogic.Specification.timeDelay;

import gui.Canvas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
public class Life {

  volatile boolean goNextGeneration = false;

  Canvas canvasPanel;

  public Life() {
    JFrame frame = new JFrame(NAME_OF_GAME);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(FIELD_SIZE, FIELD_SIZE + BUTTON_PANEL_HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

    canvasPanel = new Canvas();
    canvasPanel.setBackground(Color.pink);

    final JButton startButton = new JButton("Start");
    final JButton stopButton = new JButton("Stop");
    stopButton.setEnabled(false);
    final JButton clearButton = new JButton("Clear");

    startButton.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            startButton.setEnabled(false);
            clearButton.setEnabled(false);
            stopButton.setEnabled(true);
            if (isEmpty()) {
              goNextGeneration = !goNextGeneration;
              startButton.setText("Running");
              for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                  lifeGeneration[x][y] = (Math.random()) * 100 < 8;
                }
              }
            } else {
              goNextGeneration = !goNextGeneration;
              startButton.setText("Running");
              for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                  lifeGeneration[x][y] = nextGeneration[x][y];
                }
              }
            }
            canvasPanel.repaint();
          }
        });

    stopButton.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            goNextGeneration = !goNextGeneration;
            stopButton.setEnabled(false);
            startButton.setEnabled(true);
            startButton.setText("Start");
            clearButton.setEnabled(true);

            canvasPanel.repaint();
          }
        });

    clearButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            clearButton.setEnabled(true);
            for (int x = 0; x < LIFE_SIZE; x++) {
              for (int y = 0; y < LIFE_SIZE; y++) {
                lifeGeneration[x][y] = false;
              }
            }
            canvasPanel.repaint();
          }
        });

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(startButton);
    buttonsPanel.add(stopButton);
    buttonsPanel.add(clearButton);

    frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
    frame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);

    // бесконечная петля жизни
    while (true) {
      if (goNextGeneration) {
        processOfLife();
        canvasPanel.repaint();
        try {
          Thread.sleep(timeDelay);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  // посчитать количество соседей
  int countNeighbors(int x, int y) {
    int count = 0;
    for (int dx = -1; dx < 2; dx++) {
      for (int dy = -1; dy < 2; dy++) {
        int nX = x + dx;
        int nY = y + dy;
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

  // основной процесс жизни
  void processOfLife() {
    for (int x = 0; x < LIFE_SIZE; x++) {
      for (int y = 0; y < LIFE_SIZE; y++) {
        int count = countNeighbors(x, y);
        nextGeneration[x][y] = lifeGeneration[x][y];
        // если 3 пустых соседа вокруг пустых клеток - клетка становится живой
        nextGeneration[x][y] = (count == 3) ? true : nextGeneration[x][y];
        // если ячейка имеет менее 2 или более 3 соседей - она умрет
        nextGeneration[x][y] = ((count < 2) || (count > 4)) ? false : nextGeneration[x][y];
      }
    }
    for (int x = 0; x < LIFE_SIZE; x++) {
      System.arraycopy(nextGeneration[x], 0, lifeGeneration[x], 0, LIFE_SIZE);
    }
  }

  // проверка на жизнь
  boolean isEmpty() {
    for (int i = 0; i < LIFE_SIZE; i++) {
      for (int j = 0; j < LIFE_SIZE; j++) {
        if (lifeGeneration[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}
