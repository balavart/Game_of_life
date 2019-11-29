package gui;

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
  //  private final int fieldSize = lifeSize * SHAPE_RADIUS;
  int width = 500;
  int height = 500;

  public GameFrame() throws HeadlessException {
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    setSize(fieldSize, fieldSize + buttonPanelHeight);
    setSize(width, height);
    setLocationRelativeTo(null);
    setResizable(false);
  }

  @Override
  public String getTitle() {
    return gameName;
  }
}
