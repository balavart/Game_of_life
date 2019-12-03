package gui;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import service.GameFieldImplementation;

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
  private GameFieldImplementation gameFieldImplementation;

  /** sets values for Game JFrame. Assigns action to button. Contains verification conditions. */
  public SettingsFrame(JFrame gameframe) throws HeadlessException {
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Settings");
    setSize(300, 250);
    setLocationRelativeTo(null);
    setResizable(false);
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
            System.err.println("Window sizes are too low or too high. Type other sizes.");
            return;
          }

          if (percentShapeFullness <= 10) {
            System.err.println("Field completion percentage is too low. Type another number.");
            return;
          } else if (percentShapeFullness > 100) {
            System.err.println("Field completion percentage is too high. Type another number.");
            return;
          } else {
            gameFieldImplementation.setShapeFullness(percentShapeFullness / 2);
          }

          setVisible(false);
          gameframe.setVisible(true);
          gameframe.setLocationRelativeTo(null);
          gameframe.setResizable(false);
          gameFieldImplementation.setShapeScale(
              (Math.max(
                      width / gameFieldImplementation.getLifeSize(),
                      height / gameFieldImplementation.getLifeSize()))
                  + 1);
        });
  }

  public void setGameFieldImplementation(GameFieldImplementation gameFieldImplementation) {
    this.gameFieldImplementation = gameFieldImplementation;
  }
}
