package gui;

import static config.Specification.SHAPE_RADIUS;
import static config.Specification.lifeSize;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class GameFrame extends JFrame {
  private final String gameName = "Game of Life";
  private final int buttonPanelHeight = 50;
  private final int fieldSize = lifeSize * SHAPE_RADIUS;

  public GameFrame() throws HeadlessException {
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(fieldSize, fieldSize + buttonPanelHeight);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
  }

  @Override
  public String getTitle() {
    return gameName;
  }
}
