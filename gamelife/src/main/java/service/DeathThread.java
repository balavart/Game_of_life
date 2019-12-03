package service;

import java.util.concurrent.Callable;

/**
 * Thread of death launches the method of death of figures.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/27/2019
 */
public class DeathThread implements Callable<Boolean> {

  private GameFieldImplementation gameFieldImplementation;

  public DeathThread(GameFieldImplementation gameFieldImplementation) {
    this.gameFieldImplementation = gameFieldImplementation;
  }

  @Override
  public Boolean call() {
    gameFieldImplementation.shapesDeath();
    return true;
  }
}
