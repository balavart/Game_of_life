package gui;

import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Vardan Balayan
 * @version 1.8
 * @created 11/29/2019
 */
public class SettingsFrame2 extends JFrame {

  private JTextField textField1;
  private JTextField textField2;
  private JTextField textField3;
  private JLabel widthLabel;
  private JLabel heightLabel;
  private JLabel percentFullnessLabel;
  private JPanel settingMenuBar2;
  private JButton confirmButton;

  public SettingsFrame2() throws HeadlessException {
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Settings");
    setSize(300, 250);
    setLocationRelativeTo(null);
    setResizable(false);
    add(settingMenuBar2);
  }
}
