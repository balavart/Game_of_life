import static java.lang.Thread.sleep;

import gui.Canvas;
import gui.GameField;
import gui.GameFrame;
import gui.buttons.ButtonsMenuBar;
import gui.controller.GameWindow;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import threads.DeathThread;
import threads.DisplayThread;
import threads.LifeThread;

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
    window.getGameField().fillingByShapes();

    // window.startEndlessLifeSpan();

    boolean pause = false;
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    LifeThread lifeThread = new LifeThread(window.getGameField());
    DeathThread deathThread = new DeathThread(window.getGameField());
    DisplayThread displayThread = new DisplayThread(canvas);
    try {
      while (true) {

        while (pause) {
          sleep(1000);
        }
        executorService.invokeAll(Arrays.asList(lifeThread, deathThread));
        executorService.invokeAll(Arrays.asList(displayThread));
        canvas.repaint();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
