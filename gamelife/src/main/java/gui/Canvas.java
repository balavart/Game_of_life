package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import service.GameField;

/**
 * JPanel for drawing shapes.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
public class Canvas extends JPanel {

  private GameField gameField;

  /** assigns action to mouse click. */
  public Canvas() {
    this.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            int x = e.getX() / gameField.getShapeScale();
            int y = e.getY() / gameField.getShapeScale();
            gameField.toggleLifeGeneration(x, y);
            gameField.setNextGeneration(x, y, gameField.getShapeState(x, y));
            repaint();
          }
        });
  }

  @Override
  public Color getBackground() {
    return new Color(222, 184, 135);
  }

  /** drawing shapes. */
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(new Color(139, 69, 19));
    gameField.shapesCleaning();
    for (int x = 0; x < gameField.getLifeSize(); x++) {
      for (int y = 0; y < gameField.getLifeSize(); y++) {
        if (gameField.getLifeGeneration()[x][y]) {
          g.fillOval(
              x * gameField.getShapeScale(),
              y * gameField.getShapeScale(),
              gameField.getShapeScale(),
              gameField.getShapeScale());
        }
      }
    }
  }

  public void setGameField(GameField gameField) {
    this.gameField = gameField;
  }
}
