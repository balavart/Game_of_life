package threads;

import gui.GameField;
import java.util.concurrent.Callable;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/27/2019
 */
public class DeathThread implements Callable<Boolean> {

  private GameField gameField;
  private final String choiceName = "Death";

  public DeathThread(GameField gameField) {
    this.gameField = gameField;
  }

  @Override
  public Boolean call() throws Exception {
    gameField.shapeStateChoice(choiceName);
    return true;
  }

}
