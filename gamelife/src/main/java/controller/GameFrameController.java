package controller;

import gui.Canvas;
import gui.GameFrame;
import gui.SettingsFrame;
import gui.buttons.ButtonsMenuBar;
import java.awt.BorderLayout;
import service.GameField;

/**
 * Controller class binds objects and assigns actions to buttons.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/25/2019
 */
public class GameFrameController {

  private GameFrame gameFrame;
  private ButtonsMenuBar buttonsPanel;
  private GameField gameField;
  private SettingsFrame settingsFrame;
  private Canvas canvas;
  private boolean goNextGeneration = false;

  /** creates action listeners for each button. */
  public GameFrameController(
      SettingsFrame settingsFrame,
      GameFrame gameFrame,
      ButtonsMenuBar buttonsPanel,
      Canvas canvas) {
    this.gameFrame = gameFrame;
    this.buttonsPanel = buttonsPanel;
    this.gameField = new GameField();
    this.settingsFrame = settingsFrame;
    settingsFrame.setGameField(gameField);
    this.canvas = canvas;
    canvas.setGameField(gameField);

    gameFrame.add(BorderLayout.SOUTH, buttonsPanel);
    gameFrame.add(BorderLayout.CENTER, canvas);

    buttonsPanel
        .getStartButton()
        .addActionListener(
            e -> {
              goNextGeneration = true;
              buttonsPanel.getStartButton().setText("Running");
              buttonsPanel.getStartButton().setEnabled(false);
              buttonsPanel.getStopButton().setEnabled(true);
              buttonsPanel.getClearButton().setEnabled(false);
              if (gameField.isEmpty()) {
                gameField.fillingByShapes();
              } else {
                gameField.shapesCleaning();
              }
            });

    buttonsPanel
        .getStopButton()
        .addActionListener(
            e -> {
              goNextGeneration = !goNextGeneration;
              buttonsPanel.getStopButton().setEnabled(false);
              buttonsPanel.getStartButton().setText("Start");
              buttonsPanel.getStartButton().setEnabled(true);
              buttonsPanel.getClearButton().setEnabled(true);
            });

    buttonsPanel
        .getClearButton()
        .addActionListener(
            e -> {
              buttonsPanel.getStartButton().setEnabled(true);
              buttonsPanel.getStopButton().setEnabled(false);
              gameField.setLifeGeneration(
                  new boolean[gameField.getLifeSize()][gameField.getLifeSize()]);
              gameField.setNextGeneration(
                  new boolean[gameField.getLifeSize()][gameField.getLifeSize()]);
              canvas.repaint();
            });
  }

  public GameField getGameField() {
    return gameField;
  }

  public boolean isGoNextGeneration() {
    return goNextGeneration;
  }
}
