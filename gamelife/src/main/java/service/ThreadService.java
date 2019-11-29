package service;

import config.Specification;
import controller.GameFrameController;
import gui.Canvas;
import gui.GameFrame;
import gui.buttons.ButtonsMenuBar;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/28/2019
 */
public class ThreadService {
  // todo: убрать отсюда
  private GameFrame frame = new GameFrame();
  private Canvas canvas = new Canvas();
  private ButtonsMenuBar buttonsMenuBar = new ButtonsMenuBar();
  private GameFrameController controller = new GameFrameController(frame, buttonsMenuBar, canvas);
  private ExecutorService executorService = Executors.newFixedThreadPool(3);
  private LifeThread lifeThread = new LifeThread(controller.getGameField());
  private DeathThread deathThread = new DeathThread(controller.getGameField());
  private DisplayThread displayThread = new DisplayThread(canvas);

  private int timeDelay = 100;

  public void startThreads() {

    while (true) {
      try {
        while (!Specification.goNextGeneration) {
          Thread.sleep(timeDelay);
        }
        executorService.invokeAll(Arrays.asList(lifeThread, deathThread));
        executorService.invokeAll(Collections.singletonList(displayThread));
        // todo: перенести в поток
        canvas.repaint();
        Thread.sleep(timeDelay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
