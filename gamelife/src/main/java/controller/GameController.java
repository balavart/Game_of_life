package controller;

import static config.Specification.goNextGeneration;
import static config.Specification.lifeSize;

import config.Specification;
import gui.Canvas;
import gui.GameField;
import gui.GameFrame;
import gui.buttons.ButtonsMenuBar;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import service.ThreadService;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 25.11.2019
 */
public class GameController extends JFrame {
  private GameFrame frame;
  private ButtonsMenuBar buttonsPanel;
  private GameField gameField;
  private Canvas canvas;
  private ThreadService threadService;

  public final int TIME_DELAY = 300;
  private int gameState = 0;

  public GameController(GameFrame gameFrame, ButtonsMenuBar buttonsPanel, Canvas canvas,ThreadService threadService) {
    this.frame = gameFrame;
    this.buttonsPanel = buttonsPanel;
    this.gameField = new GameField();
    this.canvas = canvas;
    canvas.setGameField(gameField);
    this.threadService=threadService;

    frame.getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
    frame.getContentPane().add(BorderLayout.CENTER, canvas);

    startButtonsActionListeners();
  }


  // включение действий для кнопок
  public void startButtonsActionListeners() {
    buttonsPanel.getStartButton().addActionListener(startButtonListener());
    buttonsPanel.getStopButton().addActionListener(stopButtonListener());
    buttonsPanel.getClearButton().addActionListener(clearButtonListener());
  }

  // todo: перенести Listener в отдельный класс
  private ActionListener startButtonListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
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

        System.out.println("Старт функция"); // для проверки
      }
    };
  }

  // todo: перенести Listener в отдельный класс
  private ActionListener stopButtonListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        goNextGeneration=!goNextGeneration;
        buttonsPanel.getStopButton().setEnabled(false);
        // todo: разобраться как вызвать имя текста из объекта кнопки
        buttonsPanel.getStartButton().setText("Start");
        buttonsPanel.getStartButton().setEnabled(true);
        buttonsPanel.getClearButton().setEnabled(true);

        System.out.println("Стоп функция"); // для проверки


      }
    };
  }

  // todo: перенести Listener в отдельный класс
  private ActionListener clearButtonListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        buttonsPanel.getStartButton().setEnabled(true);
        buttonsPanel.getStopButton().setEnabled(false);
        gameField.setLifeGeneration(new boolean[lifeSize][lifeSize]);
        gameField.setNextGeneration(new boolean[lifeSize][lifeSize]);
        canvas.repaint();
        System.out.println("Очистка функция"); // для проверки
      }
    };
  }

  // бесконечная петля жизни
//  public void startEndlessLifeSpan() {
//
//    while (true) {
//      if (gameState == 1) {
//        gameState = 2;
//        if (gameField.isEmpty()) {
//          goNextGeneration = !goNextGeneration;
//          gameField.fillingByShapes();
//        } else {
//          goNextGeneration = !goNextGeneration;
//          gameField.shapesCleaning();
//        }
//      }
//      if (goNextGeneration) {
//
//        System.out.println("В бесконечном цикле"); // для проверки
//
//        gameField.lifeProcess();
//        canvas.repaint();
//        try {
//          Thread.sleep(TIME_DELAY);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }
//      if (gameState == 3) {
//        gameField.setLifeGeneration(new boolean[lifeSize][lifeSize]);
//        gameField.setNextGeneration(new boolean[lifeSize][lifeSize]);
//        gameState = 2;
//      }
//    }
//  }

  public GameField getGameField() {
    return gameField;
  }

}
