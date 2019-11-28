package service;

import gui.GameField;
import java.util.concurrent.Callable;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/27/2019
 */
public class LifeThread implements Callable<Boolean> {
  private GameField gameField;

  public LifeThread(GameField gameField) {
    this.gameField = gameField;
  }

  @Override
  public Boolean call() {
    gameField.shapesBorn();
    return true;
  }
}
