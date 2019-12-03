package gui.buttons;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * JPanel for buttons: "Start", "Stop" and "Clear".
 *
 * @see StartButton
 * @see StopButton
 * @see ClearButton
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class ButtonsMenuBar extends JPanel {

  private JButton startButton;
  private JButton stopButton;
  private JButton clearButton;

  /** Instantiates a new Buttons menu bar. */
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
