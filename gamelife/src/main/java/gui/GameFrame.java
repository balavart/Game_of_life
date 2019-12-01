package gui;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * JFrame for storing other gui components.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class GameFrame extends JFrame {

  private final String gameName = "Game of Life";

  public GameFrame() throws HeadlessException {
    setVisible(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public String getTitle() {
    return gameName;
  }
}
