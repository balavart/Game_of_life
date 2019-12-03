package service;

import controller.GameFrameController;
import gui.Canvas;
import gui.GameFrame;
import gui.SettingsFrame;
import gui.buttons.ButtonsMenuBar;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Service for linking objects and starting threads.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/28/2019
 */
public class ThreadService {

  private GameFrame gameFrame = new GameFrame();
  private SettingsFrame settingsFrame = new SettingsFrame(gameFrame);
  private Canvas canvas = new Canvas();
  private ButtonsMenuBar buttonsMenuBar = new ButtonsMenuBar();
  private GameFrameController controller =
      new GameFrameController(settingsFrame, gameFrame, buttonsMenuBar, canvas);
  private ExecutorService executorService = Executors.newFixedThreadPool(3);
  private LifeThread lifeThread = new LifeThread(controller.getGameField());
  private DeathThread deathThread = new DeathThread(controller.getGameField());
  private DisplayThread displayThread = new DisplayThread(canvas);

  private static final int TIME_DELAY = 100;

  /** Start threads. */
  public void startThreads() {
    //noinspection InfiniteLoopStatement
    while (true) {
      try {
        while (!controller.isGoNextGeneration()) {
          Thread.sleep(TIME_DELAY);
        }
        executorService.invokeAll(Arrays.asList(lifeThread, deathThread));
        executorService.invokeAll(Collections.singletonList(displayThread));
        canvas.repaint();
        Thread.sleep(TIME_DELAY);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
