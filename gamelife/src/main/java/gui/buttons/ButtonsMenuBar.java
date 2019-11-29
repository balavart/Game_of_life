package gui.buttons;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 25.11.2019
 */
public class ButtonsMenuBar extends JPanel {
  private JButton startButton;
  private JButton stopButton;
  private JButton clearButton;

  public ButtonsMenuBar() {
    startButton = new StartButton();
    stopButton = new StopButton();
    clearButton = new ClearButton();
    add(startButton);
    add(stopButton);
    add(clearButton);
  }

  public JButton getStartButton() {
    return startButton;
  }

  public JButton getStopButton() {
    return stopButton;
  }

  public JButton getClearButton() {
    return clearButton;
  }

  @Override
  public Color getBackground() {
    return Color.WHITE;
  }
}
