package gui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.GameField;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/28/2019
 */
class GameFieldTest {
  private GameField gameFieldTest = new GameField();

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
    gameFieldTest.setLifeGeneration(test);
    gameFieldTest.getLifeGeneration();
    assertEquals(8, gameFieldTest.countNeighbors(1, 1));
  }
}
