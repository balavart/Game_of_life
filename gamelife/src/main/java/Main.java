import gui.ButtonsMenuBar;
import gui.Canvas;
import gui.ClearButton;
import gui.GameFrame;
import gui.GameWindow;
import gui.StartButton;
import gui.StopButton;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/20/2019
 */
public class Main {
  public static void main(String[] args) {

    GameFrame frame = new GameFrame();
    Canvas canvas = new Canvas();
    StartButton startButton = new StartButton();
    StopButton stopButton = new StopButton();
    ClearButton clearButton = new ClearButton();
    ButtonsMenuBar buttonsMenuBar =
        new ButtonsMenuBar(startButton, stopButton, clearButton, canvas);
    GameWindow window = new GameWindow(frame, buttonsMenuBar, canvas);
  }
}
