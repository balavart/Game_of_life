package service;

import config.Specification;
import controller.GameController;
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
  private GameFrame frame = new GameFrame();
  private Canvas canvas = new Canvas();
  private ButtonsMenuBar buttonsMenuBar = new ButtonsMenuBar(canvas);
  private GameController window = new GameController(frame, buttonsMenuBar, canvas, this);
  private ExecutorService executorService = Executors.newFixedThreadPool(3);
  private LifeThread lifeThread = new LifeThread(window.getGameField());
  private DeathThread deathThread = new DeathThread(window.getGameField());
  private DisplayThread displayThread = new DisplayThread(canvas);

  private int timeDelay = 100;

  public void startThreads() {

    while (true) {

      try {
        while(!Specification.goNextGeneration) {
          Thread.sleep(timeDelay);
        }
          executorService.invokeAll(Arrays.asList(lifeThread, deathThread));
          executorService.invokeAll(Collections.singletonList(displayThread));
          canvas.repaint();
          Thread.sleep(timeDelay);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
