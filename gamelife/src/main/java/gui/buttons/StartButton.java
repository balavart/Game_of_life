package gui.buttons;

import java.awt.Color;
import javax.swing.JButton;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class StartButton extends JButton {

  private static final String TEXT[] = {"Start", "Running"};

  public StartButton() {
    super(TEXT[0]);
  }

  @Override
  public Color getBackground() {
    return Color.GREEN;
  }

  public void setStartText() {
    setText(TEXT[0]);
  }

  public void setRunningText() {
    setText(TEXT[1]);
  }
}
