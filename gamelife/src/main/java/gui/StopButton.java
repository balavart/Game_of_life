package gui;

import java.awt.Color;
import javax.swing.JButton;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class StopButton extends JButton {

  @Override
  public String getText() {
    return "Stop";
  }

  @Override
  public Color getBackground() {
    return Color.RED;
  }
}