package gui;

import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import service.GameField;

/**
 * JFrame for assigning initial settings.
 *
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/29/2019
 */
public class SettingsFrame extends JFrame {

  private JTextField widthTextField;
  private JTextField heightTextField;
  private JTextField percentFullnessTextField;
  private JLabel widthLabel;
  private JLabel heightLabel;
  private JLabel percentFullnessLabel;
  private JPanel settingMenuBar;
  private JButton confirmButton;
  private JFrame gameframe;
  private GameField gameField;

  /**
   * sets values for Game JFrame. Assigns action to button. Contains verification conditions.
   *
   * @see GameFrame
   */
  public SettingsFrame(JFrame gameframe) throws HeadlessException {
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Settings");
    setSize(300, 250);
    setLocationRelativeTo(null);
    setResizable(false);
    this.gameframe = gameframe;
    add(settingMenuBar);
    widthTextField.setText("500");
    heightTextField.setText("500");
    percentFullnessTextField.setText("20");

    confirmButton.addActionListener(
        e -> {
          if (!widthTextField.getText().chars().allMatch(Character::isDigit)
              || !heightTextField.getText().chars().allMatch(Character::isDigit)
              || !percentFullnessTextField.getText().chars().allMatch(Character::isDigit)) {
            System.err.println("Non-numeric value. Type number value.");
            return;
          }

          int width = Integer.parseInt(widthTextField.getText());
          int height = Integer.parseInt(heightTextField.getText());
          int percentShapeFullness = (Integer.parseInt(percentFullnessTextField.getText()));

          if ((width >= 225 && width <= 1920) && (height >= 100 && height <= 1030)) {
            gameframe.setSize(width, height);
          } else {
            System.err.println("Window sizes are too low or too hight. Type other sizes.");
            return;
          }

          if (percentShapeFullness <= 10) {
            System.err.println("Field completion percentage is too low. Type another number.");
            return;
          } else if (percentShapeFullness > 100) {
            System.err.println("Field completion percentage is too hight. Type another number.");
            return;
          } else {
            gameField.setShapeFullness(percentShapeFullness / 2);
          }

          setVisible(false);
          gameframe.setVisible(true);
          gameframe.setLocationRelativeTo(null);
          gameframe.setResizable(false);
          gameField.setShapeScale(
              (Math.max(width / gameField.getLifeSize(), height / gameField.getLifeSize())) + 1);
        });
  }

  public void setGameField(GameField gameField) {
    this.gameField = gameField;
  }
}
