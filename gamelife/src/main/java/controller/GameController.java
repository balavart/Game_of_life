package controller;

import static config.Specification.goNextGeneration;
import static config.Specification.lifeSize;

import gui.Canvas;
import gui.GameField;
import gui.GameFrame;
import gui.buttons.ButtonsMenuBar;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 25.11.2019
 */
public class GameController extends JFrame {
  private ButtonsMenuBar buttonsPanel;
  private GameField gameField;
  private Canvas canvas;

  public GameController(GameFrame gameFrame, ButtonsMenuBar buttonsPanel, Canvas canvas) {
    this.buttonsPanel = buttonsPanel;
    this.gameField = new GameField();
    this.canvas = canvas;
    canvas.setGameField(gameField);

    gameFrame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
    gameFrame.getContentPane().add(BorderLayout.CENTER, canvas);

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
              gameField.setLifeGeneration(new boolean[lifeSize][lifeSize]);
              gameField.setNextGeneration(new boolean[lifeSize][lifeSize]);
              canvas.repaint();
            });
  }

  public GameField getGameField() {
    return gameField;
  }
}
