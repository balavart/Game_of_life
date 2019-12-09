package gui.buttons;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Button "Stop" for JPanel Buttons.
 *
 * @see ButtonsMenuBar
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class StopButton extends JButton {

  /** initial visibility. */
  public StopButton() {
    setEnabled(false);
  }

  @Override
  public String getText() {
    return "Stop";
  }

  @Override
  public Color getBackground() {
    return new Color(188, 143, 143);
  }
}
