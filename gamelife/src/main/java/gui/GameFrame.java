package gui;

import config.Specification;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class GameFrame extends JFrame {

  private final String GAME_NAME = "Game of Life";
  private final int BUTTON_PANEL_HEIGHT = 50;

  public GameFrame() throws HeadlessException {
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(Specification.FIELD_SIZE, Specification.FIELD_SIZE + BUTTON_PANEL_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
  }

  @Override
  public String getTitle() {
    return GAME_NAME;
  }
}
