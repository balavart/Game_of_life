package gui;

import static gamelogic.Specification.LIFE_SIZE;
import static gamelogic.Specification.SHAPE_RADIUS;
import static gamelogic.Specification.lifeGeneration;

import gamelogic.Life;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.scene.input.MouseButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
// paint on the canvas
public class Canvas extends JPanel {

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.MAGENTA);

    for (int x = 0; x < LIFE_SIZE; x++) {
      for (int y = 0; y < LIFE_SIZE; y++) {
        if (lifeGeneration[x][y]) {
          g.fillOval(x * SHAPE_RADIUS, y * SHAPE_RADIUS, SHAPE_RADIUS, SHAPE_RADIUS);
        }
      }
    }
  }
}
