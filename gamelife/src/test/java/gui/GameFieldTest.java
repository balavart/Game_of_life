package gui;

import static config.Specification.lifeSize;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/28/2019
 */
class GameFieldTest {
  private GameField gameField = new GameField();

  @BeforeEach
  void setUp() {}

  @AfterEach
  void tearDown() {}

  @Test
  void countNeighbors() {
    boolean[][] test = {
      {true, true, true},
      {true, true, true},
      {true, true, true}
    };
    gameField.setLifeGeneration(test);
    gameField.getLifeGeneration();
    assertEquals(8, gameField.countNeighbors(1, 1));
  }


}
