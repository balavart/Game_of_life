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

  private static GameFieldImplementation gameFieldImplementationTest;
  private boolean[][] testGeneration;
  private static int testsCount;

  /** Before all. */
  @BeforeAll
  static void beforeAll() {
    gameFieldImplementationTest = new GameFieldImplementation();
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
        new boolean[gameFieldImplementationTest.getLifeSize()]
            [gameFieldImplementationTest.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, false);
    }
    gameFieldImplementationTest.setLifeGeneration(testGeneration);
    assertTrue(gameFieldImplementationTest.isEmpty());
    testsCount++;
  }

  /** Count neighbors. */
  @Test
  void countNeighbors() {
    testGeneration =
        new boolean[gameFieldImplementationTest.getLifeSize()]
            [gameFieldImplementationTest.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, true);
    }
    gameFieldImplementationTest.setLifeGeneration(testGeneration);
    assertEquals(8, gameFieldImplementationTest.countNeighbors(1, 1));
    testsCount++;
  }

  /** Shapes born. */
  @Test
  void shapesBorn() {
    testGeneration =
        new boolean[gameFieldImplementationTest.getLifeSize()]
            [gameFieldImplementationTest.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, true);
    }
    gameFieldImplementationTest.setNextGeneration(testGeneration);
    assertTrue(gameFieldImplementationTest.shapesBorn()[1][1]);
    testsCount++;
  }

  /** Shapes death. */
  @Test
  void shapesDeath() {
    testGeneration =
        new boolean[gameFieldImplementationTest.getLifeSize()]
            [gameFieldImplementationTest.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, false);
    }
    gameFieldImplementationTest.setNextGeneration(testGeneration);
    assertFalse(gameFieldImplementationTest.shapesDeath()[1][1]);
    testsCount++;
  }

  /** Shapes cleaning. */
  @Test
  void shapesCleaning() {
    testGeneration =
        new boolean[gameFieldImplementationTest.getLifeSize()]
            [gameFieldImplementationTest.getLifeSize()];

    for (boolean[] booleans : testGeneration) {
      Arrays.fill(booleans, false);
    }
    gameFieldImplementationTest.setNextGeneration(testGeneration);
    assertFalse(gameFieldImplementationTest.shapesCleaning()[1][1]);
    testsCount++;
  }
}
