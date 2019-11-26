package gui;

import static config.Specification.lifeSize;

import config.Specification;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
// paint on the canvas
public class Canvas extends JPanel {

  private GameField gameField;

  // todo: перенести mouseListener в отдельный класс
  public Canvas() {
    this.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            coordinateAssignment(e);
          }
        });
  }

  @Override
  public Color getBackground() {
    return Color.PINK;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.RED);
    paintShapes(g);
  }

  public void setGameField(GameField gameField) {
    this.gameField = gameField;
  }

  // todo: перенести в сервис отрисовки
  // клик создания фигуры
  public void coordinateAssignment(MouseEvent e) {
    if (Specification.goNextGeneration) {
      return;
    }
    int x = e.getX() / Specification.shapeRadius;
    int y = e.getY() / Specification.shapeRadius;
    gameField.setLifeGeneration(x, y, true);
    gameField.setNextGeneration(x, y, true);

    repaint();
  }

  // todo: перенести в сервис отрисовки
  // рисование на конвасе
  public void paintShapes(Graphics g) {
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        if (gameField.getLifeGeneration()[x][y]) {
          g.fillOval(
              x * Specification.shapeRadius,
              y * Specification.shapeRadius,
              Specification.shapeRadius,
              Specification.shapeRadius);
        }
      }
    }
  }
}
