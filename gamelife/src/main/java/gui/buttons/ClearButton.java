package gui.buttons;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Button "Clear" for JPanel Buttons.
 *
 * @see ButtonsMenuBar
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class ClearButton extends JButton {

  @Override
  public String getText() {
    return "Clear";
  }

  @Override
  public Color getBackground() {
    return new Color(192, 192, 192);
  }
}
