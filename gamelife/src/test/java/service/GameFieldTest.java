package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The type Game field test.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11 /28/2019
 */
class GameFieldTest {

  private static GameField gameFieldTest;
  private boolean[][] testGeneration;
  private static int testCount;

  @BeforeAll
  static void beforeAll() {
    gameFieldTest = new GameField();
    testCount = 1;
    System.out.println("Start " + GameField.class.getSimpleName() + " class testing");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("Stop " + GameField.class.getSimpleName() + " class testing");
  }

  @BeforeEach
  void setUp() {
    System.out.println("Test № " + testCount + " running");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Test № " + (testCount - 1) + " terminated");
  }

  @Test
  void countNeighbors() {
    testGeneration =
        new boolean[][] {
          {true, true, true},
          {true, true, true},
          {true, true, true}
        };
    gameFieldTest.setLifeGeneration(testGeneration);
    assertEquals(8, gameFieldTest.countNeighbors(1, 1));
    testCount++;
  }

  @Test
  void isEmpty() {
    testGeneration = new boolean[gameFieldTest.getLifeSize()][gameFieldTest.getLifeSize()];
    for (int i = 0; i < gameFieldTest.getLifeSize(); i++) {
      for (int j = 0; j < gameFieldTest.getLifeSize(); j++) {
        testGeneration[i][j] = false;
      }
    }
    gameFieldTest.setLifeGeneration(testGeneration);
    assertTrue(gameFieldTest.isEmpty());
    testCount++;
  }
}
