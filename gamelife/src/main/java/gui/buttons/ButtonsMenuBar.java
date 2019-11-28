package gui.buttons;

import gui.Canvas;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 25.11.2019
 */
public class ButtonsMenuBar extends JPanel {
  JButton startButton;
  JButton stopButton;
  JButton clearButton;
  Canvas canvas;

  public ButtonsMenuBar(Canvas canvas) {
    startButton = new StartButton();
    stopButton = new StopButton();
    clearButton = new ClearButton();
    this.canvas = canvas;

    this.add(startButton);
    this.add(stopButton);
    this.add(clearButton);
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
}
