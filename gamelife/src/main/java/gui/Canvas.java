package gui;

import static config.Specification.SHAPE_RADIUS;
import static config.Specification.lifeSize;

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

  public Canvas() {
    this.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            int x = e.getX() / SHAPE_RADIUS;
            int y = e.getY() / SHAPE_RADIUS;
            gameField.toggleLifeGeneration(x, y);
            gameField.setNextGeneration(x, y, gameField.getShapeState(x, y));
            repaint();
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
    for (int x = 0; x < lifeSize; x++) {
      for (int y = 0; y < lifeSize; y++) {
        if (gameField.getLifeGeneration()[x][y]) {
          g.fillOval(x * SHAPE_RADIUS, y * SHAPE_RADIUS, SHAPE_RADIUS, SHAPE_RADIUS);
        }
      }
    }
  }

  public void setGameField(GameField gameField) {
    this.gameField = gameField;
  }
}
