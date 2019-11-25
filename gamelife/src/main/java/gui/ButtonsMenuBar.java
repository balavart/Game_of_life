package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 25.11.2019
 */
public class ButtonsMenuBar extends JPanel {

  JButton startButton;
  JButton stopButton;
  JButton clearButton;
  Canvas canvas;

  private boolean disabled = false;

  public ButtonsMenuBar(
      JButton firstButton, JButton secondButton, JButton thirdButton, Canvas canvas) {
    startButton = firstButton;
    stopButton = secondButton;
    clearButton = thirdButton;
    this.canvas = canvas;

    this.add(startButton);
    this.add(stopButton);
    this.add(clearButton);
    startButtonAction();
    stopButtonAction();
    clearButtonAction();
  }

  private void startButtonAction() {
    startButton.addActionListener(
        e -> {
          startButton.setEnabled(disabled);
          stopButton.setEnabled(!disabled);
          clearButton.setEnabled(disabled);
          if (isEmpty()) {
            Specification.goNextGeneration = !Specification.goNextGeneration;
            startButton.setText("Running");
            fillingByShapes();
          } else {
            Specification.goNextGeneration = !Specification.goNextGeneration;
            startButton.setText("Running");
            shapesCleaning();
          }
          canvas.repaint();
        });
  }

  private void stopButtonAction() {
    stopButton.addActionListener(
        e -> {
          Specification.goNextGeneration = !Specification.goNextGeneration;
          stopButton.setEnabled(disabled);
          startButton.setText("Start");
          startButton.setEnabled(!disabled);
          clearButton.setEnabled(!disabled);

          canvas.repaint();
        });
  }

  private void clearButtonAction() {
    clearButton.addActionListener(
        e -> {
          clearButton.setEnabled(!disabled);
          startButton.setEnabled(!disabled);
          stopButton.setEnabled(disabled);

          Specification.lifeGeneration = new boolean[Specification.lifeSize][Specification.lifeSize];

          canvas.repaint();
        });
  }

  // проверка на жизнь
  public boolean isEmpty() {
    for (int x = 0; x < Specification.lifeSize; x++) {
      for (int y = 0; y < Specification.lifeSize; y++) {
        if (Specification.lifeGeneration[x][y]) {
          return false;
        }
      }
    }
    return true;
  }

  // рандомное заполнение фигурами
  public void fillingByShapes() {
    for (int x = 0; x < Specification.lifeSize; x++) {
      for (int y = 0; y < Specification.lifeSize; y++) {
        Specification.lifeGeneration[x][y] = (Math.random()) * 100 < Specification.shapeFullness;
      }
    }
  }

  // очистка фигур
  public void shapesCleaning() {
    for (int x = 0; x < Specification.lifeSize; x++) {
      for (int y = 0; y < Specification.lifeSize; y++) {
        Specification.lifeGeneration[x][y] = Specification.nextGeneration[x][y];
      }
    }
  }
}
