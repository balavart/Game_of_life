package service;

import java.util.concurrent.Callable;

/**
 * Thread of life launches the life method of figures.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/27/2019
 */
public class LifeThread implements Callable<Boolean> {

  private GameFieldImplementation gameFieldImplementation;

  public LifeThread(GameFieldImplementation gameFieldImplementation) {
    this.gameFieldImplementation = gameFieldImplementation;
  }

  @Override
  public Boolean call() {
    gameFieldImplementation.shapesBorn();
    return true;
  }
}
