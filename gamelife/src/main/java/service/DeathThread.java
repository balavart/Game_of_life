package service;

import java.util.concurrent.Callable;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/27/2019
 */
public class DeathThread implements Callable<Boolean> {
  private GameField gameField;

  public DeathThread(GameField gameField) {
    this.gameField = gameField;
  }

  @Override
  public Boolean call() {
    System.out.println("death");
    gameField.shapesDeath();
    return true;
  }
}
