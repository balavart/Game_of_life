package gui.buttons;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Button "Start" for JPanel Buttons.
 *
 * @see ButtonsMenuBar
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class StartButton extends JButton {

  public StartButton() {
    super("Start");
  }

  @Override
  public Color getBackground() {
    return Color.GREEN;
  }
}
