import gui.Canvas;
import gui.GameFrame;
import gui.buttons.ButtonsMenuBar;
import gui.controller.GameWindow;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/20/2019
 */
public class Main {
  public static void main(String[] args) {

    GameFrame frame = new GameFrame();
    Canvas canvas = new Canvas();
    ButtonsMenuBar buttonsMenuBar = new ButtonsMenuBar(canvas);

    GameWindow window = new GameWindow(frame, buttonsMenuBar, canvas);
    window.startButtonActionListeners();
    window.startEndlessLifeSpan();
  }
}
