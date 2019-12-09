package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
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
class GameFieldImplementationTest {

  private static GameField gameField;
  private boolean[][] testGeneration;
  private static int testsCount;

  /** Before all. */
  @BeforeAll
  static void beforeAll() {
    gameField = new GameFieldImplementation();
    testsCount = 1;
    System.out.println("Start " + GameFieldImplementation.class.getSimpleName() + " class testing");
  }

  /** After all. */
  @AfterAll
  static void afterAll() {
    System.out.println("Stop " + GameFieldImplementation.class.getSimpleName() + " class testing");
  }

  /** Sets up. */
  @BeforeEach
  void setUp() {
    System.out.println("Test № " + testsCount + " running");
  }

  /** Tear down. */
  @AfterEach
  void tearDown() {
    System.out.println("Test № " + (testsCount - 1) + " terminated");
  }

  /** Is empty. */
  @Test
  void isEmpty() {
    testGeneration =
        new boolean[gameField.getLifeSize()]
            [gameField.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, false);
    }
    gameField.setLifeGeneration(testGeneration);
    assertTrue(gameField.isEmpty());
    testsCount++;
  }

  /** Count neighbors. */
  @Test
  void countNeighbors() {
    testGeneration =
        new boolean[gameField.getLifeSize()]
            [gameField.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, true);
    }
    gameField.setLifeGeneration(testGeneration);
    assertEquals(8, gameField.countNeighbors(1, 1));
    testsCount++;
  }

  /** Shapes born. */
  @Test
  void shapesBorn() {
    testGeneration =
        new boolean[gameField.getLifeSize()]
            [gameField.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, true);
    }
    gameField.setNextGeneration(testGeneration);
    assertTrue(gameField.shapesBorn()[1][1]);
    testsCount++;
  }

  /** Shapes death. */
  @Test
  void shapesDeath() {
    testGeneration =
        new boolean[gameField.getLifeSize()]
            [gameField.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, false);
    }
    gameField.setNextGeneration(testGeneration);
    assertFalse(gameField.shapesDeath()[1][1]);
    testsCount++;
  }

  /** Shapes cleaning. */
  @Test
  void shapesCleaning() {
    testGeneration =
        new boolean[gameField.getLifeSize()]
            [gameField.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, false);
    }
    gameField.setNextGeneration(testGeneration);
    assertFalse(gameField.shapesCleaning()[1][1]);
    testsCount++;
  }
}
