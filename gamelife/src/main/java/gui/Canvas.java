package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import service.GameFieldImplementation;

/**
 * JPanel for drawing shapes.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
public class Canvas extends JPanel {

  private GameFieldImplementation gameFieldImplementation;

  /** assigns action to mouse click. */
  public Canvas() {
    this.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            int x = e.getX() / gameFieldImplementation.getShapeScale();
            int y = e.getY() / gameFieldImplementation.getShapeScale();
            gameFieldImplementation.toggleLifeGeneration(x, y);
            gameFieldImplementation.setNextGeneration(
                x, y, gameFieldImplementation.getShapeState(x, y));
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
    gameFieldImplementation.shapesCleaning();
    for (int x = 0; x < gameFieldImplementation.getLifeSize(); x++) {
      for (int y = 0; y < gameFieldImplementation.getLifeSize(); y++) {
        if (gameFieldImplementation.getLifeGeneration()[x][y]) {
          g.fillOval(
              x * gameFieldImplementation.getShapeScale(),
              y * gameFieldImplementation.getShapeScale(),
              gameFieldImplementation.getShapeScale(),
              gameFieldImplementation.getShapeScale());
        }
      }
    }
  }

  public void setGameFieldImplementation(GameFieldImplementation gameFieldImplementation) {
    this.gameFieldImplementation = gameFieldImplementation;
  }
}
