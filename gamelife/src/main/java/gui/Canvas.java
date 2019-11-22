package gui;

import static gamelogic.Specification.LIFE_SIZE;
import static gamelogic.Specification.SHAPE_RADIUS;
import static gamelogic.Specification.lifeGeneration;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/21/2019
 */
// paint on the canvas
public class Canvas extends JPanel {
  //   Graphics g;

  //  public Canvas() {
  //    this.g = g;
  //    addMouseListener(
  //        new MouseAdapter() {
  //          @Override
  //          public void mouseClicked(MouseEvent e) {
  //            super.mouseClicked(e);
  //            System.out.println(e.getX() + " " + e.getY());
  //            g.fillOval(
  //                e.getX() * SHAPE_RADIUS, e.getY() * SHAPE_RADIUS, SHAPE_RADIUS, SHAPE_RADIUS);
  //          }
  //        });
  //  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.MAGENTA);
    for (int x = 0; x < LIFE_SIZE; x++) {
      for (int y = 0; y < LIFE_SIZE; y++) {
        if (lifeGeneration[x][y]) {
          g.fillRect(x * SHAPE_RADIUS, y * SHAPE_RADIUS, SHAPE_RADIUS, SHAPE_RADIUS);
        }
      }
    }
  }
}
